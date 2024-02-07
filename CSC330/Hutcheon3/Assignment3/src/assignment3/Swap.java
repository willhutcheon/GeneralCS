package assignment3;

/**
 * @author willHutcheon
 * Assignment 3
 * 
 * This file includes the logic for swapping array elements
 * @since February 19, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class Swap {
    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
