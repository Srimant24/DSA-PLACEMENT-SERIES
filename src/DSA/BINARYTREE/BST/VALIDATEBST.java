package DSA.BINARYTREE.BST;

public class VALIDATEBST {
    VALIDATEBST(){

    }
    static class NODE23 {
        int value;
        NODE23 left;
        NODE23 right;

        public NODE23(int value) {

            this.value = value;
        }

    }

    public NODE23 root;
    public boolean validatebst(NODE23 node){
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        boolean isvalid= valid(node,min,max);
        return isvalid;
    }
    public boolean valid(NODE23 node,int min,int max){
        if (node==null){
            return true;
        }
        if (node.value>min && node.value<max){
            boolean left=valid(node.left,min,node.value);
            boolean right=valid(node.right, node.value,max);
            return left&&right;
        }else{
            return false;
        }
    }
}
