
/**
 * Write a description of class CustomArrayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomArrayList <E>
{
    public E[] wlist;
    int numvals;
    int length;
    /**
     * Constructor for objects of class CustomArrayList
     */
    public CustomArrayList()
    {
        wlist  = (E[]) new Object[6];
        numvals = 0;
        length = 6;
    }

    public void grow()
    {
        E[] newlist = (E[]) new Object[length + 3];
        for(int i=0;i<=numvals;i++){
            newlist[i] = wlist[i];
        }
        wlist = newlist;
        length = length + 3;
    }

    public void addToBack(E val){
        if(length-1 == numvals){ //check if its -1 or not
            grow();    
        }
        wlist[numvals] = val;
        numvals++;
    }

    public int arraySize(){
        return numvals;
    }

    public String stringOut(int i){
        return wlist[i]+"";
    }

    @Override
    public String toString(){
        String out="";
        for(int i = 0 ; i < numvals ; i++){
            out = out + " " + stringOut(i);
        }
        return out;
    }

}
