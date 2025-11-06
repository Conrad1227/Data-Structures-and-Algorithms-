
/**
 * Tree interface that has methods for Binary and AVL trees
 *
 * @author Conrad Hahn
 * @version 4/21/2025
 */
public interface Tree<E>
{
    /**
     * Inserts value into tree
     *
     * @param  e value being added
     */
    boolean insert(E e);
    /**
     * checks if tree contains value
     *
     * @param  e value being checked for
     */
    boolean contains(E e);
    /**
     * turns the tree into a string in pre-order format
     * 
     * @return preorder string representation of tree
     */
    String preOrderString();
    /**
     * turns the tree into a string in post-order format
     * 
     * @return post-order string representation of tree
     */
    String postOrderString();
    /**
     * turns the tree into a string in in-order format
     * 
     * @return in-order string representation of tree
     */
    String inOrderString();
    /**
     * empties the tree
     *
     */
    void empty();
    /**
     * checks if the tree is empty
     * 
     * @return true if the tree is empty, false if it is not
     */
    boolean isEmpty();
}
