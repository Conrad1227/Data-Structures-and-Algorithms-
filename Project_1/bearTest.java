

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class bearTest and methods in Animal Class
 *
 * @author  Conrad Hahn
 * @version 2/17/2025
 */
public class bearTest
{
    /**
     * Default constructor for test class bearTest
     */
    public bearTest()
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
     * Tests ageUp of Bear class and getAge of Animal class
     */
    @Test
    public void testAgeUpAndGetAge(){
        //intialize new Bear to test
        Bear bearTest = new Bear(1,1);
        //increment the Bear's age and then check if it is right
        assertEquals(1,bearTest.getAge(),"Wrong");
        bearTest.ageUp();
        assertEquals(2,bearTest.getAge(),"Wrong");
        bearTest.ageUp();
        assertEquals(3,bearTest.getAge(),"Wrong");
        bearTest.ageUp();
        assertNotEquals(3,bearTest.getAge(),"Wrong");
        assertTrue(bearTest.ageUp());
        assertEquals(5,bearTest.getAge(),"Wrong");
        assertTrue(bearTest.ageUp());
        //set bear with max age and test if it can be increased expecting false
        Bear bearTest2 = new Bear(999999,1);
        assertFalse(bearTest2.ageUp());
    }
    /**
     * Tests maxAge of Bear class and getGender of Animal class
     */
    @Test
    public void testMaxAgeAndGetGender(){
        //intialize new Bear to test
        Bear bearTest1 = new Bear(5,1);
        Bear bearTest2 = new Bear(10,0);
        Bear bearTest3 = new Bear(2,2);
        Bear bearTest4 = new Bear(9999999,999999);
        //test if the Bear is max age based on what was input and the gender
        assertFalse(bearTest1.maxAge());
        assertEquals('M',bearTest1.getGender(),"Wrong");
        assertTrue(bearTest2.maxAge());
        assertEquals('F',bearTest2.getGender(),"Wrong");
        assertFalse(bearTest3.maxAge());
        assertEquals('M',bearTest3.getGender(),"Wrong");
        assertTrue(bearTest4.maxAge());
        assertNotEquals('F',bearTest4.getGender(),"Wrong");
    }
    /**
     * Tests toString method of the Animal class using a Bear
     */
    @Test
    public void testToString(){
        //intialize new Bear to testing
        Bear bearTest1 = new Bear(5,1);
        Bear bearTest2 = new Bear(10,0);
        Bear bearTest3 = new Bear(2,2);
        Bear bearTest4 = new Bear(9999999,999999);
        Bear bearTest5 = new Bear(1,-1);
        Bear bearTest6 = new Bear(0,0);
        //check the toString outputs match what is expected
        assertEquals("M5",bearTest1.toString(),"Wrong");
        assertEquals("F9",bearTest2.toString(),"Wrong");
        assertEquals("M2",bearTest3.toString(),"Wrong");
        assertNotEquals("F0",bearTest4.toString(),"Wrong");
        assertEquals("M1",bearTest5.toString(),"Wrong");
        assertEquals("F0",bearTest6.toString(),"Wrong");
    }
    /**
     * Tests the getUpdated, updatedSetTrue, and updatedSetFalse methods of the Animal class
     */
    @Test
    public void testUpdates(){
        //intialize new Bear to test
        Bear bearTest1 = new Bear(5,1);
        Bear bearTest2 = new Bear(10,0);
        Bear bearTest3 = new Bear(2,2);
        Bear bearTest4 = new Bear(9999999,999999);
        Bear bearTest5 = new Bear(1,-1);
        Bear bearTest6 = new Bear(0,0);
        //set half the Bear's updated to false and half to true
        bearTest1.updatedSetTrue();
        bearTest2.updatedSetFalse();
        bearTest3.updatedSetTrue();
        bearTest4.updatedSetFalse();
        bearTest5.updatedSetTrue();
        bearTest6.updatedSetFalse();
        assertTrue(bearTest1.getUpdated());
        assertFalse(bearTest2.getUpdated());
        assertTrue(bearTest3.getUpdated());
        assertFalse(bearTest4.getUpdated());
        assertNotEquals(false,bearTest5.getUpdated(),"Wrong");
        assertNotEquals(true,bearTest6.getUpdated(),"Wrong");
    }
}
