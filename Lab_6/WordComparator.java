import java.util.*;
/**
 * Class that is used to compare two words
 *
 * @author Conrad Hahn
 * @version 3/25/25
 */
public class WordComparator implements Comparator<Word>
{
    /**
     * Constructor for objects of class WordComparator
     */
    public WordComparator()
    {
    }
    /**
     * compares two words first by their length if not equal, then frequencies if length is equal, and if both are equal then alphabetically
     *
     * @param  w1  first word being compared
     * @param  w1  second word being compared
     * @return    the comparator output of the two words
     */
    public int compare(Word w1, Word w2)
    {
     if((w1.getWord().length()==w2.getWord().length()) && w1.getFrequency()==w2.getFrequency()){
         return w1.getWord().compareTo(w2.getWord());
     } else if (w1.getWord().length()==w2.getWord().length()){
         return w1.getFrequency() - w2.getFrequency();
     } else{
         return w1.getWord().length() - w2.getWord().length();
     }
    }
}
