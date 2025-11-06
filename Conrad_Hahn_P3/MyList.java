
/**
 * Implemtation of an Generic Arraylist
 *
 * @author Conrad Hahn
 * @version 5/18/2025
 */
class MyList<T> {
    private Object[] list;
    private int numvals;

    /** 
     * creates a new leaf with default size of 10
     */
    public MyList() {
        this.list = new Object[10];
        this.numvals = 0;
    }

    /** 
     * adds value at end of list 
     * 
     * @param val the value being added to the list
     */
    public void add(T val) {
        if (numvals == list.length) {
            Object[] tmp = new Object[list.length * 2];
            // manual copy
            for (int i = 0; i < list.length; i++) {
                tmp[i] = list[i];
            }
            list = tmp;
        }
        list[numvals++] = val;
    }

    /** 
     * inserts value at index and shifts other values accordingly
     * 
     * @param val value being added to the list
     * @param i index where the value is being added
     */
    public void add(int ind, T val) {
        if (ind < 0 || ind > numvals) {
            return;
        }
        //resize if there are too many values
        if (numvals == list.length) {
            Object[] tmp = new Object[list.length * 2];
            for (int i = 0; i < list.length; i++) {
                tmp[i] = list[i];
            }
            list = tmp;
        }
        // shift right
        for (int i = numvals; i > ind; i--) {
            list[i] = list[i-1];
        }
        list[ind] = val;
        numvals++;
    }

    /** 
     * get value at index. 
     * 
     * @return the value at the specified index
     **/
    public T get(int ind) {
        if (ind < 0 || ind >= numvals) {
            return null;
        }else{
            return (T)list[ind];
        }
    }

    /** 
     * removes value at index and shifts the other values accordingly 
     * 
     * @return the value removed
     */
    public T removeAt(int ind) {
        if (ind < 0 || ind >= numvals){
            return null;
        }
        T val = (T)list[ind];
        for (int i = ind; i < numvals - 1; i++) {
            list[i] = list[i + 1];
        }
        list[--numvals] = null;
        return val;
    }

    /**
     * gets the number of values in list
     * 
     * @return number of values in the list
     */
    public int numvals() {
        return numvals;
    }

    /** 
     * checks if the list is empty
     * 
     * @return true if it is empty, false if not
     */
    public boolean isEmpty() {
        return numvals == 0;
    }

    /**
     * Return a string representation of the list's elements.
     *
     * @return comma-separated list of elements in brackets
     */
    @Override
    public String toString() {
        String out = "[";
        for (int i = 0; i < numvals; i++) {
            out += (get(i).toString());
            if (i < numvals - 1){
                out += ", "; 
            }
        }
        out += "]";
        return out;
    }
}