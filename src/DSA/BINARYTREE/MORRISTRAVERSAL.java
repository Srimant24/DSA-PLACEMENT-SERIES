package DSA.BINARYTREE;

import java.util.Vector;

public class MORRISTRAVERSAL {
    MORRISTRAVERSAL(){

    }
    static class NODE21 {
        int value;
        NODE21 left;
        NODE21 right;

        public NODE21(int value) {

            this.value = value;
        }

    }

    public NODE21 root;
    public void MORTRAVERSAL(NODE21 node){
        Vector<Integer>link=new Vector<>();
        NODE21 current=node;
        while (current!=null){
            if (current.left==null){
                link.add(current.value);
                current=current.right;
            }
            else {
                NODE21 ances=findances(current);
                if (ances.right==null){
                    ances.right=current;
                    current=current.left;
                }
                else{
                    ances.right=null;
                    link.add(current.value);
                    current=current.right;
                }
            }
        }
    }

    private NODE21 findances(NODE21 current) {
        NODE21 ances=current;
        while(ances.right!=null){
            ances=ances.right;
        }
        return ances;
    }
}
