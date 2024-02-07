package question01;

/**
 * the CollegeStudent class includes(inherits) the characteristics name, age, ID, GPA, and the new characteristics major and year for a CollegeStudent object
 * @author willhutcheon
 */
public class CollegeStudent extends Student {
    protected String major;
    protected int year;
    /**
     * parameterized constructor for the CollegeStudent class
     * @param name the constructor accepts a name value when the user creates a CollegeStudent object
     * @param age the constructor accepts an age value when the user creates a CollegeStudent object
     * @param id the constructor accepts an id value when the user creates a CollegeStudent object
     * @param gpa the constructor accepts a gpa value when the user creates a CollegeStudent object
     * @param major the constructor accepts a major value when the user creates a CollegeStudent object
     * @param year the constructor accepts a year value when the user creates a CollegeStudent object
     */
    public CollegeStudent(String name, int age, String id, double gpa, String major, int year) {
        super(name, age, id, gpa);
        this.major = major;
        this.year = year;
        // catching invalid user inputs
        if(year < 0) {
            throw new IllegalArgumentException("A student could not have been in school for negative years");
        }
    }
    /**
     * getter for the major value of an object, allows the user to retrieve the major value of a CollegeStudent object
     * @return the major value for a CollegeStudent object
     */
    public String getMajor() {
        return major;
    }
    /**
     * setter for the major value of an object, allows the user to initialize a major value to a CollegeStudent object
     * @param major accepts a major value for a CollegeStudent object
     */
    public void setMajor(String major) {
        this.major = major;
    }
    /**
     * getter for the year value of an object, allows the user to retrieve the year value of a CollegeStudent object
     * @return the year value for a CollegeStudent object
     */
    public double getYear() {
        return year;
    }
    /**
     * setter for the year value of an object, allows the user to initialize a year value to a CollegeStudent object
     * @param year accepts a year value for a CollegeStudent object
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    @Override
    public String toString() {
        return ("College Student{major=" + major + ", year=" + year + "}");
    }
}