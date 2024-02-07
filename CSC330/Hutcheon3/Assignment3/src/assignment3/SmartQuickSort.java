package assignment3;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author willHutcheon
 * Assignment 3
 * 
 * This file includes the logic for sorting an array using smart quick sort
 * @since February 19, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class SmartQuickSort {
    /**
     * helper for sorting an array using the smart quick sort method
     * @param arrayCopyForSmart copy of the original array to be used
     * @param low lowest index of the array
     * @param high highest index of the array
     */
    public static void smartQuickSortHelpersHelper(int[] arrayCopyForSmart, int low, int high) {
        int threshold = 10;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            if (high - low + 1 <= threshold) {
                int[] sorted = mergeSortSmart(Arrays.copyOfRange(arrayCopyForSmart, low, high+1));
                System.arraycopy(sorted, 0, arrayCopyForSmart, low, sorted.length);
            } else {
                if (low < high) {
                    int pivotIndex = partitionHigh(arrayCopyForSmart, low, high);
                    if (pivotIndex - 1 - low > high - (pivotIndex + 1)) {
                        stack.push(low);
                        stack.push(pivotIndex - 1);
                        stack.push(pivotIndex + 1);
                        stack.push(high);
                    } else {
                        stack.push(pivotIndex + 1);
                        stack.push(high);
                        stack.push(low);
                        stack.push(pivotIndex - 1);
                    }
                }
            }
        }
    }

    /**
     * this function contains the logic for a smart merge sort
     * @param arrayCopyForMerge copy of the original array to be used
     */
    private static int[] mergeSortSmart(int[] arrayCopyForMerge) {
        if (arrayCopyForMerge.length > 1) {
            int mid = arrayCopyForMerge.length / 2;
            int[] left = Arrays.copyOfRange(arrayCopyForMerge, 0, mid);
            int[] right = Arrays.copyOfRange(arrayCopyForMerge, mid, arrayCopyForMerge.length);
            left = mergeSortSmart(left);
            right = mergeSortSmart(right);
            return merge(arrayCopyForMerge, left, right);
        }
        return arrayCopyForMerge;
    }

    /**
     * this function contains the logic for merging two sub arrays
     * @param arrayCopyForMerge array used to hold the merged sub-arrays
     * @param left left sub array
     * @param right right sub array
     * @return the merged array
    */
    private static int[] merge(int[] arrayCopyForMerge, int[] left, int[] right) {
        int[] mergedArray = new int[left.length + right.length];
        int b = 0, c = 0, d = 0;
        while(b < left.length && c < right.length) {
            if(left[b] <= right[c]) {
                mergedArray[d++] = left[b++];
            } else {
                mergedArray[d++] = right[c++];
            }
        }
        while(b < left.length) {
            mergedArray[d++] = left[b++];
        }
        while(c < right.length) {
            mergedArray[d++] = right[c++];
        }
        return mergedArray;
    }

    /**
     * partitions the array using the highest index as a pivot
     * @param array the array to be partitioned
     * @param low lowest index of the array
     * @param high highest index of the array
     * @return index of the pivot after it has been inserted into the array
     */
    private static int partitionHigh(int[] array, int low, int high) {
        if (high <= low) {
            return low;
        }
        int pivot = array[high];
        int lastLess = low - 1;
        for(int b = low; b <= high - 1; b++) {
            if(array[b] <= pivot) {
                lastLess++;
                Swap.swap(array, lastLess, b);
            }
        }
        Swap.swap(array, lastLess + 1, high);
        return lastLess + 1;
    }
}
