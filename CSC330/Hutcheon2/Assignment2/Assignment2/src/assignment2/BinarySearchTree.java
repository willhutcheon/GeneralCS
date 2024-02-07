package assignment2;

/**
 * @author willHutcheon
 * Assignment 2
 *
 * This file implements a Binary Search Tree.
 * @since February 12, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 * @param <AnyType>
 */

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    protected BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     *
     * @param x the item to insert.
     * @param root the root of the BST
     * @return a node
     */
    protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> root) {
        /**
         * WRITE YOUR CODE HERE
         */
        if(root == null) {
            return new BinaryNode<>(x, null, null);
        }
        int compareResult = x.compareTo(root.element);
        if(compareResult < 0) {
            root.left = insert(x, root.left);
        }
        else if(compareResult > 0) {
            root.right = insert(x, root.right);
        }
        else {
            
        }

        return root;
    }

    /**
     * Counts the number of leaf nodes in this tree.
     *
     * @param t The root of the tree.
     * @return the amount of leaves on the tree
     */
    private int countLeafNodes(BinaryNode<AnyType> root) {
        /*
        WRITE YOUR CODE HERE
         */
        
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        else {
            return countLeafNodes(root.left) + countLeafNodes(root.right);
        }
    }

    /**
     * Checks if the tree is a full tree.
     *
     * @param t The root of the tree.
     * @return true or false indicating whether or not the tree is full
     */
    private boolean isFull(BinaryNode<AnyType> root) {
        /* 
        WRITE YOUR CODE HERE
         */
        
        if(root == null) {
            return true;
        }
        else if(root.left != null && root.right != null) {
            return(isFull(root.left) && isFull(root.right));
        }
        else return !(root.left != null || root.right != null);
    }

    /**
     * Inserts values into the BST
     * @param x value to be inserted
     */
    public void insert(AnyType x) {
        root = insert(x, root);
    }

    /**
     * Counts the number of leaf nodes in a tree.
     *
     * @return the number of leaf nodes in the BST
     */
    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    /**
     * Checks if the tree is full.
     *
     * @return whether or not the BST is full
     */
    public boolean isFull() {
        return isFull(root);
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     *
     * @param x the item to remove.
     */
    public void remove(AnyType x) {
        root = remove(x, root);
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param root the node that roots the subtree.
     * @return the new root of the subtree.
     */
    protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> root) {
        // If item not found, do nothing.
        if (root == null) {
            return root;
        }

        int compareResult = x.compareTo(root.element);

        if (compareResult < 0) {
            root.left = remove(x, root.left);
        } else if (compareResult > 0) {
            root.right = remove(x, root.right);
        } // Two children.
        else if (root.left != null && root.right != null) {
            root.element = findMin(root.right).element;
            root.right = remove(root.element, root.right);
        } // Zero or one child.
        else {
            root = (root.left != null) ? root.left : root.right;
        }

        return root;
    }

    /**
     * Find an item in the tree.
     *
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    /**
     * Checks whether a value is found within a BST or AVL
     * @param x the value to be searched for
     * @param root the root
     * @return whether or not the value was found within the tree
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> root) {
        if (root == null) {
            return false;
        }

        int compareResult = x.compareTo(root.element);

        if (compareResult < 0) {
            return contains(x, root.left);
        } else if (compareResult > 0) {
            return contains(x, root.right);
        } else {
            return true; // Match with current node
        }
    }

    /**
     * Find the smallest item in the tree.
     *
     * @return smallest item or null if empty.
     * @throws Exception
     */
    public AnyType findMin() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return findMin(root).element;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> root) {
        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root; // found the leftmost node
        } else {
            return findMin(root.left);
        }
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Calculate the height of the tree.
     *
     * @return the height.
     */
    public int height() {

        return height(this.root);

    }

    /**
     * Internal method to compute height of a subtree.
     *
     * @param root the node that roots the subtree.
     * @return
     */
    protected int height(BinaryNode<AnyType> root) {
        return root == null ? -1
                : 1 + Math.max(height(root.left), height(root.right));
    }

    public BinaryNode<AnyType> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<AnyType> root) {
        this.root = root;
    }

    public void printSideways(String label) {

        System.out.println(
                "\n-------------------------------" + label + "----------------------------");
        printSideways(root, "");
    }

    /**
     * Prints the tree
     * @param root the root
     * @param indent a formatting value
     */
    private void printSideways(BinaryNode root,
            String indent) {
        if (root != null) {
            printSideways(root.right, indent + "          ");
            System.out.println(indent + root.element);
            printSideways(root.left, indent + "          ");
        }

    }
}
