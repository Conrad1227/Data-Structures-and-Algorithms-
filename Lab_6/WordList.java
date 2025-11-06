import java.util.ArrayList;
/**
 * Wordlist class that will hold the ArrayList of Words
 *
 *
 * @author  Conrad Hahn
 * @version 3/25/25
 */
public class WordList
{
    // instance variables - replace the example below with your own
    public ArrayList<Word> wordFreq;

    /**
     * Constructor for objects of class WordList that adds array of strings to an arraylist of word objects
     */
    public WordList(ArrayList<String> stopWords, String[] tokens)
    {
        wordFreq = new ArrayList<Word>();
        for(int i=0;i<tokens.length;i++){
            int index = search(tokens[i]);
            if(!isStopWord(tokens[i],stopWords)){
                //skip if it detects that tokens[i] is a stopword
                if(index!=-1){//word already in array
                    wordFreq.get(index).increment();
                }else{
                    wordFreq.add(new Word(tokens[i]));
                }
            }
        }
    }
    /**
     * returns the local arraylist of Word objects in this class
     * 
     * @return the arraylist of Words
     */
    public ArrayList<Word> getWordFrequency(){
        return wordFreq;
    }
    /**
     * searches the arraylist for a certain word
     * 
     * @param w the string the is being seached for
     * 
     * @return the index where the word was found or -1 if the word wasnt found
     */
    public int search(String w){
        for(int i=0;i<wordFreq.size();i++){
            if(wordFreq.get(i).getWord().equals(w)){
                return i;
            }
        }
        return -1;
    }
    /**
     * finds and returns the Word object with the highest frequency
     * 
     * @return the most frequent Word
     */
    public Word getMostFrequent(){
        Word temp= new Word("");
        for(int i=0;i<wordFreq.size();i++){
            if(temp.getFrequency() < wordFreq.get(i).getFrequency()){
                temp=wordFreq.get(i);
            }
        }
        return temp;
    }
    /**
     * finds the top k words in the arraylist and returns them as an array
     * 
     * @param k the top k words in the arraylist are returned
     * 
     * @return a Word array of the most frequent words
     */
    public Word[] topKMostFrequent(int k){
        Word[] out = new Word[k];
        for(int i = 0; i < k; i++){
            out[i] = getMostFrequent();
            wordFreq.remove(getMostFrequent());
        }
        for(Word w : out){
            wordFreq.add(w);
        }
        return out;
    }
    /**
     * checks if the given word is in the list of stop words
     * 
     * @param word the word that is getting checked
     * @param stopWords the list of stop words being checked
     * 
     * @return true if the word is in the list and false if it is not
     */
    public boolean isStopWord(String word, ArrayList<String> stopWords){
        return stopWords.contains(word);
    }
}
