package DSA.STACK;

import java.util.Stack;

public class MINCOSTTOMAKESTRINGVALID {
    MINCOSTTOMAKESTRINGVALID(){

    }
    public static int findminimumcost(String str){
        if (str.length()%2==1){
            return -1;
        }
        Stack<Character>st=new Stack<>();
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (ch=='('){
                st.push(ch);
            }
            else {
                if (!st.empty() && st.peek()=='('){
                    st.pop();
                }
                else {
                    st.pop();
                }
            }
        }
        int a=0;
        int b=0;
        while (!st.empty()){
            if (st.peek()=='('){
                b++;
            }else {
                a++;
            }
            st.pop();
        }
        int ans=(a+1)/2 + (b+1)/2;
        return ans;
    }
}
