

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/**
 * The test class for Wordlist
 *
 * @author Conrad Hahn
 * @version 3/4/2025
 */
public class WordListTest
{
    /**
     * Default constructor for test class WordListTest
     */
    public WordListTest()
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
     * Test for search method of WordList class
     *
     */
    @Test
    public void testSearch(){
        ArrayList<String> stopstest = new ArrayList<String>();
        String[] tokens = {"Hi","The","Test","Hello","World"};
        WordList wlist = new WordList(stopstest,tokens);
        //Testing a word I put in the list
        assertEquals(1,wlist.search("The"),"Test 1 Wrong");
        //testing the same word to make sure it gives the right index
        assertNotEquals(2,wlist.search("The"),"Test 2 Wrong");
        //search for word not in list expecting -1
        assertEquals(-1,wlist.search("Whats up"),"Test 3 Wrong");
    }
    /**
     * Test for getWordFrequency method of WordList class
     *
     */
    @Test
    public void testGetWordFrequency(){
        ArrayList<String> stopstest = new ArrayList<String>();
        stopstest.add("Hi");
        String[] tokens = {"Hi","The","Test"};
        WordList wlist = new WordList(stopstest,tokens);
        //testing if the .get method works with getWordFrequency
        assertEquals("The",wlist.getWordFrequency().get(0).getWord(),"Test 1 Wrong");
        //testing the opposite case and making sure the constructor is working
        assertNotEquals("Hi",wlist.getWordFrequency().get(0).getWord(),"Test 2 Wrong");
        ArrayList<String> stopstest2 = new ArrayList<String>();
        String[] tokens2 = {""};
        WordList wlist2 = new WordList(stopstest2,tokens2);
        //testing when the arraylist is empty
        assertEquals("",wlist2.getWordFrequency().get(0).getWord(),"Test 3 Wrong");
        
    }
    /**
     * Test for isStopWord method of WordList class
     *
     */
    @Test
    public void testIsStopWord(){
        ArrayList<String> stopstest = new ArrayList<String>();
        stopstest.add("Hi");
        String[] tokens = {"Hi","The","Test"};
        WordList wlist = new WordList(stopstest,tokens);
        //testing the base function to make sure it works seperately
        assertTrue(wlist.isStopWord("Hi",stopstest));
        //testing the function working in the constructor to remove stopwords when adding tokens to the list
        assertEquals("The",wlist.getWordFrequency().get(0).getWord(),"Test 2 Wrong");
        //test for opposite case and to ensure the stopword was removed
        assertNotEquals("Hi",wlist.getWordFrequency().get(1).getWord(),"Test 3 Wrong");
    }
    /**
     * Test for getMostFrequent method of WordList class
     *
     */
    @Test
    public void testGetMostFrequent(){
        ArrayList<String> stopstest = new ArrayList<String>();
        stopstest.add("Hi");
        String[] tokens = {"Hi","The","Test","Test","Test","Test","Test"};
        WordList wlist = new WordList(stopstest,tokens);
        //testing it against explicitly getting the frequency that we know is 5
        assertEquals(wlist.getWordFrequency().get(1).getFrequency(),wlist.getMostFrequent().getFrequency(),"Test 1 Wrong");
        //putting in explicit value we know is wrong to confirm opposite case
        assertNotEquals(2,wlist.getMostFrequent().getFrequency(),"Test 2 Wrong");
    }
    /**
     * Test for topkMostFrequent method of WordList class
     *
     */
    public void testTopKMostFrequent(){
        ArrayList<String> stopstest = new ArrayList<String>();
        stopstest.add("Hi");
        String[] tokens = {"Hi","The","The","The","Test","Test","Test","Test","Test"};
        WordList wlist = new WordList(stopstest,tokens);
        Word[] tester = new Word[2];
        tester[0]= new Word("Test");
        tester[1]= new Word("The");
        //testing it against explicitly getting the frequency that we know is 5
        assertEquals(tester,wlist.topKMostFrequent(2),"Test 1 Wrong");
        //putting in explicit value we know is wrong to confirm opposite case
        String[] test2 = {"Hi","The"};
        assertNotEquals(test2,wlist.topKMostFrequent(2),"Test 2 Wrong");
    }
    
    
    
}
