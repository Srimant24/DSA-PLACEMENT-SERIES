package DSA.DPSERIES;

public class MAXPROFITPART4 {
    MAXPROFITPART4(){

    }
    public static int maxprofit(int[] prices,int k){
        int n=prices.length;
        int op=2*k;
        int[][] dp=new int[n][2*k];
        for (int i=0;i<prices.length;i++){
            for (int j=0;j<op;j++){
                dp[i][j]=-1;
            }
        }
        solvemem(0,0,prices,k,dp);
        return solve(0,0,prices,k);
    }

    public static int solvemem(int i, int op, int[] prices, int k, int[][] dp) {
        if (i== prices.length){
            return 0;
        }
        if (op==2*k){
            return 0;
        }
        if (dp[i][op]!=-1){
            return dp[i][op];
        }
        int profit=0;
        if (op%2==0){
            profit=Math.max(-prices[i]+solvemem(i+1,op+1,prices,k,dp),solvemem(i+1,op,prices,k,dp));
        }
        else {
            profit=Math.max(prices[i]+solvemem(i+1,op+1,prices,k,dp),solvemem(i+1,op,prices,k,dp));
        }
        dp[i][op] = profit;
        return dp[i][op];
    }

    public static int solve(int i,int op,int[] prices,int k){
        if (i== prices.length){
            return 0;
        }
       if (op==2*k){
           return 0;
       }
       int profit=0;
       if (op%2==0){
           profit=Math.max(-prices[i]+solve(i+1,op+1,prices,k),solve(i+1,op,prices,k));
       }
       else {
           profit=Math.max(prices[i]+solve(i+1,op+1,prices,k),solve(i+1,op,prices,k));
       }
       return profit;
    }
    public static int solvetab(int[] prices,int k){
        int n=prices.length;
        int op=2*k;
        int[][] dp=new int[n+1][2*k+1];
        for (int i=0;i<prices.length;i++){
            for (int j=0;j<op;j++){
                dp[i][j]=0;
            }
        }
        for (int i=n-1;i>=0;i--){
            for (int j=0;op<2*k;op++){
                int profit=0;
                if (op%2==0){
                    profit=Math.max(-prices[i]+dp[i+1][j+1],dp[i+1][j]);
                }
                else {
                    profit=Math.max(prices[i]+dp[i+1][j+1],dp[i+1][j]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
    public static int optimised(int[] prices,int k){
        int n= prices.length;
        int[] curr=new int[2*k+1];
        for (int i=0;i< curr.length;i++){
            curr[i]=0;
        }
        int[] next=new int[2*k+1];
        for (int i=0;i< curr.length;i++){
            next[i]=0;
        }
        for (int i=n-1;i>=0;i--){
            for (int op=0;op<2*k;op++){
                int profit=0;
                if (op%2==0){
                    profit=Math.max(-prices[i]+next[op+1],next[op]);
                }
                else {
                    profit=Math.max(prices[i]+next[op+1],next[op]);
                }
                curr[op] = profit;
            }
            next=curr;
        }
        return next[0];
    }
}
