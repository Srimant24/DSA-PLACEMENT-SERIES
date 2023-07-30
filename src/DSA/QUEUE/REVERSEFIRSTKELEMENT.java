package DSA.QUEE;

import java.util.Queue;
import java.util.Stack;

public class REVERSEFIRSTKELEMENT {
    public static Queue<Integer>modifyquee(Queue<Integer>q,int k){
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<k;i++){
            stack.push(q.poll());
        }
        while (!stack.isEmpty()){
            q.add(stack.pop());
        }
        int t=q.size()-k;
        while (t>0){
            q.add(q.poll());
        }
        return q;
    }
}
