package assignment0;

/**
 * @author willHutcheon
 * Assignment 0
 * 
 * This file contains the Employee class and its characteristics
 * @since January 17, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */

/**
 * The Employee class provides a template for the characteristics that will define Employee objects
 * @author willHutcheon
 */
public class Employee {
    private int employeeID;
    private String name;
    /**
     * Constructor for the Employee class
     * @param employeeID the employees ID number
     * @param name the employees name
     */
    public Employee(int employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", name=" + name + '}';
    }
}
