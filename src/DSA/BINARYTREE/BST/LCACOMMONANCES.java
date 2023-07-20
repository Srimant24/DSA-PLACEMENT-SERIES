package DSA.BINARYTREE.BST;

public class LCACOMMONANCES {
    LCACOMMONANCES(){

    }
    static class NODE26 {
        int value;
        NODE26 left;
        NODE26 right;

        public NODE26(int value) {

            this.value = value;
        }
    }
        public NODE26 root;
        public NODE26 commonances(NODE26 node,NODE26 p,NODE26 q){
            if (node==null){
                return null;
            }
            if (p.value>node.value && q.value>node.value){
                commonances(node.right,p,q);
            }
            if (p.value<node.value && q.value<node.value){
                commonances(node.left,p,q);
            }
            return node;
        }
   }
