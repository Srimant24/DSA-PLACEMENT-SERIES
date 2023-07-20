package DSA.DPSERIES;

import java.util.Vector;

public class MINIMUMNUMBEROFCOINS {
    MINIMUMNUMBEROFCOINS(){

    }
    public int solverecursion(Vector<Integer>num,int x){
        if(x==0){
            return 0;
        }
        if (x < 0) {
            return Integer.MAX_VALUE;
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<num.size();i++){
            int ans=solverecursion(num,x- num.get(i));
            if (x!=Integer.MAX_VALUE){
                min=Math.min(min,1+ans);
            }
        }
        return min;
    }
    public int solvememo(Vector<Integer>num,int x,int[]dp){//every element in this dp array is -1;
        if(x==0){
            return 0;
        }
        if (x < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[x]!=-1){
            return dp[x];
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<num.size();i++){
            int ans=solvememo(num,x- num.get(i),dp);
            if (x!=Integer.MAX_VALUE){
                min=Math.min(min,1+ans);
            }
        }
        dp[x]=min;
        return dp[x];
    }
    public int solvetabulation(Vector<Integer>num,int x) {
        int[] dp1 = new int[x + 1];
        dp1[0] = 0;
        for (int i = 1; 1 < dp1.length; i++) {
            dp1[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < num.size(); j++) {
                if (i - num.get(j) >= 0 && dp1[i - num.get(j)] != Integer.MAX_VALUE) {
                    dp1[i] = Math.min(dp1[i], 1 + dp1[i - num.get(j)]);
                }
            }
        }
        if (dp1[x]==Integer.MAX_VALUE){
            return -1;
        }
        return dp1[x];
    }
    public int solve(Vector<Integer>num,int x){
        int[] dp=new int[x+1];
        for (int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int ans=solvememo(num,x,dp);
        int ans1=solverecursion(num, x);
        int ans3=solvetabulation(num, x);
        return ans3;
    }
}
