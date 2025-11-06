

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DirectedGraphTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DirectedGraphTest
{
    /**
     * Default constructor for test class DirectedGraphTest
     */
    public DirectedGraphTest()
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
     * Tests the addNode and addEdge methods of the directedgraph
     * mostly testing the return of the methods but the outcomes are tested in the following test methods
     *
     */
    @Test
    public void testAddNodeAndEdge(){
        DirectedGraph<String> tester = new DirectedGraph<>();
        //adding two new nodes expecting the method to return true
        assertTrue(tester.addNode("A"),"Test 1 failed");
        assertTrue(tester.addNode("B"),"Test 2 failed");
        //adding aduplicate node expecting false since it already exists
        assertFalse(tester.addNode("A"),"Test 3 failed");
        //testing adding an edge between two existing nodes expecting true
        assertTrue(tester.addEdge("A","B",3),"Test 4 failed");
        //trying when one node doesnt exists expecting false
        assertFalse(tester.addEdge("A","C",1),"Test 5 failed");
        //resizing the weight of the edge expecting true for an edge that already exists
        assertTrue(tester.addEdge("A","B",2),"Test 6 failed");
        //adding another node and trying to add another edge
        assertTrue(tester.addNode("C"),"Test 7 failed");
        assertTrue(tester.addEdge("A","C",10),"Test 8 failed");
    }
    
    /**
     * Tests the getNeighbors method of DirectedGraph
     * Like stated in the last test, this also further tests the addNode and addEdge methods
     *
     */
    @Test
    public void testGetNeighbors(){
        DirectedGraph<String> tester = new DirectedGraph<>();
        tester.addNode("A");
        //getting neighbors on a single node expecting an empty array
        assertTrue(tester.getNeighbors("A").isEmpty(),"Test 1 failed");
        //adding a new node without an edge expecing the new node not to be in the neighbors
        tester.addNode("B");
        assertNotEquals("[B]",tester.getNeighbors("A").toString(),"Test 2 failed");
        //adding an edge between them expecting the new node to be its neighbor
        tester.addEdge("A","B",3);
        assertEquals("[B]",tester.getNeighbors("A").toString(),"Test 3 failed");
        tester.addNode("C");
        tester.addEdge("A","C",2);
        assertEquals("[B, C]",tester.getNeighbors("A").toString(),"Test 4 failed");
    }
    
    /**
     * Tests the breadthFirstCloset method of DirectedGraph as well as the returnNeighbor method of DirectedGraphNode
     * This test is done in the console since the method prints the output
     */
    @Test
    public void testBreadthFirstClosest(){
        DirectedGraph<String> tester = new DirectedGraph<>();
        tester.addNode("A");
        tester.addNode("B");
        tester.addNode("C");
        tester.addNode("D");
        tester.addEdge("D","B",4);
        tester.addEdge("A","B",2);
        tester.addEdge("A","C",1);
        tester.addEdge("A","D",3);
        //testing base case where a has three brances expecting A C since its weight is 1 
        //and then the other nodes following the order they were added
        System.out.println("Expecting A C, B null, C null, D B");
        tester.breadthFirstClosest("A");
        //Expecting D B since it is Ds only edge and then just B since it has no other edges
        System.out.println("Expecting D B, B null");
        tester.breadthFirstClosest("D");
    }
}
