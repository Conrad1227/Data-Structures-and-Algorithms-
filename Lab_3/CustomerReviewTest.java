

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CustomerReviewTest.
 *
 * @author  Conrad Hahn
 * @version 2/18/2025
 */
public class CustomerReviewTest
{
    /**
     * Default constructor for test class CustomerReviewTest
     */
    public CustomerReviewTest()
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
    }
    /**
     * Tests getCustomerName method of CustomerReview
     *
     */
    @Test
    public void testGetCustomerName(){
        //tests basic case expecting "Bob"
        CustomerReview test1 = new CustomerReview("Bob","It was bad");
        assertEquals("Bob",test1.getCustomerName(),"Test 1 Wrong");
        //tests basic opposite not equal case
        CustomerReview test2 = new CustomerReview("Sally","It was bad");
        assertNotEquals("Bob",test2.getCustomerName(),"Test 2 Wrong");
        //tests weird case where name is left blank
        CustomerReview test3 = new CustomerReview("","It was bad");
        assertEquals("",test3.getCustomerName(),"Test 3 Wrong");
        //tests weird case where name is different numbers and characters
        CustomerReview test4 = new CustomerReview("20,1203211399,..2..","It was bad");
        assertEquals("20,1203211399,..2..",test4.getCustomerName(),"Test 4 Wrong");
    }
    @Test
    public void testGetLatestReview(){
        //tests basic case expecting "It was bad"
        CustomerReview test1 = new CustomerReview("Bob","It was bad");
        assertEquals("It was bad",test1.getLatestReview(),"Test 1 Wrong");
        //tests basic opposite not equal case
        CustomerReview test2 = new CustomerReview("Sally","It was bad");
        assertNotEquals("It was good",test2.getLatestReview(),"Test 2 Wrong");
        //tests weird case where name is left blank
        CustomerReview test3 = new CustomerReview("Bob","");
        assertEquals("",test3.getLatestReview(),"Test 3 Wrong");
        //tests weird case where name is different numbers and characters
        CustomerReview test4 = new CustomerReview("Sally","20,1203211399,..2..");
        assertEquals("20,1203211399,..2..",test4.getLatestReview(),"Test 4 Wrong");
    }
    /**
     * Tests equals method of CustomerReview
     *
     */
    @Test
    public void testEquals(){
        CustomerReview test1 = new CustomerReview("Bob","It was bad");
        CustomerReview test2 = new CustomerReview("Sally","It was bad");
        CustomerReview test3 = new CustomerReview("Bob","It was bad");
        //basic test where we expect true
        assertTrue(test1.equals(test3));
        //basic test where we expect false
        assertFalse(test1.equals(test2));
    }
    /**
     * Tests hashCode method of CustomerReview
     *
     */
    @Test
    public void testHashCode(){
        //Im not sure how to get the hash code without using my method
    }
    /**
     * Tests toString method of CustomerReview
     *
     */
    @Test
    public void testToString(){
        //tests basic case expecting "It was bad"
        CustomerReview test1 = new CustomerReview("Bob","It was bad");
        assertEquals("Name: Bob Review: It was bad",test1.toString(),"Test 1 Wrong");
        //tests basic opposite not equal case
        CustomerReview test2 = new CustomerReview("Sally","It was bad");
        assertNotEquals("Name: Bob Review: It was bad",test2.toString(),"Test 2 Wrong");
        //tests weird case where name is left blank
        CustomerReview test3 = new CustomerReview("Bob","");
        assertEquals("Name: Bob Review: ",test3.toString(),"Test 3 Wrong");
        //tests weird case where name is different numbers and characters
        CustomerReview test4 = new CustomerReview("feiifweojo..12..21.1.2","20,1203211399,..2..");
        assertEquals("Name: feiifweojo..12..21.1.2 Review: 20,1203211399,..2..",test4.toString(),"Test 4 Wrong");
    }
}
