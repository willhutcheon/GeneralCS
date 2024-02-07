package question03;

/**
 *
 * @author willhutcheon
 */
public class Question03 {

    /**
     * allows the user to create arrays of objects and call an insertion sort algorithm on them
     */
    public static void main(String[] args) {
        Integer[] a1 = {10, 5, 56, 67, 4, 59, 13};
        System.out.print("Before: ");
        System.out.println(java.util.Arrays.toString(a1));
        insertionSort(a1);
        System.out.print("After: ");
        System.out.println(java.util.Arrays.toString(a1));
        Circle[] a2 = {new Circle(20), new Circle(3), new Circle(15), new Circle(45), new Circle(20), new Circle(10)};
        System.out.print("Before: ");
        System.out.println(java.util.Arrays.toString(a2));
        insertionSort(a2);
        System.out.print("After: ");
        System.out.println(java.util.Arrays.toString(a2));
    }
    /**
     * this method is a generic insertion sort algorithm, works on any array of objects
     * @param <T> accepts any type of object
     * @param array accepts an array of any type of object
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        // indexing through the array beginning at index 1
        for(int a = 1; a < array.length; a++) {
            // temporarily storing the value in the index position the for loop is at
            T temp = array[a];
            // declaring here because it will be used outside of the scope of the for loop
            int b;
            // starting the loop one index behind the greater for loop, running it until we get to the first array element
            // this loop compares the element in front to the one behind it, if the element in front of the value at the index we are on is greater than that index value, the values are switched
            for(b = a - 1; b >= 0 && temp.compareTo(array[b]) < 0; b--) {
                array[b + 1] = array[b];
            }
            // store the value we were holding in its correct index position
            array[b + 1] = temp;
        }
    }
}