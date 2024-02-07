// second maximum pseudocode
       
// secondLargest(array)
// largest = 0
// for a = 0 to array.length
// if array[a] > largest
// largest = array[a]
// secondLargest = 0
// for a = 0 to array.length
// if array[a] > largest and array[a] does not equal largest index
// secondLargest = array[a]

package question02;

/**
 *
 * @author willhutcheon
 */
public class Question02 {

    /**
     * calls secondLargest() function on an array input to return the second largest int in the array
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        int[] a1 = { 1 };
        int[] a2 = { 1, 1 };
        int[] a3 = { 1, 1, 1, 1, 1 };
        int[] a4 = { 2, 1 };
        int[] a5 = { 3, 2, 1 };
        int[] a6 = { 1, 2, 3 };
        int[] a7 = { 1, 2, 3, 3, 4, 1, 10 };
       
        // handling errors
        try {
            System.out.println(secondLargest(a1));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(secondLargest(a2));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(secondLargest(a3));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(secondLargest(a4));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(secondLargest(a5));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(secondLargest(a6));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(secondLargest(a7));
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }
   
    /**
     * this function searches an array of ints for the second largest int within the array
     * @param array accepts an array of integers of any size
     * @return returns the second largest value within the array
     */
    public static int secondLargest(int[] array) {
       
        // holds the value of the largest int in the array
        int largest = 0;
        // holds the value of the second largest int in the array
        int secondLargest = 0;
       
        // catching user input errors
       
        // array length cannot be less than 2
        if(array.length < 2) {
            throw new IllegalArgumentException("No second max for arrays of size less than 2");
        }
       
        // SOLUTION 1
        /*int q = 0;
        for(int a = 0; a < array.length; a++) {
            q += array[a];
        }
        if(q - (array[0] * array.length) == 0) {
            throw new IllegalArgumentException("The array has the same element. No second maximum");
        }*/
       
        // SOLUTION 2
        // declaring and init. a flag
        boolean x = true;
        for(int a = 0; a < array.length - 1; a++) {
            // if the element at the current index is not the same as the element at the next index position
            if (array[a] != array[a + 1]) {
                // all of the values being the same in the array is false
                x = false;
            }
        }
       
        // if the condition of different values within the array has not been satisfied
        // throw an exception
        if(x) {
            throw new IllegalArgumentException("The array has the same element. No second maximum");
        }
       
        // passing through the array by index
        for(int a = 0; a < array.length; a++) {
            // finding the largest value in the array
            if(array[a] > largest) {
                largest = array[a];
            }
        }
        for(int a = 0; a < array.length; a++) {
            // finding the second largest value in the array by restricting the result to not be at the index of the true largest value
            if(array[a] > secondLargest && array[a] != largest) {
                secondLargest = array[a];
            }
        }
       
        return secondLargest;
    }
   
}