package DSA.DPSERIES;

public class GETMONEYAMOUNT {
    GETMONEYAMOUNT(){

    }
    public static int getmoneyamount(int n){
        int[][] dp=new int[n+1][n+1];
        for (int i=0;i< dp.length;i++){
            for (int j=0;j<dp.length;j++){
                dp[i][j]=-1;
            }
        }
        solvemem(1,n,dp);
        return solve(1,n);
    }

    public static int solve(int start,int end) {
        if (start>=end){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for (int i=start;i<=end;i++){
            ans=Math.min(ans,i+Math.max(solve(start, i-1),solve(i+1,end)));
        }
        return ans;
    }
    public static int solvemem(int start,int end,int[][] dp){
        if (start>=end){
            return 0;
        }
        if (dp[start][end]!=-1){
            return dp[start][end];
        }
        int ans=Integer.MAX_VALUE;
        for (int i=start;i<=end;i++){
            ans=Math.min(ans,i+Math.max(solvemem(start, i-1,dp),solvemem(i+1,end,dp)));
        }
        dp[start][end]= ans;
        return dp[start][end];
    }
    public static int solvetab(int n){
        int[][] dp=new int[n+2][n+2];
        for (int i=0;i< dp.length;i++){
            for (int j=0;j<dp.length;j++){
                dp[i][j]=0;
            }
        }
        for (int start=n;start>=1;start--){
            for (int end=start;end<=n;end++){
                if (start==end){
                    continue;
                }
                else{
                    int ans=Integer.MAX_VALUE;
                    for (int i=start;i<=end;i++){
                        ans=Math.min(ans,i+Math.max(dp[start][i-1],dp[i+1][end]));
                    }
                    dp[start][end]= ans;

                }
            }
        }
        return dp[1][n];
    }
}
