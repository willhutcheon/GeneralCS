package set;

//import set.LinkedList;

// this class was modified by Will Hutcheon

public class IntSetTest {

    public static void main(String[] args) {
        // creating a new linked list object from the class
        LinkedList intList = new LinkedList();
        // creating a new linked list iterator from the class
        LinkedListIterator intIterator = intList.zeroth();
        
        // here i am using the insert() method to populate the linked list
        // i also pass the iterator as a parameter because the insert() method needs to know the status of it (where it is)
        // whether it needs to be incremented or not
        // i also provide duplicate values to show that they will not be allowed to be inserted into the list
        try {
            intList.insert(1, intIterator);
            intList.insert(1, intIterator);
            intList.insert(18, intIterator);
            intList.insert(77, intIterator);
            intList.insert(23, intIterator);
            intList.insert(39, intIterator);
        } catch (SetException e) {
            System.out.println(e.toString());
        }

        // here i am demonstrating the enhanced for loop to output the contents of the linked list
        // after list is filled you know datatype
        // but to avoid any issues i will just make this loop accept any type of object
        for(Object i : intList) {
            System.out.print(i + " ");
        }
        System.out.println();

        // creating a new linked list object from the class
        LinkedList objectList = new LinkedList();
        // creating a new linked list iterator from the class
        LinkedListIterator objectIterator = objectList.zeroth();
                
        // here i give an example of the generic nature of the program by giving it some type of object, it can be any comparable object
        // i also provide duplicate values to show that they will not be allowed to be inserted into the list
        try {
            objectList.insert(new Circle(2), objectIterator);
            objectList.insert(new Circle(5), objectIterator);
            objectList.insert(new Circle(5), objectIterator);
            objectList.insert(new Circle(24), objectIterator);
            objectList.insert(new Circle(5), objectIterator);
            objectList.insert(new Circle(90), objectIterator);
        } catch (SetException e) {
            System.out.println(e.toString());
        }
        
        // here i am demonstrating the enhanced for loop to output the contents of the linked list
        // after list is filled you know datatype
        // but to avoid any issues i will just make this loop accept any type of object
        for(Object j : objectList) {
            System.out.print(j + " ");
        }
        System.out.println();

        
        
        // here i am demonstrating how to make the list empty by using the makeEmpty() method on the linked list
        objectList.makeEmpty();
        // now the list is empty and i will show that here by outputting the contents using the enhanced for loop
        System.out.print("The empty list: ");
        for(Object j : objectList) {
            System.out.print(j + " ");
        }
        // here i am demonstrating the use of the remove() method to remove an item from a list
        System.out.println();
        System.out.print("The list after elements of value 1 are removed: ");
        intList.remove(1);
        // now the item is removed and i will show that here by outputting the contents using the enhanced for loop
        for(Object i : intList) {
            System.out.print(i + " ");
        }
        System.out.println();
 
        // here i am demonstrating the method to check if the list is empty using the isEmpty() method
        System.out.println("The list is empty: " + intList.isEmpty());
        // here i am demonstrating the method to check the size of the list using the getSize() method
        System.out.println("The size of the list is currently: " + intList.getSize());        
    }
}