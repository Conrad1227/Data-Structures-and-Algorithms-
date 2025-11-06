
/**
 * Interface of IntArrayList
 *
 * @author Conrad Hahn
 * @version 2/11/2025
 */
public interface IntArrayListInterface
{
    /**
     * add method for IntArrayList that adds a value to the array at the 
     * next open index
     *
     * @param  e the int that is being added to the array.
     */
    void add(int e);
    /**
     * add method for IntArrayList that adds a value to the array at a specfic
     * index
     *
     * @param e the int that is being added to the array.
     * @param index the index of the array the int is being added to
     */
    void add(int index, int e);
    /**
     * get method for IntArrayList that gets a value of the array at a 
     * certain index
     *
     * @param e the int that is being added to the array.
     * @return the value at the index
     */
    int get(int index);
    /**
     * clear method for IntArrayList that clears the array 
     */
    void clear();
    /**
     * isEmpty method for IntArrayList that checks if the array is empty
     * 
     * @return returns true if the array is empty and false if it is not
     */
    boolean isEmpty();
    /**
     * remove method for IntArrayList that removes a value from the array
     *
     * @param index the index for the value that is being removed
     * @return the value that is removed
     */
    int remove(int index);
    /**
     * size method for IntArrayList that gets the number of elements in the
     * list
     *
     * @return the number of elements in the array
     */
    int size();
    /**
     * arraySize method for IntArrayList that gets the size of the array
     *
     * @return the size of the array
     */
    int arraySize();
    /**
     * emptyCount method for IntArrayList that gets the number of empty spots 
     * int the array
     *
     * @return the number of empty spots in the array
     */
    int emptyCount();
    /**
     * toString method for IntArrayList that converts the array into a string
     *
     * @return the array as a string
     */
    String toString();
    /**
     * reset method for IntArrayList that resets the internal private counter 
     * used in next method
     *
     */
    void reset();
    /**
     * next method for IntArrayList gets the next element in the array
     *
     * @return the next element in the array
     */
    int next();
}
