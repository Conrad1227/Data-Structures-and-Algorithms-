

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/**
 * The test class MainTest.
 *
 * @author  Conrad Hahn
 * @version 3/4/2025
 */
public class MainTest
{
    /**
     * Default constructor for test class MainTest
     */
    public MainTest()
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
     * Tests case for the distinctWordsCount in Main
     *
     */
    @Test 
    public void testDistinctWordsCount(){
        String[] test = {"The","Hi","Hello","Test","The","The","The"};
        //Making sure method doesnt count every string testing 7 expecting no equals
        assertNotEquals(7,Main.distinctWordsCount(test),"Test 1 Wrong");
        //Testing the correct case expecting 4
        assertEquals(4,Main.distinctWordsCount(test),"Test 2 Wrong");
        String[] test2 = new String[5];
        //testing a string of size 5 that is empty expecting 1 for the null value only
        assertEquals(1,Main.distinctWordsCount(test2),"Test 3 Wrong");
    }
    /**
     * Tests case for the shortWordsCount in Main
     *
     */
    @Test 
    public void testShortWordsCount(){
        String[] test = {"The","Hi","Hello","Test","The","The","The"};
        //testing counter for distinct words length 3 on test string array with repeats expecting 2
        assertEquals(2,Main.shortWordsCount(test,3),"Test 1 Wrong");
        String[] test2 = {"Hello","World","Testing","Computer","Science"};
        //Testing for when string only has words greater than given length expecting 2
        assertEquals(0,Main.shortWordsCount(test2,3),"Test 2 Wrong");
        String[] test3 = {"Test","Test","Test","Test"};
        //Testing repeats in an array and making sure it does not equal 
        assertNotEquals(4,Main.shortWordsCount(test3,1),"Test 3 Wrong");
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
		Main.shortWordsCount(test3,-1);
	});
	assertEquals("Threshold cannot be negative", illegalArgumentException.getMessage());
    }
    /**
     * Tests case for the mostFrequentByLetter in Main
     *
     */
    @Test 
    public void testMostFrequentByLetter(){
        ArrayList<String> stopstest = new ArrayList<String>();
        stopstest.add("Hi");
        String[] tokens = {"Hi","The","Test","The","The","Test","The",};
        WordList testlist = new WordList(stopstest,tokens);
        //Basic test to find the most frequent word start with T expecting The
        assertEquals("The",Main.mostFrequentByLetter(testlist,'T').getWord(),"Test 1 Wrong");
        //Testing when no words in the list start with the letter expecting null
        assertEquals(null,Main.mostFrequentByLetter(testlist,'G'),"Test 2 Wrong");
        String[] tokens2 = {"The","Test","The","Test"};
        WordList testlist2 = new WordList(stopstest,tokens2);
        //test for when two words have the same frequency expecting first one to appear, so The
        assertEquals("The",Main.mostFrequentByLetter(testlist,'T').getWord(),"Test 3 Wrong");
        //Test is the case to prove case matters expecting null from list 2
        assertEquals(null,Main.mostFrequentByLetter(testlist,'t'),"Test 3 Wrong");
    }
}
