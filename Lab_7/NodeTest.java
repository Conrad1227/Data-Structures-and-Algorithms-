
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * The test class NodeTest.
 *
 * @author  Conrad Hahn
 * @version 4/1/2025
 */
public class NodeTest
{
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
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
     *
     * Tests Node constructor for single strings
     */
    @Test
    public void testStringNodeCreation() {
        Node<String> nodetest= new Node<>("Test");
        //test it is not null
        assertNotNull(nodetest, "Test 1 Fail");
        //testing it is the right string
        assertEquals("Test", nodetest.val, "Test 2 Fail");
        //testing that the string is not empty
        assertNotEquals("",nodetest.val, "Test 3 Fail");
    }

    /**
     *
     * Tests Node constructor for single integers
     */
    @Test
    public void testIntegerNodeCreation() {
        Node<Integer> nodetest= new Node<>(5);
        //test it is not null
        assertNotNull(nodetest, "Test 1 Fail");
        //testing it is the right int
        assertEquals(5, nodetest.val, "Test 2 Fail");
        //testing the int is not 0
        assertNotEquals(0, nodetest.val, "Test 3 Fail");
    }

    /**
     *
     * Tests Node constructor for lists of strings
     */
    @Test
    public void testStringNodeCreationWithList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Test");
        list.add("Hello");
        list.add("World");

        Node<String> nodetest= new Node<>(list);
        //testing the head is not null
        assertNotNull(nodetest, "Test 1 Fail");
        //testing the head is equal to the first value added
        assertEquals("Test", nodetest.val, "Test 2 Fail");
        //testing the head is not the second value added
        assertNotEquals("Hello", nodetest.val, "Test 2 Fail");
    }

    /**
     *
     * Tests Node constructor for lists of integers
     */
    @Test
    public void testIntegerNodeCreationWithList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Node<Integer> nodetest= new Node<>(list);
        //testing the head is not null
        assertNotNull(nodetest, "Test 1 Fail");
        //testing the head is equal to the first value added
        assertEquals(2, nodetest.next.val, "Test 2 Fail");
        //testing the head is not the second value added
        assertEquals(3, nodetest.next.next.val, "Test 3 Fail");
    }

    /**
     *
     * Tests Nodes addToBack method
     */
    @Test
    public void testAddToBack() {
        Node<Integer> nodetest= new Node<>(1);
        nodetest.addToBack(2);
        nodetest.addToBack(3);
        //tests the second value is the one added second
        assertEquals(2, nodetest.next.val, "Test 1 Fail");
        //tests the third value is the one added third
        assertEquals(3, nodetest.next.next.val, "Test 2 Fail");
    }

    /**
     *
     * Tests Nodes addToFront method
     */
    @Test
    public void testAddToFront() {
        Node<Integer> nodetest= new Node<>(1);
        nodetest.addToFront(2);
        nodetest.addToFront(3);
        //test the the first value is the  one added last
        assertEquals(3, nodetest.val, "Test 1 Fail");
        //Test the list is what it should be 
        assertEquals("3, 2, 1", nodetest.toString(),"Test 2 Fail");
        assertEquals(2, nodetest.next.val, "Test 3 Fail");

    }

    /**
     *
     * Tests Nodes rotate method
     */
    @Test
    public void testRotate() {
        Node<Integer> nodetest = new Node<>(1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        nodetest.rotate(-1);
                });
        assertEquals("Rotation number must be non-negative", exception.getMessage(), "Test 1 Fail");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Node<Integer> nodetest2 = new Node<>(list);
        //rotating once 
        nodetest2.rotate(1);  
        assertEquals("5, 1, 2, 3, 4", nodetest2.toString(), "Test 2 Fail");
        //testing rotating again
        nodetest2.rotate(1);
        assertEquals("4, 5, 1, 2, 3", nodetest2.toString(), "Test 3 Fail");
    }

    /**
     *
     * Tests Nodes toString method
     */
    @Test
    public void testToString() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Test");

        Node<String> nodetest= new Node<>(list);
        //Check that the list is sorted right
        assertEquals("Hello, World, Test", nodetest.toString(), "Test 1 Fail");
        //Check the list isnt empty
        assertNotEquals("", nodetest.toString(), "Test 1 Fail");
    }

}

