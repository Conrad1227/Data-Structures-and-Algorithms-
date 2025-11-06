import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Write a description of class Question2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Question2
{

    public static void  main()
    {
        Scanner scnr = new Scanner(System.in);
        ArrayList wlist = new ArrayList();
        int count = 0;
        while(count <= 3){
            wlist.add(scnr.nextLine());
            count++;
        }
        ArrayList out = process(wlist);
        System.out.print(out);
    }
    
    public static ArrayList<String> process(ArrayList<String> lines){
        Comparator c = new ByLengthAlphaWord();
        lines.sort(c);
        return lines;
    }
}
