import java.util.*;
/**
 * Write a description of class Node here.
 *
 * @author Conrad Hahn
 * @version 3/26/25
 */
public class Node <E> {
 protected E val;
 protected Node<E> next;
 /**
  * Constructor for making single nodes with specified values
  */
 public Node(E d){
  next=null;
  val = d;
 }
 /**
  * Constructor for making a linked list using an Arraylist
  */
 public Node(ArrayList<E> list){
     //cehck if list is empty
   this.val = list.get(0);
   Node<E> curr = this;
   
   for(int i = 1 ; i < list.size() ; i++){
       curr.next = new Node<E>(list.get(i));
       curr = curr.next;
   }
 }
 /**
  * converts the linked list into a string
  * 
  * @return the linked list as a string
  */
 public String toString(){
     String out = "";
     Node<E> curr = this;
     out = out + curr.val.toString();
     while(curr.next!=null){
         out = out + ", " + curr.next.val.toString();
         curr= curr.next;
     }
     return out;
 }
 /**
  * adds a value to the back of the list 
  * 
  * @param value the value you are adding
  */
 public void addToBack(E value){
     Node<E> curr = this;
     boolean exit = false;
     while(!exit){
     if(curr.next==null){
        curr.next = new Node<E>(value);
        exit=true;
     }else{
        curr= curr.next; 
     }
     }
 }
 /**
  * adds a value to the front of the list 
  * 
  * @param value the value you are adding
  */
 public void addToFront(E value){
     Node<E> newnode = new Node<E>(this.val);
     newnode.next = this.next;
     next = newnode;
     this.val = value;
 }
 /**
  * rotates the list a set amount of times
  * 
  * @param k the amount of times the list is being rotated
  */
 public void rotate(int k){
     if(k<0){
         throw new IllegalArgumentException("Rotation number must be non-negative");
     }else if(k==0){
         return;
     }else{
    for(int i=0;i<k;i++){
        Node<E> curr = this;
    while(curr.next.next!=null){
        curr=curr.next;
    }
     addToFront(curr.next.val);
     curr.next = null;
   }
 }
}
}
