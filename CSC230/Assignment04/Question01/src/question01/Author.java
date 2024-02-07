package question01;

import java.util.Date;

/**
 * declaring a class for the attributes of an author
 * @author willhutcheon
 */
public class Author {
    // declaring characteristics of an author
    private String name;
    private Date dob;
    private String email;
    /**
     * constructor for author class
     * @param name accepts a name value/characteristic
     * @param dob accepts a date of birth value/characteristic
     * @param email accepts an email value/characteristic
     */
    public Author(String name, Date dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
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
     * getter for retrieving date of birth value of an object
     * @return the date of birth value for an object instance
     */
    public Date getDob() {
        return dob;
    }
    /**
     * setter for initializing the date of birth value of an object by instance
     * @param dob accepts input to set the date of birth value of an object
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }
    /**
     * getter for retrieving email value of an object
     * @return the email value for an object instance
     */
    public String getEmail() {
        return email;
    }
    /**
     * setter for initializing the email value of an object by instance
     * @param email accepts input to set the email value of an object
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
