package DSA.GREEDY;

import java.util.Arrays;
import java.util.Vector;

public class CANDYDISTRIBUTION {
    CANDYDISTRIBUTION(){

    }
    public static int findmin(int[] a,int n,int m){
        Arrays.sort(a);
        int i=0;
        int j=m-1;
        int mini=Integer.MAX_VALUE;
        while (j<a.length){
            int diff=a[j]-a[i];
            mini=Math.min(mini,diff);
            i++;
            j++;
        }
        return mini;
    }
}
