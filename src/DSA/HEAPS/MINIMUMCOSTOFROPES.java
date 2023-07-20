package DSA.HEAPS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MINIMUMCOSTOFROPES {
    MINIMUMCOSTOFROPES(){

    }
    public int mincost(int[] arr){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i =0;i< arr.length;i++){
            minHeap.offer(arr[i]);
        }
        int ans=0;
        while (minHeap.size()>1){
            int min1=minHeap.peek();
            minHeap.poll();
            int min2=minHeap.peek();
            minHeap.poll();
            int sum=min1+min2;
            ans+=sum;
            minHeap.offer(ans);
        }
        return ans;
    }
}
