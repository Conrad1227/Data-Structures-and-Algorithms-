
/**
 * Tree of BinaryNodes
 *
 * @author Conrad Hahn
 * @version 4/21/2025
 */
public abstract class BinaryTree<E> implements Tree<E>
{
    BinaryNode root;

    /**
     * Constructor for objects of class BinaryTree
     */
    public BinaryTree(BinaryNode e)
    {
        this.root = e;
    }

    /**
     * not implemented
     * would insert a value into the BinaryTree
     *
     * @return false since it is not implemented
     */
    public boolean insert()
    {
        return false;
    }

    /**
     * determines whether a value exists in the tree
     * 
     * @param val value being searched for
     * @return true if the tree has that value, false if not 
     */
    public boolean contains(E e){
        return containsRecursive(root,e);
    }

    /**
     * private helper method that itterates down the tree recursively searching for the target
     * 
     * @param n current position in the tree
     * @param val target value that is being searched for
     * @return true if the target value is found in the node it is in, false if not, moving it onto the next recursively
     */
    private boolean containsRecursive(BinaryNode n, E val){
        //recursively searches every node for the value and returns true if the current value or either of its children are the target, if not it calls itself to check the next node
        return n.getVal()!=null && (n.getVal().equals(val) || containsRecursive(n.getLeft(),val) || containsRecursive(n.getRight(), val));
    }

    /**
     * turns the tree into a string in pre-order format
     * 
     * @return preorder string representation of tree
     */
    public String preOrderString(){
        String s = preRecursive(root);
        return s.substring(0,s.length()-2);
    }

    /**
     *  private helper method that itterates down the tree recursively adding each value to the output string
     * 
     * @param n current position in the tree
     * @return value being added to the output string
     */
    private String preRecursive(BinaryNode n){
        String out=n.getVal().toString()+", ";
        if(n.getLeft()!=null){
            out+=preRecursive(n.getLeft());
        }
        if(n.getRight()!=null){
            out+=preRecursive(n.getRight());
        }
        return out;
    }

    /**
     * turns the tree into a string in post-order format
     * 
     * @return post-order string representation of tree
     */
    public String postOrderString(){
        String s = postRecursive(root);
        return s;
    }

    /**
     * private helper method that itterates down the tree recursively adding each value to the output string
     * 
     * @param n current position in the tree
     * @return value being added to the output string
     */
    private String postRecursive(BinaryNode n){
        String out="";
        if(n.getLeft()!=null){ 
            out+=postRecursive(n.getLeft())+", ";
        }
        if(n.getRight()!=null) {
            out+=postRecursive(n.getRight())+", ";
        }
        out+=n.getVal().toString();
        return out;
    }

    /**
     * turns the tree into a string in in-order format
     * 
     * @return in-order string representation of tree
     */
    public String inOrderString(){
        String s = inRecursive(root);
        return s.substring(0,s.length()-2);
    }

    /**
     * private helper method that itterates down the tree recursively adding each value to the output string
     * 
     * @param n current position in the tree
     * @return value being added to the output string
     */
    private String inRecursive(BinaryNode n){
        String out="";
        if(n.getLeft()!=null) {
            out+=inRecursive(n.getLeft());
        }
        out+=n.getVal().toString()+", ";
        if(n.getRight()!=null) {
            out+=inRecursive(n.getRight());
        }
        return out;
    }

    /**
     * empties the tree
     *
     */
    public void empty(){
        this.root = null;
    }

    /**
     * checks if the tree is empty
     * 
     * @return true if the tree is empty, false if it is not
     */
    public boolean isEmpty(){
        if(this.root==null){
            return true;
        }else{
            return false;
        }
    }

}
