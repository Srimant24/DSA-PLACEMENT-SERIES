package DSA.BINARYTREE.BST;

import java.util.ArrayList;

public class FLATBST {
    FLATBST(){

    }
    static class NODE28 {
        int value;
        NODE28 left;
        NODE28 right;

        public NODE28(int value) {

            this.value = value;
        }
    }
    public NODE28 root;
    public void flat(NODE28 node){
        ArrayList<Integer>list= new ArrayList<>();
        fbst(node,list);
        NODE28 root = new NODE28(list.get(0));
        NODE28 curr=root;
        for (int i=1;i< list.size()-1;i++){
            NODE28 temp=new NODE28(list.get(i));
            curr.left=null;
            curr.right=temp;
            curr=temp;
        }
        curr.left=null;
        curr.right=null;
    }

    public void fbst(NODE28 node, ArrayList<Integer> list) {
        if (node==null){
            return;
        }
        fbst(node.left,list);
        list.add(node.value);
        fbst(node.right,list);
    }
}
