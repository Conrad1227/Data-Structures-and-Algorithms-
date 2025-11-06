import java.util.*;
/**
 * Write a description of class SortableNode here.
 *
 * @author  Conrad Hahn
 * @version 4/1/2025
 */
public class SortableNode <E extends Comparable <E>> extends Node<E> 
{
    /**
     * Constructor for single sortable nodes
     */
    public SortableNode(ArrayList<E> list){
        super(list);
    }

    /**
     * Constructor for lists of sortable nodes
     */
    public SortableNode(E d){
        super(d);
    }

    /**
     * Places elements of the list that are less that the value before it, and greater ones after it
     *
     * @param  value the value that is splitting the list
     */
    public void partition(E value)
    {
        ArrayList<E> lesser = new ArrayList<>();
        ArrayList<E> greater = new ArrayList<>();
        Node<E> curr = this;
        while(curr.next!=null){
            if(curr.val.compareTo(value)<0){
                lesser.add(curr.val);
            }else{
                greater.add(curr.val);
            }
            curr=curr.next;
        }

        lesser.add(value);
        lesser.addAll(greater);

        Node<E> newlist = new Node<>(lesser);
        this.val = newlist.val;
        this.next = newlist.next;
    }

    /**
     * Sorts the elements in the list 
     *
     */
    public void sort(){
        Node<E> curr = this;
        Node<E> forward = this;
        while(curr.next!=null){
            Node<E> small = curr;
            forward = curr.next;
            while(forward!=null){
                if(forward.val.compareTo(small.val)<0){
                    small=forward;
                }
                forward = forward.next;
            }
            E temp = curr.val;
            curr.val = small.val;
            small.val = temp;
            curr = curr.next;
        }
    }

    /**
     * Sorts the list and the removes duplicate values
     *
     */
    public void uniqueSort(){
        sort();
        Node<E> curr = this;
        while(curr.next!=null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;//use this to remove node
            }else{
                curr=curr.next;
            }
        }
    }

}
