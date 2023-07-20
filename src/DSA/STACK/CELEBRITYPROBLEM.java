package DSA.STACK;

import java.util.Stack;
import java.util.Vector;

public class CELEBRITYPROBLEM {
    public static int celebrity(Vector<Vector<Integer>>M,int n){
        Stack<Integer>st=new Stack<>();
        for (int i=0;i<n;i++){
            st.push(i);
        }
        while (st.size()>1){
            int a =st.pop();
            int b=st.pop();
            if (knows(M,a,b)){
                st.push(b);
            }
            else {
                st.push(a);
            }
        }
        int zerocount=0;
        int candidate=st.pop();
        for (int i=0;i<n;i++){
            if (M.get(candidate).get(i)==0){
                zerocount++;
            }
        }
        if (zerocount!=n){
            return -1;
        }
        int onecount=0;

        for (int i=0;i<n;i++){
            if (M.get(i).get(candidate)==1){
                onecount++;
            }
        }
        if (onecount!=n-1){
            return -1;
        }
        return candidate;
    }

    public static boolean knows(Vector<Vector<Integer>> M, int a, int b) {
        if (M.get(a).get(b)==1){
            return true;
        }else {
            return false;
        }
    }
}
