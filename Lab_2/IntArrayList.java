
/**
 * Write a description of class IntArrayList here.
 *
 * @author Conrad Hahn
 * @version 2/11/2025
 */
public class IntArrayList implements IntArrayListInterface
{
    //variable decleration
    //actual array being adjusted
    private int[] ints;
    //number of values in the array
    private int numvals;
    //private counter for next method
    private int counter;
    /**
     * Constructor for objects of class IntArrayList
     */
    public IntArrayList()
    {
      ints = new int[10];
      numvals = 0;
      counter = 0;
    }
    public void add(int e){
        //checks if the array has enough space to hold another value and
        //extending it if not
        if(numvals==ints.length){
            int newsize = ints.length+10;
           int[] newints = new int[newsize];
           for(int i=0;i<ints.length;i++){
               newints[i]=ints[i];
           }
           ints = newints;
        }
        ints[numvals]= e;
        numvals++;
    }
    public void add(int index, int e){
        //checks if the array has enough space to hold another value and
        //extending it if not
       if(numvals==ints.length){
            int newsize = ints.length+10;
           int[] newints = new int[newsize];
           for(int i=0;i<ints.length;i++){
               newints[i]=ints[i];
           }
           ints = newints;
        }
        //checks to see if the index where it is being added is 0
       if(ints[index]!=0){
           //incriments the elements to make room for the one being addede
            for(int i=numvals;i>index;i--){
                ints[i] = ints[i-1];
            }
            ints[index]= e;
            numvals++;
        }else{
            ints[index] = e;
        }
    }
    public int get(int index){
        //returns value of array at the index
        return ints[index];
    }
    public void clear(){
        //creates a new array object and resets value count
        ints = new int[10];
        numvals = 0;
    }
    public boolean isEmpty(){
        //checks to see if each index is empty
       for(int i=ints.length-1;i>=0;i--){
           if(ints[i]!=0){
               return false;
           }
       }
       return true;
    }
    public int remove(int index){
        //stores the removed element
        int temp = ints[index];
        //increments the values after the one that was removes
        for(int i=index;i<=numvals;i++){
            ints[i] = ints[i+1];
        }
        numvals--;
        return temp;
    }
    public int size(){
        //returns number of values in array
        return numvals;
    }
    public int arraySize(){
        //returns array length
        return ints.length;
    }
    public int emptyCount(){
        int count=0;
        //counts every emtpy space in the array
        for(int i=0;i<ints.length;i++){
            if(ints[i]==0){
                count= count +1;
            }
        }
        //makes the array smaller if the count exceeds 10
        if(count>10){
            int newsize = ints.length-10;
           int[] newints = new int[newsize];
           for(int i=0;i<newints.length;i++){
               newints[i]=ints[i];
           }
           ints = newints;
        }
        return count;
    }
    public String toString(){
        String list="";
        String num;
        //loop that adds each element to the string
        for(int i=0;i<=numvals-1;i++){
            num = ints[i]+"";
            list = list.concat(num+" ");
        }
        return list;
    }
    public void reset(){
        counter = 0;
    }
    public int next(){
        //Throwing exception if counter is out of bounds
        if(counter>=ints.length-1){
            new Exception("End of stored data is reached.");
        }
        int store = ints[counter];
        counter++;
        return store;
      }   
}
