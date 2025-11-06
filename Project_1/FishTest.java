

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * testclass for Fish class and methods in Animal class
 *
 * @author  Conrad Hahn
 * @version 2/17/2025
 */
public class FishTest
{
    /**
     * Default constructor for test class FishTest
     */
    public FishTest()
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
     * Tests ageUp of Fish class and getAge of Animal class
     */
    @Test
    public void testAgeUpAndGetAge(){
        //intialize new fish to test
        Fish fishTest = new Fish(1,1);
        //increment the fish's age and then check if it is right
        assertEquals(1,fishTest.getAge(),"Wrong");
        fishTest.ageUp();
        assertEquals(2,fishTest.getAge(),"Wrong");
        fishTest.ageUp();
        assertEquals(3,fishTest.getAge(),"Wrong");
        fishTest.ageUp();
        assertNotEquals(3,fishTest.getAge(),"Wrong");
        assertTrue(fishTest.ageUp());
        assertEquals(5,fishTest.getAge(),"Wrong");
        assertFalse(fishTest.ageUp());
    }
    /**
     * Tests maxAge of Fish class and getGender of Animal class
     */
    @Test
    public void testMaxAgeAndGetGender(){
        //intialize new fish to test
        Fish fishTest1 = new Fish(5,1);
        Fish fishTest2 = new Fish(10,0);
        Fish fishTest3 = new Fish(2,2);
        Fish fishTest4 = new Fish(9999999,999999);
        //test if the fish is max age based on what was input and the gender
        assertTrue(fishTest1.maxAge());
        assertEquals('M',fishTest1.getGender(),"Wrong");
        assertTrue(fishTest2.maxAge());
        assertEquals('F',fishTest2.getGender(),"Wrong");
        assertFalse(fishTest3.maxAge());
        assertEquals('M',fishTest3.getGender(),"Wrong");
        assertTrue(fishTest4.maxAge());
        assertNotEquals('F',fishTest4.getGender(),"Wrong");
    }
    /**
     * Tests toString method of the Animal class using a fish
     */
    @Test
    public void testToString(){
        //intialize new fish to testing
        Fish fishTest1 = new Fish(5,1);
        Fish fishTest2 = new Fish(10,0);
        Fish fishTest3 = new Fish(2,2);
        Fish fishTest4 = new Fish(9999999,999999);
        Fish fishTest5 = new Fish(1,-1);
        Fish fishTest6 = new Fish(0,0);
        //check the toString outputs match what is expected
        assertEquals("M5",fishTest1.toString(),"Wrong");
        assertEquals("F5",fishTest2.toString(),"Wrong");
        assertEquals("M2",fishTest3.toString(),"Wrong");
        assertNotEquals("F0",fishTest4.toString(),"Wrong");
        assertEquals("M1",fishTest5.toString(),"Wrong");
        assertEquals("F0",fishTest6.toString(),"Wrong");
    }
    /**
     * Tests the getUpdated, updatedSetTrue, and updatedSetFalse methods of the Animal class
     */
    @Test
    public void testUpdates(){
        //intialize new fish to test
        Fish fishTest1 = new Fish(5,1);
        Fish fishTest2 = new Fish(10,0);
        Fish fishTest3 = new Fish(2,2);
        Fish fishTest4 = new Fish(9999999,999999);
        Fish fishTest5 = new Fish(1,-1);
        Fish fishTest6 = new Fish(0,0);
        //set half the fish's updated to false and half to true
        fishTest1.updatedSetTrue();
        fishTest2.updatedSetFalse();
        fishTest3.updatedSetTrue();
        fishTest4.updatedSetFalse();
        fishTest5.updatedSetTrue();
        fishTest6.updatedSetFalse();
        assertTrue(fishTest1.getUpdated());
        assertFalse(fishTest2.getUpdated());
        assertTrue(fishTest3.getUpdated());
        assertFalse(fishTest4.getUpdated());
        assertNotEquals(false,fishTest5.getUpdated(),"Wrong");
        assertNotEquals(true,fishTest6.getUpdated(),"Wrong");
    }
}
