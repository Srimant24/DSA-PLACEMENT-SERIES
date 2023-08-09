package DSA.LINKEDLIST;

class Node11 {
    int data;
    Node11 next;

    Node11(int d) {
        data = d;
        next = null;
    }
}

public class Solution {

    private Node11 reverse(Node11 head) {
        Node11 curr = head;
        Node11 prev = null;
        Node11 next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void insertAtTail(Node11 head, Node11 tail, int val) {
        Node11 temp = new Node11(val);

        // Empty list
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    private Node11 add(Node11 first, Node11 second) {
        int carry = 0;

        Node11 ansHead = null;
        Node11 ansTail = null;

        while (first != null || second != null || carry != 0) {

            int val1 = (first != null) ? first.data : 0;
            int val2 = (second != null) ? second.data : 0;

            int sum = carry + val1 + val2;

            int digit = sum % 10;

            // Create node and add it to the answer Linked List
            insertAtTail(ansHead, ansTail, digit);

            carry = sum / 10;
            if (first != null)
                first = first.next;

            if (second != null)
                second = second.next;
        }
        return ansHead;
    }

    public Node11 addTwoLists(Node11 first, Node11 second) {
        // Step 1 - Reverse input LL
        first = reverse(first);
        second = reverse(second);

        // Step 2 - Add 2 LL
        Node11 ans = add(first, second);

        // Step 3 - Reverse the answer LL
        ans = reverse(ans);

        return ans;
    }
}
