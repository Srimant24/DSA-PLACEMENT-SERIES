package DSA.STACK;

import java.util.Stack;

public class VALIDPARENTHESIS {
    VALIDPARENTHESIS(){

    }
    public static boolean isvalidparenthsis(String str){
        Stack<Character>stack=new Stack<>();
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }
            else {
                if (!stack.isEmpty()){
                    if (ch==')'){
                        if (stack.peek()=='('){
                            stack.pop();
                        }
                    }
                    if (ch==']'){
                        if (stack.peek()=='['){
                            stack.pop();
                        }
                    }
                    if (ch=='}'){
                        if (stack.peek()=='{'){
                            stack.pop();
                        }
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        VALIDPARENTHESIS st=new VALIDPARENTHESIS();
        System.out.println(st.isvalidparenthsis("{[)}"));
    }
}
