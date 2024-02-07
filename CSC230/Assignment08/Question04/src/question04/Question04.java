package question04;

/**
 *
 * @author willhutcheon
 */
public class Question04 {

    /**
     * allows the user to create arrays of objects and call a quick sort algorithm on them
     */
    public static void main(String[] args) {
        Integer[] a1 = {10, 5, 56, 67, 4, 59, 13};
        int low = 0;
        // because the size of the array is a parameter to the methods, make sure to update your size if you create a new array with a different length here
        int high = a1.length - 1;
        System.out.print("Before: ");
        System.out.println(java.util.Arrays.toString(a1));
        quickSort(a1, low, high);
        System.out.print("After: ");
        System.out.println(java.util.Arrays.toString(a1));
        Circle[] a2 = {new Circle(20), new Circle(3), new Circle(15), new Circle(45), new Circle(20), new Circle(10)};
        // because the size of the array is a parameter to the methods, make sure to update your size if you create a new array with a different length here
        high = a2.length - 1;
        System.out.print("Before: ");
        System.out.println(java.util.Arrays.toString(a2));
        quickSort(a2, low, high);
        System.out.print("After: ");
        System.out.println(java.util.Arrays.toString(a2));
    }
    /**
     * this function contains the logic for the partitioning step of the quick sort algorithm
     * @param <T> accepts any type of object
     * @param array accepts an array of any type of object
     * @param low accepts a variable which indicates the lowest index value of the array
     * @param high accepts a variable which indicates the highest index value of the array
     * @return 
     */
    public static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        //final int rand = (int) (Math.random() * (array.length));
        //T pivot = array[rand];
        
        // choosing a pivot point
        T pivot = array[high];
        int a = low - 1;
        // indexing through the array
        for(int b = low; b <= high - 1; b++) {
            // comparing the elements
            if(array[b].compareTo(pivot) < 0) {
                // make sure we are at the correct index
                a++;
                // change the elements
                swap(array, a, b);
            }
        }
        // if the elements were in the correct order we can proceed to the next index we need to look at 
        swap(array, a + 1, high);
        // make sure we are at the correct index
        return a + 1;
    }
    /**
     * this function contains the logic for the quick sort algorithm
     * @param <T> accepts any type of object
     * @param array accepts an array of any type of object
     * @param low accepts a variable which indicates the lowest index value of the array
     * @param high accepts a variable which indicates the highest index value of the array
     */
    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        // if we have not indexed through the entire array
        if(low < high) {
            // do this logic
            // storing the index we are at
            int part = partition(array, low, high);
            // calling quicksort
            // closing the left side partition
            quickSort(array, low, part - 1);
            // closing the right side partition
            quickSort(array, part + 1, high);
        }
    }
    /**
     * this function performs the logic necessary for the swapping of positions of two elements in an array
     * @param <T> accepts any type of object
     * @param array accepts an array of any type of object
     * @param a the position of the "first" element we will be comparing, this position is one index element before the index of b
     * @param b the position of the "second" element we will be comparing, this position is one index element after the index of a
     */
    public static <T extends Comparable<T>> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
