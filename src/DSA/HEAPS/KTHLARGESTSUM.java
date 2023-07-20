package DSA.HEAPS;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class KTHLARGESTSUM {
    KTHLARGESTSUM(){

    }
    public int kthlargestsum(int[] arr,int k){
        Vector<Integer>sum=new Vector<>();
        int size=arr.length;
        for (int i=0;i<size;i++){
            int s=0;
            for (int j=i;j<size;j++){
                s+=arr[j];
                sum.add(s);
            }
        }
        Collections.sort(sum);
        return sum.get(sum.size()-k);
    }
    public int optimalkthlargestsum(int[] arr,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for(int i=0;i< arr.length;i++){
            int sum=0;
            for (int j=i;j<arr.length;j++){
                sum+=arr[j];
                if (minHeap.size()<k){
                    minHeap.offer(sum);
                }
                else {
                    if (sum> minHeap.peek()){
                        minHeap.poll();
                        minHeap.offer(sum);
                    }
                }
            }
        }
        return minHeap.peek();
    }
}
