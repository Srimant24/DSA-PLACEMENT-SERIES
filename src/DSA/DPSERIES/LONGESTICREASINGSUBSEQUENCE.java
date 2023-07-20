package DSA.DPSERIES;

import java.util.Vector;

public class LONGESTICREASINGSUBSEQUENCE {
    LONGESTICREASINGSUBSEQUENCE(){

    }
    public static int solve(int n,int[] a,int i,int j){
        if (i==n){
            return 0;
        }
        int take=0;
        if (j==-1 || a[i]>a[j]){
            take=1+solve(n,a,i+1,i);
        }
        int nottake=solve(n, a, i+1, j);
        return Math.max(take,nottake);
    }
    public static int longsub(int n,int[] a){
        int[][]dp=new int[n+1][n+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        solvememo(n,a,0,-1,dp);
        return solve(n,a,0,-1);
    }

    public static int solvememo(int n, int[] a, int i, int j, int[][] dp) {
        if (i==n){
            return 0;
        }
        if (dp[i][j+1]!=-1){
            return dp[i][j];
        }
        int take=0;
        if (j==-1 || a[i]>a[j]){
            take=1+solvememo(n,a,i+1,i,dp);
        }
        int nottake=solvememo(n, a, i+1, j,dp);
        dp[i][j+1]=Math.max(take,nottake);
        return dp[i][j];
    }
    public static int solvetab(int n,int[] a){
        int[][]dp=new int[n+1][n+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=0;
            }
        }
        for (int i=n-1;i>=0;i--){
            for (int j=i-1;j>=-1;j--){
                int take=0;
                if (j==-1 || a[i]>a[j]){
                    take=1+dp[i+1][i+1];
                }
                int notake=dp[i+1][j];
                dp[i][j+1]=Math.max(take,notake);
            }
        }
        return dp[0][0];
    }
    public static int optimised(int n,int[] a){
        int[] next=new int[n+1];
        for (int i=0;i<n;i++){
            next[i]=0;
        }
        int[] curr=new int[n+1];
        for (int i=0;i<n;i++){
            curr[i]=0;
        }

        for (int i=n-1;i>=0;i--){
            for (int j=i-1;j>=-1;j--){
                int take=0;
                if (j==-1 || a[i]>a[j]){
                    take=1+next[i+1];
                }
                int notake=next[j];
                curr[j+1]=Math.max(take,notake);
            }
            next=curr;
        }
        return next[0];
    }
    public static int findLowerBound(Vector<Integer>ans, int target) {
        int low = 0;
        int high = ans.size()- 1;
        int lowerBoundIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (ans.get(mid) >= target) {
                lowerBoundIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lowerBoundIndex;
    }
    public static int solveoptimal(int n,int[] a){
        if (n==0){
            return 0;
        }
        Vector<Integer>ans=new Vector<>();
        ans.add(a[0]);
        for (int i=1;i<n;i++){
            if (a[i]> ans.lastElement()){
                ans.add(a[i]);
            }
            else {
              int index =  findLowerBound(ans,a[i]);
              ans.set(index,a[i]);
            }
        }
        return ans.size();
    }
}
