

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ByLengthAlphaWordTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ByLengthAlphaWordTest
{
    /**
     * Default constructor for test class ByLengthAlphaWordTest
     */
    public ByLengthAlphaWordTest()
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
    public void test(){
        ByLengthAlphaWord test = new ByLengthAlphaWord();
        String w1 = "B Apple C";
        String w2 = "C Banana P";
        assertEquals(-1,test.compare(w1,w2),"fail");
    }
}
