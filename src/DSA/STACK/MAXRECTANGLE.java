package DSA.STACK;

import java.util.Stack;
import java.util.Vector;

public class MAXRECTANGLE {
    public static int largestrectanglearea(int[] height){
        int n= height.length;
        Vector<Integer>next=new Vector<>(n);
        next=nextsmallerelement(height,n);
        Vector<Integer>prv=new Vector<>(n);
        prv=prvsmallerelement(height,n);
        int area=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            int l= height[(i)];
            if (next.get(i)==-1){
                next.set(i,n);
            }
            int b=next.get(i)- prv.get(i)-1;
            int newarea=l*b;
            area=Math.max(area,newarea);
        }
        return area;
    }
    public static Vector<Integer> prvsmallerelement(int[] height, int n) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        Vector<Integer>ans=new Vector<>();
        for (int i=0;i<n;i++){
            int curr= height[(i)];
            while (stack.peek()!=-1&&height[(stack.peek())]>=curr){
                stack.pop();
            }
            ans.add(stack.peek());
            stack.push(i);
        }
        return ans;
    }
    public static Vector<Integer> nextsmallerelement(int[] height, int n) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        Vector<Integer>ans=new Vector<>();
        for (int i=n-1;i>=0;i--){
            int curr= height[(i)];
            while (stack.peek()!=-1&&height[(stack.peek())]>=curr){
                stack.pop();
            }
            ans.add(stack.peek());
            stack.push(i);
        }
        return ans;
    }
    public static int maxarea(int[][]M,int n,int m){
        int area=largestrectanglearea(M[0]);
        for (int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if (M[i][j]!=0){
                    M[i][j]=M[i][j]+M[i-1][j];
                }
                else {
                    M[i][j]=0;
                }
            }
            area=Math.max(area,largestrectanglearea(M[i]));
        }
        return area;
    }
}
