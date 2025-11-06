
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CustomArrayListTest.
 *
 * @author  Conrad Hahn
 * @version 4/9/2025
 */
public class CustomArrayListTest
{
    /**
     * Default constructor for test class CustomArrayListTest
     */
    public CustomArrayListTest()
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
     * Tests the addToBack method of CustomArrayList
     *
     */
    @Test
    public void testAddToBack(){
        CustomArrayList<Integer> tester = new CustomArrayList<>();
        tester.addToBack(3);
        //basic adding one value to list test
        assertEquals(" 3",tester.toString(),"Test 1 Fail");

        for(int i = 1 ; i<=7 ; i++){
            tester.addToBack(i);
        }
        //testing that the list increased its size to make room for more ints
        assertNotEquals("3 1 2 3 4 5" , tester.toString(),"Test 2 Fail");
        //adding five more values expecting 8 integers assuring the grow is working in addToBack
        assertEquals(8,tester.arraySize(),"Test 3 Fail");
        //Expecting list of all 8 integers added 
        assertEquals(" 3 1 2 3 4 5 6 7",tester.toString(),"Test 4 Fail");
        //Boundry case with empty list expecting toString to be empty
        CustomArrayList<Integer> tester2 = new CustomArrayList<>();
        assertEquals("",tester2.toString(),"Test 5 Fail");

    }
}
