package question04;

import java.util.Scanner;

/**
 *
 * @author willhutcheon
 */
public class Question04 {

    /**
     * allows a user to call the helper functions for the driver functions
     */
    public static void main(String[] args) {
        System.out.print("Input an integer value: ");
        int userInt = new Scanner(System.in).nextInt();
        int[] array = new int[userInt + 1];
        int i = 2;

        //int[] array = new int[userInt + 1];
        //System.out.println("Fib bad: " + fib_bad(userInt));
        //System.out.println("Fib good: ");
        //fib_good(userInt, array);
        bad_helper(userInt);
        System.out.print(fib_good(userInt, array, i));
        System.out.print(good_helper(userInt));
    }
    /**
     * this function is a helper for fib_bad()
     * @param userInt accepts a user input from console
     */
    public static void bad_helper(int userInt) {
        if(userInt < 0) {
            throw new IllegalArgumentException("There are no fibonacci values cooresponding to a negative index in the sequence");
        }
        System.out.println("Fib bad: " + fib_bad(userInt));
    }
    
    /**
     * this function utilized reccursion to return a coorresponding fibonacci number from a users input
     * @param userInt the user can input a value to see which fibonacci number corresponds to it
     * @return the fibonacci value corresponding to the users input
     */
    private static int fib_bad(int userInt) {
        // base cases
        // we can just return these values due to there being no cooresponding fib value
        if (userInt <= 1)
            return userInt;
        else
            // calculate the fib sequence until we reach the index of the input (the fib sequences index)
            return fib_bad(userInt - 1) + fib_bad(userInt - 2);
    }
    
    
    
    
    /**
     * this function accepts values from fib_good and stores them in an array
     * @param userInt accepts the result from the previous fib functions calculation
     */
    public static int good_helper(int userInt) {
        if (userInt < 0) {
            throw new IllegalArgumentException("There are no fibonacci values cooresponding to a negative index in the sequence");
        }
        int[] array = new int[userInt + 1];
        array[0] = 0;
        array[1] = 1;
        return fib_good(userInt, array, 2);
    }

    
    /**
     * this function utilized reccursion to return a coorresponding fibonacci number from a users input
     * @param userInt accepts the users input from console
     * @return the fibonacci value at the requested index
     */
    private static int fib_good(int userInt, int[] array, int i) {
        array[i] = array[i - 1] + array[i - 2];
        if (i == userInt) {
            return array[userInt];
        }
        return fib_good(userInt, array, i + 1);
    }
    
    
    
    
    
    
    
    
    
    
    

   /*public static int[] fib_good(int userInt, int[] array) {
        if (userInt == 1 || userInt == 0) {
            array[userInt] = 1;
        }
        else {
            array[userInt] = fib_good(userInt - 2, array[userInt]) + fib_good(userInt - 1, array[userInt]);
        }
        return array;
    }*/
    
    /**
     * this function accepts values from fib_good and stores them in an array
     * @param userInt accepts the result from the previous fib functions calculation
     */
    /*public static void fib_good(int userInt) {
        // creating a new array that is sized to the index within the fib sequence we want to reach
        int[] array = new int[userInt + 1];
        // making arrays out of base cases
        if (userInt <= 1) {
            System.out.print("The previous fibonacci numbers are: ");
            for(int a = 0; a < userInt + 1; a++) {
                // getting the rsult of each iteration of fib_bad() and storing them in an array
                array[a] = fib_bad(a);
                System.out.print(array[a] + " ");
            }
        }
        else {
            System.out.print("The previous fibonacci numbers are: ");
            for(int a = 0; a < userInt + 1; a++) {
                // getting the result of each iteration of fib_bad() and storing them in an array
                // each result of a reccursive call of the function will be stored effectively giving us the sequence up to some index
                array[a] = fib_bad(a);
                System.out.print(array[a] + " ");
            }
        }
        System.out.println();
    }*/
}

/*public static void fib_good1(int userInt, int[] array1) {

}*/

// needs to be a global array to not make a new one per rec.

