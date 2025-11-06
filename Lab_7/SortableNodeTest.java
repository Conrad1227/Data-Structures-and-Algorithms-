
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
/**
 * The test class SortableNodeTest.
 *
 * @author  Conrad Hahn
 * @version 4/1/2025
 */
public class SortableNodeTest
{
    /**
     * Default constructor for test class SortableNodeTest
     */
    public SortableNodeTest()
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
     * Tests SortableNodes partition method
     */
    @Test
    public void testPartition(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);

        SortableNode<Integer> nodetest2 = new SortableNode<>(list);
        nodetest2.partition(2);
        //makes sure the list is changed
        assertNotEquals("5, 2, 1, 3, 4",nodetest2.toString(),"Test 1 Failed");
        //check the list is correctly sorted
        assertEquals("1, 2, 5, 3, 5",nodetest2.toString(),"Test 2 Failed");
        //check the list isnt empty
        assertNotEquals("",nodetest2.toString(),"Test 3 Failed");

    }

    /**
     *
     * Tests SortableNodes sort method for Integers
     */
    @Test
    public void testSortInteger(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);

        SortableNode<Integer> nodetest2 = new SortableNode<>(list);
        nodetest2.sort();
        //makes sure the list is changed
        assertNotEquals("5, 2, 1, 3, 4",nodetest2.toString(),"Test 1 Failed");
        //check the list is correctly sorted
        assertEquals("1, 2, 3, 4, 5",nodetest2.toString(),"Test 2 Failed");
        //check the list isnt empty
        assertNotEquals("",nodetest2.toString(),"Test 3 Failed");

    }

    /**
     *
     * Tests SortableNodes sort method for Strings
     */
    @Test
    public void testSortString(){
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add("D");
        list.add("B");
        list.add("E");

        SortableNode<String> nodetest2 = new SortableNode<>(list);
        nodetest2.sort();
        //makes sure the list is changed
        assertNotEquals("A, C, D, B, E",nodetest2.toString(),"Test 1 Failed");
        //test the string is sorted
        assertEquals("A, B, C, D, E",nodetest2.toString(),"Test 2 Failed");
        //check the list isnt empty
        assertNotEquals("",nodetest2.toString(),"Test 3 Failed");

    }

    /**
     *
     * Tests SortableNodes uniqueSort method for Integers
     */
    @Test
    public void testUniqueSortInteger(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(4);

        SortableNode<Integer> nodetest2 = new SortableNode<>(list);
        nodetest2.uniqueSort();
        //makes sure the list is changed
        assertNotEquals("5, 1, 1, 3, 4",nodetest2.toString(),"Test 1 Failed");
        //check the list is correctly sorted
        assertEquals("1, 3, 4, 5",nodetest2.toString(),"Test 2 Failed");
        //check the list isnt empty
        assertNotEquals("",nodetest2.toString(),"Test 3 Failed");

    }

    /**
     *
     * Tests SortableNodes uniqueSort method for Strings
     */
    @Test
    public void testUniqueSortString(){
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add("C");
        list.add("D");
        list.add("E");

        SortableNode<String> nodetest2 = new SortableNode<>(list);
        nodetest2.uniqueSort();
        //makes sure the list is changed
        assertNotEquals("A, C, D, B, E",nodetest2.toString(),"Test 1 Failed");
        //test the string is sorted
        assertEquals("A, C, D, E",nodetest2.toString(),"Test 2 Failed");
        //check the list isnt empty
        assertNotEquals("",nodetest2.toString(),"Test 3 Failed");
    }

}
