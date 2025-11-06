

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WeightedElementTest.
 *
 * @author Conrad Hahn
 * @version 4/29/2025
 */
public class WeightedElementTest
{
    /**
     * Default constructor for test class WeightedElementTest
     */
    public WeightedElementTest()
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
     * Tests the constructors and basic methods of the WeightedElement class
     */
     @Test
    public void testWeightedElement() {
        WeightedElement<String, Integer> tester1 = new WeightedElement<>("Apple",2);
        //testing the constructor to see if object has correct values and weight
        assertEquals("Apple", tester1.getVal(),"Test 1 Failed");
        assertEquals(1, tester1.getWeight(),"Test 2 Failed");
        WeightedElement<String, Integer> tester2 = new WeightedElement<>("Banana", 2);
        //testing compareTo for two elements with the same weight
        assertEquals(0, tester1.compareTo(tester2),"Test 3 Failed");
        WeightedElement<String, Integer> tester3 = new WeightedElement<>("Carrot", 3);
        //tests compareTo for an element with a lower weight
        assertTrue(tester1.compareTo(tester3) < 0);
        WeightedElement<String, Integer> tester4 = new WeightedElement<>("Desert", 1);
        //tests compareTo for an element with a higher weight
        assertTrue(tester1.compareTo(tester4) > 0);
        //tests toString method
        assertEquals("Value: Desert Weight: 1", tester4.toString(),"Test 1 Failed");
    
        WeightedElement<Object, Integer> tester5 = new WeightedElement<>(null, 99);
        //tests element with null value as well as its weight
        assertNull(tester5.val);
        assertEquals(99, tester5.getWeight(),"Test 4 Failed");
        WeightedElement<String, String> tester6 = new WeightedElement<>("Apple", "A");
        WeightedElement<String, String> tester7 = new WeightedElement<>("Banana", "B");
        //tests weights as strings, a is less than b so expecting negative value
        assertTrue(tester6.compareTo(tester7) < 0);
    }
}
