package question01;

/**
 *
 * @author willhutcheon
 */
public class Question01 {

    /**
     * allows the user to create arrays of objects and call a bubble sort algorithm on them
     */
    public static void main(String[] args) {
        Integer[] a1 = {10, 5, 56, 67, 4, 59, 13};
        System.out.print("Before: ");
        System.out.println(java.util.Arrays.toString(a1));
        bubbleSort(a1);
        System.out.print("After: ");
        System.out.println(java.util.Arrays.toString(a1));
        Circle[] a2 = {new Circle(20), new Circle(3), new Circle(15), new Circle(45), new Circle(20), new Circle(10)};
        System.out.print("Before: ");
        System.out.println(java.util.Arrays.toString(a2));
        bubbleSort(a2);
        System.out.print("After: ");
        System.out.println(java.util.Arrays.toString(a2));
    }
    /**
     * this method is a generic bubble sort algorithm, works on any array of objects
     * @param <T> accepts any type of object
     * @param array accepts an array of any type of object
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        // declaring a flag
        boolean swapped = true;
        // finding how long the array is
        int last = array.length;
        // while a swap was performed
        while(swapped) {
            // do this logic
            // we have not swapped yet, flag not thrown
            swapped = false;
            // staring with the second element in the array until the last
            for(int a = 1; a < last; a++) {
                // if the element we are on is of lesser value than the element behind it
                if(array[a].compareTo(array[a - 1]) < 0) {
                    // switch those elements
                    T temp = array[a];
                    array[a] = array[a - 1];
                    array[a - 1] = temp;
                    // throw the flag now that we have performed a swap
                    swapped = true;
                }
            }
            // we can decrement the last variasble as we have one less index that needs to be sorted
            last--;
        }
    }
}

