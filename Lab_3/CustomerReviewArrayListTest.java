

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CustomerReviewArrayListTest.
 *
 * @author  Conrad Hahn
 * @version 2/11/2025
 */
public class CustomerReviewArrayListTest
{
    CustomerReviewArrayList tester = new CustomerReviewArrayList();
    /**
     * Default constructor for test class CustomerReviewArrayListTest
     */
    public CustomerReviewArrayListTest()
    {
    }
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        tester.clear();
    }
    /**
     * Test method for testing the add, getReview, and getCustomerName methods of the CustomerReviewArrayList 
     * class. 
     */
    @Test
    public void testAddAndGet(){
        //tests basic case of adding new object to first open spot on list which in this case is index 0
        CustomerReview review0 = new CustomerReview("Bob","It was bad");
        CustomerReview review1 = new CustomerReview("Max","It was good");
        CustomerReview review2 = new CustomerReview("Sally","I enjoyed it");
        tester.add(review0);
        assertEquals(review0,tester.get(0),"Test 1 Wrong");
        //testing adding review to next open spot when there already is one in the array
        //expecting the next review to be in index 1
        tester.add(review1);
        assertEquals(review1,tester.get(1),"Test 2 Wrong");
        tester.add(0,review2);
        //adding review2 to first index and making sure it moved review0 to make space
        assertNotEquals(review0,tester.get(0),"Test 3 Wrong");
        //checking that review 0 was moved correctly
        assertEquals(review0,tester.get(1),"Test 4 Wrong");
    }
    /**
     * Test method for testing the Clear and Empty methods of the CustomerReviewArrayList
     * class.
     */
    @Test
    public void testClearAndEmpty(){
        CustomerReview review0 = new CustomerReview("Bob","It was bad");
        CustomerReview review1 = new CustomerReview("Max","It was good");
        CustomerReview review2 = new CustomerReview("Sally","I enjoyed it");
        tester.add(review0);
        tester.add(review1);
        tester.add(review2);
        //adding three reviews to a new array list expecting false since it is no longer empty
        assertEquals(false,tester.isEmpty(),"Test 1 Wrong");
        //testing if the opposite test works
        assertNotEquals(true,tester.isEmpty(),"Test 2 Wrong");
        tester.clear();
        // clearing the array and then testing if the opposite is true in both cases
        assertEquals(true,tester.isEmpty(),"Test 3 Wrong");
        assertNotEquals(false,tester.isEmpty(),"Test 4 Wrong");
    }
    /**
     * Test method for testing the Remove method of the CustomerReviewArrayList. 
     */
    @Test
    public void testRemove(){
        CustomerReview review0 = new CustomerReview("Bob","It was bad");
        CustomerReview review1 = new CustomerReview("Max","It was good");
        CustomerReview review2 = new CustomerReview("Sally","I enjoyed it");
        tester.add(review0);
        tester.add(review1);
        tester.add(review2);
        //adding default values to array
        assertEquals(review0,tester.remove(0),"Test 1 Wrong");
        //testing that the index was replaced with the next value
        assertEquals(review1,tester.get(0),"Test 2 Wrong");
        //test for opposite case
        assertNotEquals(review2,tester.remove(0),"Test 3 Wrong");
        //making sure review1 isnt still there
        assertNotEquals(review1,tester.get(0),"Test 4 Wrong");
        //making sure a border case doesnt break the method expecting null
        assertEquals(null,tester.remove(99999999),"Test 5 Wrong");
    }
     /**
     * Test method for testing the Size and ArraySize methods of the 
     * CustomerReviewArrayList class. 
     */
    @Test
    public void testSizeAndArraySize(){
        CustomerReview review = new CustomerReview("Bob","It was bad");
        for(int i=0;i<=95;i++){
            tester.add(review);
        }
        //adding a large number of objects to array
        int checker = tester.size();
        //checking the number we added is equal to the numvals of tester
        assertEquals(checker,96,"Test 1 Wrong");
        
        checker = tester.arraySize();
        //checking the arraysize is equal to a multiple a 10 greater than numvals
        assertEquals(checker,100,"Test 2 Wrong");
        tester.clear();
        
        for(int i=0;i<=9995;i++){
            tester.add(review);
        }
        
        //adding a larger number of objects - border case
        checker = tester.size();
        //checking that the number we added is the same as the numvals of tester
        assertEquals(checker,9996,"Test 3 Wrong");
        
        checker = tester.arraySize();
        //checking the arraysize is equal to a multiple a 10 greater than numvals
        assertEquals(checker,10000,"Test 4 Wrong");
        tester.clear();
        
        //adding a single object as a more normal case
        tester.add(review);
        
        checker = tester.size();
        //checking that the number we added is the same as the numvals of tester expecting false from guess of 2
        assertNotEquals(checker,2,"Test 5 Wrong");
        //checking the array is still default size expecting 10
        checker = tester.arraySize();
        assertEquals(checker,10,"Test 6 Wrong");
    }
     /**
     * Test method for testing the EmptyCount method of the CustomerReviewArrayList
     * class.
     */
    @Test
    public void testEmptyCount(){
        CustomerReview review = new CustomerReview("Bob","It was bad");
        for(int i=0;i<=5;i++){
            tester.add(review);
        }
        int checker = tester.emptyCount();
        // added 6 objects to array (0,1,2,3,4,5) expecting 4 when calling emptycount
        assertEquals(checker,4,"Test 1 Wrong");
        tester.clear();
        
        for(int i=0;i<=12;i++){
            tester.add(review);
        }
        //added 13 objects making sure the array is adding extra space properly - expecting 7
        checker = tester.emptyCount();
        assertEquals(checker,7,"Test 2 Wrong");
        //testing opposite case
        
        assertNotEquals(checker,9,"Test 3 Wrong");
        
        for(int i=0;i<=4;i++){
            tester.remove(1);
        }
        //removed 5 objects leaving 8 left, expecting 2
        assertEquals(2,tester.emptyCount(),"Test 4 Wrong");
    }
     /**
     * Test method for testing the toString method of the CustomerReviewArrayList
     * class.
     */
    @Test
    public void testToString(){
        CustomerReview review0 = new CustomerReview("Bob","It was bad");
        CustomerReview review1 = new CustomerReview("Max","It was good");
        CustomerReview review2 = new CustomerReview("Sally","I enjoyed it");
        tester.add(review0);
        tester.add(review1);
        tester.add(review2);
        //testing toString where the string should be each review seperated by a comma
        assertEquals("Name: Bob Review: It was bad , Name: Max Review: It was good , Name: Sally Review: I enjoyed it",tester.toString(),"Test 1 Wrong");
    }
     /**
     * Test method for testing the next and reset methods of the CustomerReviewArrayList
     * class.
     */
    @Test 
    public void testNextAndReset(){
        CustomerReview review0 = new CustomerReview("Bob","It was bad");
        CustomerReview review1 = new CustomerReview("Max","It was good");
        CustomerReview review2 = new CustomerReview("Sally","I enjoyed it");
        tester.add(review0);
        tester.add(review1);
        tester.add(review2);
        //should get first object in the array
        assertEquals(review0,tester.next(),"Test 1 Wrong");
        //ensure the counter is incimenting and not getting same object
        assertNotEquals(review0,tester.next(),"Test 2 Wrong");
        //getting the third object in the array
        assertEquals(review2,tester.next(),"Test 3 Wrong");
        for(int i=0;i<7;i++){
            tester.next();
        }
        boolean error=false;
        try{
        tester.next();
        }catch(Exception e){
        error=true;
        }
        //testing that the method throws error when it should
        assertTrue(error);
        tester.reset();
        // tests that the reset function bring count back to 0
        assertEquals(review0,tester.next(),"Test 4 Wrong");
        
    }
    /**
     * Testing the equals method of the CustomerReviewArrayList class
     */
    @Test
    public void testEquals(){
        CustomerReviewArrayList tester2 = new CustomerReviewArrayList();
        CustomerReviewArrayList tester3 = new CustomerReviewArrayList();
        CustomerReview review0 = new CustomerReview("Bob","It was bad");
        CustomerReview review1 = new CustomerReview("Bob","It was good");
        CustomerReview review2 = new CustomerReview("Bob","I enjoyed it");
        tester.add(review0);
        tester.add(review1);
        tester.add(review2);
        tester2.add(review0);
        tester2.add(review1);
        tester2.add(review2);
        //adds three objects with the same name to each array
        //check that they are equal
        assertTrue(tester.equals(tester2));
        //check with VIPcustomer review expecting false
        VIPCustomerReview review4 = new VIPCustomerReview("Bob","It was bad");
        VIPCustomerReview review5 = new VIPCustomerReview("Bob","It was good");
        VIPCustomerReview review6 = new VIPCustomerReview("Bob","I enjoyed it");
        tester3.add(review4);
        tester3.add(review5);
        tester3.add(review6);
        assertFalse(tester.equals(tester3));
        
        //add a different reviewer to one of the lists
        CustomerReview review3 = new CustomerReview("Steve","I hate it");
        tester.add(review3);
        assertFalse(tester.equals(tester2));
        
        
        
        
    }
    /**
     * Testing the hashCode method of the CustomerReviewArrayList class
     */
    @Test 
    public void testHashCode(){
        CustomerReview review0 = new CustomerReview("Bob","It was bad");
        CustomerReview review1 = new CustomerReview("Max","It was good");
        CustomerReview review2 = new CustomerReview("Sally","I enjoyed it");
        tester.add(review0);
        tester.add(review1);
        tester.add(review2);
        int sum = review0.hashCode();
        sum = sum+ review1.hashCode();
        sum = sum+ review2.hashCode();
        //adding hashcodes manually using hashCode of CustomerReview class then comparing that with output of hashCode function of CustomerReviewArrayList
        assertEquals(sum,tester.hashCode(),"Test 1 Wrong");
        tester.clear();
        //when array is empty expecting hash code of 0
        assertEquals(0,tester.hashCode(),"Test 2 Wrong");
        tester.add(review2);
        //adding one review to make sure it isnt adding the same hashCode each time
        assertNotEquals(review1.hashCode(),tester.hashCode(),"Test 3 Wrong");
        
    }
}
