package assignment0;

/**
 * @author willHutcheon
 * Assignment 0
 * 
 * This program allows a user to construct objects from some basic classes. The program can also calculate how much an hourly employee needs to be paid for the week
 * @since January 17, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class Assignment0 {
    public static void main(String[] args) {
        Employee employee = new Employee(1234, "Billingston");
        System.out.println(employee.toString());
        System.out.println("The employees ID: " + employee.getEmployeeID());
        System.out.println("The employees name: " + employee.getName());
        System.out.println();
        Hourly hourly = new Hourly(15.25, 44, 1236, "James");
        System.out.println(hourly.toString());
        System.out.println("The employees hourly wage: " + hourly.getHourlyWage());
        System.out.println("The ammount of hours the employee has worked: " + hourly.getHoursWorked());
        System.out.println("The employees ID: " + hourly.getEmployeeID());
        System.out.println("The employees name: " + hourly.getName());
        System.out.println("For this week the employee needs to be paid: " + hourly.calculateWeekly(hourly.getHourlyWage(), hourly.getHoursWorked()));
        System.out.println();
        Permanent permanent = new Permanent(80000.00, 4321, "Will");
        System.out.println(permanent.toString());
        System.out.println("The permanent employees annual salary: " + permanent.getAnnualSalary());
        System.out.println("The permanent employees ID: " + permanent.getEmployeeID());
        System.out.println("The permanent employees name: " + permanent.getName());
        System.out.println();
        Manager manager = new Manager(7, 160000.00, 3233, "Poindexter");
        System.out.println(manager.toString());
        System.out.println("The managers team size: " + manager.getTeamSize());
        System.out.println("The managers annual salary: " + manager.getAnnualSalary());
        System.out.println("The managers employee ID: " + manager.getEmployeeID());
        System.out.println("The managers name: " + manager.getName());
    }
}