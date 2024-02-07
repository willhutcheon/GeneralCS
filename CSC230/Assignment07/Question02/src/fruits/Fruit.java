package fruits;

import common.Edible;

/**
 * the Fruit class includes the characteristic riped for a Fruit object
 * @author willhutcheon
 */
public class Fruit implements Edible {
    protected boolean riped;
    /**
     * parameterized constructor for the Fruit class
     * @param riped the constructor accepts a riped value when the user creates a Fruit object
     */
    public Fruit(boolean riped) {
        this.riped = riped;
    }
    /**
     * getter for the riped value of an object, allows the user to retrieve the riped value of a Fruit object
     * @return the riped value of a Fruit object
     */
    public boolean isRiped() {
        return riped;
    }
    /**
     * setter for the riped value of an object, allows the user to initialize a riped value to a Fruit object
     * @param riped accepts a riped value for a Fruit object
     */
    public void setRiped(boolean riped) {
        this.riped = riped;
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    @Override
    public String toString() {
        return riped + " ";
    }
    /**
     * the hotToEat() function describes how you can eat a fruit
     * @return a string description that can be output to the console
     */
    @Override
    public String howToEat() {
        return ("Most fruits are edible");
    }
}
