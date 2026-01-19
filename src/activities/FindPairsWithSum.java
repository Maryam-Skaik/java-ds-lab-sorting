/**
 * Activity: Find all pairs in a sorted array that sum up to a given target.
 * 
 * Uses the two-pointer technique after sorting the array (O(n log n) for sort + O(n) for scanning)
 */

public class FindPairsWithSum {

    public static void findPairs(int arr[], int target){
        // Sort the array first
        mergeSort(arr, 0, arr.length - 1);

        int l = 0, r = arr.length - 1;

        while(l < r){
            int sum = arr[l] + arr[r];
            if(sum == target){
                System.out.println("(" + arr[l] + ", " + arr[r] + ")");
                l++; r--;
            } else if(sum < target) {
                l++; // increase sum by moving left pointer
            } else {
                r--; // decrease sum by moving right pointer
            }
        }
    }

    // Merge sort code (same as previous file)
    public static void mergeSort(int arr[], int l, int r){
        if(l < r){
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int arr[], int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i = 0; i < n1; i++) L[i] = arr[l + i];
        for(int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while(i < n1) arr[k++] = L[i++];
        while(j < n2) arr[k++] = R[j++];
    }

    // Example usage
    public static void main(String[] args){
        int arr[] = {1, 5, 7, -1, 5};
        int target = 6;
        System.out.println("Pairs with sum = " + target + ":");
        findPairs(arr, target);
    }
}
