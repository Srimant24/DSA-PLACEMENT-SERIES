package DSA.BINARYTREE;

public class SUMTREE {
    SUMTREE(){

    }
    static class NODE5 {
        int value;
        NODE5 left;
        NODE5 right;

        public NODE5(int value) {

            this.value = value;
        }

    }
    public NODE5 root;

    class pair{
        boolean b;
        int sum;
        boolean first;
        int second;

        pair(boolean b,int sum){
            this.b=b;
            this.sum=sum;
        }
    }
    public boolean issumtree(){
        return sumfast(root).first;
    }

    private pair sumfast(NODE5 node) {
        if (node==null){
            pair p = new pair(true,0);
            return p;
        }
        if (node.left==null && node.right==null){
            pair p = new pair(true,node.value);
            return p;
        }
        pair left=sumfast(node.left);
        pair right=sumfast(node.right);

        boolean one=left.first;
        boolean two= right.first;
        boolean three=(node.value== left.second+ right.second);
        pair ans=null;
        if (one && two && three){
            ans.first=true;
            ans.second=2*node.value;
        }else{
            ans.first=false;
        }
        return ans;
    }
}
