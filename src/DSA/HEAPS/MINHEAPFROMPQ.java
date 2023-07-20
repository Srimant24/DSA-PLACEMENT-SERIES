package DSA.HEAPS;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MINHEAPFROMPQ {
    public static void main(String[] args) {
        // Create a PriorityQueue with a custom Comparator
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

        // Insert elements into the min heap
        minHeap.offer(20);
        minHeap.offer(78);
        minHeap.offer(50);
        minHeap.offer(30);
        minHeap.offer(90);
        minHeap.offer(10);

        // Remove and print the elements from the min heap
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
