
/**
 * Word class for Word objects with its methods
 *
 * @author Conrad Hahn
 * @version 3/4/2025
 */
public class Word implements Comparable <Word> {
    private String word;
    private int freq;
    /**
     * Constructor for objects of class Word
     */
    public Word(String word) {
        this.word = word;
        this.freq = 1;
    }
    /**
     * returns the word variable of the Word object
     * 
     * @return the string of the word object
     */
    public String getWord(){
        return word;
    }
    /**
     * returns the frequency of the Word object
     * 
     * @return the frequency of the word
     */
    public int getFrequency(){
        return freq;
    }
    /**
     * increments the frequency of the word by 1
     * 
     */
    public void increment(){
        freq++;
    }
    /**
     * turns the object into a string
     * 
     * @return the word object represented as a string
     */
    @Override
    public String toString(){
        String out = "Word: "+ word +" Frequency: " +freq;
        return out;
    }
    /**
     * compares two Words' frequencies
     * 
     * @return the value of the compare function
     */
    @Override
    public int compareTo(Word w){
        return Integer.compare(w.freq,this.freq);
    }
}