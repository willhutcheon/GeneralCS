package question01;

import java.util.Scanner;

/**
 *
 * @author willhutcheon
 */
public class Question01 {

    /**
     * allows a user to output the string arrays they have just input
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[] output = getStrings();
        for(int a = 0; a < output.length; a++) {
            System.out.println(output[a]);
        }
    }
    
    /**
     * this function resizes the array based on feedback from the getStrings() function
     * @param array accepts the array of string entries that has been created based on user input
     * @param trueArraySize this parameter lets the resize function know how long to resize the array
     * @return the updated array, populated and with correct length
     */
    public static String[] resize(String[] array, int trueArraySize) {
        // making a new array with the correct size
        String[] updateArray = new String[trueArraySize];
        for(int a = 0; a < array.length; a++) {
            // populating the new array with previous entries
            updateArray[a] = array[a];
        }
        return updateArray;
    }
    
    /**
     * creates an array of strings from user input
     * @return a value that indicates to the resize() function how long to make the newly sized array
     */
    public static String[] getStrings() {
        // allocating space to store the user input
        String input;
        // creating an array to hold user inputs
        String array[] = new String[2];
        // keeping track of the number of inputs
        int strings = 0;
        // flag to stop user inputs
        boolean go = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an unlimited number of strings seperated by the carriage return. Input an empty string to stop");
        while(go) {
            input = scanner.nextLine();
            // if the user inputs an empty string, terminate / exit input loop
            if(input.length() == 0) {
                go = false;
            }
            // if the array is full double its size
            // the reason for this is we do not want to spend much resources constantly resizing, but we also do not
            // want to expend memory by making the array too large
            if(strings == array.length) {
                array = resize(array, strings * 2);
            }
            // populating the array with the console inputs
            array[strings++] = input;
        }
        // creating a new array with the correct size
        String[] trueArraySize = new String[strings];
        // adding the previous entries to the array
        for(int a = 0; a < strings; a ++) {
            trueArraySize[a] = array[a];
        }
        return trueArraySize;
    }
    
}
