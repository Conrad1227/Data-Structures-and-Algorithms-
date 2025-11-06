import java.util.LinkedList;
import java.util.List;

/**
 * A linked list of snack objects
 *
 * @author Conrad Hahn
 * @version 4/9/2025
 */
public abstract class SnackBox implements List<Snack>
{
    public LinkedList<Snack> wlist;

    /**
     * Constructor for objects of class SnackBox that creates a new empty LinkedList of type Snacks
     */
    public SnackBox()
    {
        //Constructor for new linkedlist of snacks
        wlist = new LinkedList();
    }

    /**
     * Adds a snack to the list as long as its calories are above 40
     *
     * @param  e The snack that is being added to the list
     * @return true if the snack was added, and false if it was not
     */
    @Override
    public boolean add(Snack e)
    {
        //if the calories is less than 40 dont add and return false
        if(e.getCalories() < 40){
            return false;
        }else{
            //else add to the list and return true
            wlist.add(e);
            return true;
        }
    }

    /**
     * Gets the sum of all the calories from the snacks on the list
     * 
     * @return the total number of calories of snacks stored on the list
     */
    public int calorieCount(){
        int count = 0;
        for(int i = 0 ; i < wlist.size() ; i++){
            //goes through each index of the list and gets the calories to add to count
            count = count + wlist.get(i).getCalories();
        }
        return count; 
    }
}
