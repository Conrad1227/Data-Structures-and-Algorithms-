/**
 * This is a basic Input Output class that takes a user input and 
 * counts the lines, characters, and words that they input.
 *
 * @author Conrad Hahn
 * @version 1/29/2025
 */
import java.util.Scanner;
import java.io.*;  
public class BasicIO{ 
    /**
     * This is the main method that outputs the input from the user as well 
     * as well as the the count of words, characters,and lines. It also
     * verifies the input as well as the starting and stopping of the loop
     * in the error secton of the console
     *
     * @param args is not used
     */
    public static void main(String[] args) throws Exception{
        //Initializing writer, buffer, and first scanner
        FileWriter writer = new FileWriter("lab01.text");  
        BufferedWriter buffer = new BufferedWriter(writer);  
        Scanner lines =new Scanner(System.in);
        System.err.println("Enter Loop");
        //Initializing variables
        String words;
        String line;
        int noline=0;
        int chars=0;
        int nofw=0;
        //Gets first line of user input
        line = lines.nextLine();
        //Loop that checks if there are new lines of input
        while(!line.isEmpty()){
        System.err.println("continueing loop >>" + line + "<<");
        buffer.write(line);
        buffer.newLine();
        //Increment line count
        noline++;
        Scanner wholeline =new Scanner(line);
        //Loop that checks each word in the line
        while (wholeline.hasNext()){
        words = wholeline.next();
        //Increment word and char count
        nofw++;
        chars= chars + words.length();
        System.out.println(words);
        }
        line = lines.nextLine();
       }
        //All the outputs when the loop is complete
        System.err.println("Exit Loop");
        System.out.println("There are " + noline + " Lines.");
        System.out.println("There are " + chars + " characters.");
        System.out.println("There are " + nofw + " words.");
        //Writes outputs to save file and saves
        buffer.write("There are " + noline + " Lines. ");
        buffer.newLine();
        buffer.write("There are " + chars + " characters. ");
        buffer.newLine();
        buffer.write("There are " + nofw + " words. ");
        buffer.newLine();
        buffer.close();
       }
    }
    

