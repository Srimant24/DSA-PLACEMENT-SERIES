package DSA.BINARYTREE;

public class LOWESTCOMMONANCESTER {
    LOWESTCOMMONANCESTER(){

    }
    static class NODE14 {
        int value;
        NODE14 left;
        NODE14 right;

        public NODE14(int value) {

            this.value = value;
        }

    }
    public NODE14 root;
    public NODE14 LCA(NODE14 node,int n1,int n2){
        if (node==null){
            return  null;
        }
        if (node.value==n1||node.value==n2){
            return node;
        }
        NODE14 leftans = LCA(node.left,n1,n2);
        NODE14 rightans= LCA(node.right, n1, n2);

        if (leftans!=null&&rightans!=null){
            return  node;
        }
        if (leftans!=null&&rightans==null){
            return leftans;
        }
        if(leftans==null&&rightans!=null){
            return rightans;
        }else {
            return  null;
        }
    }
}
