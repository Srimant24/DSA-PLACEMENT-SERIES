package DSA.HEAPS;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class MergeKSortedArrays {
    public static class HeapNode
            implements Comparable<HeapNode> {
        int x;
        int y;
        int value;

        HeapNode(int x, int y, int value)
        {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override public int compareTo(HeapNode hn)
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
    public static ArrayList<Integer>
    mergeKArrays(int[][] arr, int K)
    {
        ArrayList<Integer> result
                = new ArrayList<Integer>();
        PriorityQueue<HeapNode> heap
                = new PriorityQueue<HeapNode>();

        // Initially add only first column of elements. First
        // element of every array
        for (int i = 0; i < arr.length; i++) {
            heap.add(new HeapNode(i, 0, arr[i][0]));
        }

        HeapNode curr = null;
        while (!heap.isEmpty()) {
            curr = heap.poll();
            result.add(curr.value);

            // Check if next element of curr min exists,
            // then add that to heap.
            if (curr.y < (arr[curr.x].length - 1)) {
                heap.add(
                        new HeapNode(curr.x, curr.y + 1,
                                arr[curr.x][curr.y + 1]));
            }
        }

        return result;
    }
}
