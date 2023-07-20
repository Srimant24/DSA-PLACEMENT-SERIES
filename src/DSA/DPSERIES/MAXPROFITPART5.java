package DSA.DPSERIES;

public class MAXPROFITPART5 {
    MAXPROFITPART5(){

    }
    public static int maxprofit(int[] prices,int fees){
        return optimised(prices,fees);
    }
    public static int optimised(int[] prices,int fees){
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
                    profit=Math.max(prices[i]+next[1]-fees,next[0]);
                }
                curr[buy]= profit;
            }
            next=curr;
        }
        return next[1];
    }
}
