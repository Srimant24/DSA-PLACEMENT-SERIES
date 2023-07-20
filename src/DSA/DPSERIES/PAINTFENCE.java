package DSA.DPSERIES;

public class PAINTFENCE {
    PAINTFENCE(){

    }
    public static int add(int a,int b){
        return a+b;
    }
    public static int mul(int a,int b){
        return a*b;
    }
    public static int paintrecursion(int n,int k){
        if (n == 1) {
            return k;
        }
        if (n==2){
            return add(k,mul(k,k-1));
        }
        int ans=add(mul(paintrecursion(n-1,k),k-1),mul(paintrecursion(n-2,k),k-1));
        return ans;
    }
    public static int paintmemo(int n,int k,int[] dp){
        if (n == 1) {
            return k;
        }
        if (n==2){
            return add(k,mul(k,k-1));
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        dp[n]=add(mul(paintmemo(n-1,k,dp),k-1),mul(paintmemo(n-2,k,dp),k-1));
        return dp[n];
    }

    public static int ninjaprint(int n,int k){
        int[] dp=new int[n+1];
        for (int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int ans=paintrecursion(n,k);
        int ans1=paintmemo(n,k,dp);
        int ans3=painttabu(n,k);
        return ans1;
    }

    public static int painttabu(int n, int k) {
        int[] dp1=new int[n+1];
        for (int i=0;i<dp1.length;i++){
            dp1[i]=0;
        }
        dp1[1]=k;
        dp1[2]=add(k,mul(k,k-1));
        for (int i=3;i<=n;i++){
            int fisrt=mul(k-1,dp1[i-1]);
            int sec=mul(k-1,dp1[i-2]);
            int ans=add(fisrt,sec);
            dp1[i]=ans;
        }
        if (dp1[n]==0){
            return 0;
        }
        return dp1[n];
    }
    public int optimised(int n,int k){
        int a=k;
        int b=add(k,mul(k,k-1));
        for (int i=3;i<=n;i++){
            int temp=b;
            int first=mul(a,(k-1));
            int second=mul(b,(k-1));
            int ans=add(first,second);
            b=ans;
            a=temp;
        }
        return b;
    }
}
