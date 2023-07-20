package DSA.DPSERIES;

import java.util.Vector;

public class MAXSQUARE {
    MAXSQUARE() {

    }

    public static int solve(Vector<Vector<Integer>> mat, int i, int j, int maxi) {
        if (i >= mat.size() || j >= mat.get(0).size()) {
            return 0;
        }
        int right = solve(mat, i, j + 1, maxi);
        int bottom = solve(mat, i + 1, j, maxi);
        int digo = solve(mat, i + 1, j + 1, maxi);

        if (mat.get(i).get(j) == 1) {
            int ans = Math.min(right, Math.min(digo, bottom));
            maxi = Math.max(maxi, ans);
            return ans;
        } else {
            return 0;
        }
    }

    public static int solvememo(Vector<Vector<Integer>> mat, int i, int j, int[][] dp, int maxi) {
        if (i >= mat.size() || j >= mat.get(0).size()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = solvememo(mat, i, j + 1, dp, maxi);
        int bottom = solvememo(mat, i + 1, j, dp, maxi);
        int digo = solvememo(mat, i + 1, j + 1, dp, maxi);

        if (mat.get(i).get(j) == 1) {
            dp[i][j] = Math.min(right, Math.min(digo, bottom));
            maxi = Math.max(maxi, dp[i][j]);
            return dp[i][j];
        } else {
            return dp[i][j] = 0;
        }
    }

    public static int findsq(Vector<Vector<Integer>> mat, int i, int j, int n, int m) {
        int[][] dp = new int[n][m];
        int maxi = 0;
        for (int l = 0; l < n; l++) {
            for (int k = 0; k < m; k++) {
                dp[l][k] = -1;
            }
        }
        solvememo(mat, 0, 0, dp, 0);
        solvetabu(mat, n, m, maxi);
        return solve(mat, 0, 0, 0);
    }

    public static int solvetabu(Vector<Vector<Integer>> mat, int n, int m, int maxi) {
        int[][] dp1 = new int[n][m];
        for (int l = 0; l < n; l++) {
            for (int k = 0; k < m; k++) {
                dp1[l][k] = Integer.MIN_VALUE;
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    int right = dp1[i][j + 1];
                    int bottom = dp1[i + 1][j];
                    int digo = dp1[i + 1][j + 1];

                    if (mat.get(i).get(j) == 1) {
                        dp1[i][j] = Math.min(right, Math.min(digo, bottom));
                        maxi = Math.max(maxi, dp1[i][j]);

                    } else {
                        dp1[i][j] = 0;
                    }
                }
            }
        }
        return dp1[0][0];
    }

    public static int solveoptimised(Vector<Vector<Integer>> mat, int n, int m, int maxi) {
        int[] curr = new int[m+1];
        int[] next = new int[m+1];
        for (int i = 0; i < n; i++) {
            curr[i] = 0;
            next[i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int right = curr[j + 1];
                int bottom = next[j];
                int digo = next[j + 1];

                if (mat.get(i).get(j) == 1) {
                    curr[j] = Math.min(right, Math.min(digo, bottom));
                    maxi = Math.max(maxi, curr[j]);

                } else {
                    curr[j] = 0;
                }
            }
           next=curr;
        }
        return next[0];
    }
}


