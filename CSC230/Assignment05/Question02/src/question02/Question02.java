package question02;

import java.util.Scanner;

/**
 *
 * @author willhutcheon
 */
public class Question02 {

    /**
     * allows the user to call the greatestCommonDivisor() method
     */
    public static void main(String[] args) {
        System.out.print("Input the first value: ");
        int first = new Scanner(System.in).nextInt();
        System.out.print("Input the second value: ");
        int second = new Scanner(System.in).nextInt();
        System.out.println("The greatest common divisor is " + greatestCommonDivisor(first, second));
    }
    /**
     * this function finds the greatest common divisor os two integer inputs
     * @return the greatest common divisor of the two inputs
     */
    public static int greatestCommonDivisor(int first, int second) {
        // creating a place to hold values temporarily
        int temp = 0;
        // ensuring we are not dividing by 0
        while(second != 0) {
            // storing the second input in a variable that holds values temporarily
            temp = second;
            // storing the result of the remainder that is left when the first input is divided by the second
            second = first % second;
            // storing the value in temp in the first user input
            first = temp;
            // if there is a remainder left over after the division the loop repeats itself
        }
        // returning the greatest common factor of the two inputs
        return first;
    }
}
