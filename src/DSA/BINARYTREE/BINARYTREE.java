package DSA.BINARYTREE;

import java.util.Scanner;

public class BINARYTREE {
    public BINARYTREE(){

    }
    class NODE{
        int value;
        NODE left;
        NODE right;

        public NODE(int value){
            this.value=value;
        }
    }
    public NODE root;

    public void populate(Scanner sc){
         System.out.println("please enter the root node : ");
         int value= sc.nextInt();
          root=new NODE(value);
         populate(sc,root);
     }

    public void populate(Scanner sc, NODE node) {
        System.out.println("do u want to enter the left node :"+node.value);
        boolean left=sc.nextBoolean();
        if (left){
            System.out.println("enter the node at the left of :"+node.value);
            int value= sc.nextInt();
            node.left=new NODE(value);
            populate(sc,node.left);
        }
        System.out.println("do u want to enter the left node :"+node.value);
        boolean right=sc.nextBoolean();
        if (right) {
            System.out.println("enter the node at the left of :" + node.value);
            int value = sc.nextInt();
            node.right = new NODE(value);
            populate(sc, node.right);
        }
    }
    public void display(){
        display(root," ");
    }

    public void display(NODE node,String s) {
        if (node==null){
            return;
        }
        System.out.println(node.value+s);
        display(node.left,"\t");
        display(node.right,"\t");
    }
}
