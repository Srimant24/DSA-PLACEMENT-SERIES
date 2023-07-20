package DSA.STACK;

import java.util.Stack;

public class DELETEMIDDLEELMENTFORMSTACK {
    DELETEMIDDLEELMENTFORMSTACK(){

    }
    public static void deletemiddle(Stack<Integer>input,int n){
        int count=0;
        solve(input,count,n);
    }

    public static void solve(Stack<Integer> input, int count, int n) {
        if (count==n/2){
            input.pop();
            return;
        }
        int num=input.peek();
        input.pop();
        solve(input, count+1, n);
        input.push(num);
    }
}
