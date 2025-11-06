
/**
 * Generic first in first out queue
 *
 * @author Conrad Hahn
 * @version 5/18/2025
 */
public class Queue<T> {
    private MyList<T> list = new MyList<>();

    /** 
     * adds a value to the end of the queue
     * 
     * @param new value being added to the end of the queue
     */
    public void enqueue(T item) {
        list.add(item);
    }

    /** 
     * removes the value at the front of the queue
     * 
     * @return the value removed from the front of the queue
     */
    public T dequeue() {
        if (list.isEmpty()){ 
            return null;
        }else{
            return list.removeAt(0);
        }
    }

    /**  
     * checks the value at the front of the queue but does not remove it
     * 
     * @return the value at the front of the queue
     */
    public T peek() {
        return list.get(0);
    }

    /**  
     * checks if the queue is empty or not
     * 
     * @return true if the queue is empty, false if it isnt
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**  
     * gets the numvals of the queue
     * 
     * @return the number of values in the queue
     **/
    public int size() {
        return list.numvals();
    }
}
