package assignment1;

/**
 * @author willHutcheon
 * Assignment 1
 * 
 * This file contains the Employee class and its characteristics
 * @since January 30, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */

/**
 * The Employee class provides a template for the characteristics that will define Employee objects
 * @author willHutcheon
 */
public class Employee implements Comparable<Employee> {
    private String employeeID;
    private String firstName;
    private String lastName;
    private double salary;
    /**
     * Constructor for the Employee class
     * @param employeeID the employees ID number
     * @param firstName the employees first name
     * @param lastName the employees last name
     * @param salary the employees salary
     */
    public Employee(String employeeID, String firstName, String lastName, double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        if(salary < 0) {
            throw new IllegalArgumentException("The employee must have some salary greater than or equal to 0");
        }
    }
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSalary(double salary) {
        this.salary = salary;
        if(salary < 0) {
            throw new IllegalArgumentException("The employee must have some salary greater than or equal to 0");
        }
    }
    public String getEmployeeID() {
        return employeeID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + '}';
    }
    @Override
    public int compareTo(Employee o) {
        return this.employeeID.compareTo(o.employeeID);
    }
}

