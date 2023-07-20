package DSA.DPSERIES;

import java.util.Collections;
import java.util.Vector;

public class MINSWAPSTOMAKESUBSWQINCREASING {
    MINSWAPSTOMAKESUBSWQINCREASING(){

    }
    public static int solve(int in,Vector<Integer>num1,Vector<Integer>num2,int swapped){
        if (in== num1.size()){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        int prv1=num1.get(in-1);
        int prv2=num2.get(in-1);
        if (swapped==1){
            swap(prv1,prv2);
        }
        if (num1.get(in)>prv1 && num2.get(in)>prv2){
            ans=solve(in+1,num1,num2,0);
        }
        if (num1.get(in)>prv2 && num2.get(in)>prv1){
            ans=Math.min(ans,1+solve(in+1,num1,num2,1));
        }
        return ans;
    }
    public static int solvemem(int in,Vector<Integer>num1,Vector<Integer>num2,int swapped,int[][] dp){
        if (in== num1.size()){
            return 0;
        }
        if (dp[in][swapped]!=-1){
            return dp[in][swapped];
        }
        int ans=Integer.MAX_VALUE;
        int prv1=num1.get(in-1);
        int prv2=num2.get(in-1);
        if (swapped==1){
            swap(prv1,prv2);
        }
        if (num1.get(in)>prv1 && num2.get(in)>prv2){
            ans=solvemem(in+1,num1,num2,0,dp);
        }
        if (num1.get(in)>prv2 && num2.get(in)>prv1){
            ans=Math.min(ans,1+solvemem(in+1,num1,num2,1,dp));
        }
        dp[in][swapped]=ans;
        return dp[in][swapped];
    }

    public static void swap(int prv1, int prv2) {
        int temp=prv1;
        prv1=prv2;
        prv2=temp;
    }
    public static int solvetab(Vector<Integer>num1,Vector<Integer>num2){
        int n=num1.size();
        int[][] dp = new int[n+1][2];
        for (int i=0;i< dp.length;i++){
            for (int j=0;j<2;j++){
                dp[i][j]=0;
            }
        }
        for (int in=n-1;in>=1;in--){
            for (int j=1;j>=0;j--){
                int ans=Integer.MAX_VALUE;
                int prv1=num1.get(in-1);
                int prv2=num2.get(in-1);
                if (j==1){
                    swap(prv1,prv2);
                }
                if (num1.get(in)>prv1 && num2.get(in)>prv2){
                    ans=dp[in+1][0];
                }
                if (num1.get(in)>prv2 && num2.get(in)>prv1){
                    ans=Math.min(ans,1+dp[in+1][1]);
                }
                dp[in][j]=ans;
            }
        }
        return dp[1][0];
    }
    public static int optimised(Vector<Integer>num1,Vector<Integer>num2){
        int n=num1.size();
        int swap=0;
        int noswap=0;
        int currswap=0;
        int curnoswap=0;
        for (int in=n-1;in>=1;in--){
            for (int j=1;j>=0;j--){
                int ans=Integer.MAX_VALUE;
                int prv1=num1.get(in-1);
                int prv2=num2.get(in-1);
                if (j==1){
                    swap(prv1,prv2);
                }
                if (num1.get(in)>prv1 && num2.get(in)>prv2){
                    ans=noswap;
                }
                if (num1.get(in)>prv2 && num2.get(in)>prv1){
                    ans=Math.min(ans,1+swap);
                }
               if (j==1){
                    currswap=ans;
               }else {
                    curnoswap=ans;
               }
            }
            swap=currswap;
            noswap=curnoswap;
        }
        return Math.min(swap,noswap);
    }
    public static int minswap(Vector<Integer>num1,Vector<Integer>num2){
        num1.add(0,-1);
        num2.add(0,-1);
        int n=num1.size();
        int[][] dp = new int[n][2];
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        solvemem(1,num1,num2,0,dp);
        int swapped=0;
        return solve(1,num1,num2,0);
    }
}
