package DSA.STACK;

import java.util.Stack;

public class SPECIALSTACK {
    static Stack<Integer>stack;
    static int mini;
    public static void push(int data){
        if (stack.empty()){
            stack.push(data);
            mini=data;
        }else {
            if (data<mini){
                stack.push(2*data-mini);
                mini=data;
            }
            else {
                stack.push(data);
            }
        }
    }
    public static int pop(){
        if (stack.empty()){
            return -1;
        }
        int curr= stack.pop();
        if (curr>mini){
            return curr;
        }else {
            int prvmin=mini;
            int value=2*mini-curr;
            mini=value;
            return prvmin;
        }
    }
    public static int top(){
        if (stack.empty())
        {
        return -1;
        }
        int curr=stack.peek();
        if (curr<mini){
            return mini;
        }else {
            return curr;
        }
    }
    public static boolean isempty(){
        return stack.empty();
    }
    public static int getmin(){
        if (stack.empty()){
            return -1;
        }
        else {
            return mini;
        }
    }
}
