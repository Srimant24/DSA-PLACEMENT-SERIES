package DSA.DPSERIES;

import java.util.Vector;

public class MAXPROFITPART1 {
    MAXPROFITPART1(){

    }
    public static int maxprofit(Vector<Integer>prices){
        int n= prices.size();
        int min=prices.get(0);
        int profit=0;
        for (int i =1;i<n;i++){
            int diff=prices.get(i)-min;
            profit=Math.max(diff,profit);
            min=Math.min(min,prices.get(i));
        }
        return profit;
    }
}
