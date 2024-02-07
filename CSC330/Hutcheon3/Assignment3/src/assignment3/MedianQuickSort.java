package assignment3;

import java.util.Stack;

/**
 * @author willHutcheon
 * Assignment 3
 * 
 * This file includes the logic for sorting an array using median quick sort
 * @since February 19, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class MedianQuickSort {
    /**
     * helper for sorting an array using the median quick sort method
     * @param arrayCopyForMedian copy of the original array to be used
     * @param low lowest index of the array
     * @param high highest index of the array
     */
    public static void medianQuickSortHelper(int[] arrayCopyForMedian, int low, int high) {
        medianQuickSort(arrayCopyForMedian, low, high);
    }

    /**
     * this function contains the logic for sorting an array using the median quick sort method
     * @param arrayCopyForMedian copy of the original array to be used
     * @param low lowest index of the array
     * @param high highest index of the array
     * @return the array
     */
    private static int[] medianQuickSort(int[] arrayCopyForMedian, int low, int high) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            if (low < high) {
                int part = medianPartition(arrayCopyForMedian, low, high);
                stack.push(low);
                stack.push(part - 1);
                stack.push(part + 1);
                stack.push(high);
            }
        }
        return arrayCopyForMedian;
    }
    
    /**
     * this function contains the logic for the partitioning of the array
     * @param arrayCopyForMedian copy of the original array to be used
     * @param low lowest index of the array
     * @param high highest index of the array
     * @return the index where the swapped element will go
     */
    private static int medianPartition(int[] arrayCopyForMedian, int low, int high) {
        int pivotIndex = medianOfThree(arrayCopyForMedian, low, high);
        int pivot = arrayCopyForMedian[pivotIndex];
        Swap.swap(arrayCopyForMedian, pivotIndex, high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arrayCopyForMedian[j] <= pivot) {
                i++;
                Swap.swap(arrayCopyForMedian, i, j);
            }
        }
        Swap.swap(arrayCopyForMedian, i + 1, high);
        return i + 1;
    }

    /**
     * this function is being used to determine a good pivot element to be used in the sorting
     * @param arrayCopyForMedian copy of the original array to be used
     * @param low lowest index of the array
     * @param high highest index of the array
     * @return the index where the median element was found
     */
    private static int medianOfThree(int[] arrayCopy, int low, int high) {        
        int middle = (low + high) / 2;
        int[] trippleArray = {arrayCopy[low], arrayCopy[middle], arrayCopy[high]};
        if(trippleArray[0] > trippleArray[1])
            Swap.swap(trippleArray, 0, 1);
        if(trippleArray[1] > trippleArray[2])
            Swap.swap(trippleArray, 1, 2);
        if(trippleArray[0] > trippleArray[1])
            Swap.swap(trippleArray, 0, 1);
        if (trippleArray[1] == arrayCopy[low]) {
            return low;
        }
        else if (trippleArray[1] == arrayCopy[middle]) {
            return middle;
        }
        else {
            return high;
        }
    }



}