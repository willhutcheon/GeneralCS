package common;

/**
 * in this interface, we can group methods who's base behavior can be shared between multiple classes
 * @author willhutcheon
 */
public interface Edible {
    // this function will be shared among multiple classes as multiple classes can be described by conveying how to eat the object they create
    public String howToEat();
}
