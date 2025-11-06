

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
/**
 * The test class FreqComparatorTest.
 *
 * @author  Conrad Hahn
 * @version 3/25/25
 */
public class FreqComparatorTest
{
    /**
     * Default constructor for test class FreqComparatorTest
     */
    public FreqComparatorTest()
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
     * Test method for compare method of FreqComparator
     */
     @Test
    public void testCompare() {
        Comparator<Word> comparator = new WordComparator();
        Word word0 = new Word("apple");
        Word word1 = new Word("apple");
        Word word2 = new Word("banana");
        Word word3 = new Word("pear");
        Word word4 = new Word("grape");
        Word word5 = new Word("arape");
        
        // Test 1: Different lengths
        assertTrue(comparator.compare(word1, word2) == 0); 
        // Test 2: Same length, different frequencies
        assertTrue(comparator.compare(word3, word4) < 0);
        // Test 3: Same length, same frequency, lexicographic order
        assertTrue(comparator.compare(word4, word5) < 0); 
    }
}
