package DSA.DPSERIES;

public class PERFECTSQUARE {
    PERFECTSQUARE(){

    }
    public static int solverecur(int n){
        if (n==0){
            return 0;
        }
        int ans=n;
        for (int i=1;i*i<=n;i++){
            ans=Math.min(ans,1+solverecur(n-i*i));
        }
        return ans;
    }
    public static int minsquare(int n){
        int[] dp=new int[n+1];
        for (int i=0;i<n;i++){
            dp[i]=-1;
        }
        memo(n,dp);
        return solverecur(n);
    }
    public static int memo(int n,int[]dp){
        if (n==0){
            return 0;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        int ans=n;
        for (int i=1;i*i<=n;i++){
            ans=Math.min(ans,1+memo(n-i*i,dp));
        }
        dp[n]= ans;
        return dp[n];
    }
    public static int tabu(int n){
        int[] dp1=new int[n+1];
        for (int i=0;i< dp1.length;i++){
            dp1[i]=Integer.MAX_VALUE;
        }
        dp1[0]=0;
        for (int i=1;i<=n;i++){
            for (int j=1;j*j<=n;j++){
                dp1[i]=Math.min(dp1[i],1+dp1[i-j*j]);
            }
        }
        return dp1[n];
    }
}
