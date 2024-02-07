package question01;

import java.util.Date;

/**
 *
 * @author willhutcheon
 */
public class Question01 {

    /**
     * @param args the command line arguments
     * the main method allow the user to create author and book objects
     */
    public static void main(String[] args) {
        // creating an author object
        Author sipser = new Author("Michael Siper", new Date("10/14/1964"), "sipser@gmail.com");
        // creating book objects
        Book itc = new Book("Introduction to the Theory of Computation", sipser, 112.50, 23);
        Book foc = new Book("Fundamental of Computer Science", sipser, 117.49, 14);
        
        // invoking getters on the itc object
        System.out.println(itc.getName());
        System.out.println(itc.getAuthor().getName());
        System.out.println(itc.getAuthor().getDob());
        System.out.println(itc.getAuthor().getEmail());
        System.out.println(itc.getPrice());
        System.out.println(itc.getQtyInStock());
        System.out.println();
        
        // invoking getters on the foc object
        System.out.println(foc.getName());
        System.out.println(foc.getAuthor().getName());
        System.out.println(foc.getAuthor().getDob());
        System.out.println(foc.getAuthor().getEmail());
        System.out.println(foc.getPrice());
        System.out.println(foc.getQtyInStock());
        System.out.println();
        
        // invoking setters on the book objects to init. the values for these objects
        itc.setQtyInStock(100);
        foc.setQtyInStock(45);
        // outputting the newly init values of the stock of the book objects
        System.out.println(itc.getQtyInStock());
        System.out.println(foc.getQtyInStock());
    }
    
}
