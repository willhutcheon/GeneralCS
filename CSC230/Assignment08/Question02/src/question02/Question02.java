package question02;

/**
 *
 * @author willhutcheon
 */
public class Question02 {

    /**
     * allows the user to create arrays of objects and call a selection sort algorithm on them
     */
    public static void main(String[] args) {
        Integer[] a1 = {10, 5, 56, 67, 4, 59, 13};
        System.out.print("Before: ");
        System.out.println(java.util.Arrays.toString(a1));
        selectionSort(a1);
        System.out.print("After: ");
        System.out.println(java.util.Arrays.toString(a1));
        Circle[] a2 = {new Circle(20), new Circle(3), new Circle(15), new Circle(45), new Circle(20), new Circle(10)};
        System.out.print("Before: ");
        System.out.println(java.util.Arrays.toString(a2));
        selectionSort(a2);
        System.out.print("After: ");
        System.out.println(java.util.Arrays.toString(a2));
    }
    /**
     * this method is a generic selection sort algorithm, works on any array of objects
     * @param <T> accepts any type of object
     * @param array accepts an array of any type of object
     */
    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        // setting a marker to a value equivalent to the length of the array
        int marker = array.length - 1;
        // while we have not reached an index beyond the beginning of the array
        while(marker > 0) {
            // do this logic
            // initilize a variable to hold the index value we are on
            int index = 1;
            // indexing through the array
            for(int i = 0; i < marker + 1; i++) {
                // if the value of the index the loop is at is a greater value than the one after it
                if(array[i].compareTo(array[index]) > 0) {
                    // record which index the lesser value was at
                    index = i;
                }
            }
            // swap the positions of these values based on that
            T temp = array[index];
            array[index] = array[marker];
            array[marker] = temp;
            // make the range(length of the array) we have to search through one less, as the sequencing is now
            // correct at that index so we no longer have to worry about it
            marker--;
        }
    }
}