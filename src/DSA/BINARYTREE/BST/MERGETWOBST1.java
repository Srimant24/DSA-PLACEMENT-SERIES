package DSA.BINARYTREE.BST;

public class MERGETWOBST1 {
    MERGETWOBST1(){

    }
    static class NODE31{
        int value;
        NODE31 left;
        NODE31 right;

        public NODE31(int value) {

            this.value = value;
        }
        public NODE31() {

        }
    }
    public NODE31 root;
    public void merge(NODE31 node1,NODE31 node2){
        NODE31 head=new NODE31();
        doublelylinkedlist(node1,head);
        doublelylinkedlist(node2,head);
    }

    public void doublelylinkedlist(NODE31 node, NODE31 head) {
        if (node==null){
            return;
        }
        doublelylinkedlist(node.right,head);
        node.right=head;
        if (head!=null){
            head.left=node;
        }
        head=node;
        doublelylinkedlist(node.left,head);
    }
}
