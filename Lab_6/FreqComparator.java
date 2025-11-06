import java.util.*;
/**
 * Class that is used to compare the frequencies of two words
 *
 * @author Conrad Hahn
 * @version 3/25/25
 */
class FreqComparator implements Comparator<Word>
{
    /**
     * Constructor for objects of class FreqComparator
     */
    public FreqComparator()
    {
    }
     /**
     * compares two words first by frequencies
     *
     * @param  w1  first word being compared
     * @param  w1  second word being compared
     * @return    the comparator output of the two words
     */
    public int compare(Word w1,Word w2)
    {
        return Integer.compare(w1.getFrequency(), w2.getFrequency());
    }
}
