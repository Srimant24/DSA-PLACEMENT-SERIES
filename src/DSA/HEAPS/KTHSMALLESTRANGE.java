package DSA.HEAPS;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KTHSMALLESTRANGE {
    KTHSMALLESTRANGE(){

    }
    public static class HeapNode1
            implements Comparable<HeapNode1> {
        int x;
        int y;
        int value;

        HeapNode1(int x, int y, int value)
        {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override public int compareTo(HeapNode1 hn)
        {
            if (this.value <= hn.value) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }

    // Function to merge k sorted arrays.
    public static int
    mergeKArrays(int[][] arr, int K)
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        PriorityQueue<HeapNode1> heap
                = new PriorityQueue<HeapNode1>();

        // Initially add only first column of elements. First
        // element of every array
        for (int i = 0; i < arr.length; i++) {
            min=Math.min(min,arr[i][0]);
            max=Math.max(max,arr[i][0]);
            heap.add(new HeapNode1(i, 0, arr[i][0]));
        }
        int start=min;
        int end=max;
        while (!heap.isEmpty()) {
          HeapNode1 curr = heap.poll();
          min= curr.value;
          if (max-min<end-start){
              start=min;
              end=max;
          }

            if (curr.y+1 < (arr[curr.x].length - 1)) {
                max=Math.max(max,arr[curr.x][curr.y + 1]);
                heap.add(new HeapNode1(curr.x, curr.y + 1,arr[curr.x][curr.y + 1]));
            }
            else {
                break;
            }
        }

        return (end-start+1);
    }
}
