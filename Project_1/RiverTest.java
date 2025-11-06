

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RiverTest.
 *
 * @author  Conrad Hahn
 * @version 2/17/2025
 */
public class RiverTest
{
    /**
     * Default constructor for test class RiverTest
     */
    public RiverTest()
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
     * Tests the getSize method of the river class
     */
    @Test
    public void testGetSize(){
        //initializes new rivers with set size and tests that their sizes are correct
        River riverTest = new River(10);
        assertEquals(10,riverTest.getSize(),"Wrong");
        River riverTest1 = new River(1000000);
        assertEquals(1000000,riverTest1.getSize(),"Wrong");
        River riverTest2 = new River(-1292929);
        assertEquals(1,riverTest2.getSize(),"Wrong");
        River riverTest3 = new River(10);
        assertNotEquals(15,riverTest3.getSize(),"Wrong");
        River riverTest4 = new River(0);
        assertEquals(1,riverTest4.getSize(),"Wrong");
    }
    /**
     * Tests the getStrength and addSpecific methods of the river class 
     */
    @Test
    public void testGetStrengthAndAddSpecific(){
        //initializes new rivers with set size and tests that their sizes are correct
        Bear bearTest1 = new Bear(5,1);
        River riverTest = new River(10);
        //should be male bear with strength 4
        riverTest.addSpecific(bearTest1,0);
        riverTest.getStrength(bearTest1);
    }
    /**
     * Tests the toString method of the river class 
     */
    @Test
    public void testToString(){
        //initializes new rivers with set size
        Bear bearTest1 = new Bear(5,1);
        Fish fishTest1 = new Fish(2,0);
        River riverTest = new River(6);
        riverTest.addSpecific(fishTest1,4);
        assertEquals("--- --- --- --- FF2 --- ",riverTest.toString(),"Wrong");
        riverTest.addSpecific(bearTest1,0);
        assertEquals("BM5 --- --- --- --- --- ",riverTest.toString(),"Wrong");
        Bear bearTest2 = new Bear(-99999,9999);
        riverTest.addSpecific(bearTest2,9999999);
        assertEquals("--- --- --- --- --- BM0 ",riverTest.toString(),"Wrong");
    }
    /**
     * Tests the updatedSetFalse method of the river class 
     */
    @Test
    public void testUpdatedSetFalse(){
        River riverTest = new River(6);
        Fish fishTest1 = new Fish(2,0);
        riverTest.addSpecific(fishTest1,4);
        fishTest1.updatedSetTrue();
        riverTest.updatedSetFalse();
        assertFalse(fishTest1.getUpdated());
    }
    /**
     * Tests the numEmpty method of the river class 
     */
    @Test
    public void testNumEmpty(){
        River riverTest = new River(6);
        Fish fishTest1 = new Fish(2,0);
        riverTest.addSpecific(fishTest1,4);
        assertEquals(5,riverTest.numEmpty(),"Wrong");
        River riverTest1 = new River(888);
        riverTest1.addSpecific(fishTest1,747);
        assertEquals(887,riverTest1.numEmpty(),"Wrong");
        River riverTest2 = new River(1);
        riverTest2.addSpecific(fishTest1,0);
        assertEquals(0,riverTest2.numEmpty(),"Wrong");
    }
    /**
     * Tests the updateCell method of the river class 
     */
    @Test
    public void testUpdateCell(){
        River riverTest = new River(6);
        Fish fishTest1 = new Fish(2,0);
        riverTest.addSpecific(fishTest1,4);
        assertEquals("--- --- --- --- FF2 --- ",riverTest.toString(),"Wrong1");
        riverTest.updateCell(4);
        assertNotEquals("--- --- --- --- FF2 --- ",riverTest.toString(),"Wrong2");
        Fish fishTest2 = new Fish(4,1);
        riverTest.addSpecific(fishTest2,3);
        assertEquals("--- --- --- FM4 --- --- ",riverTest.toString(),"Wrong3");
        riverTest.updateCell(4);
        assertEquals("--- --- --- FM4 --- --- ",riverTest.toString(),"Wrong4");
        Fish fishTest3 = new Fish(1,0);
        riverTest.addSpecific(fishTest3,2);
        assertEquals("--- --- FF1 --- --- --- ",riverTest.toString(),"Wrong5");
        riverTest.updateCell(2);
        assertNotEquals("--- --- FF1 --- --- --- ",riverTest.toString(),"Wrong6");
    }
    
    
    
    
    
    
    
}
