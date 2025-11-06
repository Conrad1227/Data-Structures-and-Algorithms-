import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Tests the generic queue class
 *
 * @author  Conrad Hahn
 * @version 5/18/2025
 */
public class QueueTest
{
    /**
     * Default constructor for test class QueueTest
     */
    public QueueTest()
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
    
     @Test
    public void testQueue() {
        Queue<String> tester = new Queue<>();
        tester.enqueue("X");
        tester.enqueue("Y");
        //adding two values should result in a size of 2
        assertEquals(2, tester.size(), "Test 1 Failed");
        //first deque should return the first value added, X
        assertEquals("X", tester.dequeue(), "Test 2 failed");
        //next deque should remove the second value, Y
        assertEquals("Y", tester.dequeue(), "Test 3 failed");
        //queue should now be empty
        assertTrue(tester.isEmpty(), "Test 4 failed");
        //testing for integers
        Queue<Integer> tester2 = new Queue<>();
        tester2.enqueue(5);
        tester2.enqueue(6); 
        tester2.enqueue(7); 
        //Size of the stack should be 3 after adding 3 values
        assertEquals(3, tester2.size(), "Test 5 failed");
        //dequeue should remove the first value added, 5
        assertEquals(5, tester2.dequeue(), "Test 6 failed");
        //next deque should be the next value, 6
        assertEquals(6, tester2.dequeue(), "Test 7 failed");
        //the queue should not be empty
        assertFalse(tester2.isEmpty(), "Test 8 failed");
    }
}
