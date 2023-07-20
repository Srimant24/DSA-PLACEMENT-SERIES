package DSA.BINARYTREE;

public class IDENTICALBINARYTREE {
    IDENTICALBINARYTREE(){

    }
    static class NODE4 {
        int value;
        NODE4 left;
        NODE4 right;

        public NODE4(int value) {

            this.value = value;
        }

    }
    public NODE4 root;

    public boolean isidentical(NODE4 node1,NODE4 node2){
        if(node1==null && node2==null){
            return  true;
        }
        if(node1!=null && node2==null){
            return  false;
        }
        if(node1==null && node2!=null){
            return  false;
        }
        boolean left=isidentical(node1.left,node2.left);
        boolean right=isidentical(node1.right,node2.right);
        boolean value=(node1.value== node2.value);
        if (left && right && value){
            return  true;
        }
        return false;
    }
}
