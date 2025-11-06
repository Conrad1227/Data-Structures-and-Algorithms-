
/**
 * Write a description of class GenericArrayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GenericArrayList<E>
{
    private E[] x;
    int numvals;
    int length;
    /**
     * Constructor for objects of class GenericArrayList
     */
    public GenericArrayList()
    {
        x = (E[]) new Object[10];
        numvals = 0;
        length = 10;
    }
    
    public void grow(){
        E[] newlist = (E[]) new Object[length+10];
        length+=10;
        for(int i=0;i<x.length;i++){
            newlist[i] = x[i];
        }
        x = newlist;
    }
    
    public void addToBack(E val){
        if(numvals == length){
            grow();
        }
        x[numvals+1] = val;
        numvals++;
    }
    
    @Override
    public String toString(){
        String out = "";
        for(int i=0;i<numvals;i++){
            out = out + " " + x[i].toString();
        }
        return out;
    }
}
