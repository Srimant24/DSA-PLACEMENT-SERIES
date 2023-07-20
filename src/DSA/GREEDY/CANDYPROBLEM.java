package DSA.GREEDY;

import java.util.Arrays;
import java.util.Vector;

public class CANDYPROBLEM {
    CANDYPROBLEM(){

    }
    public static Vector<Integer> candystore(int[] candy,int n,int k){
        Arrays.sort(candy);
        int mini=0;
        int buy=0;
        int free=n-1;
        while (buy<=free){
            mini=mini+candy[buy];
            buy++;
            free=free-k;
        }
        int maxi=0;
        int buy1=n-1;
        int free1=0;
        while (free1<=buy1){
            maxi=maxi+candy[buy1];
            buy1--;
            free1=free1+k;
        }
        Vector<Integer>ans=new Vector<>();
        ans.add(mini);
        ans.add(maxi);
        return ans;

    }
}
