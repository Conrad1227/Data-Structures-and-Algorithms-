

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MyClassicPriorityQueueTest.
 *
 * @author  Conrad Hahn
 * @version 4/29/2025
 */
public class MyClassicPriorityQueueTest
{
    /**
     * Default constructor for test class MyClassicPriorityQueueTest
     */
    public MyClassicPriorityQueueTest()
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
     * Tests method decreaseKey of MyClassicPriorityQueue
     *
     */
    @Test
    public void testDecreaseKey() {
        MyClassicPriorityQueue<Integer> tester = new MyClassicPriorityQueue<>();
        //expecting null after calling on empty queue
        assertNull(tester.decreaseKey(5, 2));
        tester.add(5);
        //trying to input a value greater than the key expecting null 
        assertNull(tester.decreaseKey(5, 10));
        tester.add(10);
        tester.add(20);
        tester.add(30);
        //base case where the value is being decreased and returns value being decreased
        assertEquals(20, tester.decreaseKey(20, 2),"Test 1 Failed");
        //checking that this is now the new lowest value
        assertEquals(2, tester.peek(),"Test 2 Failed");
        tester.decreaseKey(30, 10);
        //decreasing a value and then making sure it is now on the map and the previous value is not 
        assertTrue(tester.getMap().containsKey(10));
        assertFalse(tester.getMap().containsKey(50));
    }
    
    /**
     * Tests methods add and poll of MyClassicPriorityQueue
     *
     */
    @Test
    public void testAddAndPoll() {
        MyClassicPriorityQueue<WeightedElement<Integer, Integer>> myTester = new MyClassicPriorityQueue<>();
        //poll for an empty queue should be null
        assertNull(myTester.poll());
        for(int i = 1 ; i<5 ; i++){
            myTester.add(new WeightedElement(i,i));
        }
        //size of queue should be length 4
        assertEquals(4,myTester.size(),"Test 1 failed");
        //first element of queue should be 1 since it was added first
        WeightedElement<Integer,Integer> val = myTester.poll();
        assertEquals("Value: 1 Weight: 1",val.toString(),"Test 2 Failed");
        //now the size should be one less
        assertEquals(3,myTester.size(),"Test 3 failed");
        //next value of poll should be 2 if added properly
        assertEquals("Value: 2 Weight: 2",myTester.poll().toString(),"Test 4 Failed");
        myTester.add(new WeightedElement(1,1));
        val = myTester.poll();
        //first value of queue should be 1 now after adding it
        assertEquals("Value: 1 Weight: 1",val.toString(),"Test 5 Failed");
    }
}
