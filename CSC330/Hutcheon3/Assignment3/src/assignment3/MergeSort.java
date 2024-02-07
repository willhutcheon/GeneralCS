package assignment3;

/**
 * @author willHutcheon
 * Assignment 3
 * 
 * This file includes the logic for sorting an array using merge sort
 * @since February 19, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class MergeSort {
    /**
     * helper for sorting an array using the merge sort method
     * @param arrayCopyForMerge copy of the original array to be used
     * @param low lowest index of the array
     * @param high highest index of the array
     */
    public static void mergeSortHelper(int[] arrayCopyForMerge, int low, int high) {
        int n = arrayCopyForMerge.length;
        int currSize;
        int leftStart;
        for (currSize = 1; currSize < n; currSize = 2 * currSize) {
            for (leftStart = 0; leftStart < n - 1; leftStart += 2 * currSize) {
                int mid = Math.min(leftStart + currSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * currSize - 1, n - 1);
                merge(arrayCopyForMerge, leftStart, mid, rightEnd);
            }
        }
    }

    /**
     * this function contains the logic for merging two sub arrays
     * @param arrayCopyForMerge array to be merged
     * @param low lowest index of the array
     * @param mid middle index of the array
     * @param high highest index of the array
     */
    private static void merge(int[] arrayCopyForMerge, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (arrayCopyForMerge[i] <= arrayCopyForMerge[j]) {
                temp[k++] = arrayCopyForMerge[i++];
            } else {
                temp[k++] = arrayCopyForMerge[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arrayCopyForMerge[i++];
        }
        while (j <= high) {
            temp[k++] = arrayCopyForMerge[j++];
        }
        for (i = low; i <= high; i++) {
            arrayCopyForMerge[i] = temp[i - low];
        }
    }
}
