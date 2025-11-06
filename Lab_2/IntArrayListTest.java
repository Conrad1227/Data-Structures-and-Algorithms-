

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class IntArrayListTest.
 *
 * @author  Conrad Hahn
 * @version 2/11/2025
 */
public class IntArrayListTest
{
    IntArrayList tester = new IntArrayList();
    /**
     * Default constructor for test class IntArrayListTest
     */
    public IntArrayListTest()
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
     * Test method for testing the add and get methods of the IntArrayList 
     * class. 
     */
    @Test
    public void testAddAndGet(){
        tester.add(1);
        int checker = tester.get(0);
        assertEquals(checker,1,"Wrong");
        
        for(int i=12;i>=0;i--){
            tester.add(i);
        }
        checker = tester.get(12);
        assertEquals(checker,1,"Wrong");
        
        tester.add(12,4);
        checker = tester.get(12);
        assertEquals(checker,4,"Wrong");
        checker = tester.get(13);
        assertEquals(checker,1,"Wrong");
        tester.clear();
        
        for(int i=0;i<=9999;i++){
            tester.add(i);
        }
        checker = tester.get(9999);
        assertEquals(checker,9999,"Wrong");
        tester.clear();
    }
    /**
     * Test method for testing the Clear and Empty methods of the IntArrayList
     * class.
     */
    @Test
    public void testClearAndEmpty(){
        for(int i=99999;i>=0;i--){
            tester.add(i*9999);
        }
        
        assertFalse(tester.isEmpty());
        
        tester.clear();
        int checker = tester.get(5);
        assertEquals(0,checker,"Wrong");
        
        assertTrue(tester.isEmpty());
        tester.clear();
    }
    /**
     * Test method for testing the Remove method of the IntArrayList. 
     */
    @Test
    public void testRemove(){
        for(int i=12;i>=0;i--){
            tester.add(i);
        }
        int checker = tester.remove(9);
        assertEquals(checker,3,"Wrong"); 
        checker = tester.get(9);
        assertEquals(checker,2,"Wrong");
        checker = tester.remove(9);
        assertEquals(checker,2,"Wrong"); 
        checker = tester.get(9);
        assertEquals(checker,1,"Wrong"); 
        tester.clear();
        
    }
     /**
     * Test method for testing the Size and ArraySize methods of the 
     * IntArrayList class. 
     */
    @Test
    public void testSizeAndArraySize(){
        for(int i=0;i<=95;i++){
            tester.add(i);
        }
        
        int checker = tester.size();
        assertEquals(checker,96,"Wrong");
        
        checker = tester.arraySize();
        assertEquals(checker,100,"Wrong");
        tester.clear();
        for(int i=0;i<=9995;i++){
            tester.add(i);
        }
        
        checker = tester.size();
        assertEquals(checker,9996,"Wrong");
        
        checker = tester.arraySize();
        assertEquals(checker,10000,"Wrong");
        tester.clear();
        for(int i=0;i<=1;i++){
            tester.add(i);
        }
        
        checker = tester.size();
        assertEquals(checker,2,"Wrong");
        
        checker = tester.arraySize();
        assertEquals(checker,10,"Wrong");
        
        tester.clear();
    }
     /**
     * Test method for testing the EmptyCount method of the IntArrayList
     * class.
     */
    @Test
    public void testEmptyCount(){
        for(int i=0;i<=5;i++){
            tester.add(i);
        }
        int checker = tester.emptyCount();
        assertEquals(checker,5,"Wrong");
        tester.clear();
        
        for(int i=0;i<=12;i++){
            tester.add(i);
        }
        checker = tester.emptyCount();
        assertEquals(checker,8,"Wrong");
        
        
        tester.clear();
    }
     /**
     * Test method for testing the toString method of the IntArrayList
     * class.
     */
    @Test
    public void testToString(){
        //doesnt work
        String a = "0 1 2 3 4 5 6 7 8 9 10 ";
        for(int i=0;i<=10;i++){
            tester.add(i);
        }
        String b = tester.toString();
        assertTrue(a.equals(b));
        tester.clear();
        
        a = "0 1 2 3 ";
        for(int i=0;i<=3;i++){
            tester.add(i);
        }
        b = tester.toString();
        assertTrue(a.equals(b));
        tester.clear();
        
        a = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 ";
        for(int i=0;i<=15;i++){
            tester.add(i);
        }
        b = tester.toString();
        assertTrue(a.equals(b));
        tester.clear();
    }
     /**
     * Test method for testing the next and reset methods of the IntArrayList
     * class.
     */
    @Test public void testNextAndReset(){
        for(int i=0;i<10;i++){
            tester.add(i);
        }
        int checker = tester.next();
        assertEquals(checker,0,"Wrong");
        checker = tester.next();
        assertEquals(checker,1,"Wrong");
        checker = tester.next();
        assertEquals(checker,2,"Wrong");
        checker = tester.next();
        assertEquals(checker,3,"Wrong");
        checker = tester.next();
        assertEquals(checker,4,"Wrong");
        checker = tester.next();
        assertEquals(checker,5,"Wrong");
        checker = tester.next();
        assertEquals(checker,6,"Wrong");
        checker = tester.next();
        assertEquals(checker,7,"Wrong");
        checker = tester.next();
        assertEquals(checker,8,"Wrong");
        checker = tester.next();
        assertEquals(checker,9,"Wrong");
        boolean error=false;
        try{
        tester.next();
        }catch(Exception e){
        error=true;
        }
        assertTrue(error);
        tester.reset();
        checker = tester.next();
        assertEquals(checker,0,"Wrong");
        
    }
}
