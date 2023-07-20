package DSA.STACK;

import java.util.Stack;

public class FINDREDUNDANTBRACKETS {
    FINDREDUNDANTBRACKETS(){

    }public static boolean findredundant(String str){
        Stack<Character>st=new Stack<>();
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (ch=='(' || ch=='*'|| ch=='+'||ch=='-' ||ch=='/'){
                st.push(ch);
            }
            else {
                if (ch==')'){
                    boolean isredundant=true;
                    while (st.peek()!='('){
                        char top=st.peek();
                        if (top=='*'|| top=='+'||top=='-' ||top=='/'){
                            isredundant=false;
                        }
                        st.pop();
                    }
                    if (isredundant==true){
                        return true;
                    }

                }
            }
        }
        return false;
    }
}
