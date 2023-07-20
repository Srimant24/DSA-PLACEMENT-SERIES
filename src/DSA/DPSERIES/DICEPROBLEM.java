package DSA.DPSERIES;

public class DICEPROBLEM {
    DICEPROBLEM(){

    }
    public static int solve(int m,int n,int x){
        if (x<0){
            return 0;
        }
        if (n==0 && x!=0){
            return 0;
        }
        if (n!=0 && x==0){
            return 0;
        }
        if (n==0 && x==0){
            return 1;
        }
        int ans=0;
        for (int i=1;i<=m;i++){
            ans=ans+solve(m,n-1,x-i);
        }
        return ans;
    }
    public static int solvememo(int m,int n,int x,int[][] dp){
        if (x<0){
            return 0;
        }
        if (n==0 && x!=0){
            return 0;
        }
        if (n!=0 && x==0){
            return 0;
        }
        if (n==0 && x==0){
            return 1;
        }
        if (dp[n][x]!=-1){
            return dp[n][x];
        }
        int ans=0;
        for (int i=1;i<=m;i++){
            ans=ans+solvememo(m,n-1,x-i,dp);
        }
        dp[n][x]=ans;
        return dp[n][x];
    }
    public static int noofways(int m,int n,int x){
        int[][] dp=new int[n+1][x+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<x;j++){
                dp[i][j]=-1;
            }
        }
        solvememo(m,n,x,dp);
        return solve(m,n,x);
    }
    public static int  solvetab(int m,int n,int x){
        int[][] dp=new int[n+1][x+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<x;j++){
                dp[i][j]=0;
            }
        }
        dp[0][0]=1;

        for (int i=1;i<=n;i++){
            for (int j=1;j<=x;j++){
                int ans=0;
                for (int k=1;i<=m;k++){
                    if (x-i>=0){
                        ans=ans+dp[n-1][x-i];
                    }
                }
                dp[n][x]=ans;
            }
        }
        return dp[n][x];
    }
    public static int optimised(int m,int n,int x){
        int []curr=new int[x+1];
        for (int i=0;i< curr.length;i++){
            curr[i]=0;
        }
        int []prv=new int[x+1];
        for (int i=0;i< curr.length;i++){
            prv[i]=0;
        }
        curr[0]=1;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=x;j++){
                int ans=0;
                for (int k=1;i<=m;k++){
                    if (x-i>=0){
                        ans=ans+prv[x-i];
                    }
                }
                curr[x]=ans;
            }
            prv=curr;
        }
        return curr[x];
    }
}
