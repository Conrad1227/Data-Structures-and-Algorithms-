

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
/**
 * The test class WordComparatorTest.
 *
 * @author  Conrad Hahn
 * @version 3/25/25
 */
public class WordComparatorTest
{
    /**
     * Default constructor for test class WordComparatorTest
     */
    public WordComparatorTest()
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
     * Test method for compare method of LengthComparator
     */
    @Test
    public void testCompare() {
        Comparator<Word> comparator = new LengthComparator();
        Word word1 = new Word("apple");
        Word word2 = new Word("banana");
        Word word3 = new Word("pear");
        Word word4 = new Word("grape");
        Word word5 = new Word("grape");
        //Testing Different lengths expecting banana to be longer than apple
        assertTrue(comparator.compare(word1, word2) < 0);
        //Same length, lexicographic order expecting pear to come before grape
        assertTrue(comparator.compare(word3, word4) < 0);
        //Equal words expecting 0
        assertEquals(0, comparator.compare(word4, word5)); 
    }
}
