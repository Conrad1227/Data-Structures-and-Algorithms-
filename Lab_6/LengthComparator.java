import java.util.*;
/**
 * Class that is used to compare the length of two words
 * 
 * @author  Conrad Hahn
 * @version 3/25/25
 */
public class LengthComparator implements Comparator<Word>
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class LengthComparator
     */
    public LengthComparator()
    {
        // initialise instance variables
    }
     /**
     * compares two words by their length if not equal, and if they are equal then alphabetically
     *
     * @param  w1  first word being compared
     * @param  w1  second word being compared
     * @return    the comparator output of the two words
     */
    public int compare(Word w1, Word w2)
    {
        if(w1.getWord().length()==w2.getWord().length()){
            return w2.getWord().compareTo(w1.getWord());
        }else{
            return w1.getWord().length() - w2.getWord().length();
        }
    }
}
