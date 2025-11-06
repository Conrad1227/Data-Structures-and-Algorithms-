
/**
 * Write a description of class CustomerReview here.
 *
 * @author  Conrad Hahn
 * @version 2/18/2025
 */
public class CustomerReview
{
    // instance variables - replace the example below with your own
    private String customerName;
    private String latestReview;
    /**
     * Constructor for objects of class CustomerReview
     */
    public CustomerReview(String customerName, String latestReview){
        this.customerName = customerName;
        this.latestReview = latestReview;
    }
    /**
     * Returns customer name
     * 
     * @return customerName
     */
    public String getCustomerName(){
        return customerName;
    }
    /**
     * Gets customers latest review
     * 
     * @return lastestReview
     */
    public String getLatestReview(){
        return latestReview;
    }
    /**
     * Checks if a certain name for a customer review is the same as another
     * 
     * @return true if the names match, false if not
     */
    @Override
    public boolean equals(Object customerNameCheck){
        if(customerNameCheck instanceof CustomerReview){ 
        CustomerReview namecheck = (CustomerReview) customerNameCheck;
        return namecheck.getCustomerName().equals(customerName);
        }else {
        return false;
        }
    }
    /**
     * gets hash code of the review 
     * 
     * @return true if the names match, false if not
     */
    @Override
    public int hashCode(){
        return customerName.hashCode();
    }
    /**
     * turns the review into a string
     * 
     * @return the review as a string
     */
    public String toString(){
        String output = "Name: " + customerName + " Review: " + latestReview;
        return output;
    }
}
