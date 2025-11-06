
/**
 * Generic stack class
 *
 * @author Conrad Hahn
 * @version 5/18/2025
 */
class Stack<T> {
    private MyList<T> list = new MyList<>();

    /** 
     * pushes new value onto the stack. 
     * 
     * @param val new value being added to the stack
     */
    public void push(T val) {
        list.add(val);
    }

    /** 
     * pops value from the stack.
     * 
     * @return value that was removed
     */
    public T pop() {
        int s = list.numvals();
        if (s == 0){
            return null; 
        }else{
            return list.removeAt(s - 1);
        }
    }

    /** 
     * returns the top value without removing it 
     * 
     * @return the value at the top of the stack
     */
    public T peek() {
        int s = list.numvals();
        if (s == 0){
            return null; 
        }else{
            return list.get(s - 1);
        }
    }

    /** 
     * checks if the stack is empty
     * 
     * @return true if it is, false if it is not
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /** 
     * gets the number of values in the stack
     *  
     *  @return the number of values on stack
     */
    public int size() {
        return list.numvals();
    }
}

