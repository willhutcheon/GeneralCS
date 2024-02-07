package assignment0;

/**
 * @author willHutcheon
 * Assignment 0
 * 
 * This file contains the Manager class and its characteristics
 * @since January 17, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */

/**
 * The Manager class provides a template for the characteristics that will define Manager objects, this class inherits the characteristics included in the Permanent and Employee classes
 * @author willHutcheon
 */
public class Manager extends Permanent {
    private int teamSize;
    /**
     * Constructor for the Manager class
     * @param teamSize the size of the managers team
     * @param annualSalary the employees annual salary
     * @param employeeID the employees ID number
     * @param name the employees name
     */
    public Manager(int teamSize, double annualSalary, int employeeID, String name) {
        super(annualSalary, employeeID, name);
        this.teamSize = teamSize;
        // catching illogical inputs
        if(teamSize < 0) {
            throw new IllegalArgumentException("Invalid team size");
        }
    }
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
        // catching illogical inputs
        if(teamSize < 0) {
            throw new IllegalArgumentException("Invalid team size");
        }
    }
    public int getTeamSize() {
        return teamSize;
    }
    @Override
    public String toString() {
        return "Manager{" + "teamSize=" + teamSize + '}';
    }
}
