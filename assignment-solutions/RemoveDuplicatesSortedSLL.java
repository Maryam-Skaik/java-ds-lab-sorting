package assignment_solutions;

/**
 * Problem:
 * Remove duplicates from a sorted singly linked list.
 * 
 * Approach:
 * - Copy SLL elements to array
 * - Sort array (merge sort)
 * - Rebuild list skipping duplicates
 */
public class RemoveDuplicatesSortedSLL {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public Node removeDuplicatesSorted(Node head) {
        if (head == null) return null;

        int count = 0;
        Node temp = head;
        while (temp != null) { count++; temp = temp.next; }

        int[] arr = new int[count];
        temp = head;
        for (int i = 0; i < count; i++) {
            arr[i] = temp.data;
            temp = temp.next;
        }

        SortingAlgorithms.mergeSort(arr, 0, arr.length - 1);

        Node newHead = new Node(arr[0]);
        Node curr = newHead;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                curr.next = new Node(arr[i]);
                curr = curr.next;
            }
        }

        return newHead;
    }
}
