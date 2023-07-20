package DSA.DPSERIES;

import java.util.Vector;

public class MINIMUMJUMPSIDEWAYS {
    MINIMUMJUMPSIDEWAYS() {

    }

    public static int solve(Vector<Integer> obstacles, int curpos, int curlane) {
        if (curpos == obstacles.size() - 1) {
            return 0;
        }
        if (obstacles.get(curpos + 1) != curlane) {
            return solve(obstacles, curpos + 1, curlane);
        } else {
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                if (curlane != i && obstacles.get(curpos) != i) {
                    ans = Math.min(ans, 1 + solve(obstacles, curpos, i));
                }
            }
            return ans;
        }
    }

    public static int solvememo(Vector<Integer> obstacles, int curpos, int curlane, int[][] dp) {
        if (curpos == obstacles.size() - 1) {
            return 0;
        }
        if (dp[curlane][curpos] != -1) {
            return dp[curlane][curpos];
        }
        if (obstacles.get(curpos + 1) != curlane) {
            return solvememo(obstacles, curpos + 1, curlane, dp);
        } else {
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                if (curlane != i && obstacles.get(curpos) != i) {
                    ans = Math.min(ans, 1 + solvememo(obstacles, curpos, i, dp));
                }
            }
            dp[curlane][curpos] = ans;
            return dp[curlane][curpos];
        }
    }

    public static int solvetabu(Vector<Integer> obstacles) {
        int n = obstacles.size();
        int[][] dp = new int[4][n];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][n] = 0;
        dp[1][n] = 0;
        dp[2][n] = 0;
        dp[3][n] = 0;
        for (int pos = n - 1; pos >= 0; pos--) {
            for (int lane = 1; lane <= 3; lane++) {
                if (obstacles.get(pos + 1) != lane) {
                    dp[lane][pos] = dp[lane][pos + 1];
                } else {
                    int ans = Integer.MAX_VALUE;
                    for (int i = 1; i <= 3; i++) {
                        if (lane != i && obstacles.get(pos) != i) {
                            ans = Math.min(ans, 1 + dp[i][pos + 1]);
                        }
                    }
                    dp[lane][pos] = ans;
                }
            }
        }
        return Math.min(dp[2][0], Math.min(1 + dp[1][0], 1 + dp[3][0]));
    }

    public static int minsidejump(Vector<Integer> obstacles) {
        int n = obstacles.size();
        int[][] dp = new int[4][n];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        solvememo(obstacles, 0, 2, dp);
        solvetabu(obstacles);
        return solve(obstacles, 0, 2);
    }
}