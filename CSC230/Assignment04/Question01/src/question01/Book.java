package question01;

/**
 * declaring a class for the attributes of a book
 * @author willhutcheon
 */
public class Book {
    // declaring characteristics of a book
    private String name;
    private Author author;
    private double price;
    private int qtyInStock;
    /**
     * book constructor
     * @param name accepts a name value/characteristic
     * @param author accepts an author value/characteristic
     * @param price accepts a price value/characteristic
     * @param qtyInStock accepts a quantity in stock value/characteristic
     */
    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }
    /**
     * getter for retrieving name value of an object
     * @return the name value for an object instance
     */
    public String getName() {
        return name;
    }
    /**
     * setter for initializing the name value of an object by instance
     * @param name accepts input to set the name value of an object
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter for retrieving author value of an object
     * @return the author value for an object instance
     */
    public Author getAuthor() {
        return author;
    }
    /**
     * setter for initializing the author value of an object by instance
     * @param author accepts input to set the author value of an object
     */
    public void setAuthor(Author author) {
        this.author = author;
    }
    /**
     * getter for retrieving price value of an object
     * @return the price value for an object instance
     */
    public double getPrice() {
        return price;
    }
    /**
     * setter for initializing the price value of an object by instance
     * @param price accepts input to set the price value of an object
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * getter for retrieving value of the quantity in stock of a book for an instance of an object
     * @return the qtyInStock value for an object instance
     */
    public int getQtyInStock() {
        return qtyInStock;
    }
    /**
     * setter for initializing the quantity in stock of a book for an instance of an object
     * @param qtyInStock accepts input to set the qtyInStock value of an object
     */
    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }
}