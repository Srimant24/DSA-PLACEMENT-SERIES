package DSA.HEAPS;
import java.util.PriorityQueue;
import java.util.Comparator;
public class MAXHEAPFROMPQ {
    public static void main(String[] args) {
        // Create a PriorityQueue with a custom Comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Insert elements into the max heap
        maxHeap.offer(20);
        maxHeap.offer(78);
        maxHeap.offer(50);
        maxHeap.offer(30);
        maxHeap.offer(90);
        maxHeap.offer(10);

        // Remove and print the elements from the max heap
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
