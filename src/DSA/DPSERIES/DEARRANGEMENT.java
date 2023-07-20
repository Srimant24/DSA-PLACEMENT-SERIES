package DSA.DPSERIES;

public class DEARRANGEMENT {
    DEARRANGEMENT(){

    }
    static double mod=((10^9)+7);

   public static double sovemmo(int n,double[] dp){
       if (n==1){
           return 0;
       }
       if (n==2){
           return 1;
       }
       if (dp[n]!=-1){
           return dp[n];
       }
       dp[n]=( ((n-1)%mod)*((sovemmo(n-1,dp)%mod)+(sovemmo(n-2,dp)%mod)) %mod);
       return dp[n];
   }

    public double dearrangementsrecursion(int n){
        if (n==1){
            return 0;
        }
        if (n==2){
            return 1;
        }
        double ans=( ((n-1)%mod)*((dearrangementsrecursion(n-1)%mod)+(dearrangementsrecursion(n-2)%mod)) %mod);
        return ans;
    }
    public double countdearrangement(int n){
        double[] dp=new double[n+1];
       for (int i=0;i< dp.length;i++){
           dp[i]=-1;
       }
        double ans=dearrangementsrecursion(n);
        double ans1=sovemmo(n,dp);
        return ans;
    }
    public double solvetabu(int n){
       double[] dp1=new double[n+1];
       for (int i=0;i<n;i++){
           dp1[i]=0;
       }
       dp1[1]=0;
       dp1[2]=1;
       for (int i=3;i<=n;i++){
           double first=dp1[i-1]%mod;
           double sec=dp1[i-2]%mod;
           double sum=(first+sec)%mod;
           double ans=(i-1)*sum;
           dp1[i]=ans;
       }
       return dp1[n];
    }
    public double optimised(int n){
        double a=0;
        double b=1;
        for (int i=3;i<=n;i++){
            double temp=b;
            double first=b%mod;
            double sec=a%mod;
            double sum=(first+sec)%mod;
            double ans=((i-1)*sum)%mod;
            b=ans;
            a=temp;
        }
        return b;
    }
}
