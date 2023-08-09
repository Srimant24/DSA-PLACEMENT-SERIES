package DSA.LINKEDLIST;

class Node8 {
    public int data;
    public Node8 next;

    public Node8(int d) {
        this.data = d;
        this.next = null;
    }
}

public class SortLinkedList012 {

    public static void insertAtTail(Node8 tail, Node8 curr) {
        tail.next = curr;
        tail = curr;
    }

    public static Node8 sortList(Node8 head) {
        Node8 zeroHead = new Node8(-1);
        Node8 zeroTail = zeroHead;
        Node8 oneHead = new Node8(-1);
        Node8 oneTail = oneHead;
        Node8 twoHead = new Node8(-1);
        Node8 twoTail = twoHead;

        Node8 curr = head;

        // Create separate lists for 0s, 1s, and 2s
        while (curr != null) {

            int value = curr.data;

            if (value == 0) {
                insertAtTail(zeroTail, curr);
            } else if (value == 1) {
                insertAtTail(oneTail, curr);
            } else if (value == 2) {
                insertAtTail(twoTail, curr);
            }
            curr = curr.next;
        }

        // Merge the 3 sublists

        // 1s list not empty
        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            // 1s list is empty
            zeroTail.next = twoHead.next;
        }

        oneTail.next = twoHead.next;
        twoTail.next = null;

        // Setup head
        head = zeroHead.next;

        // Delete dummy nodes (in Java, memory management is automatic, no need for delete)
        zeroHead = null;
        oneHead = null;
        twoHead = null;

        return head;
    }

    public static void printList(Node8 head) {
        Node8 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node8 head = new Node8(1);
        head.next = new Node8(2);
        head.next.next = new Node8(0);
        head.next.next.next = new Node8(1);
        head.next.next.next.next = new Node8(2);

        System.out.println("Original List:");
        printList(head);

        Node8 sortedHead = sortList(head);

        System.out.println("Sorted List:");
        printList(sortedHead);
    }
}

