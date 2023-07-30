package DSA.QUEE;

import java.util.Queue;
import java.util.Stack;

public class REVERSEAQUEE {
    public static Queue<Integer> reverse(Queue<Integer>queue){
        Stack<Integer>stack=new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
        return queue;
    }
}
