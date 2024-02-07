package question01;

/**
 *
 * @author willhutcheon
 * Question 01
 */

public class Question01 {

    /**
     * @param args the command line arguments
     * the main method allows users to create cat objects
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //creating a new cat object
        Cat cat =  new Cat("Tom","01012022", Color.WHITE_BLACK, false, 7);
        
        // setting values
        cat.setName("Tom");
        cat.setDob("01012022");
        cat.setColor(Color.WHITE_BLACK);
        cat.setStatus(false);
        // checking if cat is sleeping, if cat is not sleeping then it can move
        if(cat.getStatus() == false) {
            cat.setDistanceFromHome(7);
        }
        //cat.setDistanceFromHome(7);
        System.out.println(cat.getName());
        System.out.println(cat.getDob());
        System.out.println(cat.getColor());
        System.out.println(cat.getStatus());
        System.out.println(cat.getDistanceFromHome());
    }
    
}