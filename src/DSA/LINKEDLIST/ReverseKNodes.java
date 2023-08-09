package DSA.LINKEDLIST;

class Node4 {
    public int data;
    public Node4 next;

    public Node4(int d) {
        this.data = d;
        this.next = null;
    }
}

public class ReverseKNodes {

    public static Node4 kReverse(Node4 head, int k) {
        // base case
        if (head == null) {
            return null;
        }

        // step 1: reverse first k nodes
        Node4 next = null;
        Node4 curr = head;
        Node4 prev = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // step 2: Recursion handles the remaining part
        if (next != null) {
            head.next = kReverse(next, k);
        }

        // step 3: return head of reversed list
        return prev;
    }

    public static void printList(Node4 head) {
        Node4 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node4 head = new Node4(1);
        head.next = new Node4(2);
        head.next.next = new Node4(3);
        head.next.next.next = new Node4(4);
        head.next.next.next.next = new Node4(5);
        head.next.next.next.next.next = new Node4(6);
        head.next.next.next.next.next.next = new Node4(7);
        head.next.next.next.next.next.next.next = new Node4(8);

        int k = 3;

        System.out.println("Original List:");
        printList(head);

        Node4 newHead = kReverse(head, k);

        System.out.println("List after reversing every " + k + " nodes:");
        printList(newHead);
    }
}

