package animals;

import common.Edible;

/**
 * the Chicken class includes(inherits) the characteristics name, age, and the new characteristic weight for a Chicken object
 * @author willhutcheon
 */
public class Chicken extends Animal implements Edible {
    private double weight;
    /**
     * parameterized constructor for the Chicken class
     * @param name the constructor accepts a name value when the user creates a Chicken object
     * @param age the constructor accepts an age value when the user creates a Chicken object
     * @param weight the constructor accepts a weight value when the user creates a Chicken object
     */
    public Chicken(double weight, String name, int age) {
        super(name, age);
        this.weight = weight;
        // catching invalid user inputs
        if(weight <= 0) {
            throw new IllegalArgumentException("A chicken has to weigh something");
        }
    }
    /**
     * getter for the weight value of an object, allows the user to retrieve the weight value of a Chicken object
     * @return the weight value of a Chicken object
     */
    public double getWeight() {
        return weight;
    }
    /**
     * setter for the weight value of an object, allows the user to initialize a weight value to a Chicken object
     * @param weight accepts a weight value of a Chicken object
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    /**
     * formatting the output and returning it in a string format
     * @return the formatted output
     */
    @Override
    public String toString() {
        return ("Chicken{name=" + name + ", age=" + age + ", weight=" + weight + "}");
    }
    /**
     * the hotToEat() function describes how you can eat a chicken
     * @return a string description that can be output to the console
     */
    @Override
    public String howToEat() {
        return ("Fried or curry :-)!!!");
    }
}
