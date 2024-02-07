package assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author willHutcheon
 * Assignment 1
 *
 * This program maps employee objects to an attendance metric to correlate employees to a unique attendance record
 * @since January 30, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public abstract class Assignment1<T extends Comparable<T>> implements Iterable<T>{
    public static void main(String[] args) {
        TreeMap<Employee, Integer> attendance = new TreeMap<>();
        starter(attendance);
    }

    /**
     * this function acts as a starting point for the program to run. this function allows the user to interact with the other functions
     * within this program using a menu-based system
     * @param attendance a TreeMap that maps the employees to how many days they have been to work
     */
    public static void starter(TreeMap<Employee, Integer> attendance) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to use the program? Input 'y' if so: ");
        String continueUsingMenu = scanner.nextLine();
        while(continueUsingMenu.equals("y")) {
            populateMap(attendance);
            System.out.println("1. Display ");
            System.out.println("2. Add Employee ");
            System.out.println("3. Search ");
            System.out.println("4. Exit ");
            System.out.println("Input a value cooresponding to an option: ");
            int userInput = Integer.valueOf(scanner.nextLine());
            if(userInput == 1) {
                displayMap(attendance);
                System.out.println("Would you like to continue to use the program? Input 'y' if so: ");
            }
            if(userInput == 2) {
                addToMap(attendance);
                System.out.println("Would you like to continue to use the program? Input 'y' if so: ");
            }
            if(userInput == 3) {
                searchMap(attendance);
                System.out.println("Would you like to continue to use the program? Input 'y' if so: ");
            }
            if(userInput == 4) {
                System.out.println("Would you like to exit the program? Input 'n' if so: ");
            }
            continueUsingMenu = scanner.nextLine();
        }
        if(continueUsingMenu.equals("n")) {
            System.out.println("Thanks for using Will Hutcheon's program");
        }
    }
    /**
     * displays the current contents of the TreeMap
     * @param attendance a TreeMap that maps the employees to how many days they have been to work
     */
    public static void displayMap(TreeMap<Employee, Integer> attendance) {
        System.out.println(attendance);
    }
    /**
     * allows a user to add a new employee object to the TreeMap
     * @param attendance a TreeMap that maps the employees to how many days they have been to work
     */
    public static void addToMap(TreeMap<Employee, Integer> attendance) {
        System.out.println("Input the information for the employee, press enter after you have input a value: ");
        System.out.println("Input the employees ID value: ");
        Scanner scanner = new Scanner(System.in);
        String userID = scanner.nextLine();
        System.out.println("Input the employees first name: ");
        String userFirstName = scanner.nextLine();
        System.out.println("Input the employees last name: ");
        String userLastName = scanner.nextLine();
        System.out.println("Input the employees salary value: ");
        double userSalary = Double.valueOf(scanner.nextLine());
        Employee employee = new Employee(userID, userFirstName, userLastName, userSalary);
        if(attendance.containsKey(employee)) {
            int daysAtWork = attendance.get(employee);
            daysAtWork++;
            attendance.put(employee, daysAtWork);
        }
        else {
            attendance.put(employee, 1);
        }
    }
    /**
     * allows a user to search the TreeMap for a key value as well as whether a value corresponding to a key within a map shows up in the map
     * @param attendance a TreeMap that maps the employees to how many days they have been to work
     */
    public static void searchMap(TreeMap<Employee, Integer> attendance) {
        System.out.println("Input a key value to search for: ");
        Scanner scanner = new Scanner(System.in);
        Integer key = Integer.valueOf(scanner.nextLine());
        System.out.println("Key " + key + " is in the map? " + attendance.containsValue(key));
        System.out.println("Input the information for the employee, press enter after you have input a value: ");
        System.out.println("Input the employees ID value: ");
        String userID = scanner.nextLine();
        System.out.println("Input the employees first name: ");
        String userFirstName = scanner.nextLine();
        System.out.println("Input the employees last name: ");
        String userLastName = scanner.nextLine();
        System.out.println("Input the employees salary value: ");
        double userSalary = Double.valueOf(scanner.nextLine());
        Employee employee = new Employee(userID, userFirstName, userLastName, userSalary);
        if(attendance.containsKey(employee)) {
            System.out.println(employee.toString() + attendance.get(employee));
        }
        else {
            System.out.println("The employee you have provided does not exist within the map");
        }
    }
    /**
     * initializes the TreeMap structure with contents from the text file
     * @param attendance a TreeMap that maps the employees to how many days they have been to work
     */
    public static void populateMap(TreeMap<Employee, Integer> attendance) {
        try {
            String delimiter = ",";
            String stringHolder;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("employee.txt"));
            while((stringHolder = bufferedReader.readLine()) != null) {
                String[] textFromFile = stringHolder.split(delimiter);
                String intArray = textFromFile[0];
                double doubleArray = Double.parseDouble(textFromFile[3]);
                Employee employee = new Employee(intArray, textFromFile[1], textFromFile[2], doubleArray);           
                if(attendance.containsKey(employee)) {
                    Integer daysAtWork = attendance.get(employee);
                    daysAtWork++;
                    attendance.put(employee, daysAtWork);
                }
                else {
                    attendance.put(employee, 1);
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Could not find file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

