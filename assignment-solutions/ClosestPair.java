package assignment_solutions;

/**
 * Problem:
 * Find closest pair in array (min absolute difference)
 * 
 * Approach:
 * - Sort array
 * - Compare consecutive elements
 */
public class ClosestPair {

    public static int[] closestPair(int[] arr) {
        SortingAlgorithms.mergeSort(arr, 0, arr.length - 1);

        int minDiff = Integer.MAX_VALUE;
        int a = arr[0], b = arr[1];

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                a = arr[i - 1];
                b = arr[i];
            }
        }

        return new int[]{a, b, minDiff};
    }
}
