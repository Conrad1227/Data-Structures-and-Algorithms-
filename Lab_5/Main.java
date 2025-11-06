import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;
import java.io.*;  
/**
 * Main class for lab 5 that holds the main method
 *
 * @author Conrad Hahn
 * @version 3/4/2025
 */
public class Main
{
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // initialise instance variables
    }
    /**
     * Reads given text files and stopwords and creates a new WordList object with that data
     *
     * @param  args not used
     */
    public static void main(String[] args)
    {
        try{
        //Initializing all of the scanners, Arraylists, and BufferedWriters
        Scanner textscnr = new Scanner(new File("Pride_and_Prejudice.txt"));
        Scanner swordsscnr = new Scanner(new File("stopwords.txt"));
        ArrayList<String> text = new ArrayList<String>();
        ArrayList<String> stops = new ArrayList<String>();
        FileWriter writer = new FileWriter("Lab04.txt");  
        BufferedWriter buffer = new BufferedWriter(writer);
        String delimiters = "[\\W]+";
        //Adding elements from scanners to arraylists
        while( swordsscnr.hasNext() ){
            stops.add(swordsscnr.next());
        }
        while(textscnr.hasNext()){
            text.add(textscnr.next());
        }
        //Joining arraylist into a string and making it lowercase
        String fulltext = String.join("-",text);
        fulltext = fulltext.toLowerCase();
        //turning that string into an array of strings
        String[] tokens = new String[text.size()];
        tokens = fulltext.split(delimiters);
        //initializing the WordList
        WordList wlist = new WordList(stops,tokens);
        int wordcount=0;
        //Making a new array of Strings to use in Lab 5 methods
        String[] finallist = new String[wlist.getWordFrequency().size()];
        //Writing every element of the Wordlist to te text file
        for(int i=0;i<wlist.getWordFrequency().size();i++){
            finallist[i] = wlist.getWordFrequency().get(i).toString();
            buffer.write(wlist.getWordFrequency().get(i).toString());
            buffer.newLine();
            wordcount++;
        }
        System.out.println(wordcount);
        Word[] temp=new Word[5];
        temp = wlist.topKMostFrequent(5);
        for(int i=0;i<5;i++){
           System.out.println(temp[i]);
        }
        buffer.close();
        //Lab 5 method calls here
        //How many words were excluded
        int total = distinctWordsCount(tokens);
        //How many words are in final count
        int totalWithoutStops = distinctWordsCount(finallist);
        //Difference is how many were exlcuded 
        System.out.println((total-totalWithoutStops) + " Words were excluded from the input text");
        //Words less than 3 letters long count
        int wordsLength3 = shortWordsCount(tokens,3);
        System.out.println(wordsLength3 + " Words are at most length 3");
        //Most frequent word starting with p
        Word frequentP = mostFrequentByLetter(wlist,'p');
        System.out.println(frequentP.getWord() + " is the most frequent word starting with p");
        //Getting the longest word starting with p
        Stream<Word> longPStream = wlist.getWordFrequency().stream();
        Word longestP = longPStream.filter(s -> s.getWord().startsWith(""+'p')).max((w1,w2) -> w1.getWord().length()-w2.getWord().length()).orElse(null);
        System.out.println(longestP.getWord() + " is the longest word starting with p");
        }catch(IOException e){
        System.err.print(e);
        }
    }
    /**
     * Goes through the array of words and counts how many different words there are
     *
     * @param  words array of words that are being counted
     *  
     * @return the number of distinct words
     */
    public static int distinctWordsCount(String[] words){
        Stream<String> myStream = Arrays.stream(words);
        long answer = myStream.distinct().count();
        int out = (int)answer;
        return out;
    }
    /**
     * Goes through an array of strings and counts how many are of a specified size
     *
     * @param words array of words that are being counted
     * @param thresh the length of the words being counted
     * 
     * @return the number of words of specified length
     */
    public static int shortWordsCount(String[] words, int thresh){
        if (thresh < 0) {
            throw new IllegalArgumentException("Threshold cannot be negative");
        }
        Stream<String> myStream = Arrays.stream(words);
        long answer = myStream.filter(s -> s.length() <= thresh).distinct().count();
        int out = (int)answer;
        return out;
    }
    /**
     * Goes through an array of strings and gets the most frequent word that starts with a certain letter
     *
     * @param words array of words that are being used
     * @param letter the first letter of the words being looked at
     * 
     * @return the most frequent word that starts with a specified letter
     */
    public static Word mostFrequentByLetter(WordList words, char letter){
        Stream<Word> myStream = words.getWordFrequency().stream();
        return myStream.filter(s -> s.getWord().startsWith("" + letter)).max((w1,w2) -> w2.compareTo(w1)).orElse(null);
    }
}

