package sorting.assignment_solutions;

/**
 * Problem:
 * Sort a singly linked list using merge sort
 *
 * Approach:
 * - Recursive divide & conquer
 * - Find middle, split, sort each half, merge
 */
public class MergeSortSLL {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node mergeSortList(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = getMiddle(head);
        Node next = mid.next;
        mid.next = null;

        Node left = mergeSortList(head);
        Node right = mergeSortList(next);

        return mergeLists(left, right);
    }

    private static Node mergeLists(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data) {
            a.next = mergeLists(a.next, b);
            return a;
        } else {
            b.next = mergeLists(a, b.next);
            return b;
        }
    }

    private static Node getMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
