package DSA.BINARYTREE;

import java.util.ArrayList;
import java.util.Queue;

public class ZIGZAGTRAVERSAL {
    ZIGZAGTRAVERSAL(){

    }
    static class NODE6 {
        int value;
        NODE6 left;
       NODE6 right;

        public NODE6(int value) {

            this.value = value;
        }

    }
    public NODE6 root;

    public ArrayList zigzagtraversal(NODE6 node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Queue<NODE6> Q=null;
        Q.add(node);
        boolean lefttoright=true;
        while(!Q.isEmpty()){
            ArrayList<Integer>ans = new ArrayList<>();
            NODE6 peek = Q.peek();
            Q.remove();
            for (int i=0;i< Q.size();i++){
                if(lefttoright){
                    int index=i;
                    ans.add(index,peek.value);
                }else{
                    int index= Q.size()-i-1;
                    ans.add(index, peek.value);
                }
                if(peek.left!=null){
                    Q.add(peek.left);
                }if (peek.right!=null){
                    Q.add(peek.right);
                }
            }
            lefttoright=!lefttoright;
            for (int i =0;i< ans.size();i++){
                result.add(ans.get(i));
            }
        }
        return result;
    }
}
