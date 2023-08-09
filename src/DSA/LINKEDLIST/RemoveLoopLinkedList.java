package DSA.LINKEDLIST;

class Node5 {
    public int data;
    public Node5 next;

    public Node5(int d) {
        this.data = d;
        this.next = null;
    }
}

public class RemoveLoopLinkedList {

    public static Node5 floydDetectLoop(Node5 head) {
        if (head == null)
            return null;

        Node5 slow = head;
        Node5 fast = head;

        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            slow = slow.next;

            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public static Node5 getStartingNode(Node5 head) {
        if (head == null)
            return null;

        Node5 intersection = floydDetectLoop(head);

        if (intersection == null)
            return null;

        Node5 slow = head;

        while (slow != intersection) {
            slow = slow.next;
            intersection = intersection.next;
        }

        return slow;
    }

    public static Node5 removeLoop(Node5 head) {
        if (head == null)
            return null;

        Node5 startOfLoop = getStartingNode(head);

        if (startOfLoop == null)
            return head;

        Node5 temp = startOfLoop;

        while (temp.next != startOfLoop) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        Node5 head = new Node5(1);
        head.next = new Node5(2);
        head.next.next = new Node5(3);
        head.next.next.next = new Node5(4);
        head.next.next.next.next = new Node5(5);

        // Create a loop for testing
        head.next.next.next.next.next = head.next;

        // Detect and remove the loop
        head = removeLoop(head);

        // Print the linked list to check for the loop removal
        Node5 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

