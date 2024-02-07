package question01;

/**
 * the Student class includes(inherits) the characteristics name, age, and the new characteristics ID and GPA for a Student object
 * @author willhutcheon
 */
public class Student extends Person {
    protected String id;
    protected double gpa;
    /**
     * parameterized constructor for the Student class
     * @param name the constructor accepts a name value when the user creates a Student object
     * @param age the constructor accepts an age value when the user creates a Student object
     * @param id the constructor accepts an id value when the user creates a Student object
     * @param gpa the constructor accepts a gpa value when the user creates a Student object
     */
    public Student(String name, int age, String id, double gpa) {
        super(name, age);
        this.id = id;
        this.gpa = gpa;
        // catching invalid user inputs        
        if(gpa < 0 || gpa > 4) {
            throw new IllegalArgumentException("Invalid GPA value, a GPA can be within the range of 0 - 4");
        }
    }
    /**
     * getter for the id value of an object, allows the user to retrieve the id value of a Student object
     * @return the id value of a Student object
     */
    public String getId() {
        return id;
    }
    /**
     * setter for the id value of an object, allows the user to initialize an id value to a Student object
     * @param id accepts an id value for a Student object
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * getter for the gpa value of an object, allows the user to retrieve the gpa value of a Student object
     * @return the gpa value for a Student object
     */
    public double getGpa() {
        return gpa;
    }
    /**
     * setter for the gpa value of an object, allows the user to initialize a gpa value to a Student object
     * @param gpa accepts a gpa value for a Student object
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    @Override
    public String toString() {
        return ("Student{ID=" + id + ", GPA=" + gpa + "}");
    }
}