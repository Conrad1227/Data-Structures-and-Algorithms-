import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;  
/**
 * Main class for lab 4 that holds the main method
 *
 * @author Conrad Hahn
 * @version 2/25/2025
 */
public class Main
{
    // instance variables - replace the example below with your own
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
        Scanner textscnr = new Scanner(new File("Pride_and_Prejudice.txt"));
        Scanner swordsscnr = new Scanner(new File("stopwords.txt"));
        ArrayList<String> text = new ArrayList<String>();
        ArrayList<String> stops = new ArrayList<String>();
        FileWriter writer = new FileWriter("Lab04.txt");  
        BufferedWriter buffer = new BufferedWriter(writer);
        String delimiters = "[\\W]+";
        while( swordsscnr.hasNext() ){
            stops.add(swordsscnr.next());
        }
        System.out.println(stops.get(2));
        while(textscnr.hasNext()){
            text.add(textscnr.next());
        }
        String fulltext = String.join("-",text);
        fulltext = fulltext.toLowerCase();
        String[] tokens = new String[text.size()];
        tokens = fulltext.split(delimiters);
        
        WordList wlist = new WordList(stops,tokens);
        int wordcount=0;
        for(int i=0;i<wlist.getWordFrequency().size();i++){
            buffer.write(wlist.getWordFrequency().get(i).toString());
            buffer.newLine();
            wordcount++;
        }
        System.out.println(wordcount);
        int k = 5;
        Word[] temp=new Word[k];
        temp = wlist.topKMostFrequent(k);
        for(int i=0;i<k;i++){
           System.out.println(temp[i]);
        }
        buffer.close();
        }catch(IOException e){
        System.err.print(e);
        }
    }
}

