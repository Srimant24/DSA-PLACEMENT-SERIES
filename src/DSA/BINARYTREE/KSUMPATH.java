package DSA.BINARYTREE;

import java.util.Vector;

public class KSUMPATH {
    KSUMPATH(){

    }
    static class NODE15 {
        int value;
        NODE15 left;
        NODE15 right;

        public NODE15(int value) {

            this.value = value;
        }

    }
    public NODE15 root;
    public int ksp(NODE15 node,int k){
        Vector<Integer>result=new Vector<>();
        int count=0;
        calulatecount(node,k,count,result);
        return count;
    }

    public void calulatecount(NODE15 node, int k, int count, Vector<Integer> result) {
        if (node==null){
            return ;
        }
        result.add(node.value);
        calulatecount(node.left, k, count, result);
        calulatecount(node.right, k, count, result);
        int size= result.size();
        int sum=0;
        for (int i=size-1;i>=0;i--){
            sum+= result.get(i);
            if (sum==k){
                count++;
            }
        }
        result.remove(size-1);
    }
}
