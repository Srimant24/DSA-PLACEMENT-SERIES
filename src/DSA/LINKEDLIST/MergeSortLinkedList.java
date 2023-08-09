package DSA.LINKEDLIST;

class Node9 {
    public int data;
    public Node9 next;

    public Node9(int d) {
        this.data = d;
        this.next = null;
    }
}

public class MergeSortLinkedList {

    public static Node9 findMid(Node9 head) {
        Node9 slow = head;
        Node9 fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node9 merge(Node9 left, Node9 right) {
        if (left == null)
            return right;

        if (right == null)
            return left;

        Node9 ans = new Node9(-1);
        Node9 temp = ans;

        // Merge 2 sorted linked lists
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }

        while (left != null) {
            temp.next = left;
            temp = left;
            left = left.next;
        }

        while (right != null) {
            temp.next = right;
            temp = right;
            right = right.next;
        }

        ans = ans.next;
        return ans;
    }

    public static Node9 mergeSort(Node9 head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Break linked list into 2 halves, after finding mid
        Node9 mid = findMid(head);

        Node9 left = head;
        Node9 right = mid.next;
        mid.next = null;

        // Recursive calls to sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge both left and right halves
        Node9 result = merge(left, right);

        return result;
    }

    public static void printList(Node9 head) {
        Node9 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node9 head = new Node9(6);
        head.next = new Node9(2);
        head.next.next = new Node9(8);
        head.next.next.next = new Node9(5);
        head.next.next.next.next = new Node9(3);
        head.next.next.next.next.next = new Node9(7);

        System.out.println("Original List:");
        printList(head);

        Node9 sortedHead = mergeSort(head);

        System.out.println("Sorted List:");
        printList(sortedHead);
    }
}

