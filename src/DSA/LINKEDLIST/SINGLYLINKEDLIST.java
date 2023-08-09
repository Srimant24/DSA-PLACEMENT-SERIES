package DSA.LINKEDLIST;
import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node1 next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Destructor (Not required in Java as Java has automatic garbage collection)
}

public class SINGLYLINKEDLIST {
    static void insertAtHead(Node1 head, int d) {
        Node1 temp = new Node1(d);
        temp.next = head;
        head = temp;
    }

    static void insertAtTail(Node1 tail, int d) {
        Node1 temp = new Node1(d);
        tail.next = temp;
        tail = temp;
    }

    static void print(Node1 head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void insertAtPosition(Node1 tail, Node1 head, int position, int d) {
        // insert at Start
        if (position == 1) {
            insertAtHead(head, d);
            return;
        }

        Node1 temp = head;
        int cnt = 1;

        while (cnt < position - 1) {
            temp = temp.next;
            cnt++;
        }

        // inserting at Last Position
        if (temp.next == null) {
            insertAtTail(tail, d);
            return;
        }

        // creating a node for d
        Node1 node1ToInsert = new Node1(d);

        node1ToInsert.next = temp.next;

        temp.next = node1ToInsert;
    }

    static void deleteNode(int position, Node1 head) {
        // deleting first or start node
        if (position == 1) {
            Node1 temp = head;
            head = head.next;
            // memory free start node
            temp.next = null;
            // Delete operation not required in Java as Java has automatic garbage collection
        } else {
            // deleting any middle node or last node
            Node1 curr = head;
            Node1 prev = null;

            int cnt = 1;
            while (cnt < position) {
                prev = curr;
                curr = curr.next;
                cnt++;
            }

            prev.next = curr.next;
            curr.next = null;
            // Delete operation not required in Java as Java has automatic garbage collection
        }
    }

    static boolean isCircularList(Node1 head) {
        // empty list
        if (head == null) {
            return true;
        }

        Node1 temp = head.next;
        while (temp != null && temp != head) {
            temp = temp.next;
        }

        return temp == head;
    }

    static boolean detectLoop(Node1 head) {
        if (head == null)
            return false;

        Map<Node1, Boolean> visited = new HashMap<>();

        Node1 temp = head;

        while (temp != null) {
            // cycle is present
            if (visited.containsKey(temp) && visited.get(temp)) {
                System.out.println("Present on element " + temp.data);
                return true;
            }

            visited.put(temp, true);
            temp = temp.next;
        }
        return false;
    }

    static Node1 floydDetectLoop(Node1 head) {
        if (head == null)
            return null;

        Node1 slow = head;
        Node1 fast = head;

        while (slow != null && fast != null) {

            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            slow = slow.next;

            if (slow == fast) {
                System.out.println("present at " + slow.data);
                return slow;
            }
        }

        return null;
    }

    static Node1 getStartingNode(Node1 head) {
        if (head == null)
            return null;

        Node1 intersection = floydDetectLoop(head);
        Node1 slow = head;

        while (slow != intersection) {
            slow = slow.next;
            intersection = intersection.next;
        }

        return slow;
    }

    static void removeLoop(Node1 head) {
        if (head == null)
            return;

        Node1 startOfLoop = getStartingNode(head);
        Node1 temp = startOfLoop;

        while (temp.next != startOfLoop) {
            temp = temp.next;
        }

        temp.next = null;
    }

    public static void main(String[] args) {
        // Created a new node
        Node1 node1 = new Node1(10);

        // Head pointed to node1
        Node1 head = node1;
        Node1 tail = node1;

        insertAtTail(tail, 12);
        insertAtTail(tail, 15);
        insertAtPosition(tail, head, 4, 22);

        tail.next = head.next;

        System.out.println("head " + head.data);
        System.out.println("tail " + tail.data);

        if (floydDetectLoop(head) != null) {
            System.out.println("Cycle is present");
        } else {
            System.out.println("No cycle");
        }

        Node1 loop = getStartingNode(head);

        System.out.println("Loop starts at " + loop.data);

        removeLoop(head);
        print(head);

        /*
        print(head);

        if (isCircularList(head)) {
            System.out.println("Linked List is Circular in nature");
        } else {
            System.out.println("Linked List is not Circular");
        }
        */
    }
}


