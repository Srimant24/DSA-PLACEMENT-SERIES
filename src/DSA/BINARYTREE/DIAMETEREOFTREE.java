package DSA.BINARYTREE;

public class DIAMETEREOFTREE {
    public DIAMETEREOFTREE(){

    }
    static class NODE2 {
        int value;
        NODE2 left;
        NODE2 right;
        int height;

        public NODE2(int value) {

            this.value = value;
        }


    }
    class pair{
        int dia;
        int height;
        int first;
        int second;

        pair(int dia,int height){
            this.dia=dia;
            this.height=height;
        }
    }
    public NODE2 root;
    int height(NODE2 node){
        if (node==null){
            return 0;
        }
        return  Math.max(height(node.left),height(node.right))+1;
    }
    public int diametere(NODE2 node){
        if (node==null){
            return  0;
        }
        int d1=diametere(node.left);
        int d2=diametere(node.right);
        int d3=height(node.left)+1+height(node.right);
        int m1= Math.max(d1,d2);
        int m2=Math.max(m1,d3);
        return m2;
    }
    public pair diafast(NODE2 node){
        if (node==null){
            pair p = new pair(0,0);
            return p;
        }
        pair left=diafast(node.left);
        pair right=diafast(node.right);
        int op1 = left.first;
        int op2 = right.first;
        int op3= left.second+1+right.second;
         pair ans=null;
         ans.first=Math.max(Math.max(op1,op2),op3);
         ans.second=Math.max(left.second, right.second)+1;
         return ans;
    }
    int diameter1(NODE2 node){
        return diafast(node).first;
    }
}
