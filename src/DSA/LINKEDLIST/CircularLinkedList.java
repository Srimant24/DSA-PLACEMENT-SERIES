package DSA.LINKEDLIST;
import java.util.HashMap;
import java.util.Map;

class Node3 {
    public int data;
    public Node3 next;

    // constructor
    public Node3(int d) {
        this.data = d;
        this.next = null;
    }

    public void freeMemory() {
        int value = this.data;
        if (this.next != null) {
            this.next.freeMemory();
            this.next = null;
        }
        System.out.println("Memory is free for node with data " + value);
    }
}

public class CircularLinkedList {

    public static void insertNode(Node3[] tail, int element, int d) {
        // empty list
        if (tail[0] == null) {
            Node3 newNode3 = new Node3(d);
            tail[0] = newNode3;
            newNode3.next = newNode3;
        } else {
            // non-empty list
            // assuming that the element is present in the list
            Node3 curr = tail[0];

            while (curr.data != element) {
                curr = curr.next;
            }

            // element found -> curr is representing element wala node
            Node3 temp = new Node3(d);
            temp.next = curr.next;
            curr.next = temp;
        }
    }

    public static void print(Node3 tail) {
        Node3 temp = tail;

        // empty list
        if (tail == null) {
            System.out.println("List is Empty ");
            return;
        }

        do {
            System.out.print(tail.data + " ");
            tail = tail.next;
        } while (tail != temp);

        System.out.println();
    }

    public static void deleteNode(Node3[] tail, int value) {
        // empty list
        if (tail[0] == null) {
            System.out.println("List is empty, please check again");
            return;
        } else {
            // non-empty

            // assuming that "value" is present in the Linked List
            Node3 prev = tail[0];
            Node3 curr = prev.next;

            while (curr.data != value) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = curr.next;

            // 1 Node Linked List
            if (curr == prev) {
                tail[0] = null;
            }

            // >=2 Node linked list
            else if (tail[0] == curr) {
                tail[0] = prev;
            }

            curr.next = null;
        }
    }

    public static boolean isCircularList(Node3 head) {
        // empty list
        if (head == null) {
            return true;
        }

        Node3 temp = head.next;
        while (temp != null && temp != head) {
            temp = temp.next;
        }

        return temp == head;
    }

    public static boolean detectLoop(Node3 head) {
        if (head == null)
            return false;

        Map<Node3, Boolean> visited = new HashMap<>();

        Node3 temp = head;

        while (temp != null) {
            // cycle is present
            if (visited.containsKey(temp) && visited.get(temp)) {
                return true;
            }

            visited.put(temp, true);
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node3[] tail = { null };

        // insertNode(tail, 5, 3);
        // print(tail[0]);

        // insertNode(tail, 3, 5);
        // print(tail[0]);

        /*
         * insertNode(tail, 5, 7); print(tail[0]);
         *
         * insertNode(tail, 7, 9); print(tail[0]);
         *
         * insertNode(tail, 5, 6); print(tail[0]);
         *
         * insertNode(tail, 9, 10); print(tail[0]);
         *
         * insertNode(tail, 3, 4); print(tail[0]);
         *
         * deleteNode(tail, 5); print(tail[0]);
         */

        if (isCircularList(tail[0])) {
            System.out.println("Linked List is Circular in nature");
        } else {
            System.out.println("Linked List is not Circular");
        }
    }
}

