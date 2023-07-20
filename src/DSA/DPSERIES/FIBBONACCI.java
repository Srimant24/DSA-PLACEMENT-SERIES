package DSA.DPSERIES;

import java.util.Scanner;

public class FIBBONACCI {
    FIBBONACCI(){

    }
    public static int fibbo(int n,int[] dp){//memorisation
        if (n<=1){
            return n;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        dp[n]=fibbo(n-1,dp)+fibbo(n-2,dp);
        return dp[n];
    }
    public static int fibbo1(int n,int []dp1){ //tabulation
        dp1[0]=0;
        dp1[1]=1;
        for (int i=2;i<=n;i++){
            dp1[i]=dp1[i-1]+dp1[i-2];
        }
        return dp1[n];
    }

    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] dp=new int[n+1];
        for (int i=0;i<=n;i++){
            dp[i]=-1;
        }
        //System.out.println(fibbo(n,dp));
        int[] dp1=new int[n+1];
        //System.out.println(fibbo1(n,dp1));
        int a=0;
        int b=1;
        for (int i=2;i<=n;i++){
            int temp=b;
            int c=a+b;
            b=c;
            a=temp;
        }
        System.out.println(b);
    }
}
