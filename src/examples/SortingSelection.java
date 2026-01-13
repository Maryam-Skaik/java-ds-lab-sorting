/*
 * SortingSelection.java
 * Author: Maryam
 *
 * This file contains implementations of the most commonly taught sorting algorithms:
 * Bubble Sort, Selection Sort, Insertion Sort, Merge Sort, and Quick Sort.
 * Each function is fully commented to explain how it works, its properties, and its usage.
 *
 * Key Concepts Explained:
 * - In-place vs. not in-place
 * - Stable vs. unstable
 * - Time & space complexity
 * - Connections to arrays, recursion, and algorithmic thinking
 */

package sorting.selection;

import java.util.Arrays;

public class SortingSelection {

    /**
     * Bubble Sort Algorithm
     * ---------------------
     * Concept:
     * Repeatedly compares adjacent elements and swaps them if they are out of order.
     * After each pass, the largest unsorted element "bubbles" to its correct position.
     *
     * Properties:
     * - Stable: Yes (equal elements retain their order)
     * - In-place: Yes (no extra memory needed)
     * - Time complexity: O(n^2)
     * - Best for teaching the concept of swapping and iterative sorting
     */
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Selection Sort Algorithm
     * ------------------------
     * Concept:
     * Repeatedly finds the minimum element from the unsorted portion
     * and swaps it with the first unsorted element.
     *
     * Properties:
     * - Stable: No (swaps may change the relative order of equal elements)
     * - In-place: Yes
     * - Time complexity: O(n^2)
     * - Good for understanding array indexing and selection logic
     */
    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find index of the minimum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            // Swap the found minimum element with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Insertion Sort Algorithm
     * ------------------------
     * Concept:
     * Builds the sorted portion of the array one element at a time by inserting
     * each new element into its correct position.
     *
     * Properties:
     * - Stable: Yes
     * - In-place: Yes
     * - Best case: O(n) (array already sorted)
     * - Worst case: O(n^2) (array reverse sorted)
     * - Efficient for small or nearly sorted arrays
     */
    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element to insert
            int j = i - 1;

            // Shift elements of the sorted portion to the right to make space
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key in its correct position
            arr[j + 1] = key;
        }
    }

    /**
     * Merge Sort Algorithm
     * --------------------
     * Concept:
     * Divide-and-conquer algorithm that divides the array into halves,
     * recursively sorts each half, and then merges the sorted halves.
     *
     * Properties:
     * - Stable: Yes
     * - In-place: No (requires temporary arrays for merging)
     * - Time complexity: O(n log n)
     * - Excellent for large datasets and recursion practice
     */
    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;

            // Recursively sort left and right halves
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            // Merge the sorted halves
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int arr[], int l, int mid, int r) {
        int n1 = mid - l + 1; // Size of left subarray
        int n2 = r - mid;     // Size of right subarray

        int L[] = new int[n1]; // Temporary left array
        int R[] = new int[n2]; // Temporary right array

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        // Merge the temporary arrays back into arr[l..r]
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { // <= ensures stability
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements if any
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    /**
     * Quick Sort Algorithm
     * --------------------
     * Concept:
     * Divide-and-conquer algorithm that selects a pivot element,
     * partitions the array into elements less than and greater than the pivot,
     * and recursively sorts the partitions.
     *
     * Properties:
     * - Stable: No (swaps may change the relative order of equal elements)
     * - In-place: Yes (uses recursion stack only)
     * - Average Time: O(n log n)
     * - Worst Time: O(n^2) (rare, depends on pivot choice)
     */
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1;       // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    /**
     * Main method to test sorting algorithms
     */
    public static void main(String[] args) {
        int[] arr;

        // Bubble Sort
        arr = new int[]{5, 2, 4, 3, 1};
        bubbleSort(arr);
        System.out.println("Bubble Sort: " + Arrays.toString(arr));

        // Selection Sort
        arr = new int[]{29, 10, 14, 37, 13};
        selectionSort(arr);
        System.out.println("Selection Sort: " + Arrays.toString(arr));

        // Insertion Sort
        arr = new int[]{8, 3, 5, 2};
        insertionSort(arr);
        System.out.println("Insertion Sort: " + Arrays.toString(arr));

        // Merge Sort
        arr = new int[]{38, 27, 43, 10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(arr));

        // Quick Sort
        arr = new int[]{12, 7, 14, 9, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(arr));
    }
}
