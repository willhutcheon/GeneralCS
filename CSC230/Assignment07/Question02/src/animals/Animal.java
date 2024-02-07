package animals;

/**
 * the Animal class includes the characteristics name and age for an Animal object
 * @author willhutcheon
 */
public class Animal {
    protected String name;
    protected int age;
    /**
     * parameterized constructor for the Animal class
     * @param name the constructor accepts a name value when the user creates an Animal object
     * @param age the constructor accepts an age value when the user creates an Animal object
     */
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        // catching invalid user inputs
        if(age < 0) {
            throw new IllegalArgumentException("An animal cannot be negative years old");
        }
    }
    /**
     * the sound() function describes a quality of animals
     */
    protected void sound() {
        System.out.println("Animals make funny sounds");
    }
    /**
     * getter for the name value of an object, allows the user to retrieve the name value of an Animal object
     * @return the name value of an Animal object
     */
    public String getName() {
        return name;
    }
    /**
     * setter for the name value of an object, allows the user to initialize a name value to an Animal object
     * @param name accepts a name value of an Animal object
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter for the age value of an object, allows the user to retrieve the age value of an Animal object
     * @return the age value of an Animal object
     */
    public int getAge() {
        return age;
    }
    /**
     * setter for the age value of an object, allows the user to initialize an age value to an Animal object
     * @param age accepts an age value of an Animal object
     */
    public void setAge(int age ) {
        this.age = age;
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    //@Override
    public String toString() {
        return name + " " + age;
    }
}
