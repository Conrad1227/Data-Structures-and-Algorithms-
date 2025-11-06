/**
 * A balanced tree of AVLNodes
 *
 * @author Conrad Hahn
 * @version 4/21/2025
 */
public class AVLTree<E extends Comparable> extends BinarySearchTree<E>
{
    AVLNode root; 
    /**
     * constructor creating a root node
     * 
     * @param e value of root node being created
     */
    public AVLTree(AVLNode e){
        super(e);
        this.root=e;
        super.root=this.root;
    }

    /**
     * inserts node into tree and balances the tree based on the balaning factor of each node
     * 
     * @param e value being added to the tree
     * @return true if the value was added, false if the value already is in the tree
     */
    public boolean insert(E e){
        if(root==null){
            root=new AVLNode(e);
            return true;
        }
        if(contains(e)) {
            return false; 
        }
        insertRecursive(root, e);
        return balance(root);
    }

    /**
     * private helper method that recursively moves through tree until an empty child in a valid position is found to add a new value to 
     * 
     * @param curr current node being checked
     * @param insert E type object representing value to be inserted
     */
    private void insertRecursive(BinaryNode curr, E val){
        if(val.compareTo(curr.getVal())<0){ 
            if(curr.getLeft()==null){
                curr.setLeft(new AVLNode(val, (AVLNode)curr));
            }
            else {
                insertRecursive(curr.getLeft(),val);
            }
        }
        else{ 
            if(curr.getRight()==null){
                curr.setRight(new AVLNode(val, (AVLNode)curr));
            }
            else {
                insertRecursive(curr.getRight(),val);
            }  
        }
    }

    /**
     * finds the height of a given node by recursively traversing through all nodes and and choosing largest value
     * 
     * @param curr node currently being examined
     * @return the height of a given node
     */
    public int getHeight(BinaryNode curr){
        //return -1 for recursive call if node has no children
        if(curr==null){
            return -1;
        }
        int maxL;
        int maxR;
        if(curr.getLeft()!=null){
            maxL=getHeight(curr.getLeft());
        }else {
            maxL=-1;
        }
        if(curr.getRight()!=null){
            maxR=getHeight(curr.getRight());
        }else{
            maxR=-1;  
        }
        return Math.max(maxL,maxR)+1;
    }

    /**
     * finds the balance factor of a given node
     * 
     * @param e the node whos balance factor is being returned
     * @return the balance factor of the node
     */
    public int getBF(AVLNode e){
        return getHeight(e.getRight())-getHeight(e.getLeft());
    }

    /**
     * balances tree recursively from current down using left and right rotations
     * 
     * @param curr the pivot node for a specific balance operation
     * @return true if the tree was balanced, false if not
     */
    private boolean balance(AVLNode curr){
        if(curr==null){
            return true;
        }
        int bf = getBF(curr);
        //looping until balanced
        while(true){ 
             //requires shift right if bf is <-1
            if(bf<-1){
                //if pivot isnt root node
                if(curr.getParent()!=null){ 
                    //replace pivot node in eyes of parent and update parent node of child being pulled up
                    curr.getParent().setLeft((AVLNode)curr.getLeft());
                    ((AVLNode)(curr.getLeft())).setParent(curr.getParent());
                }
                //if it is root node
                else{
                     //update parent of new root node to null adn set root node
                    ((AVLNode)(curr.getLeft())).setParent(null);
                    root=(AVLNode)curr.getLeft();
                }
                //set parent of pivot node to its replacement
                curr.setParent(((AVLNode)curr.getLeft())); 
                BinaryNode temp = curr.getLeft().getRight(); 
                //replace node stored in hold with pivot note
                curr.getLeft().setRight(curr); 
                curr.setLeft(temp); 
            }
            //requires left shift
            else if(bf>1){ 
                //if not pivoting on root node
                if(curr.getParent()!=null){ 
                    //replace pivot node in eyes of parent and update parent node of child being pulled up
                    curr.getParent().setRight((AVLNode)curr.getRight());
                    ((AVLNode)(curr.getRight())).setParent(curr.getParent()); 
                }
                //if pivoting on root node
                else{ 
                    //update parent of new root node to null adn set root node
                    ((AVLNode)(curr.getRight())).setParent(null); 
                    root=(AVLNode)curr.getRight(); 
                }
                 //set parent of pivot node to its replacement
                curr.setParent(((AVLNode)curr.getRight())); 
                BinaryNode temp = curr.getRight().getLeft(); 
                //replace node stored in hold with pivot note
                curr.getRight().setLeft(curr); 
                curr.setRight(temp); 
            }
            else {
                //balance children after parent
                return balance((AVLNode)(curr.getLeft())) && balance((AVLNode)(curr.getRight()));
            } 
            bf=getBF(curr);
        }
    }

    /**
     * returns the root
     * 
     * @return root node of current tree
     */
    public AVLNode getRoot(){
        return root;
    }
}