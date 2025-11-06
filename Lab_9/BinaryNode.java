
/**
 * Node objects for binary trees
 *
 * @author Conrad Hahn
 * @version 4/22/2025
 */
public class BinaryNode<E extends Comparable>
{
    BinaryNode left;
    BinaryNode right;
    E val;

    /**
     * Constructor for nodes that have certain values
     */
    public BinaryNode(E val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    
    /**
     * gets value of node
     
     * @return value of node
     */
    public E getVal()
    {
        return val;        
    }

    /**
     * sets value of node 
     * 
     * @param  val value being set for node
     * 
     */
    public void setVal(E val)
    {
        this.val = val;        
    }

    /**
     * sets right child of the node
     * 
     * @param right node being set as the right child
     * 
     */
    public void setRight(BinaryNode<E> right)
    {
        this.right = right;     
    }

    /**
     * sets left child of the node
     * 
     * @param left node being set as the left child
     * 
     */
    public void setLeft(BinaryNode<E> left)
    {
        this.left = left;        
    }

    /**
     * gets left child of the node
     * 
     * @return the left child of the node
     */
    public BinaryNode getLeft()
    {
        return left;     
    }

    /**
     * gets right child of the node
     * 
     * @return the right child of the node
     * 
     */
    public BinaryNode getRight()
    {
        return right;    
    }
}
