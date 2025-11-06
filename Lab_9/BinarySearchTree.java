import java.util.Comparator;
/**
 * Write a description of class BinarySearchTree here.
 *
 * @author Conrad Hahn
 * @version 4/21/2025
 */
public class BinarySearchTree<E extends Comparable> extends BinaryTree<E>
{

    /**
     * Constructor for objects of class BinarySearchTree
     */
    public BinarySearchTree(BinaryNode e){
        super(e);
    }

    /**
     * Inserts a value into the correct location on the tree
     *
     * @param  val that value that is being inserted into the tree
     * @return true if the value was inserted, false if it was already in the list
     */
    public boolean insert(E e)
    {
         if(root==null){
            root=new BinaryNode(e);
            return true;
        }else if(contains(e)){
            return false;
        }else{
            insertRecursive(root,new BinaryNode(e));
            return true;
        }
        
    }
    
    /**
     * Helper method for insert that recursively calls itself to iterate down
     * the tree to find the proper location to insert the new value
     *
     * @param newNode the node being inserted
     * @param e the node that the method is attempting to add newNode to
     */
    private void insertRecursive(BinaryNode e, BinaryNode newNode){
        if(newNode.getVal().compareTo(e.getVal())<0){ 
            if(e.getLeft()==null){
                e.setLeft(newNode);
            }else {
                insertRecursive(e.getLeft(),newNode);
            }
        }
        else{
            if(e.getRight()==null) {
                e.setRight(newNode);
            }else {
                insertRecursive(e.getRight(),newNode);
            }
        }
    }
    /**
     * Searches the tree for a specified value to determine if the tree contains it or not
     * helper is required to move through the list targeting specific nodes along the way
     *
     * @param  val that value that is being searched for
     * @return true if the tree contatins the value, false  if it doesnt
     */
    public boolean contains(E e){
        return containsRecursive(e, root);
    }
    
    /**
     * helper class for contains that recursively moves down the tree to find value
     *
     * @param  val that value that is being searched for
     * @return true if the node being checked is the target, false if it reaches a null node without finding the value
     */
    public boolean containsRecursive(E val, BinaryNode e){
        if(val.compareTo((E)e.getVal())==0){
            return true;
        }else if(val.compareTo((E)e.getVal())>0){
            if(e.getRight()==null){
                return false;
            }
            return containsRecursive(val, e.getRight());
        }else{
            if(e.getLeft()==null){
                return false;
            }
            return containsRecursive(val, e.getLeft());
        }
    }
}
