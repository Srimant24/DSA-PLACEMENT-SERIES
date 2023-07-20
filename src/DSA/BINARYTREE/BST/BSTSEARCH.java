package DSA.BINARYTREE.BST;

public class BSTSEARCH {
    BSTSEARCH(){

    }
    static class NODE21 {
        int value;
        NODE21 left;
        NODE21 right;

        public NODE21(int value) {

            this.value = value;
        }

    }

    public NODE21 root;

    public boolean search(NODE21 node,int n){
        if (node==null){
            return false;
        }
        if (node.value==n){
            return true;
        }
        if (n>node.value){
            return search(node.right,n);
        }
        else {
            return search(node.left,n);
        }
    }
    public boolean search1(NODE21 node,int n){
        NODE21 temp=node;
        while(temp!=null){
            if (temp.value==n){
                return true;
            }
            if (n>node.value){
                temp=temp.right;
            }
            if (n>node.value){
                temp=temp.left;
            }
        }
        return false;
    }
}
