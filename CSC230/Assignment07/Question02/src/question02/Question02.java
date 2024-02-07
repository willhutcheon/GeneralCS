package question02;

import animals.Dog;
import animals.Chicken;
import fruits.Orange;
import fruits.Apple;

/**
 * a user can access main() from the Question02 class
 * @author willhutcheon
 */
public class Question02 {

    /**
     * a user can create and initialize objects within the main() function
     */
    public static void main(String[] args) {
        // creating and initializing some objects from the classes within the package
        Dog lily = new Dog("Shih Tzu", "Lily", 3);
        System.out.println(lily.toString());
        System.out.println("The dogs name: " + lily.getName());
        System.out.println("The dogs age: " + lily.getAge());
        System.out.println();
        Chicken chicken = new Chicken(2.0, "No Name", 4);
        System.out.println(chicken.toString());
        System.out.println("The chickens name: " + chicken.getName());
        System.out.println("The chickens age: " + chicken.getAge());
        System.out.println("How to eat it? " + chicken.howToEat());
        System.out.println();
        Orange orange = new Orange("Sweet", true);
        System.out.println(orange.toString());
        System.out.println("The taste of the orange: " + orange.getTaste());
        System.out.println("How to eat it? " + orange.howToEat());
        System.out.println();
        Apple apple = new Apple("red", true);
        System.out.println(apple.toString());
        System.out.println("The color of the apple: " + apple.getColor());
        System.out.println("How to eat? " + apple.howToEat());
    }
    
}
