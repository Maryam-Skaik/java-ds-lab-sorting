/**
 * Activity: Find the maximum difference between any two elements in an array.
 * 
 * Returns an array of three values:
 * - max difference
 * - first element (min element contributing to max difference)
 * - second element (max element contributing to max difference)
 * 
 * Uses a single-pass algorithm with O(n) time complexity.
 */

public class MaxDifference {

    public static int[] maxDifference(int arr[]){
        int min = arr[0];                  // Minimum element seen so far
        int maxDiff = arr[1] - arr[0];     // Initial max difference
        int first = arr[0], second = arr[1];

        for(int i = 0; i < arr.length; i++){
            // Check if current element minus minimum so far gives a bigger difference
            if(arr[i] - min > maxDiff){
                maxDiff = arr[i] - min;
                first = min;   // Min element
                second = arr[i]; // Current element
            }

            // Update min if current element is smaller
            if(arr[i] < min) min = arr[i];
        }

        return new int[]{maxDiff, first, second};
    }

    // Example usage
    public static void main(String[] args){
        int arr[] = {2, 3, 10, 6, 4, 8, 1};
        int[] result = maxDifference(arr);
        System.out.println("Max difference: " + result[0] + 
                           " (between " + result[1] + " and " + result[2] + ")");
    }
}
