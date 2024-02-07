package assignment2;

/**
 * @author willHutcheon
 * Assignment 2
 *
 * This file implements a self-balancing AVL Tree.
 * @since February 12, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 * @param <AnyType>
 */
public class AVLTree<AnyType extends Comparable<? super AnyType>> extends BinarySearchTree<AnyType> {

    public AVLTree() {
        super();
        this.BALANCE_FACTOR = 1;
    }

    private final int BALANCE_FACTOR;
    
    public void balance() {
        balance(root);
    }

    /**
     * This function includes the logic used to balance a BST
     * @param root The root of the BST
     * @return The balanced tree.
     */
    private BinaryNode<AnyType> balance(BinaryNode<AnyType> root) {
        if (root == null) {
            return root;
        }
        /*
        INSERT YOUR CODE FOR CHECKING FOR THE FOUR CASES OF IMBALANCE HERE.
        INCLUDE CALLS TO THE FOUR ROTATING METHODS PROVIDED BELOW.
         */
        
        else {
            if(height(root.left) > height(root.right) + 1) {
                if(height(root.left.left) >= height(root.left.right)) {
                    return rotateRightWithLeftChild(root);
                }
                else {
                    return doubleLeftRight(root); 
                }
            }
            else if(height(root.left) + 1 < height(root.right)) {
                if(height(root.right.left) <= height(root.right.right)) {
                    return rotateLeftWithRightChild(root);
                }
                else {
                    return doubleRightLeft(root);
                }
            }
        }
        
        return root;
    }

    /**
     * Rotate binary tree node with left child. For AVL trees, this is a single
     * rotation for case 1.
     */
    private BinaryNode<AnyType> rotateRightWithLeftChild(BinaryNode<AnyType> k2) {
        BinaryNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        return k1;
    }

    /**
     * Rotate binary tree node with right child. For AVL trees, this is a single
     * rotation for case 4.
     */
    private BinaryNode<AnyType> rotateLeftWithRightChild(BinaryNode<AnyType> k1) {

        BinaryNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        return k2;
    }

    /**
     * Double rotate binary tree node: first left child with its right child;
     * then node k3 with new left child. For AVL trees, this is a double
     * rotation for case 2.
     */
    private BinaryNode<AnyType> doubleLeftRight(BinaryNode<AnyType> k3) {

        k3.left = rotateLeftWithRightChild(k3.left);

        return rotateRightWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child with its left child;
     * then node k1 with new right child. For AVL trees, this is a double
     * rotation for case 3.
     */
    private BinaryNode<AnyType> doubleRightLeft(BinaryNode<AnyType> k1) {

        k1.right = rotateRightWithLeftChild(k1.right);

        return rotateLeftWithRightChild(k1);
    }

    /**
     * Insert into the tree; duplicates are ignored.
     *
     * @param x the item to insert.
     */
    @Override
    public void insert(AnyType x) {
        root = insert(x, root);
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param root the node that roots the subtree.
     * @return the new root of the subtree.
     */
    @Override
    protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> root) {
        return balance(super.insert(x, root));
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     *
     * @param x the item to remove.
     */
    @Override
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
    @Override
    protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> root) {

        return balance(super.remove(x, root));
    }
    
    public void checkBalance() {
        checkBalance(root);
    }
    
    /**
     * Test for checking if an AVL is balanced
     * @param root the root of the AVL
     * @return whether or not the AVL is balanced
     */
    private int checkBalance(BinaryNode<AnyType> root) {
        if (root == null) {
            return -1;
        } else {
            int heightLeft = checkBalance(root.left);
            int heightRight = checkBalance(root.right);
            if (Math.abs(height(root.left) - height(root.right)) > BALANCE_FACTOR
                    || height(root.left) != heightLeft || height(root.right) != heightRight) {
                System.out.println("!!!!!!UNBALANCED TREE!!!!!!");
            }
        }

        return height(root);
    }

}
