package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author willHutcheon
 * Assignment 4
 *
 * This file produces a digraph from a .txt input and performs various operations on it.
 * @since April 16, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class Digraph {
    private int vertices; // number of vertices
    private List<List<Integer>> adjList; // adjacency list
    private int[] inDegree; // in-degree of each vertex
    /**
     * Constructs a digraph based on a .txt input
     * @param filename the name of the file containing the digraph representation
     * @throws FileNotFoundException exception thrown if the file is not found
     */
    public Digraph(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        adjList = new ArrayList<>(vertices);
        inDegree = new int[vertices];
        for(int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        // read edges and update adjacency list and in-degree array
        for(int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList.get(u).add(v);
            inDegree[v]++;
        }
    }
    /**
     * Performs a topological sort on a digraph by DFS
     * @return the topologically sorted digraph
     */
    public List<Integer> topologicalSort() {
        List<Integer> sorted = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                dfs(i, visited, stack);
            }
        }
        // pop elements from the stack to produce the sorted digraph
        while(!stack.isEmpty()) {
            sorted.add(stack.pop());
        }
        return sorted;
    }
    /**
     * Recursively traverses a digraph using a DFS approach
     * @param u current vertex
     * @param visited keeps track of visited vertices
     * @param stack used to keep track of the order in which vertices have been visited
     */
    private void dfs(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for(int v : adjList.get(u)) {
            if(!visited[v]) {
                dfs(v, visited, stack);
            }
        }
        stack.push(u);
    }
    /**
     * Uses a DFS approach to traverse the digraph and detect cycles
     * @return a bool indicating whether or not the digraph has cycles
     */
    public boolean hasCycleHelper() {
        boolean[] visited = new boolean[vertices];
        boolean[] onStack = new boolean[vertices];
        for(int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                if(hasCycle(i, visited, onStack)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Uses a DFS approach to traverse the digraph and detect cycles
     * @param u current node
     * @param visited keeps track of visited nodes
     * @param onStack keeps track of current node being operated on
     * @return indicates whether or not a cycle was detected in the digraph
     */
    private boolean hasCycle(int u, boolean[] visited, boolean[] onStack) {
        visited[u] = true;
        onStack[u] = true;
        for(int v : adjList.get(u)) {
            if(!visited[v]) {
                if(hasCycle(v, visited, onStack)) {
                    return true;
                }
            } else if(onStack[v]) {
                return true;
            }
        }
        onStack[u] = false;
        return false;
    }
    /**
     * Generates all possible topological sortings of a digraph
     * @return 
     */
    public List<List<Integer>> generateAllSortsHelper() {
        List<List<Integer>> allSorts = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        int[] inDegreeCopy = inDegree.clone();
        generateAllSorts(visited, new ArrayList<>(), allSorts, inDegreeCopy);
        return allSorts;
    }
    /**
     * Generates all possible topological sortings of a digraph
     * @param visited keeps track of visited nodes
     * @param currentSort keeps track of the current topological sorting
     * @param allSorts stores all the generated topological sortings
     * @param inDegreeCopy contains the in-degree for each vertex
     */
    private void generateAllSorts(boolean[] visited, List<Integer> currentSort, List<List<Integer>> allSorts, int[] inDegreeCopy) {
        boolean flag = false;
        for(int i = 0; i < vertices; i++) {
            if(!visited[i] && inDegreeCopy[i] == 0) {
                visited[i] = true;
                currentSort.add(i);
                for(int neighbor : adjList.get(i)) {
                    inDegreeCopy[neighbor]--;
                }
                generateAllSorts(visited, currentSort, allSorts, inDegreeCopy);
                visited[i] = false;
                currentSort.remove(currentSort.size() - 1);
                for(int neighbor : adjList.get(i)) {
                    inDegreeCopy[neighbor]++;
                }
                flag = true;
            }
        }
        if(!flag) {
            allSorts.add(new ArrayList<>(currentSort));
        }
    }
    /**
     * Prints a digraph using an adjacency list representation
     */
    public void printAdjList() {
        for(int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for(int j : adjList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}