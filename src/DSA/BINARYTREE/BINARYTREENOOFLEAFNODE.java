package DSA.BINARYTREE;

public class BINARYTREENOOFLEAFNODE {
    BINARYTREENOOFLEAFNODE(){

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
    public int noofleaf(NODE23 node){
        int count=0;
        noofleafnode(node,count);
        return count;
    }
    public void noofleafnode(NODE23 node,int count){

        if (node==null){
            return ;
        }
        noofleafnode(node.left,count);
        if (node.left==null&&node.right==null){
            count++;
        }
        noofleafnode(node.right,count);
    }
}
