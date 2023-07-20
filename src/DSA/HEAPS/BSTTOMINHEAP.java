package DSA.HEAPS;

import java.util.ArrayList;

public class BSTTOMINHEAP {
    BSTTOMINHEAP(){

    }
    static class Node {

        int data;
        Node left, right;


        Node(int data)
        {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static void bstToArray(Node root,
                                   ArrayList<Integer> arr)
    {
        if (root == null)
            return;

        bstToArray(root.left, arr);

        arr.add(root.data);

        bstToArray(root.right, arr);
    }

    private static void arrToMinHeap(Node root,
                                     ArrayList<Integer> arr,int i)
    {
        if (root == null)
            return;
        root.data = arr.get(i);

        arrToMinHeap(root.left, arr,i+1);
        arrToMinHeap(root.right, arr,i+1);
    }
    static void convertToMinHeap(Node root)
    {
        int index = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        bstToArray(root, arr);

        arrToMinHeap(root, arr,index);
    }
}