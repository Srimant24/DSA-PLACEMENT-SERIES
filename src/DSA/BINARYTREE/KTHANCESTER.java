package DSA.BINARYTREE;

import java.util.ArrayList;

public class KTHANCESTER {
    KTHANCESTER() {

    }

    static class NODE16 {
        int value;
        NODE16 left;
        NODE16 right;

        public NODE16(int value) {

            this.value = value;
        }

    }

    public NODE16 root;

   public NODE16 KTHANCES(NODE16 node,int k,int value){
       if (node==null){
           return null;
       }
       if(node.value==value){
           return node;
       }
       NODE16 leftans=KTHANCES(node.left, k, value);
       NODE16 rightans=KTHANCES(node.right,k,value);
       if (leftans!=null&& rightans==null){
           k--;
           if (k<=0){
               k=Integer.MAX_VALUE;
               return node;
           }
           return leftans;
       }
       if (leftans==null&& rightans!=null){
           k--;
           if (k<=0){
               k=Integer.MAX_VALUE;
               return node;
           }
           return rightans;
       }
       return null;
   }
    public int KTHANCESTOR(NODE16 node,int k,int value){
       NODE16 node1=KTHANCES(node,k,value);
       if (node1==null&&node1.value==value){
           return -1;
       }
       return node1.value;
    }
}

