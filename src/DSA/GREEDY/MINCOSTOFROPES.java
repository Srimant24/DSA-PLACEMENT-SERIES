package DSA.GREEDY;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MINCOSTOFROPES {
    MINCOSTOFROPES(){

    }
    public static int mincost(int[] rope,int n){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i=0;i<n;i++){
            minHeap.add(rope[i]);
        }
        int cost=0;
        while (minHeap.size()>1){
            int first=minHeap.poll();
            int second=minHeap.poll();
            int mergedlength=first+second;
            cost+=mergedlength;
            minHeap.add(mergedlength);
        }
        return cost;
    }
}
