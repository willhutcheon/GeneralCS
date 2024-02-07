package set;

/**
 * Basic node stored in a linked list. Note that this class is not accessible outside of the package
 *
 * @author chandana
 * @param <T> is the type
 */
class Node<T> {

    T element;
    Node<T> next;

    /**
     * Constructor
     *
     * @param theElement is the element
     */
    public Node(T theElement) {
        this(theElement, null);
    }

    /**
     * Constructor
     *
     * @param theElement is the element
     * @param n is the next node
     */
    public Node(T theElement, Node<T> n) {
        element = theElement;
        next = n;
    }
}