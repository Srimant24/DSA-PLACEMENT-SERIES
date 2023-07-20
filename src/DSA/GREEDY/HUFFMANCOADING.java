package DSA.GREEDY;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class HUFFMANCOADING {
    HUFFMANCOADING() {

    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            // Compare the integer values of the nodes
            int data1 = node1.getData();
            int data2 = node2.getData();

            // Custom comparison condition
            if (data1 > data2) {
                return 1; // Return positive value if data1 is greater
            } else if (data1 < data2) {
                return -1; // Return negative value if data1 is smaller
            } else {
                return 0; // Return 0 if data1 and data2 are equal
            }
        }
    }
    public static void traverse(Node root, Vector<String> ans, String temp){
        if (root.left==null && root.right==null){
            ans.add(temp);
            return;
        }
        traverse(root.left, ans, temp+"0");
        traverse(root.right, ans, temp+"1");
    }
    public static Vector<String>huffmancodes(String s,Vector<Integer>f,int n){
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new NodeComparator());
        for (int i=0;i<n;i++){
            Node temp=new Node(f.get(i));
            minHeap.add(temp);
        }
        while (minHeap.size()>1){
            Node left=minHeap.poll();
            Node right=minHeap.poll();
            Node newnode=new Node(left.data+ right.data);
            newnode.left=left;
            newnode.right=right;
            minHeap.add(newnode);
        }
        Node root=minHeap.poll();
        Vector<String>ans=new Vector<>();
        String temp="";
        traverse(root,ans,temp);
        return ans;
    }
}

