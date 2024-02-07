package assignment0;

/**
 * @author willHutcheon
 * Assignment 0
 * 
 * This file contains the Permanent class and its characteristics
 * @since January 17, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */

/**
 * The Permanent class provides a template for the characteristics that will define Permanent objects, this class inherits the characteristics included in the Employee class
 * @author willHutcheon
 */
public class Permanent extends Employee {
    private double annualSalary;
    /**
     * Constructor for the Permanent class
     * @param annualSalary the employees annual salary
     * @param employeeID the employees ID number
     * @param name the employees name
     */
    public Permanent(double annualSalary, int employeeID, String name) {
        super(employeeID, name);
        this.annualSalary = annualSalary;
        // catching illogical inputs
        if(annualSalary < 0) {
            throw new IllegalArgumentException("You should pay them something");
        }
    }
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
        // catching illogical inputs
        if(annualSalary < 0) {
            throw new IllegalArgumentException("You should pay them something");
        }
    }
    public double getAnnualSalary() {
        return annualSalary;
    }
    @Override
    public String toString() {
        return "Permanent{" + "annualSalary=" + annualSalary + '}';
    }
}
