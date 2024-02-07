package question01;

/**
 *
 * @author willhutcheon
 * Question01
 */
public class Question01 {

    /**
     * 
     * @param args
     * The main method is used to call test cases for the area of a circle
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println(circleArea(3.0, 1000000000));
    }
    
    /**
     * Calculates the area of a circle by calculating the area of a quadrant and then multiplying that number by 4
     * @param r User input radius value
     * @param numOfRectangles Number of rectangles that will divide the circle quadrant
     * @return The area of the circle, value will always be positive
     */
    public static double circleArea(double r, int numOfRectangles) {
        // error checking user input
        // if the users input is a value less than 0 an exception will be thrown
        if (r < 0) {
            throw new IllegalArgumentException("Your input must be a value greater than or equal to 0");
        }
        
        // calculating the width of each rectangle
        double dx = (double)r / (double)numOfRectangles;
        double area = 0;
        for (int i = 0; i < numOfRectangles; i++) {
            double x = i * dx;
            // finding the height of a rectangle
            double y = Math.sqrt(r * r - x * x);
            // calculating the area of a quadrant by calculating the area of the rectangle (l * w) and then accumulating the sum
            // of the areas of all of the rectangles in the quadrant
            area = area + dx * y;
        }
        // total of all the quadrants of the circle
        return area * 4;
    }
}
