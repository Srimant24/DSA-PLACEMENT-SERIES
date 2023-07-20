package DSA.HEAPS;
import java.io.*;
import java.util.*;
public class MERGEKSORTEDLINKEDLIST {
    MERGEKSORTEDLINKEDLIST() {

    }

    class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    // Class implements Comparator to compare Node data
    class NodeComparator implements Comparator<Node> {

        public int compare(Node k1, Node k2) {
            if (k1.data > k2.data)
                return 1;
            else if (k1.data < k2.data)
                return -1;
            return 0;
        }
    }


    // Function to merge k sorted linked lists
    Node mergeKList(Node[] arr, int K) {
        // Priority_queue 'queue' implemented
        // as min heap with the help of
        // 'compare' function
        PriorityQueue<Node> queue
                = new PriorityQueue<>(new NodeComparator());
        Node head = null;
        Node tail = head;
        // Push the head nodes of all
        // the k lists in 'queue'
        for (int i = 0; i < K; i++) {
            if (arr[i] != null) {
                queue.add(arr[i]);
            }
        }
        // Handles the case when k = 0
        // or lists have no elements in them
        if (queue.isEmpty())
            return null;
        // Loop till 'queue' is not empty
        while (!queue.isEmpty()) {
            // Get the top element of 'queue'
            Node temp=queue.poll();
            if (head==null){
                head=temp;
                tail=temp;
                if (tail.next!=null){
                    queue.offer(tail.next);
                }
            }
            tail.next=temp;
            tail=temp;
            if (tail.next!=null){
                queue.offer(tail.next);
            }
        }
        return head;
    }
}
