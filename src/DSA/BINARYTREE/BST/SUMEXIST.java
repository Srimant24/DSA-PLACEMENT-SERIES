package DSA.BINARYTREE.BST;

import java.util.ArrayList;

public class SUMEXIST {
    SUMEXIST(){

    }
    static class NODE27 {
        int value;
        NODE27 left;
        NODE27 right;

        public NODE27(int value) {

            this.value = value;
        }
    }
    public NODE27 root;
    public boolean sum(NODE27 node,int target){
        ArrayList<Integer>list=new ArrayList<>();
        getlist(node,list);
        int start=0;
        int end= list.size()-1;
        int sum=0;
        while (start<=end){
            sum= list.get(start)+ list.get(end);
            if (sum==target){
                return true;
            } else if (sum>target) {
                end--;
            }else {
                start++;
            }
        }
        return false;
    }

    public void getlist(NODE27 node, ArrayList<Integer> list) {
        if (node==null){
            return;
        }
        getlist(node.left,list);
        list.add(node.value);
        getlist(node.right,list);
    }
}
