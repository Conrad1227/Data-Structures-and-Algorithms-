
/**
 * Creates weighted objects that contain a value and a weight for use in priority queues
 * 
 * @author Conrad Hahn
 * @version 4/28/2025
 */
public class WeightedElement<E, W extends Comparable<W>> implements Comparable<WeightedElement<E, W>> {
    public E val;
    public W weight;
    /**
     * Constructor for objects of class WeightedElement
     */
    public WeightedElement(E val, W weight)
    {
        this.val = val;
        this.weight = weight;
    }

    /**
     * returns the value of weighted element
     *
     * @return the value of the element
     */
    public E getVal()
    {
        return val;
    }
    
    /**
     * returns the weight of weighted element
     *
     * @return the weight of the element
     */
    public W getWeight()
    {
        return weight;
    }
    
    /**
     * Compare method for weights of elements
     *
     * @param weight2 the weight being compared to the current
     * @return compareTo value of weights being compared
     */
    @Override
    public int compareTo(WeightedElement<E,W> weight2)
    {
        return this.weight.compareTo(weight2.weight);
    }
    
    /**
     * toString method for weighted element used for testing
     *
     * @return weighted element as a string that prints its value and weight
     */
    @Override
    public String toString(){
        String out = "Value: " + this.val + " Weight: " + this.weight;
        return out;
    }
}
