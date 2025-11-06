import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;

/**
 * The test class MyPriorityQueueTest.
 *
 * @author  Conrad Hahn
 * @version 4/28/2025
 */
public class MyPriorityQueueTest
{
    /**
     * Default constructor for test class MyPriorityQueueTest
     */
    public MyPriorityQueueTest()
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
     * Tests methods add and peek of MyPiorityQueue as well as compares them to javas built in PriorityQueue
     *
     */
    @Test
    public void testAddandPeek(){
        //testing int,int type
        MyPriorityQueue<WeightedElement<Integer, Integer>> myTester = new MyPriorityQueue<>();
        PriorityQueue<WeightedElement<Integer, Integer>> javaTester = new PriorityQueue<>();
        //peek for an empty queue should be null
        assertNull(myTester.peek());
        for(int i = 1 ; i<5 ; i++){
            myTester.add(new WeightedElement(i,i));
            javaTester.add(new WeightedElement(i,i));
        }
        String test1 = myTester.peek().toString();
        String test2 = javaTester.peek().toString();
        //testing first if the add is properly ordering values
        assertTrue(myTester.isHeap());
        //now testing that the first value in both is the same
        assertEquals(test1,test2,"Test 1 Failed");
        myTester.add(new WeightedElement(10,0));
        javaTester.add(new WeightedElement(10,0));
        test1 = myTester.peek().toString();
        test2 = javaTester.peek().toString();
        //testing the first value is the same again after adding a new one with the highest priority
        assertEquals(test1,test2,"Test 2 Failed");
        //testing again that it stayed a heap
        assertTrue(myTester.isHeap());
        //testing string, string
        MyPriorityQueue<WeightedElement<String, String>> myStringTester = new MyPriorityQueue<>();
        PriorityQueue<WeightedElement<String, String>> javaStringTester = new PriorityQueue<>();
        //running same test but with strings adding the same thing to each in different ordering than their priority
        javaStringTester.add(new WeightedElement("Carrot","C"));
        myStringTester.add(new WeightedElement("Carrot","C"));
        javaStringTester.add(new WeightedElement("Desert","D"));
        myStringTester.add(new WeightedElement("Desert","D"));
        javaStringTester.add(new WeightedElement("Apple","A"));
        myStringTester.add(new WeightedElement("Apple","A"));
        javaStringTester.add(new WeightedElement("Banana","B"));
        myStringTester.add(new WeightedElement("Banana","B"));
        test1 = myStringTester.peek().toString();
        test2 = javaStringTester.peek().toString();
        //testing first if the add is properly ordering values
        assertTrue(myStringTester.isHeap());
        //now testing that the first value in both is the same
        assertEquals(test1,test2,"Test 3 Failed");
        myStringTester.add(new WeightedElement("Egg","E"));
        javaStringTester.add(new WeightedElement("Egg","E"));
        test1 = myStringTester.peek().toString();
        test2 = javaStringTester.peek().toString();
        //testing the first value is the same again after adding a new one with the lowest priority
        assertEquals(test1,test2,"Test 4 Failed");
        //testing again that it stayed a heap
        assertTrue(myStringTester.isHeap());        
    }
    
    /**
     * Tests methods Poll and Size of MyPiorityQueue as well as compares them to javas built in PriorityQueue
     *
     */
    @Test
    public void testPollAndSize(){
        MyPriorityQueue<WeightedElement<Integer, Integer>> myTester = new MyPriorityQueue<>();
        PriorityQueue<WeightedElement<Integer, Integer>> javaTester = new PriorityQueue<>();
        //poll for an empty queue should be null
        assertNull(myTester.poll());
        for(int i = 1 ; i<5 ; i++){
            myTester.add(new WeightedElement(i,i));
            javaTester.add(new WeightedElement(i,i));
        }
        //size of both queues should be the same and length 4
        assertEquals(4,myTester.size(),"Test 1 failed");
        assertEquals(myTester.size(),javaTester.size(),"Test 2 failed");
        //first element of both queues should be the same , 1
        WeightedElement<Integer,Integer> val = myTester.poll();
        assertEquals("Value: 1 Weight: 1",val.toString(),"Test 3 Failed");
        assertEquals(val.toString(),javaTester.poll().toString(),"Test 4 falied");
        //now the size should be one less and the same
        assertEquals(3,myTester.size(),"Test 5 failed");
        assertEquals(myTester.size(),javaTester.size(),"Test 6 failed");
        //next value of poll should be 2 
        assertEquals("Value: 2 Weight: 2",myTester.poll().toString(),"Test 7 Failed");
        
        //now the same thing but with Strings
        MyPriorityQueue<WeightedElement<String, String>> myStringTester = new MyPriorityQueue<>();
        PriorityQueue<WeightedElement<String, String>> javaStringTester = new PriorityQueue<>();
        //running same test but with strings adding the same thing to each in different ordering than their priority
        javaStringTester.add(new WeightedElement("Carrot","C"));
        myStringTester.add(new WeightedElement("Carrot","C"));
        javaStringTester.add(new WeightedElement("Desert","D"));
        myStringTester.add(new WeightedElement("Desert","D"));
        javaStringTester.add(new WeightedElement("Apple","A"));
        myStringTester.add(new WeightedElement("Apple","A"));
        javaStringTester.add(new WeightedElement("Banana","B"));
        myStringTester.add(new WeightedElement("Banana","B"));
        //testing size expecting 4 after adding 4 values
        assertEquals(4,myStringTester.size(),"Test 8 Failed");
        String test1 = myStringTester.poll().toString();
        String test2 = javaStringTester.poll().toString();
        //now testing that the polled value in both is the same and is apple
        assertEquals(test1,test2,"Test 3 Failed");
        assertEquals("Value: Apple Weight: A",test1,"Test 9 Failed");
        myStringTester.add(new WeightedElement("Egg","E"));
        javaStringTester.add(new WeightedElement("Egg","E"));
        //after removing one value and adding another size should still be 4
        assertEquals(4,myStringTester.size(),"Test 10 Failed");
        test1 = myStringTester.poll().toString();
        test2 = javaStringTester.poll().toString();
        //testing the first value is the same again after adding a new one with the lowest priority
        assertEquals(test1,test2,"Test 11 Failed");   
    }
}
