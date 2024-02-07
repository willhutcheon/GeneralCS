package assignment2;

/**
 * @author willHutcheon
 * Assignment 2
 *
 * This file implements a Binary Tree node.
 * @since February 12, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 * @param <AnyType>
 */
public class BinaryNode<AnyType> {

    AnyType element;           // data in the node
    BinaryNode<AnyType> left;  // left child
    BinaryNode<AnyType> right; // right child

    BinaryNode(AnyType theElement) {
        this(theElement, null, null);
    }

    BinaryNode(AnyType theElement, BinaryNode<AnyType> lt,
            BinaryNode<AnyType> rt) {
        element = theElement;
        left = lt;
        right = rt;
    }

    public AnyType getElement() {
        return element;
    }

    public void setElement(AnyType element) {
        this.element = element;
    }

    public BinaryNode<AnyType> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<AnyType> left) {
        this.left = left;
    }

    public BinaryNode<AnyType> getRight() {
        return right;
    }

    public void setRight(BinaryNode<AnyType> right) {
        this.right = right;
    }

}
