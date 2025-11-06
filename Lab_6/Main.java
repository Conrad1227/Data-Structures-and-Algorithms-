import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;  
/**
 * Main class for lab 6 that holds the main method
 *
 * @author  Conrad Hahn
 * @version 3/25/25
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
     * Reads given text files and stopwords and creates a new WordList object with that data. Then prints out the top k most frequent using a method and sorting algorithm, then the longest words, and then the most frequent long words
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
        buffer.close();
        
        //lab 6
        
        WordList list1 = new WordList(stops,tokens);
        WordList list2 = new WordList(stops,tokens);
        WordList list3 = new WordList(stops,tokens);
        WordList list4 = new WordList(stops,tokens);
        
        //top 15 words no sort
        int k = 15;
        Word[] temp=new Word[k];
        temp = list1.topKMostFrequent(k);
        System.out.println("topKMostFrequent:");
        for(int i=0;i<k;i++){
           System.out.println(temp[i]);
        }
        
        //top 15 words with bubble sort
        bubbleSort(list2.getWordFrequency(),new FreqComparator());
        System.out.println("Bubble Sort:");
        for(int i=0;i<k;i++){
           System.out.println(list2.getWordFrequency().get(i));
        }
        
        //top 15 longest words
        selectionSort(list3.getWordFrequency(),new LengthComparator());
        System.out.println("Selection Sort:");
        for(int i=0;i<k;i++){
           System.out.println(list3.getWordFrequency().get(i));
        }
        
        //top 15 most frequent long words
        insertionSort(list4.getWordFrequency(),new WordComparator());
        System.out.println("Insertion Sort:");
        for(int i=0;i<k;i++){
           System.out.println(list4.getWordFrequency().get(i));
        }
        
        
        
        
        }catch(IOException e){
        System.err.print(e);
        }
    }
    /**
     * sorts an arraylist using selection sort algorithm
     * 
     * @param  list the ArrayList being sorted
     * @param  c the Comparator needed for comparing objects of type T
     * @return    the number of swaps that occured
     */
    static <T> int selectionSort(ArrayList<T> list, Comparator<T> c ) { 
         int length = list.size();
         int count = 0;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (c.compare(list.get(j),list.get(min)) > 1) {
                    min = j;
                }
            }
            T temp = list.get(i);
            list.set(i,list.get(min));
            list.set(min,temp); 
            count++;
        }
        return count;
    }
    /**
     * sorts an arraylist using bubble sort algorithm
     * 
     * @param  list the ArrayList being sorted
     * @param  c the Comparator needed for comparing objects of type T
     * @return  the number of swaps that occured
     */
    static <T> int bubbleSort(ArrayList<T> list, Comparator<T> c){
        int length= list.size();
        T temp = null;
        boolean sorted;
        int count = 0;
        for (int i = 0; i <length- 1; i++) {
            sorted = true;
            for (int j = 0; j <length - i - 1; j++) {
                if (c.compare(list.get(j),list.get(j + 1)) < 0) {
                    temp = list.get(j);
                   list.set(j,list.get(j + 1));
                    list.set(j + 1,temp);
                    sorted = false;
                    count++;
                }
            }
            if (sorted == true)
                break;
        }
        return count;
    }
    /**
     * sorts an arraylist using insertion sort algorithm
     * 
     * @param  list the ArrayList being sorted
     * @param  c the Comparator needed for comparing objects of type T
     * @return  the number of shifts that occured
     */
    static <T> int insertionSort(ArrayList<T> list, Comparator<T> c)
    {
        int length = list.size();
        int count = 0;
        for (int i = 1; i <length; ++i) {
            T temp = list.get(i);
            int j = i - 1;
            while (j >= 0 && c.compare(list.get(j),temp)<0) {
                list.set(j + 1,list.get(j));
                j = j - 1;
            }
            list.set(j + 1,temp);
            count++;
        }
        return count;
    }
}

