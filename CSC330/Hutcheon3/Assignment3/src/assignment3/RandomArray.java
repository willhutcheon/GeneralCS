package assignment3;

import java.util.Random;

/**
 * @author willHutcheon
 * Assignment 3
 * 
 * This file includes the logic for generating an array of random values 1-100
 * @since February 19, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class RandomArray {
    public static int[] getRandomArray(int howMany) {
        int[] array = new int[howMany];
        Random random = new Random();
        for(int i = 0; i < howMany; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
