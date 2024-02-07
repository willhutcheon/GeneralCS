package fruits;

/**
 * the Apple class includes(inherits) the characteristic riped, as well as the new characteristic color for an Apple object
 * @author willhutcheon
 */
public class Apple extends Fruit {
    private String color;
    /**
     * parameterized constructor for the Apple class
     * @param color the constructor accepts a color value when the user creates an Apple object
     * @param riped the constructor accepts a riped value when the user creates an Apple object
     */
    public Apple(String color, boolean riped) {
        super(riped);
        this.color = color;
    }
    /**
     * getter for the color value of an object, allows the user to retrieve the color value of an Apple object
     * @return the color value of an Apple object
     */
    public String getColor() {
        return color;
    }
    /**
     * setter for the color value of an object, allows the user to initialize a color value to an Apple object
     * @param color accepts a color value of an Apple object
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    @Override
    public String toString() {
        return ("Apple{riped=" + riped + ", color=" + color+ "}");
    }
    /**
     * the hotToEat() function describes how you can eat an apple
     * @return a string description that can be output to the console
     */
    @Override
    public String howToEat() {
        return ("You can eat raw!!");
    }
}
