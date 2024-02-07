package bigrationaltest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Chandana Ariyawansa 
 * DO NOT CHANGE ANY CODE IN THE main METHOD!!!!!!
 *
 */
public class BigRationalTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*------------------Test cases for Question 2 /*------------------*/
        // Remove multiline comment when you are ready to test
        
        System.out.println("Testing Question 2");
        System.out.println(new BigRational("2/3").pow(4)); // output: 16 / 81
        System.out.println(new BigRational("2/4").pow(2)); // outpit: 1 / 4
        System.out.println(new BigRational("1/0").pow(5)); // output: Infinity
        System.out.println(new BigRational("-10/0").pow(2));// output: Infinity
        System.out.println(new BigRational("-10/0").pow(3));// output: -Infinity
        // Output: java.lang.ArithmeticException: Exponent is negative
        try {
            System.out.println(new BigRational("2/3").pow(-2));
        } catch (ArithmeticException ex) {
            System.out.println(ex.toString());
        }
        System.out.println("End of testing question 2");
        System.out.println("----------------------------------------------------------------");
        
        /*---------------End of Test cases for Question 2 /*-------------*/

 /*------------------Test cases for Question 3 /*------------------*/
        // Remove multiline comment when you are ready to test
        
        System.out.println("Testing Question 3");
        System.out.println(new BigRational("2/3").reciprocal()); // Output: 3/2
        System.out.println(new BigRational("-2/3").reciprocal()); // Output: -3/2
        System.out.println(new BigRational("1/0").reciprocal()); // Output: 0
        System.out.println(new BigRational("-1/0").reciprocal()); // Output: 0
        System.out.println("End of testing question 3");
        System.out.println("----------------------------------------------------------------");
        
        /*---------------End of Test cases for Question 3 /*-------------*/

 /*------------------Test cases for Question 4 /*------------------*/
        // Remove multiline comment when you are ready to test
        
        System.out.println("Testing Question 4");
        System.out.println(new BigRational("10/1").toBigInteger()); // Output: 10

        // Output: java.lang.ArithmeticException: Not an interger value
        try {
            System.out.println(new BigRational("1/2").toBigInteger());
        } catch (ArithmeticException ex) {
            System.out.println(ex.toString());
        }
        System.out.println("End of testing question 4");
        System.out.println("----------------------------------------------------------------");
        
        /*---------------End of Test cases for Question 4 /*-------------*/

 /*------------------Test cases for Question 5 /*------------------*/
        // Remove multiline comment when you are ready to test
        
        System.out.println("Testing Question 5");
        System.out.println(new BigRational("10/1").toInteger()); // Output: 10

        // Output: java.lang.ArithmeticException: Not an interger value
        try {
            System.out.println(new BigRational("1/2").toInteger());
        } catch (ArithmeticException ex) {
            System.out.println(ex.toString());
        }
        System.out.println("End of testing question 5");
        System.out.println("----------------------------------------------------------------");
        
        /*---------------End of Test cases for Question 5 /*-------------*/

 /*------------------Test cases for Question 6 /*------------------*/
        // Remove multiline comment when you are ready to test
        
        System.out.println("Testing Question 6");
        System.out.println(new BigRational("0/0").toString()); // Output: Indeterminate

        System.out.println("End of testing question 6");
        System.out.println("----------------------------------------------------------------");
        
        /*---------------End of Test cases for Question 6 /*-------------*/

 /*------------------Test cases for Question 7 /*------------------*/
        // Remove multiline comment when you are ready to test
        
        System.out.println("Testing Question 7");
        System.out.println(new BigRational("2/3").compareTo(new BigRational("1/2"))); // Output: 1 becasue 2/3 > 1/2
        System.out.println(new BigRational("1/2").compareTo(new BigRational("2/3"))); // Output: -1 becasue 1/2 < 2/3
        System.out.println(new BigRational("2/3").compareTo(new BigRational("4/6"))); // Output:  becasue 2/3 = 4/6

        //Output: java.lang.ArithmeticException: One of them is indeterminate
        try {
            System.out.println(new BigRational("2/3").compareTo(new BigRational("0/0")));
        } catch (ArithmeticException ex) {
            System.out.println(ex.toString());
        }

        // In the following example, you cannot sort the content because one number is in indeterminate form So, it cannot be sorted"
        //Output: java.lang.ArithmeticException: One of them is indeterminate
        ArrayList<BigRational> a1 = new ArrayList<>();

        a1.add(new BigRational("1/3"));
        a1.add(new BigRational("1/5"));
        a1.add(new BigRational("0/0")); // cannot compare to anything. Because of that you cannot sort the list
        a1.add(new BigRational("1/8"));
        a1.add(new BigRational("2/8"));

        try {
            Collections.sort(a1);
        } catch (ArithmeticException ex) {
            System.out.println("List may have an indeterminate. So, it cannot be sorted");
        }

        
        // Following list can be sorted.
        // Output: [-Infinity, 1 / 8, 1 / 5, 1 / 4, 1 / 3, 3 / 8, Infinity]    
        ArrayList<BigRational> a2 = new ArrayList<>();

        a2.add(new BigRational("1/3"));
        a2.add(new BigRational("1/5"));
        a2.add(new BigRational("1/8"));
        a2.add(new BigRational("2/8"));
        a2.add(new BigRational("3/8"));
        a2.add(new BigRational("-1/0")); // negative infinity
        a2.add(new BigRational("+1/0")); // positive infinity

        Collections.sort(a2);
        System.out.println(Arrays.toString(a2.toArray()));
        System.out.println("End of testing question 7");
        System.out.println("----------------------------------------------------------------");
        
        /*---------------End of Test cases for Question 7 /*-------------*/
    }
}
