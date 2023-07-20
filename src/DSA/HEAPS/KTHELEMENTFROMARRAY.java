package DSA.HEAPS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KTHELEMENTFROMARRAY {
    KTHELEMENTFROMARRAY(){

    }
    public int kthelement(int[] arr,int k,int n){
        //n = ending index i.e maxHeap.size()-1
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0;i<k;i++){
            maxHeap.offer(arr[i]);
        }
        for (int i=k;i<=n;i++){
            if (arr[i]< maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        int ans = maxHeap.peek();
        return ans;
    }
    /*
    for kth the smallest element form min heap and then reverse the sign of comparision in line 17
    */
}
