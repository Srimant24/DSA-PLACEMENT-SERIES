package DSA.STACK;

import java.util.Stack;

public class SORTSTACK {
    SORTSTACK(){

    }
    public static void sortstack(Stack<Integer>stack){
        if (stack.isEmpty()){
            return;
        }
        int num=stack.pop();
        sortstack(stack);
        insertsorted(stack,num);
    }

    public static void insertsorted(Stack<Integer> stack, int num) {
        if (stack.empty() || !stack.isEmpty() && stack.peek() <num){
            stack.push(num);
            return;
        }
        int n=stack.pop();
        insertsorted(stack,num);
        stack.push(n);
    }
}
