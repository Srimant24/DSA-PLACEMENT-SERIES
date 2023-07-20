package DSA.BINARYTREE;

public class FLATBINARYTREE {
    FLATBINARYTREE(){

    }
    static class NODE20 {
        int value;
        NODE20 left;
        NODE20 right;

        public NODE20(int value) {

            this.value = value;
        }

    }

    public NODE20 root;
    public  void flattree(NODE20 node){
        if (node==null){
            return;
        }
        NODE20 current=node;
        NODE20 prv=null;
        while(current!=null){
            if (current.left!=null){
                prv=current.left;
                while (prv.right!=null){
                    prv=prv.right;
                }
                prv.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
    }
}
