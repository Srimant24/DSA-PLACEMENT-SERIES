package DSA.DPSERIES;

public class MAXPROFITPART2 {
    MAXPROFITPART2(){

    }
    public static int maxprofit(int[] prices){
        int n= prices.length;
        int[][]dp=new int[n][2];
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        solvemem(0,1,prices,dp);
        solvetab(prices);
        return solve(0,1,prices);
    }
    public static int solve(int i,int buy,int[] prices){
        if (i>= prices.length){
            return 0;
        }
        int profit=0;
        if (buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,prices),solve(i+1,1,prices));
        }
        else {
            profit=Math.max(prices[i]+solve(i+1,1,prices),solve(i+1,0,prices));
        }
        return profit;
    }
    public static int solvemem(int i, int buy, int[] prices, int[][] dp){
        if (i>= prices.length){
            return 0;
        }
        if (dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int profit=0;
        if (buy==1){
            profit=Math.max(-prices[i]+solvemem(i+1,0,prices, dp),solvemem(i+1,1,prices, dp));
        }
        else {
            profit=Math.max(prices[i]+solvemem(i+1,1,prices, dp),solvemem(i+1,0,prices, dp));
        }
        dp[i][buy]= profit;
        return dp[i][buy];
    }
    public static int solvetab(int[] prices){
        int n= prices.length;
        int[][]dp=new int[n+1][2];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<2;j++){
                dp[i][j]=0;
            }
        }
        for (int i=n-1;i>=0;i--){
            for (int buy=0;buy<=1;buy++){
                int profit=0;
                if (buy==1){
                    profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else {
                    profit=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][buy]= profit;

            }
        }
        return dp[0][1];
    }
    public static int optimised(int[] prices){
        int n= prices.length;
        int[] curr=new int[2];
        for (int i=0;i< curr.length;i++){
            curr[i]=0;
        }
        int[] next=new int[2];
        for (int i=0;i< curr.length;i++){
            next[i]=0;
        }
        for (int i=n-1;i>=0;i--){
            for (int buy=0;buy<=1;buy++){
                int profit=0;
                if (buy==1){
                    profit=Math.max(-prices[i]+next[0],next[1]);
                }
                else {
                    profit=Math.max(prices[i]+next[1],next[0]);
                }
                curr[buy]= profit;
            }
            next=curr;
        }
        return next[1];
    }
}
