package question03;

import java.util.Scanner;

/**
 *
 * @author willhutcheon
 */
public class Question03 {

    /**
     * allows the user to call the binarySearch() method
     */
    public static void main(String[] args) {
        // the array input must be sorted
        int[] array0 = {1,2,3,4,5};
        int[] array1 = {1};
        int[] array2 = {};
        int[] array3 = {1,2,2,2};
        System.out.print("Enter a number to find the index of within the array: ");
        int index = new Scanner(System.in).nextInt();
        System.out.println(binarySearch(array0, index));
        System.out.println(binarySearch(array1, index));
        System.out.println(binarySearch(array2, index));
        System.out.println(binarySearch(array3, index));
    }
    
    /**
     * the binary search repeatedly divides in half the portion of an array that could contain the users input until it has found the index of that input
     * @return the index value corresponding to value of the users input or 0 if the input is not found within the array
     */
    public static int binarySearch(int[] array, int index) {
        // initializing a variable to hold the value of the index of the beginning of the array (index 0)
        int beginning = 0;
        // initializing a variable to hold the value of the last index of the array
        int last = array.length - 1;
        while(beginning <= last) {
            // finding the center index of the array and storing it in a variable
            int middle = (beginning + last) / 2;
            // if the value at the middle index of the array is equivalent to the value of the users input
            if(array[middle] == index) {
                // return the index that the value was found at (in this case the middle index of the array)
                return middle;
            }
            // if the value at the middle index is less than the value of the users input
            else if(array[middle] < index) {
                // we check the upper half of the array
                // in setting our variables this way we will be checking the middle of index of the upper half on the next iteration of the loop
                beginning = middle + 1;
            }
            // otherwise we check the lower half of the array
            // in setting our variables this way we will be checking the middle of index of the lower half on the next iteration of the loop
            else {
                last = middle - 1;
            }
        }
        return 0;
    }
}
