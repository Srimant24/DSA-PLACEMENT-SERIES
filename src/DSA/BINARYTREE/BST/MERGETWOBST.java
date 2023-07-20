package DSA.BINARYTREE.BST;

import java.util.Vector;

public class MERGETWOBST {
    MERGETWOBST(){

    }
    static class NODE30 {
        int value;
        NODE30 left;
        NODE30 right;

        public NODE30(int value) {

            this.value = value;
        }
    }
    public NODE30 root;

    public NODE30 formbst(NODE30 node1,NODE30 node2){
        Vector<Integer>bst1=new Vector<>();
        Vector<Integer>bst2=new Vector<>();
        formpreorder(node1,bst1);
        formpreorder(node2,bst2);
        Vector<Integer>mergevector=merge(bst1,bst2);
        int start=0;
        int end= mergevector.size();
         NODE30 root=populate(mergevector,start,end);
         return root;
    }
    public NODE30 populate(Vector<Integer>vector,int s,int e){
        if (s>e){
            return null;
        }
        int mid=(s+e)/2;
        NODE30 node=new NODE30(vector.get(mid));
        node.left=populate(vector,s,mid-1);
        node.right=populate(vector, mid+1, e);
        return node;
    }
    public void formpreorder(NODE30 node, Vector<Integer> bst) {
        if (node==null){
            return ;
        }
        formpreorder(node.left,bst);
        bst.add(node.value);
        formpreorder(node.right,bst);

    }
    public Vector merge(Vector<Integer>one,Vector<Integer>two){
        Vector<Integer>merz=new Vector<>();
        int i=0;
        int j=0;
        int k=0;
        while (i< one.size() && j< two.size()){
            if (one.get(i) <= two.get(j)) {
                merz.add(k,one.get(i));
                i++;
                k++;
            }
            merz.add(j, two.get(j));
            j++;
            k++;
        }
        if (i> one.size()){
            while (j< two.size()){
                merz.add(k,two.get(j));
                j++;
                k++;
            }
        }
        while (i< one.size()){
            merz.add(k,two.get(i));
            j++;
            k++;
        }
        return merz;
    }
}
