package DSA.DPSERIES;

import java.util.Vector;

public class COSTOFCLIMBINGSTAIRS {
    COSTOFCLIMBINGSTAIRS(){

    }
    public int mincost(Vector<Integer>cost){
        int n=cost.size();
        int[] dp=new int[n+1];
        for (int i=0;i<=n;i++){
            dp[i]=-1;
        }
        int ans=Math.min(solve(cost,n-1,dp),solve(cost,n-2,dp));
        int ans1=Math.min(solve1(cost,n-1),solve1(cost,n-2));
        int ans3=solve3(cost,n);
        System.out.println(ans1);
        return ans;
    }

    public int solve1(Vector<Integer> cost, int n) {//tabulation
        int[] dp1=new int[n+1];
        dp1[0]=cost.get(0);
        dp1[1]=cost.get(1);
        for (int i=2;i<=n;i++){
            dp1[i]=cost.get(i)+Math.min(dp1[i-1],dp1[i-2]);
        }
        return Math.min(dp1[n-1],dp1[n-2]);
    }

    public int solve(Vector<Integer> cost, int n,int[]dp) {//memorisation
        if (n==0){
            return cost.get(0);
        } if (n==1){
            return cost.get(1);
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        dp[n]=cost.get(n)+Math.min(solve(cost, n-1,dp),solve(cost, n-2,dp));
        return dp[n];
    }
    public int solve3(Vector<Integer>cost,int n){//optimal
        int a=cost.get(0);
        int b=cost.get(1);
        for (int i=2;i<=n;i++){
            int temp=b;
            int curr=cost.get(i)+Math.min(a,b);
            b=curr;
            a=temp;
        }
        return Math.min(a,b);
    }
}
