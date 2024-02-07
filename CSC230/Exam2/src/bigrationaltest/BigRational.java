package bigrationaltest;

import java.math.BigInteger;

/**
 * This class represents rational numbers. A rational number stores a numerator
 * and denominator, and we will use BigIntegers to represent the numerator and
 * denominator. Thus our class will be aptly named BigRational
 *
 * Following concepts haven used. public static final constants use of an
 * existing class, namely BigInteger (composition) multiple constructors
 * throwing exceptions implementing a set of accessors implementing equals and
 * toString
 */

// this class was modified by Will Hutcheon

public class BigRational implements Comparable<Object> {

    public static final BigRational ZERO = new BigRational();
    public static final BigRational ONE = new BigRational("1");

    private BigInteger num; // only this can be nagative
    private BigInteger den; // never negative

    /**
     * BigRational constructor
     */
    public BigRational() {
        this(BigInteger.ZERO);
    }

    /**
     * parameterized BigRational constructor
     * @param n accepts a BigInteger value
     */
    public BigRational(BigInteger n) {
        this(n, BigInteger.ONE);
    }

    /**
     * parameterized constructor for the BigRational class
     * @param num accepts a users input which will correspond to a numerator
     * @param den accepts a users input which will correspond to a denominator
     */
    public BigRational(BigInteger num, BigInteger den) {
        this.num = num;
        this.den = den;
        // when a user creates a BigRational object, an inherent property of each object of this type they create is these functions and their
        // characteristics and behaviors
        // if the result can be determined we can continue, if the result is indeterminate there is no reason to call functions fixSigns() or reduce()
        if(!num.equals(BigInteger.ZERO) && !den.equals(BigInteger.ZERO)) {
            fixSigns();
            reduce();
        }
    }

    /**
     * this constructor checks if the users input is empty and if so throws and error. If the input is valid it is formatted
     * @param str accepts the users input in the form of a string
     */
    public BigRational(String str) {
        // if the user did not input anything throw an error
        if (str.length() == 0) {
            throw new IllegalArgumentException("empty string");
        }
        // finding where the '/' is within the users input
        int slashIndex = str.indexOf('/');
        // formatting output
        if (slashIndex == -1) {
            num = new BigInteger(str.trim());
            den = BigInteger.ONE; // den = 1
        } else {
            num = new BigInteger(str.substring(0, slashIndex).trim());
            den = new BigInteger(str.substring(slashIndex + 1).trim());
            // if the result can be determined we can continue, if the result is indeterminate there is no reason to call functions fixSigns() or reduce()
            if(!num.equals(BigInteger.ZERO) && !den.equals(BigInteger.ZERO)) {
                fixSigns();
                reduce();
            }
        }
    }

    /**
     * this function is evaluating whether the user has input a 0 for the numerator and denominator value, if so an exception will be thrown
     */
    private void check00() {
        if (num.equals(BigInteger.ZERO) && den.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("division by zero");
        }
    }

    /**
     * this function checks whether the (-) sign is being applied to the numerator or the denominator, if it is being applied to the denominator, this function
     * corrects this by negating both values, effectively changing the denominator to a positive value and the numerator to negative. If the numerator is already negative, it is negated to a positive
     * value as (-) / (-) = (+)
     */
    private void fixSigns() {
        if(den.compareTo(BigInteger.ZERO) < 0) {
            num = num.negate();
            den = den.negate();            
        }
    }

    /**
     * this function finds the greatest common denominator of BigInteger type values and then formats them back into a x/y format
     */
    private void reduce() {
        BigInteger gcd = num.gcd(den);
        num = num.divide(gcd);
        den = den.divide(gcd);
    }

    /**
     * this function uses a built in function (abs()) to obtain the result of the absolute value of an input
     * @return a BigRational number that is always positive
     */
    public BigRational abs() {
        return new BigRational(num.abs(), den);
    }

    /**
     * this function uses a built in function (negate()) to obtain the result equivalent to the negation of an input
     * @return a BigRational number that has a value opposite in sign of the input
     */
    public BigRational negate() {
        return new BigRational(num.negate(), den);
    }

    /**
     * this function provides logic for the addition of two BigRational inputs
     * @param other accepts a BigRational value to add to another BigRational
     * @return a BigRational value that has had an addition operation performed on it
     */
    public BigRational add(BigRational other) {
        BigInteger newNumerator = this.num.multiply(other.den).add(other.num.multiply(this.den));
        BigInteger newDenominator = this.den.multiply(other.den);
        return new BigRational(newNumerator, newDenominator);
    }

    /**
     * this function provides logic for the subtraction of two BigRational inputs
     * @param other accepts a BigRational value to subtract from another BigRational
     * @return a BigRational value that has had a subtraction operation performed on it
     */
    public BigRational subtract(BigRational other) {
        return add(other.negate());
    }

    /**
     * this function provides logic for the multiplication of two BigRational inputs
     * @param other accepts a BigRational value to multiply with another BigRational
     * @return a BigRational value that has had a multiplicative operation performed on it
     */
    public BigRational multiply(BigRational other) {
        BigInteger newNumerator = this.num.multiply(other.num);
        BigInteger newDenominator = this.den.multiply(other.den);
        return new BigRational(newNumerator, newDenominator);
    }

    /**
     * this function provides logic for the division of two BigRational inputs
     * @param other accepts a BigRational value to divide from another BigRational
     * @return a BigRational value that has had a division operation performed on it
     */
    public BigRational divide(BigRational other) {
        BigInteger newNumerator = this.num.multiply(other.den);
        BigInteger newDenominator = this.den.multiply(other.num);
        return new BigRational(newNumerator, newDenominator);
    }

    /**
     * this function checks if the object being passed to is it a BigRational, if it is the function determines if two inputs are equivalent
     * @param other a value of Object type
     * @return the equivalency status of user inputs
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof BigRational) {
            BigRational rhs = ((BigRational) other);
            return num.equals(rhs.num) && den.equals(((BigRational) other).den);
        }
        return false;
    }

    /**
     * this function is catching mathematically invalid inputs and outputting their errors
     * @return a String value which describes the error with the input
     */
    @Override
    public String toString() {
        // if the input for the denominator is 0
        if (den.equals(BigInteger.ZERO)) {
            // if the input for the numerator is a value less than 0
            if (num.compareTo(BigInteger.ZERO) < 0) {
                // return a String output of "-Infinity"
                return "-Infinity";
            }
            // if the input for the numerator is a value greater than 0
            else if (num.compareTo(BigInteger.ZERO) > 0) {
                // return a String output of "Infinity"                
                return "Infinity";
            }
        }
        // if the input is 0/0 we return a String value of "Indeterminate"
        if (num.equals(BigInteger.ZERO) && den.equals(BigInteger.ZERO)) {
            return "Indeterminate";
        }
        // if the denominator is 1 its as if we are not performing any operation so we can just return the numerator
        if (den.equals(BigInteger.ONE)) {
            return num.toString();
        }
        // if the input is valid we format and output it
        else {
            return num + " / " + den;
        }
    }
    
    /**
     * this function takes an instance of a users input, checks the value of its numerator and denominator, and then raises these values to a power that is specified
     * by the user
     * @param exp the user can input a value to raise the numerator and denominator to
     * @return the rational number after it has been raised to the users exponent value
     */
    public BigRational pow(int exp) {
        // throwing exceptions for invalid inputs
        if(exp < 0) {
            throw new ArithmeticException("Exponent is negative");
        }
        // raising the users input to the power of his/her exponent value input
        return new BigRational(num.pow(exp), den.pow(exp));
    }
    
    /**
     * this function takes an instance of a users input, checks the value of its numerator and denominator, and then switches the positions of
     * these values, producing a result that is equivalent to the reciprocal of the input
     * @return the reciprocal value of the users input
     */
    public BigRational reciprocal() {
        // if any of the values within the rational are 0
        if(num.equals(BigInteger.ZERO) || den.equals(BigInteger.ZERO)) {
            // return a value of 0
            return new BigRational(BigInteger.ZERO, BigInteger.ONE);
        }
        // otherwise
        // switching the places of the numerator and the denominator
        return new BigRational(den, num);
    }
    
    /**
     * this function converts a users rational number into a BigInteger type by checking if a users denominator value is 1
     * @return the converted value with the proper type (BigInteger)
     */
    public BigInteger toBigInteger() {
        // checking if the users denominator is 1
        if(den.equals(BigInteger.ONE)) {
            // if it is we can just return the numerator
            return num;
        }
        // if not we throw an exception
        else {
            throw new ArithmeticException("Not an integer value");
        }
    }
    
    /**
     * this function converts a users rational number into an int type by converting an input from a BigInteger type into an int type and then checking if a users denominator value is 1
     * @return the converted value with the proper type (int)
     */
    public int toInteger() {
        // checking if the users denominator is 1        
        if(den.equals(BigInteger.ONE)) {
            // if it is we can convert from a BigInteger type to an int type using intValue() and return that value
            return num.intValue();
        }
        // if not we throw an exception        
        else {
            throw new ArithmeticException("Not an integer value");
        }
    }
    
    /**
     * this function checks for indeterminate or non-BigRational inputs and throws an exception as they cannot be compared. If the input is valid the function determines which BigRational is a greater value
     * @param object accepts any object, the object is then type checked for an instance of a BigRational within the function. If the input is a BigRational and not 0/0, it is comparable
     * @return an integer value indicative of which input was greater
     */
    @Override
    public int compareTo(Object object) {
        if(object instanceof BigRational) {
            // gettting the correct type
            BigRational other = (BigRational)object;        
            // if at any point the input is 0/0 we throw an exception
            if(num.equals(BigInteger.ZERO) && den.equals(BigInteger.ZERO) || other.num.equals(BigInteger.ZERO) && other.den.equals(BigInteger.ZERO)) {
                throw new ArithmeticException("One of them is indeterminate");
            }        
            // cross multiplying
            BigInteger a = num.multiply(other.den);
            BigInteger b = other.num.multiply(den);
            // comparing
            return a.compareTo(b);
        }
        return 0;
    }
}