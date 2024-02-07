package assignment3;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @author willHutcheon
 * Assignment 3
 * 
 * This file includes the logic for sorting an array using quick sort with various pivot values
 * @since February 19, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class SpecificQuickSort {
    /**
     * helper for sorting the array using a low, middle, and high pivot value. this function times how long it took to sort an array using the three pivot values
     * @param arrayCopyForSpecific the array to be sorted
     * @param low lowest index of the array
     * @param high highest index of the array
     */
    public static void specificQuickSortHelper(int[] arrayCopyForSpecific, int low, int high) {
        long preSpecificQuickSortHigh = 0, postSpecificQuickSortHigh = 0, preSpecificQuickSortMiddle = 0, postSpecificQuickSortMiddle = 0, preSpecificQuickSortLow = 0, postSpecificQuickSortLow = 0;
        int[] arrayCopyForSpecificHigh = Arrays.copyOf(arrayCopyForSpecific, arrayCopyForSpecific.length);
        int[] arrayCopyForSpecificLow = Arrays.copyOf(arrayCopyForSpecific, arrayCopyForSpecific.length);
        preSpecificQuickSortMiddle = System.currentTimeMillis();
        specificQuickSortHighLowOrMiddle(arrayCopyForSpecific, low, high, 3);
        IsSorted.isSorted(arrayCopyForSpecific);
        postSpecificQuickSortMiddle = System.currentTimeMillis();
        System.out.println("The time (in millis) it took to quick sort the array using the middle index as the pivot was: " + (postSpecificQuickSortMiddle - preSpecificQuickSortMiddle));
        preSpecificQuickSortHigh = System.currentTimeMillis();
        specificQuickSortHighLowOrMiddle(arrayCopyForSpecificHigh, low, high, 1);
        IsSorted.isSorted(arrayCopyForSpecificHigh);
        postSpecificQuickSortHigh = System.currentTimeMillis();
        System.out.println("The time (in millis) it took to quick sort the array using the highest index as the pivot was: " + (postSpecificQuickSortHigh - preSpecificQuickSortHigh));
        preSpecificQuickSortLow = System.currentTimeMillis();
        specificQuickSortHighLowOrMiddle(arrayCopyForSpecificLow, low, high, 2);
        IsSorted.isSorted(arrayCopyForSpecificLow);
        postSpecificQuickSortLow = System.currentTimeMillis();
        System.out.println("The time (in millis) it took to quick sort the array using the lowest index as the pivot was: " + (postSpecificQuickSortLow - preSpecificQuickSortLow));
    }

    /**
     * this function contains the logic for quick sorting an array based on a pivot value
     * @param array the array to be sorted
     * @param low lowest index of the array
     * @param high highest index of the array
     * @param pivotChoice the type of pivot to be used (low, middle, high)
     * @return the array
     */
    private static void specificQuickSortHighLowOrMiddle(int[] array, int low, int high, int pivotChoice) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (start < end) {
                int part;
                if (pivotChoice == 1) {
                    part = partitionHigh(array, start, end);
                } else if (pivotChoice == 2) {
                    part = partitionLow(array, start, end);
                } else {
                    part = partitionMiddle(array, start, end);
                }
                stack.push(start);
                stack.push(part - 1);
                stack.push(part + 1);
                stack.push(end);
            }
        }
    }
    
    /**
     * partitions the array using the highest index as a pivot
     * @param array the array to be partitioned
     * @param low lowest index of the array
     * @param high highest index of the array
     * @return index of the pivot after it has been inserted into the array
     */
    private static int partitionHigh(int[] array, int low, int high) {
        int pivot = array[high];
        int a = low - 1;
        for (int b = low; b <= high - 1; b++) {
            if (array[b] < pivot) {
                a++;
                Swap.swap(array, a, b);
            }
        }
        Swap.swap(array, a + 1, high);
        return a + 1;
    }
    /**
     * partitions the array using the lowest index as a pivot
     * @param array the array to be partitioned
     * @param low lowest index of the array
     * @param high highest index of the array
     * @return index of the pivot after it has been inserted into the array
     */
    private static int partitionLow(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low + 1;
        for(int j = low + 1; j <= high; j++) {
            if(array[j] < pivot) {
                Swap.swap(array, i, j);
                i++;
            }
        }
        Swap.swap(array, low, i - 1);
        return i - 1;
    }
    /**
     * partitions the array using the middle index as a pivot
     * @param array the array to be partitioned
     * @param low lowest index of the array
     * @param high highest index of the array
     * @return index of the pivot after it has been inserted into the array
     */
    private static int partitionMiddle(int[] array, int low, int high) {
        int pivotIndex = (low + high) / 2;
        int pivotValue = array[pivotIndex];
        Swap.swap(array, pivotIndex, high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivotValue) {
                i++;
                Swap.swap(array, i, j);
            }
        }
        Swap.swap(array, i + 1, high);
        return i + 1;
    }
}
