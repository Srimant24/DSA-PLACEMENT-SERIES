package DSA.BINARYTREE;

public class HEIGHTOFTREE {
    public HEIGHTOFTREE(){

    }
    static class NODE1 {
        int value;
        NODE1 left;
        NODE1 right;
        int height;

        public NODE1(int value) {

            this.value = value;
        }

    }
    public NODE1 root;
     int height(NODE1 node){
         if (node==null){
             return 0;
         }
         return  Math.max(height(node.left),height(node.right))+1;
     }
}
