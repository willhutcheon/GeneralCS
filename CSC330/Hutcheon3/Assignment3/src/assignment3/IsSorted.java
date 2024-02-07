package assignment3;

/**
 * @author willHutcheon
 * Assignment 3
 * 
 * This file includes the logic for checking if an array has been sorted
 * @since February 19, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class IsSorted {
    static boolean isSorted(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }
}
