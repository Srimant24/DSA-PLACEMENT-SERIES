package DSA.BINARYTREE;

public class BALANCETREE {
    public BALANCETREE(){

    }
    static class NODE3 {
        int value;
        NODE3 left;
        NODE3 right;
        int height;

        public NODE3(int value) {

            this.value = value;
        }
    }

    public NODE3 root;
    class pair{
        boolean b;
        boolean first;
        int height;
        int second;

        pair(boolean b,int height){
            this.b=b;
            this.height=height;
        }
    }
    int height(NODE3 node){
        if (node==null){
            return 0;
        }
        return  Math.max(height(node.left),height(node.right))+1;
    }
    public boolean balance()
    {

        return balance(root);
    }
    public boolean balance1()
    {

        return balancefast(root).first;
    }

    private pair balancefast(NODE3 node) {
        if(node==null){
            pair p = new pair(true,0);
            return p;
        }
        pair left=balancefast(node.left);
        pair right=balancefast(node.right);

        boolean one=left.first;
        boolean two=right.first;
        int h = Math.abs(left.second- right.second);
        pair ans=null;
        ans.second=Math.max(left.second, right.second)+1;
        if (one&&two&&h<=1){
             ans.first=true;
        }else{
            ans.first=false;
        }
        return ans;
    }

    public boolean balance(NODE3 node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balance(node.left) && balance(node.right);
    }
}
