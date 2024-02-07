package animals;

/**
 * the Dog class includes(inherits) the characteristics name, age, and the new characteristic breed for a Dog object
 * @author willhutcheon
 */
public class Dog extends Animal {
    private String breed;
    /**
     * parameterized constructor for the Dog class
     * @param name the constructor accepts a name value when the user creates a Dog object
     * @param age the constructor accepts an age value when the user creates a Dog object
     * @param breed the constructor accepts a breed value when the user creates a Dog object
     */
    public Dog(String breed, String name, int age) {
        super(name, age);
        this.breed = breed;
    }
    /**
     * getter for the breed value of an object, allows the user to retrieve the breed value of a Dog object
     * @return the breed value of a Dog object
     */
    public String getBreed() {
        return breed;
    }
    /**
     * setter for the breed value of an object, allows the user to initialize a breed value to a Dog object
     * @param breed accepts a breed value of a Dog object
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }
    /**
     * the sound() function describes a quality of the dog animal
     */
    @Override
    public void sound() {
        System.out.println("The dog says bark");
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    @Override
    public String toString() {
        return ("Dog{name=" + name + ", age=" + age + ", breed=" + breed + "}");
    }
}
