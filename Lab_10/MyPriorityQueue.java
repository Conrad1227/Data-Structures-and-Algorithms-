import java.util.ArrayList;

/**
 * Creates a generic Priority queue
 *
 * @author Conrad Hahn
 * @version 4/28/2025
 */
public class MyPriorityQueue <T extends Comparable<T>>  
{
    protected ArrayList<T> heap;
    /**
     * Constructor for objects of class MyPriorityQueue
     */
    public MyPriorityQueue()
    {
        heap = new ArrayList<T>();
    }

    /**
     * Adds a new value to the heap and bubbles it up to proper location
     *
     * @param newval the value being added to the heap
     * @return true if the value was added false if it wasnt
     */
    public boolean add(T newval)
    {
        heap.add(newval);
        int i = heap.size()-1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(parent)) < 0) {
                T temp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.set(parent, temp);
                i = parent;
            } else {
                i=-1;
            }
        }
        return true;
    }

    /**
     * Looks at the minimal value of the heap but does not remove it
     *
     * @return the mininmum value of heap
     */
    public T peek(){
        if(heap.isEmpty()){
            return null;
        }else{
            return heap.get(0);
        }
    }

    /**
     * Removes and returns the minimal value of the heap, moving all other values accordingly
     *
     * @return the value that is being removed
     */
    public T poll(){
        if (heap.isEmpty()){
            return null;
        }
        T out = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            int i = 0;
            while (2*i+ 1 < heap.size()) {
                int left = 2*i + 1;
                int right = 2*i + 2;
                int smallest = left;
                if (right < heap.size() && heap.get(right).compareTo(heap.get(left)) < 0) {
                    smallest = right;
                }
                if (heap.get(i).compareTo(heap.get(smallest)) > 0) {
                    T temp = heap.get(i);
                    heap.set(i, heap.get(smallest));
                    heap.set(smallest, temp);
                    i = smallest;
                } else break;
            }
        }
        return out;
    }

    /**
     * Checks if the list is properly ordered for a heap
     *
     * @return true if the list is ordered correctly false if not
     */
    public boolean isHeap() {
        for (int i = 0; i < heap.size(); i++) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            if (left < heap.size() && heap.get(i).compareTo(heap.get(left)) > 0){
                return false;
            }
            if (right < heap.size() && heap.get(i).compareTo(heap.get(right)) > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the list is properly ordered for a heap
     *
     * @return true if the list is ordered correctly false if not
     */
    public int size() {
        return heap.size();
    }
}
