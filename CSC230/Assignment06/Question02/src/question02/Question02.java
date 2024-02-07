package question02;

import java.util.Scanner;

/**
 *
 * @author willhutcheon
 */
public class Question02 {

    /**
     * allows the user to call the caller() method to reverse an integer input
     */
    public static void main(String[] args) {
        //System.out.print("Input an integer value to be reversed: ");
        //int userInt = new Scanner(System.in).nextInt();
        //System.out.println(revInt(userInt));
        caller();
    }
    /**
     * this function does some error handling and allows for the calling of the function that contains the logic only when a condition is met
     */
     public static void caller() {
        System.out.print("Input an integer value to be reversed: ");
        int userInt = new Scanner(System.in).nextInt();
        System.out.println(revInt(userInt));
        if(userInt <= 0) {
            throw new IllegalArgumentException("Your input must be a value greater than or equal to 0");
        }
        else {
            revInt(userInt);
        }
     }
    
    /**
     * 
     * @param userInt is the users integer input which will be further processed by the revInt() function it is passed to
     * @return a value equivalent to the "reverse: of an integer input
     */
    private static int revInt(int userInt){
        int reverse = 0;
        int remainder;
        // the input must be positive
        while(userInt > 0) {
            // "getting" the value at the last "index" of the input
            // applying % 10 to our input effectively gives us the value at the last index by focusing in on the least significant digit of a
            // number (only if we use 10, if we use 100, for instance, we will be "looking at" the second least sig fig and so on)
            remainder = userInt % 10;
            // storing the value we just "extracted", multiplying the result by 10 each reccursion will ensure the value we have just extracted goes into the correct "index" (sig fig) of our new, reversed number we are making 
            reverse = (reverse * 10) + remainder;
            // now that we have "extracted" the value we were looking for we can effectively reccursively shave the number down, we can only do this because we have that value stored
            // and now having a 0 in the least sig fig position is of no significance to us, we can remove it to reduce the problem (ie 120 / 10 = 12 and now we have a new number that we need to extract
            // the value from its "last index" so we can reposition it)
            userInt = userInt / 10;
            // the process happens again but the size of the problem has been reduced
            revInt(userInt);
        }
        // return our result
        return reverse;
    }
}