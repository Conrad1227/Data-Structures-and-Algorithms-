import java.util.LinkedList;
import java.util.List;

/**
 * Write a description of class Q3_List here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Q3_List implements List<Q3>
{
    LinkedList<Q3> list;

    /**
     * Constructor for objects of class Q3_List
     */
    public Q3_List()
    {
        list = new LinkedList<Q3>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    @Override 
    public boolean add(Q3 val){
        return true;
    }
}
