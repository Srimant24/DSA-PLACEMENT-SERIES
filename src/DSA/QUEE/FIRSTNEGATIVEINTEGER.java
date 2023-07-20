package DSA.QUEE;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Vector;

public class FIRSTNEGATIVEINTEGER {
    public static Vector<Integer>printfirstnegativeelement(int[] arr,int n,int k){
        Deque<Integer>deque = new ArrayDeque<>();
        Vector<Integer>ans = new Vector<>();
        for (int i=0;i<k;i++){
            if (arr[i]<0){
                deque.addLast(i);
            }
        }
        if (deque.size()>0){
            ans.add(arr[deque.pollFirst()]);
        }else {
            ans.add(0);
        }
        for (int i=k;i<n;i++){
            if (!deque.isEmpty()&&i-deque.peekFirst()>=k){
                deque.pollFirst();
            }else {
                if (arr[i]<0){
                    deque.addLast(i);
                }
            }
            if (deque.size()>0){
                ans.add(arr[deque.pollFirst()]);
            }else {
                ans.add(0);
            }
        }
        return ans;
    }
}
