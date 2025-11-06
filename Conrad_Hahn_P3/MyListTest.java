

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MyListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyListTest
{
    /**
     * Default constructor for test class MyListTest
     */
    public MyListTest()
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
     * tests all the methods of Mylist. These include add(for both at the end and at specific index), 
     * removeAt, numvals, isEmpty, and get
     */
    @Test
    public void testMyList(){
        MyList<String> tester = new MyList<>();
        //list should be empty 
        assertTrue(tester.isEmpty());
        // adding items at end of list
        tester.add("A");
        tester.add("B"); 
        //should no longer be empty
        assertFalse(tester.isEmpty());
        //size should be 2 since two values were added
        assertEquals(2, tester.numvals(), "Test 3 failed");
        //first element of list should be A since it was added first
        assertEquals("A", tester.get(0), "Test 4 failed");
        //next one should be B
        assertEquals("B", tester.get(1), "Test 5 failed");
        // remove at index expecting A
        assertEquals("A", tester.removeAt(0), "Test 6 failed");
        //expecting size now to be 1
        assertEquals(1, tester.numvals(), "Test 7 failed");
        //element 0 should now be B if shifted properly
        assertEquals("B", tester.get(0), "Test 8 failed");
        //testing for integers
        MyList<Integer> tester1 = new MyList<>();
        tester1.add(2);
        tester1.add(4);
        tester1.add(6);
        //adding basic values to end of the list expecting second one added to be at second index
        assertEquals(4,tester1.get(1),"Test 9 Failed");
        //testing that the number of values is correct
        assertEquals(3,tester1.numvals(),"Test 10 Failed");
        tester1.add(1,1);
        //testing after adding value to middle of list index 1 should be 1 now
        assertEquals(1,tester1.get(1),"Test 11 Failed");
        //testing if shifting right worked
        assertEquals(4,tester1.get(2),"Test 12 Failed");
        tester1.removeAt(2);
        //removing the value should mean it is no longer there expecting not equal
        assertNotEquals(1,tester1.get(2),"Test 13 Failed");
        //checking that it shifted the 6 back expecting 6 in original position
        assertEquals(6,tester1.get(2),"Test 14 Failed");
        //removing the first element testing if the rest shift down
        tester1.removeAt(0);
        assertEquals(1,tester1.get(0),"Test 15 Failed");
        
    }
}
