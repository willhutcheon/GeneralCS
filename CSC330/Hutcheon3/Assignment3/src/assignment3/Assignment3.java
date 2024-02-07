package assignment3;

/**
 * @author willHutcheon
 * Assignment 3
 *
 * This program demonstrates the differences in performance of various sorting algorithms
 * @since February 19, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class Assignment3 {
    public static void main(String[] args) {
        starter();
    }
    /**
     * beginning point for program that can be called in main
     */
    private static void starter() {
        int arrayLength = 1400;
        int[] array = RandomArray.getRandomArray(arrayLength);
        int[] arrayCopy = array.clone();
        medianQuickSortCheck(arrayLength, array.clone());
        System.out.println();
        mergeSortCheck(arrayLength, array.clone());
        System.out.println();
        randomQuickSortCheck(arrayLength, array.clone());
        System.out.println();
        smartQuickSortCheck(arrayLength, array.clone());
        System.out.println();
        specificQuickSortCheck(arrayLength, array.clone());
    }
    /**
     * times how long it took to sort an array using the median value quick sort method as well as validates whether the array has been properly sorted
     * @param arrayLength length of the array
     * @param arrayCopy copy of the original array
     */
    private static void medianQuickSortCheck(int arrayLength, int[] arrayCopy) {
        long preMedianQuickSort = 0, postMedianQuickSort = 0;
        preMedianQuickSort = System.currentTimeMillis();
        MedianQuickSort.medianQuickSortHelper(arrayCopy, 0, arrayCopy.length - 1);
        postMedianQuickSort = System.currentTimeMillis();
        System.out.println("The time (in millis) it took to quick sort the array using a median pivot was: " + (postMedianQuickSort - preMedianQuickSort));
        IsSorted.isSorted(arrayCopy);
    }
    
    /**
     * times how long it took to sort an array using the merge sort method as well as validates whether the array has been properly sorted
     * @param arrayLength length of the array
     * @param arrayCopy copy of the original array
     */
    private static void mergeSortCheck(int arrayLength, int[] arrayCopy) {
        long preMergeSort = 0, postMergeSort = 0;
        preMergeSort = System.currentTimeMillis();
        MergeSort.mergeSortHelper(arrayCopy, 0, arrayCopy.length - 1);
        postMergeSort = System.currentTimeMillis();
        System.out.println("The time (in millis) it took to merge sort the array was: " + (postMergeSort - preMergeSort));
        IsSorted.isSorted(arrayCopy);
    }
    
    /**
     * times how long it took to sort an array using the random value quick sort method as well as validates whether the array has been properly sorted
     * @param arrayLength length of the array
     * @param arrayCopy copy of the original array
     */
    private static void randomQuickSortCheck(int arrayLength, int[] arrayCopy) {
        long preRandomQuickSort = 0, postRandomQuickSort = 0;
        preRandomQuickSort = System.currentTimeMillis();
        RandomQuickSort.randomQuickSortHelper(arrayCopy);
        postRandomQuickSort = System.currentTimeMillis();
        System.out.println("The time (in millis) it took to quick sort the array using a random pivot was: " + (postRandomQuickSort - preRandomQuickSort));
        IsSorted.isSorted(arrayCopy);
    }
    
    /**
     * times how long it took to sort an array using the smart quick sort method as well as validates whether the array has been properly sorted
     * @param arrayLength length of the array
     * @param arrayCopy copy of the original array
     */
    private static void smartQuickSortCheck(int arrayLength, int[] arrayCopy) {
        long preSmartQuickSort = 0, postSmartQuickSort = 0;
        preSmartQuickSort = System.currentTimeMillis();
        SmartQuickSort.smartQuickSortHelpersHelper(arrayCopy, 0, arrayCopy.length - 1);
        postSmartQuickSort = System.currentTimeMillis();
        System.out.println("The time (in millis) it took to quick sort the array using the smart quick sort was: " + (postSmartQuickSort - preSmartQuickSort));
        IsSorted.isSorted(arrayCopy);
    }
    
    /**
     * times how long it took to sort an array using the specific value quick sort method as well as validates whether the array has been properly sorted
     * @param arrayLength length of the array
     * @param arrayCopy copy of the original array
     */
    private static void specificQuickSortCheck(int arrayLength, int[] arrayCopy) {
        SpecificQuickSort.specificQuickSortHelper(arrayCopy, 0, arrayCopy.length - 1);
    }
}