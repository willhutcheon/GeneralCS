package question01;

/**
 * the Teacher class includes(inherits) the characteristics name, age, and the new characteristics subject and salary for a Teacher object
 * @author willhutcheon
 */
public class Teacher extends Person {
    protected String subject;
    protected double salary;
    /**
     * parameterized constructor for the Teacher class
     * @param name the constructor accepts a name value when the user creates a Teacher object
     * @param age the constructor accepts an age value when the user creates a Teacher object
     * @param subject the constructor accepts a subject value when the user creates a Teacher object
     * @param salary the constructor accepts a salary value when the user creates a Teacher object
     */
    public Teacher(String name, int age, String subject, double salary) {
        super(name, age);
        this.subject = subject;
        this.salary = salary;
        // catching invalid user inputs        
        if(salary < 0) {
            throw new IllegalArgumentException("A teacher cannot have a negative salary");
        }
    }
    /**
     * getter for the subject value of an object, allows the user to retrieve the subject value of a Teacher object
     * @return the subject value for a Teacher object
     */
    public String getSubject() {
        return subject;
    }
    /**
     * setter for the subject value of an object, allows the user to initialize a subject value to a Teacher object
     * @param subject accepts a subject value for a Teacher object
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * getter for the salary value of an object, allows the user to retrieve the salary value of a Teacher object
     * @return the salary value for a Teacher object
     */
    public double getSalary() {
        return salary;
    }
    /**
     * setter for the salary value of an object, allows the user to initialize a salary value to a Teacher object
     * @param salary accepts a salary value for a Teacher object
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    @Override
    public String toString() {
        return ("Teacher{subject=" + subject + ", salary=" + salary + "}");
    }
}