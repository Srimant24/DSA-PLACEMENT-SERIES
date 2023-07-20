package DSA.DPSERIES;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class LONGESTARITHMATICSUBSEQUENCEFORGIVENDIFF {
    LONGESTARITHMATICSUBSEQUENCEFORGIVENDIFF(){

    }
    public static int longsub(Vector<Integer>arr,int diff){
        Map<Integer,Integer>dp=new HashMap<>();
        int ans=0;
        for (int i=0;i< arr.size();i++){
            int temp=arr.get(i)-diff;
            int tempans=0;
            if (dp.containsKey(temp)){
                tempans=dp.get(temp);
            }
            dp.put(arr.get(i),1+tempans);
            ans=Math.max(ans,dp.get(arr.get(i)));
        }
        return ans;
    }
}
