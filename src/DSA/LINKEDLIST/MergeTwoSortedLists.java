package DSA.LINKEDLIST;

class Node7<T> {
    public T data;
    public Node7<T> next;

    public Node7(T d) {
        this.data = d;
        this.next = null;
    }
}

public class MergeTwoSortedLists {

    public static <T extends Comparable<T>> void solve(Node7<T> first, Node7<T> second) {
        Node7<T> curr1 = first;
        Node7<T> next1 = curr1.next;

        Node7<T> curr2 = second;
        Node7<T> next2 = curr2.next;

        while (next1 != null && curr2 != null) {

            if ((curr2.data.compareTo(curr1.data) >= 0) && (curr2.data.compareTo(next1.data) <= 0)) {

                curr1.next = curr2;
                curr2.next = next1;
                curr1 = curr2;
                curr2 = next2;
            } else {
                curr1 = next1;
                next1 = next1.next;
            }
        }

        if (next1 == null && curr2 != null) {
            curr1.next = curr2;
        }
    }

    public static <T extends Comparable<T>> Node7<T> sortTwoLists(Node7<T> first, Node7<T> second) {
        if (first == null)
            return second;

        if (second == null)
            return first;

        if (first.data.compareTo(second.data) <= 0) {
            solve(first, second);
            return first;
        } else {
            solve(second, first);
            return second;
        }
    }

    public static <T> void printList(Node7<T> head) {
        Node7<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node7<Integer> first = new Node7<>(1);
        first.next = new Node7<>(3);
        first.next.next = new Node7<>(5);

        Node7<Integer> second = new Node7<>(2);
        second.next = new Node7<>(4);
        second.next.next = new Node7<>(6);

        System.out.println("First List:");
        printList(first);

        System.out.println("Second List:");
        printList(second);

        Node7<Integer> mergedHead = sortTwoLists(first, second);

        System.out.println("Merged and Sorted List:");
        printList(mergedHead);
    }
}

