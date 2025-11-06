
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BinarySearchTreeTest.
 *
 * @author  Conrad Hahn
 * @version 4/22/2025
 */
public class BinarySearchTreeTest
{
    /**
     * Default constructor for test class BinarySearchTreeTest
     */
    public BinarySearchTreeTest()
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
     * Tests Insert and Contains methods of binary search tree
     *
     */
    @Test
    public void testInsertAndContains(){
        BinarySearchTree<Integer> tester = new BinarySearchTree<>(new BinaryNode(1));
        tester.insert(2);
        tester.insert(3);
        tester.insert(4);
        //testing inserting a duplicate value expecting false
        assertFalse(tester.insert(2));
        //testing contains with a value inserted to test insert and contains. Searching for 2 expecting true
        assertTrue(tester.contains(2));
        //testing value that was never insterted into the list
        assertFalse(tester.contains(0));
        //testing contain with the node that was added in the constructor
        assertTrue(tester.contains(1));
    }

    /**
     * Tests preOrderString method of BinaryTree which also tests preRecursive when used
     *
     */
    @Test
    public void testPreOrder(){
        BinarySearchTree<Integer> tester = new BinarySearchTree<>(new BinaryNode(1));
        for(int i=2;i<8;i++){
            tester.insert(i);
        }
        //basic test containing numbers 1 through 7 expecting order they were added
        assertEquals("1, 2, 3, 4, 5, 6, 7",tester.preOrderString(),"Test 1 failed");
        BinarySearchTree<Integer> tester2 = new BinarySearchTree<>(new BinaryNode(4));
        tester2.insert(2);
        tester2.insert(1);
        tester2.insert(3);
        tester2.insert(6);
        tester2.insert(5);
        tester2.insert(7);
        //expecting nodes to be read from first added
        assertEquals("4, 2, 1, 3, 6, 5, 7",tester2.preOrderString(),"Test 2 failed");
        tester2.insert(1);
        //expecting string to be the same since the value wasnt added
        assertEquals("4, 2, 1, 3, 6, 5, 7",tester2.preOrderString(),"Test 3 failed");
        tester2.insert(8);
        //expecting value added to be at end of string since it is the largest
        assertEquals("4, 2, 1, 3, 6, 5, 7, 8",tester2.preOrderString(),"Test 4 failed");
    }

    /**
     * Tests postOrderString method of BinaryTree which also tests postRecursive when used
     *
     */
    @Test
    public void testPostOrder(){
        BinarySearchTree<Integer> tester = new BinarySearchTree<>(new BinaryNode(1));
        for(int i=2;i<8;i++){
            tester.insert(i);
        }
        //basic test containing numbers 1 through 7 expecting reverse order of when they were added
        //since each node is the right child of the last
        assertEquals("7, 6, 5, 4, 3, 2, 1",tester.postOrderString(),"Test 1 failed");
        BinarySearchTree<Integer> tester2 = new BinarySearchTree<>(new BinaryNode(4));
        tester2.insert(2);
        tester2.insert(1);
        tester2.insert(3);
        tester2.insert(6);
        tester2.insert(5);
        tester2.insert(7);
        //expecting nodes to be read from left to right then root
        assertEquals("1, 3, 2, 5, 7, 6, 4",tester2.postOrderString(),"Test 2 failed");
        tester2.insert(1);
        //expecting string to be the same since the value wasnt added
        assertEquals("1, 3, 2, 5, 7, 6, 4",tester2.postOrderString(),"Test 3 failed");
        tester2.insert(8);
        //expecting value to be after the 5 since it is now 7s right child
        assertEquals("1, 3, 2, 5, 8, 7, 6, 4",tester2.postOrderString(),"Test 4 failed");
    }

    /**
     * Tests inOrderString method of BinaryTree which also tests inRecursive when used
     *
     */
    @Test
    public void testInOrder(){
        BinarySearchTree<Integer> tester = new BinarySearchTree<>(new BinaryNode(1));
        for(int i=2;i<8;i++){
            tester.insert(i);
        }
        //expecting nodes to be read from smallest to greatest
        assertEquals("1, 2, 3, 4, 5, 6, 7",tester.inOrderString(),"Test 1 failed");
        BinarySearchTree<Integer> tester2 = new BinarySearchTree<>(new BinaryNode(4));
        tester2.insert(2);
        tester2.insert(1);
        tester2.insert(3);
        tester2.insert(6);
        tester2.insert(5);
        tester2.insert(7);
        //expecting nodes to be read from smallest to greatest added in different order
        assertEquals("1, 2, 3, 4, 5, 6, 7",tester2.inOrderString(),"Test 2 failed");
        //inserting anothing node with negative value that is the least expecting it to be first
        tester2.insert(-7);
        //testing again expecting -7 to be first
        assertEquals("-7, 1, 2, 3, 4, 5, 6, 7",tester2.inOrderString(),"Test 2 failed");
    }

    /**
     * Tests empty and isEmpty methods of BinaryTree
     *
     */
    @Test
    public void testEmptyAndIsEmpty(){
        BinarySearchTree<Integer> tester = new BinarySearchTree<>(new BinaryNode(1));
        for(int i=2;i<8;i++){
            tester.insert(i);
        }
        //testing when the tree is not full expecting false
        assertFalse(tester.isEmpty());
        //emptying the tree
        tester.empty();
        //testing again expecting true;
        assertTrue(tester.isEmpty());
    }

    
    
    
    
}
