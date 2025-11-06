import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AVLTreeTest.
 *
 * @author  Conrad Hahn
 * @version 4/22/2025
 */
public class AVLTreeTest
{
    /**
     * Default constructor for test class AVLTreeTest
     */
    public AVLTreeTest()
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
     * Tests the insert method of AVLTree which also uses balance so that is being tested as well.
     * Balance also uses the getHeight and getBF methods which are being tested as well
     *
     */
    @Test
    public void testInsert(){
        AVLTree<Integer> tester = new AVLTree(new AVLNode(5));
        tester.insert(1);
        tester.insert(6);
        tester.insert(2);
        tester.insert(9);
        tester.insert(-3);
        //testing the balance factor of the root of the tree to ensure that the balancing worked 
        //expecting the absolute value of BF to be less than 2
        assertTrue(Math.abs(tester.getBF(tester.getRoot()))<2);
        //checking if balancing worked using the post order
        assertEquals("-3, 2, 1, 9, 6, 5",tester.postOrderString(),"Test 3 wrong");
        tester.insert(-12);
        //adding new value expecting the BF to stay the same
        assertTrue(Math.abs(tester.getBF(tester.getRoot()))<2);
    }
}
