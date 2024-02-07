package assignment0;

/**
 * @author willHutcheon
 * Assignment 0
 * 
 * This file contains the Hourly class and its characteristics
 * @since January 17, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */

/**
 * The Hourly class provides a template for the characteristics that will define Hourly objects, this class inherits the characteristics included in the Employee class
 * @author willHutcheon
 */
public class Hourly extends Employee {
    private double hourlyWage;
    private double hoursWorked;
    /**
     * Constructor for the Hourly class
     * @param hourlyWage the employees hourly wage
     * @param hoursWorked the amount of hours the employee has worked
     * @param employeeID the employees ID number
     * @param name the employees name
     */
    public Hourly(double hourlyWage, double hoursWorked, int employeeID, String name) {
        super(employeeID, name);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        // catching illogical inputs
        if(hourlyWage < 0) {
            throw new IllegalArgumentException("An employee must be paid some positive value");
        }
        if(hoursWorked <= 0 || hoursWorked > 168) {
            throw new IllegalArgumentException("The value of hours you have input is illogical");
        }
    }
    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
        // catching illogical inputs
        if(hourlyWage < 0) {
            throw new IllegalArgumentException("An employee must be paid some positive value");
        }
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
        // catching illogical inputs
        if(hoursWorked <= 0 || hoursWorked > 168) {
            throw new IllegalArgumentException("The value of hours you have input is illogical");
        }
    }
    public double getHourlyWage() {
        return hourlyWage;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }
    /**
     * This function accepts values for the amount of hours an employee worked per week, as well as their hourly pay rate to calculate
     * how much the employee needs to be paid for the week. The function also handles payment for overtime (employee worked > 40 hr)
     * @param hourlyWage how much the employee makes per hour
     * @param hoursWorked how many hours an employee has worked
     * @return the total amount to be paid to an employee for the week
     */
    public double calculateWeekly(double hourlyWage, double hoursWorked) {
        final double overtime = hoursWorked - 40;
        double overtimeRate = hourlyWage;
        // overtime
        if(overtime > 0) {
            overtimeRate *= 1.5;
        }
        final double toPay = hourlyWage * hoursWorked + (overtimeRate * overtime) - (hourlyWage * overtime);
        return toPay;
    }
    @Override
    public String toString() {
        return "Hourly{" + "hourlyWage=" + hourlyWage + ", hoursWorked=" + hoursWorked + '}';
    }
}
