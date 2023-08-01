package DSA.QUEE;
import java.util.Queue;
import java.util.Stack;

public class INTERLEAVEDQUEE {
    public static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            throw new IllegalArgumentException("Queue size must be even.");
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> reversedStack = new Stack<>();
        int halfSize = queue.size() / 2;

        // Push the first half of the queue into the stack
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.poll());
        }

        // Reverse the elements in the stack
        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }

        // Interleave the elements from the reversed stack and the remaining queue
        while (!reversedStack.isEmpty()) {
            queue.offer(reversedStack.pop());
            queue.offer(queue.poll());
        }
    }
}
