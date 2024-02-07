package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author willHutcheon
 * Assignment 2
 *
 * This program creates Binary Search Trees and AVLTrees and compares their performances.
 * @since February 12, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class Assignment2 {
    public static void main(String[] args) {
        testBST();
        testAVL();
        runBenchMark();
    }

    /**
     * Creates a BST and prints it out.
     */
    private static void testBST() {
        List<Integer> intList = new ArrayList<>();
        //Generate 20 random integers and insert them into a BST
        intList.addAll(ThreadLocalRandom.current().ints(10, 99)
                .distinct().limit(20).collect(ArrayList::new, ArrayList::add,
                ArrayList::addAll));

        BinarySearchTree<Integer> binST = new BinarySearchTree<>();

        for (int i = 0; i < intList.size(); i++) {
            binST.insert(intList.get(i));
        }

        binST.printSideways("Binary Search Tree");

        System.out.println("\nIs the BST full?: " + binST.isFull());
        System.out.println(
                "Number of leaf nodes in BST: " + binST.countLeafNodes());

    }

    /**
     * Creates an AVL Tree and prints it out while checking for balance.
     */
    private static void testAVL() {
        List<Integer> intList = new ArrayList<>();

        intList.addAll(Arrays.asList(32, 15, 5, 8, 40, 68, 18, 25, 17, 35, 33,
                39, 2, 98, 55, 96, 60));
        AVLTree<Integer> avltree = new AVLTree<>();

        for (int i = 0; i < intList.size(); i++) {
            avltree.insert(intList.get(i));
            //avltree.balance();
            avltree.checkBalance();
        }
        avltree.printSideways("AVL Tree");
        //avltree.balance();
        avltree.checkBalance();
        while (!avltree.isEmpty()) {
            avltree.remove(avltree.getRoot().element);
            avltree.printSideways("Remove root");
            //avltree.balance();
            avltree.checkBalance();
        }
    }

    /**
     * Runs a performance comparison between ordinary Binary Search Trees and
     * AVL trees.
     */
    private static void runBenchMark() {
        long preInsertionBST = 0, postInsertionBST = 0, preInsertionAVL = 0, postInsertionAVL = 0, preSearchBST = 0, postSearchBST = 0, preSearchAVL = 0, postSearchAVL = 0;
        int amountToAdd = 500000, intsToSearchFor =  500000;
        BinarySearchTree<Integer> binST = new BinarySearchTree<>();
        AVLTree<Integer> avltree = new AVLTree<>();
        List<Integer> intList = new ArrayList<>();
        List<Integer> intsToSearchForList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < intsToSearchFor; i++) {
            int x = random.nextInt(100);
            intsToSearchForList.add(x);
        }
        preInsertionAVL = System.currentTimeMillis();
        for(int i = 0; i < amountToAdd; i++) {
            int x = random.nextInt(100);
            intList.add(x);
            avltree.insert(x);
        }
        postInsertionAVL = System.currentTimeMillis();
        preInsertionBST = System.currentTimeMillis();
        for(int i = 0; i < amountToAdd; i++) {
            binST.insert(intList.get(i));
        }
        postInsertionBST = System.currentTimeMillis();
        preSearchBST = System.currentTimeMillis();
        for(int i = 0; i < intsToSearchFor; i++) {
            binST.contains(intsToSearchForList.get(i));
        }
        postSearchBST = System.currentTimeMillis();
        preSearchAVL = System.currentTimeMillis();
        System.out.println();
        for(int i = 0; i < intsToSearchFor; i++) {
            avltree.contains(intsToSearchForList.get(i));
        }
        postSearchAVL = System.currentTimeMillis();        
        //System.out.println("The values that will be inserted into the trees: " + intList);
        //System.out.println("The values that will be searched for in the trees: " + intsToSearchForList);
        //binST.printSideways("Binary Search Tree");
        System.out.println("The time (in millis) it took to insert " + amountToAdd + " values into the BST was: " + (postInsertionBST - preInsertionBST));
        System.out.println("The time (in millis) it took to search for " + intsToSearchFor + " values in a BST that had " + amountToAdd + " elements was: " + (postSearchBST - preSearchBST));
        //avltree.printSideways("AVL Tree");
        System.out.println("The time (in millis) it took to insert " + amountToAdd + " values into the AVL was: " + (postInsertionAVL - preInsertionAVL));
        System.out.println("The time (in millis) it took to search for " + intsToSearchFor + " values in an AVL that had " + amountToAdd + " elements was: " + (postSearchAVL - preSearchAVL));
    }

}
