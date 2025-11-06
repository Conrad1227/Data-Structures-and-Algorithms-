/**
 * Array list of Customer Reviews
 *
 * @author Conrad Hahn
 * @version 2/11/2025
 */
public class CustomerReviewArrayList
{
    //variable decleration
    //actual array being adjusted
    private CustomerReview[] reviews;
    //adds new array for VIP reviews for testing
    private VIPCustomerReview[] vipReviews;
    //number of values in the array
    private int numvals;
    //private counter for next method
    private int counter;
    /**
     * Constructor for objects of class CustomerReviewArrayList
     */
    public CustomerReviewArrayList()
    {
      //initialize vars
      reviews = new CustomerReview[10];
      
      vipReviews = new VIPCustomerReview[10];
      numvals = 0;
      counter = 0;
    }
    /**
     * add method for CustomerReviewArrayList that adds a value to the array at the 
     * next open index
     *
     * @param  e the review that is being added to the array.
     */
    public void add(CustomerReview e){
        //checks if the array has enough space to hold another value and
        //extending it if not
        if(numvals==reviews.length){
            int newsize = reviews.length+10;
           CustomerReview[] newreviews = new CustomerReview[newsize];
           for(int i=0;i<reviews.length;i++){
               newreviews[i]=reviews[i];
           }
           reviews = newreviews;
        }
        reviews[numvals]= e;
        numvals++;
    }
    /**
     * add method for CustomerReviewArrayList that adds a value to the array at the 
     * next open index
     *
     * @param  e the review that is being added to the array.
     */
    public void add(VIPCustomerReview e){
        //checks if the array has enough space to hold another value and
        //extending it if not
        if(numvals==reviews.length){
            int newsize = reviews.length+10;
           VIPCustomerReview[] newreviews = new VIPCustomerReview[newsize];
           for(int i=0;i<reviews.length;i++){
               newreviews[i]=vipReviews[i];
           }
           vipReviews = newreviews;
        }
        vipReviews[numvals]= e;
    }
    /**
     * add method for CustomerReviewArrayList that adds a review to the array at a specfic
     * index
     *
     * @param e the review that is being added to the array.
     * @param index the index of the array the review is being added to
     */
    public void add(int index, CustomerReview e){
        //checks if the array has enough space to hold another value and
        //extending it if not
       if(numvals==reviews.length){
            int newsize = reviews.length+10;
           CustomerReview[] newreviews = new CustomerReview[newsize];
           for(int i=0;i<reviews.length;i++){
               newreviews[i]=reviews[i];
           }
           reviews = newreviews;
        }
        //checks to see if the index where it is being added is 0
       if(reviews[index]!=null){
           //incriments the elements to make room for the one being addede
            for(int i=numvals;i>index;i--){
                reviews[i] = reviews[i-1];
            }
            reviews[index]= e;
            numvals++;
        }else{
            reviews[index] = e;
        }
    }
    /**
     * get method for CustomerReviewArrayList that gets a value of the array at a 
     * certain index
     *
     * @param e the review that is being added to the array.
     * @return the value at the index
     */
    public CustomerReview get(int index){
        //returns value of array at the index
        if(index>=0 && index<reviews.length){
        return reviews[index];
        }
        return null;
    }
    /**
     * clear method for CustomerReviewArrayList that clears the array 
     */
    public void clear(){
        //creates a new array object and resets value count
        reviews = new CustomerReview[10];
        numvals = 0;
    }
    /**
     * isEmpty method for CustomerReviewArrayList that checks if the array is empty
     * 
     * @return returns true if the array is empty and false if it is not
     */
    public boolean isEmpty(){
        //checks to see if each index is empty
       for(int i=reviews.length-1;i>=0;i--){
           if(reviews[i]!=null){
               return false;
           }
       }
       return true;
    }
    /**
     * remove method for CustomerReviewArrayList that removes a value from the array
     *
     * @param index the index for the value that is being removed
     * @return the value that is removed
     */
    public CustomerReview remove(int index){
        //stores the removed element if the index is within the length
        if(index>=0 && index<reviews.length){
        CustomerReview temp = reviews[index];
        //increments the values after the one that was removes
        numvals= numvals-1;
        for(int i=index;i<numvals;i++){
                reviews[i] = reviews[i+1];
                reviews[i+1]=null;
            }
        //checks and updates size of array if it is too large after removing
        emptyCount();
        return temp;
        }
        return null;
    }
    /**
     * size method for CustomerReviewArrayList that gets the number of elements in the
     * list
     *
     * @return the number of elements in the array
     */
    public int size(){
        //returns number of values in array
        return numvals;
    }
    /**
     * arraySize method for CustomerReviewArrayList that gets the size of the array
     *
     * @return the size of the array
     */
    public int arraySize(){
        //returns array length
        return reviews.length;
    }
    /**
     * emptyCount method for CustomerReviewArrayList that gets the number of empty spots 
     * in the array
     *
     * @return the number of empty spots in the array
     */
    public int emptyCount(){
        int count=0;
        //counts every emtpy space in the array
        for(int i=0;i<reviews.length;i++){
            if(reviews[i]==null){
                count= count +1;
            }
        }
        //makes the array smaller if the count exceeds 10
        
        if(count>10){
           CustomerReview[] newreviews = new CustomerReview[reviews.length-10];
           for(int i=0;i<newreviews.length;i++){
               newreviews[i]=reviews[i];
           }
           reviews = newreviews;
        }
        
        return count;
    }
    /**
     * toString method for CustomerReviewArrayList that converts the array into a string
     *
     * @return the array as a string
     */
    public String toString(){
        String list="";
        //loop that adds each element to the string
        for(int i=0;i<=numvals-1;i++){
            if(i==0){
                list = reviews[i].toString();
            }else{
                list = list + " , " + reviews[i].toString();
            }
          
        }
        return list;
    }
    /**
     * reset method for CustomerReviewArrayList that resets the internal private counter 
     * used in next method
     *
     */
    public void reset(){
        counter = 0;
    }
    /**
     * next method for CustomerReviewArrayList gets the next element in the array
     *
     * @return the next element in the array
     */
    public CustomerReview next(){
        //Throwing exception if counter is out of bounds
        if(counter>=reviews.length-1){
            new Exception("End of stored data is reached.");
        }
        CustomerReview store = reviews[counter];
        counter++;
        return store;
      }   
    /**
     * gets the sum of all the hashcodes of the objects in the array
     *
     * @return sum of array objects' hashcodes
     */
    @Override
    public int hashCode(){
        //setting a variable to hold sum of hashcodes
        int hashtemp=0;
        for(int i=0;i<numvals;i++){
            //adds each hashcode to the sum
            hashtemp = hashtemp + reviews[i].hashCode();
        }
        return hashtemp;
    }
    /**
     * checks if two arraylists are equal
     *
     * @param review review arraylist
     *
     * @return if the array lists are equal
     */
    @Override
    public boolean equals(Object review){
        //goes through each value and checks that it is equal to the corresponding review
        for(int i=0;i<numvals;i++){
            if(!reviews[i].equals(((CustomerReviewArrayList)review).get(i))){
                return false;
            }
        }
        return true;
    }
}
