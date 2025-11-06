import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;

/**
 * Write a description of class main here.
 *
 * @author Conrad Hahn
 * @version 4/8/2025
 */
public class main
{
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
     try{
     Scanner scnr = new Scanner(new File("input.txt"));
     FileWriter writer = new FileWriter("output.txt");
     BufferedWriter buffer = new BufferedWriter(writer);
     while(scnr.hasNext()){
        String temp = scnr.next();
        buffer.write(temp.charAt(temp.length()-1) + " ");
     }
     buffer.close();
    }catch (Exception e){
        System.err.print(e);
    }
  }
}
