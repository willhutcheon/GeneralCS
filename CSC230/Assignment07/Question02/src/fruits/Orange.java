package fruits;

/**
 * the Orange class includes(inherits) the characteristic riped, as well as the new characteristic taste for an Orange object
 * @author willhutcheon
 */
public class Orange extends Fruit {
    private String taste;
    /**
     * parameterized constructor for the Orange class
     * @param taste the constructor accepts a taste value when the user creates an Orange object
     * @param riped the constructor accepts a riped value when the user creates an Orange object
     */
    public Orange(String taste, boolean riped) {
        super(riped);
        this.taste = taste;
    }
    /**
     * getter for the taste value of an object, allows the user to retrieve the taste value of an Orange object
     * @return the taste value of an Orange object
     */
    public String getTaste() {
        return taste;
    }
    /**
     * setter for the taste value of an object, allows the user to initialize a taste value to an Orange object
     * @param taste accepts a taste value of an Orange object
     */
    public void setTaste(String taste) {
        this.taste = taste;
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    @Override
    public String toString() {
        return ("Orange{riped=" + riped + ", taste=" + taste + "}");
    }
    /**
     * the hotToEat() function describes how you can eat an orange
     * @return a string description that can be output to the console
     */
    @Override
    public String howToEat() {
        return ("Make sure to peel before you eat!!!");
    }
}
