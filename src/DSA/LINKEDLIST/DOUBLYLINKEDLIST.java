package DSA.LINKEDLIST;

class Node1 {
    int data;
    Node1 prev;
    Node1 next;

    // Constructor
    Node1(int d) {
        this.data = d;
        this.prev = null;
        this.next = null;
    }

    // Destructor (Not required in Java as Java has automatic garbage collection)
}

public class DOUBLYLINKEDLIST {
    // Traversing a linked list
    static void print(Node1 head) {
        Node1 temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Gives length of Linked List
    static int getLength(Node1 head) {
        int len = 0;
        Node1 temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    static void insertAtHead(Node1 tail, Node1 head, int d) {
        // Empty list
        if (head == null) {
            Node1 temp = new Node1(d);
            head = temp;
            tail = temp;
        } else {
            Node1 temp = new Node1(d);
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    static void insertAtTail(Node1 tail, Node1 head, int d) {
        if (tail == null) {
            Node1 temp = new Node1(d);
            tail = temp;
            head = temp;
        } else {
            Node1 temp = new Node1(d);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    static void insertAtPosition(Node1 tail, Node1 head, int position, int d) {
        // Insert at Start
        if (position == 1) {
            insertAtHead(tail, head, d);
            return;
        }

        Node1 temp = head;
        int cnt = 1;

        while (cnt < position - 1) {
            temp = temp.next;
            cnt++;
        }

        // Inserting at Last Position
        if (temp.next == null) {
            insertAtTail(tail, head, d);
            return;
        }

        // Creating a node for d
        Node1 node1ToInsert = new Node1(d);

        node1ToInsert.next = temp.next;
        temp.next.prev = node1ToInsert;
        temp.next = node1ToInsert;
        node1ToInsert.prev = temp;
    }

    static void deleteNode(int position, Node1 head) {
        // Deleting first or start node
        if (position == 1) {
            Node1 temp = head;
            temp.next.prev = null;
            head = temp.next;
            temp.next = null;
            // Delete operation not required in Java as Java has automatic garbage collection
        } else {
            // Deleting any middle node or last node
            Node1 curr = head;
            Node1 prev = null;

            int cnt = 1;
            while (cnt < position) {
                prev = curr;
                curr = curr.next;
                cnt++;
            }

            curr.prev = null;
            prev.next = curr.next;
            curr.next = null;
            // Delete operation not required in Java as Java has automatic garbage collection
        }
    }

    public static void main(String[] args) {
        Node1 head = null;
        Node1 tail = null;

        print(head);

        insertAtHead(tail, head, 11);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtHead(tail, head, 13);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtHead(tail, head, 8);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtTail(tail, head, 25);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtPosition(tail, head, 2, 100);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtPosition(tail, head, 1, 101);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        insertAtPosition(tail, head, 7, 102);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);

        deleteNode(7, head);
        print(head);
        System.out.println("head  " + head.data);
        System.out.println("tail  " + tail.data);
    }
}

