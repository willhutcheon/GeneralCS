package question01;

import java.util.Scanner;

/**
 *
 * @author willhutcheon
 */
public class Question01 {

    /**
     * allows for the user to call the caller() function
     */
    public static void main(String[] args) {
        /*String string = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string: ");
        string = scanner.nextLine();
        System.out.println(stringLength(string));*/
        caller();
    }
    
    /**
     * this function allows us to make a clean protected function call in main that includes logic from other functions(function in this case)
     */
    public static void caller() {
        String string = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string: ");
        string = scanner.nextLine();
        System.out.println(stringLength(string));
    }
    
    /**
     * this function recursively determines the length of a string input by calling itself, a function which increments one character (through the use of varying the index position limit of a sub string) per call until
     * the end of a string input is reached
     * @param string the users string input to be processed
     * @return the length of the string input
     */
    private static int stringLength(String string) {
        // if the string is empty return a length of 0
        if(string == "") {
            return 0;
        }
        // otherwise pass through the string until the end is reached, adding one to the substring index limit per recursion
        else {
            return stringLength(string.substring(1)) + 1;
        }
    }
}