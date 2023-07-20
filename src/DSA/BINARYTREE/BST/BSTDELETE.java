package DSA.BINARYTREE.BST;

public class BSTDELETE {
    BSTDELETE(){

    }
    static class NODE22 {
        int value;
        NODE22 left;
        NODE22 right;

        public NODE22(int value) {

            this.value = value;
        }

    }

    public NODE22 root;

    public NODE22 delete(NODE22 node,int n){
        if (node==null){
            return node;
        }
        if (node.value==n){
            if (node.left==null && node.right==null){
                return null;
            }
            if (node.left!=null && node.right==null){
                NODE22 temp = node.left;
                node=null;
                return temp;
            }
            if (node.left==null && node.right!=null){
                NODE22 temp = node.right;
                node=null;
                return temp;
            }
            if (node.left!=null && node.right!=null){
                int mini=minimum(node.right).value;
                node.value=mini;
                node.right=delete(node.right,n);
                return node;
            }
        }else{
            if (n> node.value){
                node.right=delete(node.right,n);
            }else {
                node.left=delete(node.left,n);
            }
        }
        return node;
    }

    public NODE22 minimum(NODE22 right) {
        NODE22 temp=right;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }
}
