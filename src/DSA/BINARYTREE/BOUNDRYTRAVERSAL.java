package DSA.BINARYTREE;

import java.util.ArrayList;

public class BOUNDRYTRAVERSAL {
    BOUNDRYTRAVERSAL(){

    }
    static class NODE7 {
        int value;
        NODE7 left;
        NODE7 right;

        public NODE7(int value) {

            this.value = value;
        }

    }
    public NODE7 root;
    public  void lefttraversal(NODE7 node, ArrayList<Integer>list){
        if(node==null||node.left==null&&node.right==null){
            return;
        }
        list.add(node.value);
        if (node.left!=null){
            lefttraversal(node.left,list);
        }
        if (node.right!=null){
            lefttraversal(node.right,list);
        }
    }
    public void traverseleaf(NODE7 node,ArrayList<Integer>list){
        if (node==null){
            return;
        }if(node.left==null&&node.right==null){
            list.add(node.value);
        }
        traverseleaf(node.left,list);
        traverseleaf(node.right,list);
    }
    public void righttraversal(NODE7 node,ArrayList<Integer>list){
        if(node==null||node.left==null&&node.right==null){
            return;
        }
        if (node.right!=null){
            righttraversal(node.right,list);
        }if(node.left!=null){
            righttraversal(node.left,list);
        }
        list.add(node.value);
    }
    public ArrayList boundarytraversal(NODE7 node){
        ArrayList<Integer>list=null;
        if (node==null){
            return list;
        }
        list.add(node.value);
        lefttraversal(node.left,list);
        traverseleaf(node.left,list);
        traverseleaf(node.right,list);
        righttraversal(node.right,list);
        return list;
    }
}
