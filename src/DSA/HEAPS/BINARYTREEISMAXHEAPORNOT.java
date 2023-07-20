package DSA.HEAPS;

import DSA.BINARYTREE.BST.MERGETWOBST1;

public class BINARYTREEISMAXHEAPORNOT {
    BINARYTREEISMAXHEAPORNOT(){

    }
    static class NODE32{
        int value;
        NODE32 left;
        NODE32 right;

        public NODE32(int value) {

            this.value = value;
        }

    }
    public NODE32 root;
    public boolean isBINARYTREEISMAXHEAPORNOT(NODE32 node){
        int index=0;
        int totalcount=count(node);
        if (iscbt(node,index,totalcount) && ismaxheap(node)) {
            return true;
        }
        return false;
    }

    public boolean ismaxheap(NODE32 node) {
        if (node.left==null&&node.right==null){
            return true;
        }if (node.left!=null){
            return node.value>node.left.value;
        }
        if (node.left!=null&&node.right!=null){
            return node.value>node.left.value&&node.value>node.right.value&&ismaxheap(node.left)&&ismaxheap(node.right);
        }
        return false;
    }

    public int count(NODE32 node) {
        if (root==null){
            return 0;
        }
        int no=1+count(node.left)+count(node.right);
        return no;
    }

    public boolean iscbt(NODE32 node,int index,int noofnodes) {
        if (node==null){
            return true;
        }
        if (index>=noofnodes){
            return false;
        }
        else{
            boolean left=iscbt(node.left, 2*index+1, noofnodes);
            boolean right=iscbt(node.right, 2*index+2, noofnodes);
            return left&&right;
        }
    }
}
