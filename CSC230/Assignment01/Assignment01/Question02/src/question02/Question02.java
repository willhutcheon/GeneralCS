package question02;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author willhutcheon
 * Question 02
 */

public class Question02 {

    /**
     * @param args
     * The main method is used to call test functions for checking the array conformations
     */
    public static void main(String[] args) {
        // TODO code application logic here
        checkVertical(genArray());
        checkHorizontal(genArray());
        checkLRDiagonal(genArray());
        checkRLDiagonal(genArray());
 
    }

    /***
     *
     * @return the array populated with random upper case characters
     */
    public static char[][] genArray() {
        // getting and initalizing the size of the array from user input on console
        System.out.println("How many rows in the array? Input a value greater than or equal to 4: ");
        int rows = new Scanner(System.in).nextInt();
        System.out.println("How many columns in the array? Input a value greater than or equal to 4: ");
        int columns = new Scanner(System.in).nextInt();
        // declaring a new array based on user input
        char[][] array = new char[rows][columns];
        if (rows < 4 || columns < 4) {
            throw new IllegalArgumentException("Your input must be a value greater than or equal to 4");
        }
        // populating a matrix with random chars
        for(int a = 0; a < array.length; a++) {
            for (int b = 0; b < array[0].length; b++) {
                // producing a random number
                Random r = new Random();
                // using the random number to generate a random upper case char
                array[a][b] = (char)(r.nextInt(26) + 'A');
                // printing array
                System.out.print(array[a][b] + " ");
            }
            System.out.println();
        }

        return array;
    }
   
 
    /**
     * Passes through the matrix by row checking whether a sequence of four consecutive letters occurs
     * @param array the array of randomly generated capital letters is passed to the function
     * @return true if the array has a sequence of four consecutive letters on a row, false if not
     */
    public static boolean checkHorizontal(char[][] array){
        // declaring a flag to be triggered when an instance is valid
        // condition is not valid yet
        boolean q = false;
        // rows
        // iterating through the array from left to right by row
        for(int a = 0; a < array.length; a++) {
            for (int b = 0; b <= array[0].length - 4; b++) {
                // validating whether the value the current index holds is sequential to the next 4 on the row
                if ((array[a][b] + 1) == (array[a][b + 1]) && (array[a][b + 1] + 1) == array[a][b + 2] && (array[a][b + 2] + 1) == array[a][b + 3]) {
                    // flag triggered
                    q = true;
                }
            }
        }
        System.out.println(q);
        return q;
    }
   
    /**
     * Passes through the matrix by column checking whether a sequence of four consecutive letters occurs
     * @param array the array of randomly generated capital letters is passed to the function
     * @return true if the array has a sequence of four consecutive letters on a column, false if not
     */
    public static boolean checkVertical(char[][] array) {
        // declaring a flag to be triggered when an instance is valid
        boolean q = false;
        // columns
        // iterating through the array from top to bottom by column
        for(int b = 0; b < array[0].length; b++) {
            for(int a = 0; a <= array.length - 4; a++) {
                // validating whether the value the current index holds is sequential to the next 4 on the column
                if((array[a][b] + 1) == array[a + 1][b] && (array[a + 1][b] + 1) == array[a + 2][b] && (array[a + 2][b] + 1) == array[a + 3][b]) {
                    q = true;
                }
            }
        }
        System.out.println(q);
        return q;
    }
   
    /**
     * Passes through the matrix diagonally from top to bottom, left to right, checking whether a sequence of four consecutive letters occurs
     * @param array the array of randomly generated capital letters is passed to the function
     * @return true if the array has a sequence of four consecutive letters diagonally left to right, false if not
     */
    public static boolean checkLRDiagonal(char[][] array) {
        // declaring a flag to be triggered when an instance is valid
        boolean q = false;
        // diagonal left to right
        // iterating through the array from left to right by row, once an index is located by the for loop the if loop validates whether
        // the index one row over and one column down is sequential
        for(int a = 0; a <= array.length - 4; a++) {
            for(int b = 0; b <= array[0].length - 4; b++) {
                if((array[a][b] + 1) == array[a + 1][b + 1] && (array[a + 1][b + 1] + 1) == array[a + 2][b + 2] && (array[a + 2][b + 2] + 1) == array[a + 3][b + 3]) {
                    q = true;
                }
            }
        }
        System.out.println(q);
        return q;
    }
   
    /**
     * Passes through the matrix diagonally from top to bottom, right to left, checking whether a sequence of four consecutive letters occurs
     * @param array the array of randomly generated capital letters is passed to the function
     * @return true if the array has a sequence of four consecutive letters diagonally right to left, false if not
     */
    public static boolean checkRLDiagonal(char[][] array) {
        // declaring a flag to be triggered when an instance is valid
        boolean q = false;
        // diagonal left to right
        // iterating through the array from right to left by row, once an index is located by the for loop the if loop validates whether
        // the index one column to the left and one row down is sequential
        for(int a = 0; a <= array.length - 3; a++) {
            for(int b = 3; b < array[0].length; b++) {
                if((array[a][b] + 1) == array[a + 1][b - 1] && (array[a + 1][b - 1] + 1) == array[a + 2][b - 2] && (array[a + 2][b - 2] + 1) == array[a + 3][b - 3]) {
                    q = true;
                }
            }
        }
        System.out.println(q);        
        return q;
    }
   
}