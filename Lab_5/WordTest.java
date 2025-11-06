import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The test class for Word
 *
 * @author Conrad Hahn
 * @version 3/4/2025
 */
public class WordTest
{
    /**
     * Default constructor for test class WordTest
     */
    public WordTest()
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
     * Test for getWord method of Word class
     *
     */
    @Test
    public void testGetWord(){
        Word test1 = new Word("Tester");
        Word test2 = new Word("99999999999999999999999");
        Word test3 = new Word("");
        assertEquals("Tester",test1.getWord(),"Test 1 Wrong");
        assertEquals("99999999999999999999999",test2.getWord(),"Test 2 Wrong");
        assertNotEquals("Hello World",test3.getWord(),"Test 3 Wrong");
    }
    /**
     * Test for getFrequency and increment method of Word class
     *
     */
    @Test
    public void testGetFrequencyAndIncrement(){
        Word test1 = new Word("Tester");
        assertEquals(1,test1.getFrequency(),"Test 1 Wrong");
        test1.increment();
        assertNotEquals(1,test1.getFrequency(),"Test 2 Wrong");
        assertEquals(2,test1.getFrequency(),"Test 3 Wrong");
        for(int i=0;i<10000;i++){
            test1.increment();
        }
        assertEquals(10002,test1.getFrequency(),"Test 4 Wrong");
    }
    /**
     * Test for toString method of Word class
     *
     */
    @Test
    public void testToString(){
        Word test1 = new Word("Tester");
        Word test2 = new Word("99999999999999999999999");
        Word test3 = new Word("");
        test2.increment();
        for(int i=0;i<10000;i++){
            test1.increment();
        }
        assertEquals("Word: Tester Frequency: 10001",test1.toString(),"Test 1 Wrong");
        assertEquals("Word: 99999999999999999999999 Frequency: 2",test2.toString(),"Test 2 Wrong");
        assertNotEquals("Word: Hello World Frequency: 5",test3.toString(),"Test 3 Wrong");
    }
    /**
     * Test for compareTo method of Word class
     *
     */
    @Test
    public void testCompareTo(){
        Word test1 = new Word("Tester");
        Word test2 = new Word("99999999999999999999999");
        Word test3 = new Word("");
        Word test4 = new Word("Hello World");
        test2.increment();
        test3.increment();
        for(int i=0;i<10000;i++){
            test1.increment();
        }
        assertNotEquals(2,test1.compareTo(test2),"Test 1 Wrong");
        assertEquals(0,test2.compareTo(test3),"Test 2 Wrong");
        assertEquals(-1,test3.compareTo(test4),"Test 3 Wrong");
    }
}
