import java.util.HashMap;

/**
 * Creates a generic Priority queue with a corresponding hash map
 *
 * @author Conrad Hahn
 * @version 4/29/2025
 */
public class MyClassicPriorityQueue<T extends Comparable<T>> extends MyPriorityQueue<T> 
{
    private HashMap<T, Integer> map;
    
    /**
     * Constructor for objects of class MyClassicPriorityQueue
     */
    public MyClassicPriorityQueue()
    {
        super();
        map = new HashMap<>();
    }

    /**
     * adds a new value to the queue and adds it to the hashmap
     *
     * @param newval the value being added to the map
     * @return true if the value was added, false if it wasnt
     */
    @Override
    public boolean add(T newval) {
        boolean added = super.add(newval);
        if (added){
        map.put(newval, size() - 1); 
        return true;
        }else{
            return false;
        }
    }
    
    /**
     * removes and returns the minimum value of the queue as well as removing it from the map
     *
     * @return the value being removed
     */
    @Override
    public T poll() {
        T min = super.poll();
        if (min != null){
            map.remove(min);
            return min;
        }
        return null;
    }
    
    /**
     * returns the HashMap of MyClassicPriorityQueue
     *
     * @return the Hashmap
     */
    public HashMap<T, Integer> getMap() {
        return map;
    }
    
    /**
     * Decreases a specific target to another specified value
     *
     * @param  target the value that is being decreased
     * @param  smallerValue the new, smaller, value at the target
     * @return the value before it was decreased, null if the new value wasnt smaller or target isnt in the map
     */
    public T decreaseKey(T target, T smallerValue) {
        Integer i = map.get(target);
        if (i == null || smallerValue.compareTo(target) >= 0){
            return null;
        }
        heap.set(i, smallerValue);
        map.remove(target);
        map.put(smallerValue, i);
        //bubble up algorithm used in MyPriorityQueue's add method
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(parent)) < 0) {
                T temp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.set(parent, temp);
                i = parent;
            } else{
              i=-1;  
            }
        }
        return target;
    }
    
    
}
