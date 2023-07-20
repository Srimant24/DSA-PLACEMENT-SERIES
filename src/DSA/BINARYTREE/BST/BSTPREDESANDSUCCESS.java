package DSA.BINARYTREE.BST;

public class BSTPREDESANDSUCCESS {
    BSTPREDESANDSUCCESS(){

    }
    static class NODE25 {
        int value;
        NODE25 left;
        NODE25 right;

        public NODE25(int value) {

            this.value = value;
        }

    }
    class pair{
        int pre;
        int suc;
        int first;
        int second;

        pair(int pre,int suc){
            this.pre=pre;
            this.suc=suc;
        }
    }
    public NODE25 root;
    public pair predesnadsuccess(NODE25 node,int key){
        pair p = new pair(0,0);
        int pre=-1;
        int suc=-1;
        NODE25 temp=node;
        while (temp.value!=key){
            if (key> temp.value){
                pre= temp.value;
                temp=temp.right;
            }
            else {
                suc= temp.value;
                temp=temp.left;
            }
        }
        NODE25 lefttree=temp.left;
        while (lefttree!=null){
            pre= lefttree.value;;
            lefttree=lefttree.left;
        }
        NODE25 righttree=temp.right;
        while (righttree!=null){
            pre= righttree.value;;
            lefttree=lefttree.right;
        }
        p.first= lefttree.value;
        p.second=righttree.value;
        return p;
    }
}
