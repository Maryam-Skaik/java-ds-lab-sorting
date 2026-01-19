/**
 * Activity: Find the k-th smallest and k-th largest elements in an array
 * 
 * This file contains methods to find the k-th smallest and k-th largest
 * elements by first sorting the array using merge sort.
 */

public class FindKthSmallest {

    // Method to find the k-th smallest element in the array
    public static int findSmallest(int arr[], int k){
        // Sort the array first using merge sort
        mergeSort(arr, 0, arr.length - 1);

        // Return the (k-1)th element, because array index starts from 0
        return arr[k - 1];
    }

    // Method to find the k-th largest element in the array
    public static int findLargest(int arr[], int k){
        // Sort the array first using merge sort
        mergeSort(arr, 0, arr.length - 1);

        // Return the element at position length - k
        return arr[arr.length - k];
    }

    // Merge sort implementation
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
        int arr[] = {5, 2, 9, 1, 7};
        System.out.println("2nd smallest: " + findSmallest(arr, 2));
        System.out.println("3rd largest: " + findLargest(arr, 3));
    }
}
