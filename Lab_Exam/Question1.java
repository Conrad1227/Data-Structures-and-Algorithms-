import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

/**
 * Write a description of class Question1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Question1
{

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args){
        try{
            Scanner scnr = new Scanner(new File("input.txt"));
            FileWriter writer = new FileWriter("output.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            Scanner wordscnr;
            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                wordscnr = new Scanner(line);
                while(wordscnr.hasNext()){
                    String temp = wordscnr.next();
                    buffer.write(temp.charAt(temp.length()-1)+" "); 
                }
                buffer.newLine();
            }
            buffer.close();
        }catch(Exception e){
            System.err.print(e);
        }
    }
}
