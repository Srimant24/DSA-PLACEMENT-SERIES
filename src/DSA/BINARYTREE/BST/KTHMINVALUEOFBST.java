package DSA.BINARYTREE.BST;

public class KTHMINVALUEOFBST {
    KTHMINVALUEOFBST(){

    }
    static class NODE24 {
        int value;
        NODE24 left;
        NODE24 right;

        public NODE24(int value) {

            this.value = value;
        }

    }

    public NODE24 root;
    public int returnkthmin(NODE24 node){
        int i=0;
        int k=3;
        int value=kthmin(node,i,k);
        return value;
    }

    public int kthmin(NODE24 node, int i, int k) {
        if (node==null){
            return -1;
        }
        int left=kthmin(node.left,i,k);
        if(left!=-1){
            return left;
        }
        i++;
        if (i==k){
            return node.value;
        }
        return kthmin(node.right,i,k);
    }
}
