package DSA.STACK;

import java.util.Stack;
import java.util.Vector;

public class NEXTSMALLERELEMENT {
    NEXTSMALLERELEMENT(){

    }
    public static Vector<Integer>nextsmallelement(Vector<Integer>arr,int n){
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        Vector<Integer>ans=new Vector<>();
        for (int i=n-1;i>=0;i--){
            int curr= arr.get(i);
            while (stack.peek()>=curr){
                stack.pop();
            }
            ans.add(stack.peek());
            stack.push(curr);
        }
        return ans;
    }
}
