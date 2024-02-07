package question01;

/**
 *
 * @author willhutcheon
 */

/**
 * 
 * @author willh
 * creating a class for a cat who's characteristics will be used as a template for cat objects
 */

// creating a cat class
public class Cat {
    // declaring variables
    private Color color;
    private String name;
    private String dob;
    private boolean status;
    private int distanceFromHome;
    
    // cat class constructor
    /**
     * 
     * @param name stores the name of a cat object
     * @param dob stores the date of birth of a cat object
     * @param color stores the color of a cat object
     * @param status stores the sleeping status of a cat object, false indicates not sleeping, true indicates sleeping 
     * @param distanceFromHome stores the distance from home of a cat object
     */
    Cat(String name, String dob, Color color, boolean status, int distanceFromHome) {
        // error checking for a negative distance input, throws an error if input is negative
        if(distanceFromHome < 0) {
            throw new IllegalArgumentException("The distance must be greater than or equal to 0");
        }
    }
    
    // getter for getting the name value of each object created
    /**
     * 
     * @return name value
     */
    public String getName() {
        return name;
    }
    // setter for initializing the name value of each object created
    /**
     * 
     * @param name accepts the user input for the name value
     */
    public void setName(String name) {
        this.name = name;
    }
    // getter for getting the date of birth value of each object created
    /**
     * 
     * @return date of birth value
     */
    public String getDob() {
        return dob;
    }
    // setter for initializing the date of birth of each object created
    /**
     * 
     * @param dob accepts the user input for the date of birth
     */
    public void setDob(String dob) {
        this.dob = dob;
    }
    // getter for getting the sleeping status of each object created
    // false indicates not sleeping, true indicates sleeping
    /**
     * 
     * @return sleeping status of cat
     */
    public boolean getStatus() {
        return status;
    }
    // setter for initializing the sleeping status of each object created
    /**
     * 
     * @param status accepts the user input for the sleeping status of the cat
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    // getter for getting the distance from home of each object created
    /**
     * 
     * @return the distance from home value
     */
    public int getDistanceFromHome() {
        return distanceFromHome;
    }
    // setter for initializing the distance from home of each object created
    /**
     * 
     * @param distanceFromHome accepts the user input for the cats distance from home
     */
    public void setDistanceFromHome(int distanceFromHome) {
        // error checking for a negative distance input, throws an error if input is negative
        if(distanceFromHome < 0) {
            throw new IllegalArgumentException("The distance must be greater than or equal to 0");
        }
        this.distanceFromHome = distanceFromHome;
    }
    // getter for getting the color of each object created
    /**
     * 
     * @return the color value
     */
    public Color getColor() {
        return color;
    }
    // setter for initializing the color of each object created
    /**
     * 
     * @param color accepts the user input for the color of the cat
     */
    public void setColor(Color color) {
        this.color = color;
    }
}