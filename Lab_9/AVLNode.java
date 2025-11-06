
/**
 * AVLNode objects to be used in AVLTree
 *
 * @author Conrad Hahn
 * @version 4/21/2025
 */
public class AVLNode<E extends Comparable> extends BinaryNode
{
    AVLNode parent;
    int height;
    /**
     * basic constructor designed to define a root node for AVLTree. Parent value is null and height is initially set to 0
     * @param val E type object to be designated as node value
     */
    public AVLNode(E val){
        super(val);
        height=0;
        super.left=left;
        super.right=right;
    }
    /**
     * builds new AVLNode with specified value and parent Node value
     * 
     * @param val E type object to be designated as node value
     * @param parent AVLNode type object to be designated as this node's parent node
     */
    public AVLNode(E val, AVLNode parent){
        super(val);
        this.parent=parent;
    }
    /**
     * returns the current parent node to this node
     * 
     * @return AVLnode representing the parent node to the current node
     */
    public AVLNode getParent(){
        return parent;
    }
    /**
     * sets parent node to a passed object
     * 
     * @param n value to be set as parent to current node
     */
    public void setParent(AVLNode n){
        parent=n;
    }
}
