package question01;

import java.util.Scanner;

/**
 *
 * @author willhutcheon
 */
public class Question01 {

    /**
     * allows the user to call the isPalindromne() method
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome());
    }
    /**
     * this function indexes through a users string input, and compares the first char in the string to the last. each index is incremented, opposite in sign, allowing for two "scanners" to converge upon
     * each other in the middle of a string input. This allows for O(1) time complexity and no extra memory space needed, ie to hold a separate copy of a reversed string input to compare to the original
     * @return a boolean value (x) indicating whether an input is a palindrome or not
     */
    public static boolean isPalindrome() {
        // boolean flag is initially set ot false, condition of palindrome is not satisfied yet
        boolean x = true;
        String input;
        // setting the first index position
        int first = 0;
        System.out.print("Enter a string: ");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        // converting input entierly to lower case for error checking
        // ie Sss is a palindrome but will be flagged as false because S != s so I convert the entire input to lower(can also be to upper) to account for this
        input = input.toLowerCase();
        // setting the last index position
        int last = input.length();
        // indexing through the input
        for(int c = 0; c <= input.length(); c++) {
            for(int a = 0; a < input.length(); a++) {
                // updating the index position
                first = a;
            }
            for(int b = input.length(); b >= 0; b--) {
                // updating the index position
                last = b;
            }
            // if the characters are equivalent at the cooresponding indexes
            if(input.charAt(first) == input.charAt(last)) {
                // close the gap, each index positions are moved further towards the middle by 1
                first++;
                last--;
            }
            // if there is an instance where two letters are not equivalent the flag is triggered to indicate no palindrome
            else {
                x = false;
            }
        }
        // return the status of the flag
        return x;
    }
}
