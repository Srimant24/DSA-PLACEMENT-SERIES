package DSA.DPSERIES;

public class MAXPROFITPART3 {
    MAXPROFITPART3(){
    }
    public static int maxprofit(int[] prices){
        int n= prices.length;
        int[][][] dp=new int[n][2][3];
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                for (int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        solvemem(0,1,prices,2,dp);
       // solvetab(prices);
        return solve(0,1,prices,2);
    }
    public static int solve(int i,int buy,int[] prices,int limit){
        if (i>= prices.length){
            return 0;
        }
        if (limit==0){
            return 0;
        }
        int profit=0;
        if (buy==1){
            profit=Math.max(-prices[i]+solve(i+1,0,prices,limit),solve(i+1,1,prices,limit));
        }
        else {
            profit=Math.max(prices[i]+solve(i+1,1,prices,limit-1),solve(i+1,0,prices,limit));
        }
        return profit;
    }
    public static int solvemem(int i, int buy, int[] prices,int limit, int[][][] dp){
        if (i>= prices.length){
            return 0;
        }
        if (dp[i][buy][limit]!=-1){
            return dp[i][buy][limit];
        }
        int profit=0;
        if (buy==1){
            profit=Math.max(-prices[i]+solvemem(i+1,0,prices,limit, dp),solvemem(i+1,1,prices,limit, dp));
        }
        else {
            profit=Math.max(prices[i]+solvemem(i+1,1,prices,limit-1, dp),solvemem(i+1,0,prices,limit, dp));
        }
        dp[i][buy][limit]= profit;
        return dp[i][buy][limit];
    }
    public static int solvetab(int[] prices){
        int n= prices.length;
        int[][][] dp=new int[n+1][2][3];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<2;j++){
                for (int k=0;k<3;k++){
                    dp[i][j][k]=0;
                }
            }
        }
        for (int i=n-1;i>=0;i--){
            for (int buy=0;buy<=1;buy++){
                for (int limit=1;limit<=2;limit--){
                    int profit=0;
                    if (buy==1){
                        profit=Math.max(-prices[i]+dp[i+1][0][limit],dp[i+1][1][limit]);
                    }
                    else {
                        profit=Math.max(prices[i]+dp[i+1][1][limit-1],dp[i+1][0][limit]);
                    }
                    dp[i][buy][limit]= profit;

                }
            }
        }
        return dp[0][1][2];
    }
    public static int optimised(int[] prices){
        int n= prices.length;
        int[][]curr=new int[2][3];
        for (int i=0;i<curr.length;i++){
            for (int j=0;j<3;j++){
                curr[i][j]=0;
            }
        }
        int[][]next=new int[2][3];
        for (int i=0;i<next.length;i++){
            for (int j=0;j<3;j++){
                curr[i][j]=0;
            }
        }
        for (int i=n-1;i>=0;i--){
            for (int buy=0;buy<=1;buy++){
                for (int limit=1;limit<=2;limit--){
                    int profit=0;
                    if (buy==1){
                        profit=Math.max(-prices[i]+next[0][limit],next[1][limit]);
                    }
                    else {
                        profit=Math.max(prices[i]+next[1][limit-1],next[0][limit]);
                    }
                    curr[buy][limit]= profit;

                }
            }
            next=curr;
        }
        return next[1][2];
    }
}
