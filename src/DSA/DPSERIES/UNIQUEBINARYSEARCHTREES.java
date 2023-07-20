package DSA.DPSERIES;

public class UNIQUEBINARYSEARCHTREES {
    UNIQUEBINARYSEARCHTREES(){

    }
    public static int solvemem(int n,int[] dp){
        if (n<=1){
            return 1;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for (int i=1;i<=n;i++){
            ans+=solvemem(i-1,dp)*solvemem(n-i,dp);
        }
        dp[n]= ans;
        return dp[n];
    }
    public static int solve(int n){
        if (n<=1){
            return 1;
        }
        int ans=0;
        for (int i=1;i<=n;i++){
            ans+=numTrees(i-1)*numTrees(n-i);
        }
        return ans;
    }
    public static int numTrees(int n){
        int[] dp=new int[n+1];
        for (int i=0;i< dp.length;i++){
            dp[i]=-1;
        }
        solvemem(n,dp);
       return solve(n);
    }
    public static int solvetab(int n){
        int[] dp=new int[n+1];
        for (int i=0;i< dp.length;i++){
            dp[i]=0;
        }
        dp[0]=dp[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
