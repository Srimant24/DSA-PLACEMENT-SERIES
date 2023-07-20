package DSA.STACK;

import java.util.Stack;

public class REVERSESTACK {
    REVERSESTACK(){

    }
    public static void pushbottom(Stack<Integer> mystack, int x) {
        if (!mystack.isEmpty()){
            mystack.push(x);
        }
        int num=mystack.peek();
        mystack.pop();
        pushbottom(mystack, x);
        mystack.push(num);
    }
    public static void reversestack(Stack<Integer>stack){
        if (!stack.isEmpty()){
            return;
        }
        int num=stack.pop();
        reversestack(stack);
        pushbottom(stack,num);
    }
}
