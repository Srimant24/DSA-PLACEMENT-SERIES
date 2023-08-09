package DSA.LINKEDLIST;

class Node6 {
    public int data;
    public Node6 next;

    public Node6(int d) {
        this.data = d;
        this.next = null;
    }
}

public class UniqueSortedList {

    public static Node6 uniqueSortedList(Node6 head) {
        // Empty List
        if (head == null)
            return null;

        // Non-empty list
        Node6 curr = head;

        while (curr != null) {

            if ((curr.next != null) && curr.data == curr.next.data) {
                Node6 nextNext = curr.next.next;
                Node6 node6ToDelete = curr.next;
                curr.next = nextNext;
                node6ToDelete = null; // This line is Java equivalent of 'delete(nodeToDelete)' in C++
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void printList(Node6 head) {
        Node6 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node6 head = new Node6(1);
        head.next = new Node6(2);
        head.next.next = new Node6(2);
        head.next.next.next = new Node6(3);
        head.next.next.next.next = new Node6(3);
        head.next.next.next.next.next = new Node6(3);
        head.next.next.next.next.next.next = new Node6(4);

        System.out.println("Original List:");
        printList(head);

        Node6 newHead = uniqueSortedList(head);

        System.out.println("List after removing duplicates:");
        printList(newHead);
    }
}

