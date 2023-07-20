package DSA.BINARYTREE.BST;

public class FINDLARGESTBST {
    FINDLARGESTBST(){

    }
    static class NODE32{
        int value;
        NODE32 left;
        NODE32 right;

        public NODE32(int value) {

            this.value = value;
        }
    }
    class info{
        int max;
        int min;
        boolean isbst;
        int size;
    }
    public NODE32 root;
    public int max(NODE32 node){
        int maxsize=0;
        info information =solve(node,maxsize);
        return maxsize;
    }

    public info solve(NODE32 node, int maxsize) {
        info in=null;
        if (node==null){
            return in;
        }
        info left=solve(node.left,maxsize);
        info right=solve(node.right,maxsize);
        in.max=Math.max(node.value,right.max);
        in.min=Math.min(node.value, left.min);
        in.size= left.size+ right.size+1;
        if (left.isbst&& right.isbst&&(root.value>left.max&&root.value< right.min)){
            in.isbst=true;
        }else{
            in.isbst=false;
        }
        if (in.isbst==true){
            maxsize=Math.max(maxsize,in.size);
        }
        return in;
    }
}
