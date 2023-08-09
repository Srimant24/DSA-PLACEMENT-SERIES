package DSA.LINKEDLIST;

class Node10 {
    public int data;
    public Node10 next;
    public Node10 arb;

    public Node10(int d) {
        this.data = d;
        this.next = null;
        this.arb = null;
    }
}

public class CopyRandomLinkedList {

    private static void insertAtTail(Node10 head, Node10 tail, int d) {
        Node10 newNode10 = new Node10(d);
        if (head == null) {
            head = newNode10;
            tail = newNode10;
        } else {
            tail.next = newNode10;
            tail = newNode10;
        }
    }

    private static void print(Node10 head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static void printRandom(Node10 head) {
        while (head != null) {
            System.out.print(" head data: " + head.data + " ");
            if (head.arb != null) {
                System.out.print(" head random data: " + head.arb.data);
            } else {
                System.out.print(" head random data: NULL");
            }
            head = head.next;
            System.out.println();
        }
    }

    public static Node10 copyList(Node10 head) {
        // Step 1: Create a Clone List
        Node10 cloneHead = null;
        Node10 cloneTail = null;

        Node10 temp = head;
        while (temp != null) {
            insertAtTail(cloneHead, cloneTail, temp.data);
            temp = temp.next;
        }

        // Step 2: Insert nodes of Clone List in between the originalList
        Node10 originalNode10 = head;
        Node10 cloneNode10 = cloneHead;

        while (originalNode10 != null && cloneNode10 != null) {
            Node10 next = originalNode10.next;
            originalNode10.next = cloneNode10;
            originalNode10 = next;

            next = cloneNode10.next;
            cloneNode10.next = originalNode10;
            cloneNode10 = next;
        }

        // Step 3: Random pointer copy
        originalNode10 = head;
        cloneNode10 = cloneHead;

        while (originalNode10 != null && cloneNode10 != null) {

            if (originalNode10.arb != null) {
                cloneNode10.arb = originalNode10.arb.next;
            } else {
                cloneNode10.arb = null;
            }

            cloneNode10 = cloneNode10.next;
            originalNode10 = originalNode10.next;
        }

        // Step 4: Revert step 2 changes
        originalNode10 = head;
        cloneNode10 = cloneHead;

        while (originalNode10 != null && cloneNode10 != null) {
            originalNode10.next = originalNode10.next != null ? originalNode10.next.next : originalNode10.next;

            cloneNode10.next = cloneNode10.next != null ? cloneNode10.next.next : cloneNode10.next;

            originalNode10 = originalNode10.next;
            cloneNode10 = cloneNode10.next;
        }

        // Step 5: Answer return
        return cloneHead;
    }

    public static void main(String[] args) {
        Node10 head = new Node10(1);
        head.next = new Node10(2);
        head.next.next = new Node10(3);
        head.next.next.next = new Node10(4);
        head.next.next.next.next = new Node10(5);

        head.arb = head.next.next;
        head.next.arb = head;
        head.next.next.arb = head.next.next.next.next;
        head.next.next.next.arb = head.next;
        head.next.next.next.next.arb = head.next.next;

        System.out.println("Original List:");
        printRandom(head);

        Node10 clonedHead = copyList(head);

        System.out.println("Cloned List:");
        printRandom(clonedHead);
    }
}
