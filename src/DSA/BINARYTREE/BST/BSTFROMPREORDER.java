package DSA.BINARYTREE.BST;

public class BSTFROMPREORDER {
    BSTFROMPREORDER(){

    }
    static class NODE29 {
        int value;
        NODE29 left;
        NODE29 right;

        public NODE29(int value) {

            this.value = value;
        }
    }
    public NODE29 root;
    public NODE29 preorder(int[] pre){
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        int i=0;
        return bstfrompre(pre,min,max,i);
    }

    public NODE29 bstfrompre(int[] pre, int min, int max, int i) {
        if (i>= pre.length){
            return null;
        }
        if (pre[i]<min || pre[i]>max){
                return null;
        }
        NODE29 root = new NODE29(pre[i++]);
        root.left=bstfrompre(pre,min, root.value,i);
        root.right=bstfrompre(pre, root.value,max,i);
        return root;
    }
}
