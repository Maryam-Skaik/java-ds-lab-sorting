/**
 * Activity: Find the missing number in an array of consecutive integers starting from 1.
 * 
 * Assumes array contains numbers from 1 to n with exactly one missing number.
 * Sorts the array first to simplify scanning.
 */

public class FindMissingNumber {

    public static int findMissing(int arr[]){
        // Sort the array first
        mergeSort(arr, 0, arr.length - 1);

        int n = 1; // Expected number starting from 1
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == n){
                n++; // number is present, check next
            } else if(arr[i] > n){
                return n; // missing number found
            }
        }

        return n; // if all numbers till max are present, missing number is next one
    }

    // Merge sort (same as previous files)
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
        int arr[] = {3, 7, 1, 2, 8, 4, 5};
        System.out.println("Missing number: " + findMissing(arr));
    }
}
