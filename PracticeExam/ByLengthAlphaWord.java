import java.util.Comparator;
import java.util.Scanner;

/**
 * Write a description of class ByLengthAlphaWord here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ByLengthAlphaWord implements Comparator<String>
{
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int compare(String w1, String w2)
    {
        Scanner a = new Scanner(w1);
        Scanner b = new Scanner(w2);
        String a1 = "";
        String a2 = "";
        String afirst = "";
        String b1 = "";
        String b2 = "";
        String bfirst = "";
        a1 = a.next();
        b1 = b.next();
        while(a.hasNext()){
            if(a1.compareTo(a2)>0){
                afirst = a2;
                a1 = a.next();
            }else{
                a2 = a.next();
            }
        }
        while(b.hasNext()){
            if(b1.compareTo(b2)>0){
                bfirst = b2;
                b1 = b.next();
            }else{
                b2 = b.next();
            }
        }
        return bfirst.length()-afirst.length();
    }
}
