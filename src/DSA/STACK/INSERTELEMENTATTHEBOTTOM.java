package DSA.STACK;

import java.util.Stack;

public class INSERTELEMENTATTHEBOTTOM {
    INSERTELEMENTATTHEBOTTOM(){

    }
    public static Stack<Integer> solve(Stack<Integer>mystack,int x){
        pushbottom(mystack,x);
        return mystack;
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
}
