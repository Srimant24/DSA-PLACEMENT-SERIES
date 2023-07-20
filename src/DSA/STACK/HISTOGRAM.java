package DSA.STACK;

import java.util.Stack;
import java.util.Vector;

public class HISTOGRAM {
    HISTOGRAM(){

    }
    public static int largestrectanglearea(Vector<Integer>height){
        int n= height.size();
        Vector<Integer>next=new Vector<>(n);
        next=nextsmallerelement(height,n);
        Vector<Integer>prv=new Vector<>(n);
        prv=prvsmallerelement(height,n);
        int area=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            int l= height.get(i);
            if (next.get(i)==-1){
                next.set(i,n);
            }
            int b=next.get(i)- prv.get(i)-1;
            int newarea=l*b;
            area=Math.max(area,newarea);
        }
        return area;
    }

    public static Vector<Integer> prvsmallerelement(Vector<Integer> height, int n) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        Vector<Integer>ans=new Vector<>();
        for (int i=0;i<n;i++){
            int curr= height.get(i);
            while (stack.peek()!=-1&&height.get(stack.peek())>=curr){
                stack.pop();
            }
            ans.add(stack.peek());
            stack.push(i);
        }
        return ans;
    }

    public static Vector<Integer> nextsmallerelement(Vector<Integer> height, int n) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        Vector<Integer>ans=new Vector<>();
        for (int i=n-1;i>=0;i--){
            int curr= height.get(i);
            while (stack.peek()!=-1&&height.get(stack.peek())>=curr){
                stack.pop();
            }
            ans.add(stack.peek());
            stack.push(i);
        }
        return ans;
    }
}
