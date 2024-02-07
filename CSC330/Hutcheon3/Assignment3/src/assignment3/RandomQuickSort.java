package assignment3;

import java.util.Random;
import java.util.Stack;

/**
 * @author willHutcheon
 * Assignment 3
 * 
 * This file includes the logic for sorting an array using quick sort with a random pivot
 * @since February 19, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class RandomQuickSort {
    /**
     * helper for sorting an array using the random quick sort method
     * @param array the array to be sorted
     */
    public static void randomQuickSortHelper(int[] array) {
        int low = 0;
        int high = array.length - 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            if (low < high) {
                int pivotIndex = randomPartition(array, low, high);
                stack.push(low);
                stack.push(pivotIndex - 1);
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    /**
     * selects a random pivot element to be used for quick sort
     * @param arr the array
     * @param low lowest index of the array
     * @param high highest index of the array
     * @return index of pivot element after partitioning
     */
    private static int randomPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        int pivotValue = arr[pivotIndex];
        Swap.swap(arr, pivotIndex, high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivotValue) {
                Swap.swap(arr, i, j);
                i++;
            }
        }
        Swap.swap(arr, i, high);
        return i;
    }
}
