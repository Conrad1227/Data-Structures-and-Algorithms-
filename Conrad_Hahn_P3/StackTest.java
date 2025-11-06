

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the methods of the Stack class
 *
 * @author  Conrad Hahn
 * @version 5/18/2025
 */
public class StackTest
{
    /**
     * Default constructor for test class testerTest
     */
    public StackTest()
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
     * Tests the methods of the Stack class which are, pop, peek, push,
     * isEmpty, and size
     *
     */
    @Test
    public void testStack() {
        Stack<Integer> tester = new Stack<>();
        tester.push(1);
        tester.push(2); 
        //Size of the stack should be 2 after adding 2 values
        assertEquals(2, tester.size(), "Test 1 failed");
        //peeking should return the last value added, so 2
        assertEquals(2, tester.peek(), "Test 2 failed");
        //pop should remove the last value added, also 2
        assertEquals(2, tester.pop(), "Test 3 failed");
        //next pop should be the  next value, 1
        assertEquals(1, tester.pop(), "Test 4 failed");
        //now the stack should be empty
        assertTrue(tester.isEmpty(), "Test 5 failed");
        //testing for Strings
        Stack<String> tester2 = new Stack<>();
        tester2.push("A");
        tester2.push("B"); 
        tester2.push("C"); 
        //Size of the stack should be 3 after adding 3 values
        assertEquals(3, tester2.size(), "Test 6 failed");
        //peeking should return the last value added, so C
        assertEquals("C", tester2.peek(), "Test 7 failed");
        //pop should remove the last value added, also C
        assertEquals("C", tester2.pop(), "Test 8 failed");
        //next pop should be the  next value, B
        assertEquals("B", tester2.pop(), "Test 9 failed");
        //the stack should not be empty
        assertFalse(tester2.isEmpty(), "Test 10 failed");
    }
}
