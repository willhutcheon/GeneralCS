package question02;

/**
 * this class defines the characteristics of a Circle object and implements the comparable interface to compare Circle objects
 * @author willhutcheon
 */
public class Circle implements Comparable<Circle> {
    // the only property this circle has is a radius
    int radius;
    /**
     * constructor for the Circle class
     * @param newRadius accepts a radius value
     */
    public Circle(int radius) {
        this.radius = radius;
        if(radius < 0) {
            throw new IllegalArgumentException("A circle cannot have a negative radius");
        }
    }
    /**
     * getter for the radius value, allows for the retrieval of a radius input from a user
     * @return the radius value
     */
    public int getRadius() {
        return radius;
    }
    /**
     * setter for the radius value, allows for the initialization of a radius value
     * @param radius accepts an input for the radius value
     */
    public void setRadius(int radius) {
        this.radius = radius;
        if(radius < 0) {
            throw new IllegalArgumentException("A circle cannot have a negative radius");
        }
    }
    /**
     * this function overrides the default compareTo() method to compare the radii of two Circle objects
     * @param o accepts a Circle object
     * @return the result of a comparison (by subtraction) of one circle objects radius to another
     */
    @Override
    public int compareTo(Circle o) {
        return radius - o.radius;
    }
    /**
     * this function overrides the toString() method for a custom formatted output
     * @return the formatted string output
     */
    @Override
    public String toString() {
        return "Circle " + radius;
    }
}