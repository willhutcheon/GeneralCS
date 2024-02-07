package question01;

/**
 * the Person class includes the characteristics name and age for a Person object
 * @author willhutcheon
 */
public class Person {
    protected String name;
    protected int age;
    /**
     * parameterized constructor for the Person class
     * @param name the constructor accepts a name value when the user creates a Person object
     * @param age the constructor accepts an age value when the user creates a Person object
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        // catching invalid user inputs
        if(age < 0) {
            throw new IllegalArgumentException("A person cannot be negative years old");
        }
    }
    /**
     * getter for the name value of an object, allows the user to retrieve the name value of a Person object
     * @return the name value of a Person object
     */
    public String getName() {
        return name;
    }
    /**
     * setter for the name value of an object, allows the user to initialize a name value to a Person object
     * @param name accepts a name value of a Person object
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter for the age value of an object, allows the user to retrieve the age value of a Person object
     * @return the age value of a Person object
     */
    public int getAge() {
        return age;
    }
    /**
     * setter for the age value of an object, allows the user to initialize an age value to a Person object
     * @param age accepts an integer age value for a Person object
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    @Override
    public String toString() {
        return ("Person{person=" + name + ", age=" + age + "}");
    }
}