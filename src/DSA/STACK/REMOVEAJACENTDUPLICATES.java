package DSA.STACK;

import java.util.Stack;

public class REMOVEAJACENTDUPLICATES {

    public static String removeAdjacentDuplicates(String str) {
        Stack<Character>stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<str.length();i++){
            if (!stack.empty()&&stack.peek()==str.charAt(i)){
                stack.pop();
            }
            else {
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String inputString = "abbaca";
        String result = removeAdjacentDuplicates(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("String after removing adjacent duplicates: " + result);
    }
}






