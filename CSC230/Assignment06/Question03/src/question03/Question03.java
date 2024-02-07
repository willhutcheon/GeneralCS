package question03;

import java.util.Scanner;

/**
 *
 * @author willhutcheon
 */
public class Question03 {

    /**
     * from main a user can input a string value as well as call helper functions that go to drivers
     */
    public static void main(String[] args) {  
        System.out.println("Enter a string value: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();        
        reverse1(input);
        reverse2(input);
    }
    /**
     * this function is a helper to the driver reverse()
     * @param input accepts the users input from console
     * @return the input
     */
    public static String reverse1(String input) {
        String result = "";
        // declaring the starting position to be the end "index" of a string input
        int position = input.length() - 1;
        // calling the driver on the input
        System.out.println(reverse(input, position, result));
        return input;
    }
    /**
     * this function recursively reverses an input
     * @param input accepts the users input from console
     * @param position used to keep track of the "index" we are at within a string
     * @param result a place to hold the reversed string
     * @return the reversed string
     */
    private static String reverse(String input, int position, String result) {
        if(position < 0) {
            return result;
        }
        else {
            // decrementing the index position once per rec. and then adding the character at that new index to our result string until it finds the ending index, indicated
            // by a position value of -1
            return reverse(input, position - 1, result += input.charAt(position));
        }
    }
    /**
     * this function is a helper to the driver reverse()
     * @param input accepts the users input from console
     * @return the input
     */
    public static StringBuffer reverse2(String input) {
        // creating an empty string buffer
        StringBuffer sb = new StringBuffer("");
        int position = input.length() - 1;
        // calling the driver on the input
        System.out.println(reverse(input, position, sb));
        return sb;
    }
    /**
     * this function recursively reverses an input using a string buffer
     * @param input accepts the users input from console
     * @param position used to keep track of the "index" we are at within a string
     * @param sb a buffer structure that we can use as a sort of holder for our results
     * @return the reversed string
     */
    private static StringBuffer reverse(String input, int position, StringBuffer sb) {
        if(position < 0) {
            return sb;
        }
        // we can use the same logic as the other function but since we are working with a buffer data structure we need to append our result character onto the structure
        else {
            return reverse(input, position - 1, sb.append(input.charAt(position)));
        }
    }   
}





// String s = the string you wish to reverse
// Int position = the last index point of the string
// String result = the string that you will be adding the reverse of string s into (the string that s will concat to) and returning.