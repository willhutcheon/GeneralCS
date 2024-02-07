package assignment4;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author willHutcheon
 * Assignment 4
 *
 * This program creates a digraph and performs a topological sorting on it, as well as provides all possible topological sortings of a
 * digraph input. The program also checks whether the digraph input is acyclic or not. An adjacency list representation of the digraph is displayed.
 * @since April 16, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class Assignment4 {
    public static void main(String[] args) {
        try {
            Digraph digraph = new Digraph("tinydigraph.txt");
            if(!digraph.hasCycleHelper()) {
                List<Integer> sorted = digraph.topologicalSort();
                System.out.print("Topological sort: ");
                System.out.println(sorted);   
                System.out.print("All possible topological sorts: ");
                System.out.println(digraph.generateAllSortsHelper());
                System.out.println("Adjacency list representation");
                digraph.printAdjList();
                System.out.print("Cyclic digraph?: ");
                System.out.println(digraph.hasCycleHelper());
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
