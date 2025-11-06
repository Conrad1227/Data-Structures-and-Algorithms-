

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
/**
 * The test class Part1Test.
 *
 * @author  Conrad Hahn
 * @version 2/5/2025
 */
public class Part1Test extends Part1
{
    /**
     * Default constructor for test class Part1Test
     */
    public Part1Test()
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
     * Tests the equals method of java String class
     */
    @Test
    public void testEquals(){
        String a = "Hello";
        String b = "Hello";
        assertTrue(a.equals(b));
        
        a = "Hi";
        b = "Hello";
        assertFalse(a.equals(b));
        
        a= "Hi";
        b= "Hi";
        assertTrue(a.equals(b));
    }
    /**
     * Tests the concat method of java String class
     */
    @Test
    public void testConcat(){
        String a = "Hello ";
        String b = "World";
        String c = "Hello World";
        assertEquals(c,a.concat(b),"Wrong");
        
        a = "My name is ";
        b = "Conrad";
        c = "My name is Conrad";
        assertEquals(c,a.concat(b),"Wrong");
        
        a = "CS ";
        b = "150";
        c = "CS 150";
        assertEquals(c,a.concat(b),"Wrong");
    }
    /**
     * Tests the compareTo method of java String class
     */
    @Test
    public void testCompareTo(){
        String a = "Hello";
        String b = "Hello";
        assertEquals(0,a.compareTo(b),"Wrong");
        
        a = "My name is Conrad";
        b = "My name is Conrad";
        assertEquals(0,a.compareTo(b),"Wrong");        
    
        a= "Hi";
        b= "Hi";
        assertEquals(0,a.compareTo(b),"Wrong");
    }   
    /**
     * Tests the charAt method of java String class
     */
    @Test
    public void testCharAt(){
        String a ="Hello";
        assertEquals('H',a.charAt(0),"Wrong");
        
        a = "My name is Conrad";
        assertEquals('i',a.charAt(8),"Wrong");
        
        a = "........................";
        assertEquals('.',a.charAt(12),"Wrong");
    }
    /**
     * Tests the indexOf method of java String class
     */
    @Test
    public void testIndexOf(){
        String a ="Hello";
        assertEquals('H',a.charAt(0),"Wrong");
        
        a = "My name is Conrad";
        assertEquals('i',a.charAt(8),"Wrong");
        
        a = "........................";
        assertEquals('.',a.charAt(12),"Wrong");
    }
    /**
     * Tests the subString method of java String class
     */
    @Test
    public void testSubString(){
        String a = "Hello World";
        assertEquals("World",a.substring(6),"Wrong");
        
        a = "9999999999999999999999999999999999";
        assertEquals("",a.substring(a.length()),"Wrong");
        
        a = "Hi";
        assertEquals("Hi",a.substring(0),"Wrong");
        
    }
    /**
     * Tests the split method of java String class
     */
    @Test
    public void testSplit(){
        String a = "Eggs,Bacon,Sausage,Waffles";
        String[] list = a.split("[,\\s\\.]");
        assertEquals("Eggs",list[0],"Wrong");
        
        String b = "100,000,000,000,000,000,000";
        String[] list2 = b.split("[,\\s\\.]");
        assertEquals("000",list2[6],"Wrong");
        
        String c = "99999999999 99999999 999999 99999 99999 99999 999999 99";
        String[] list3 = c.split("[,\\s\\.]");
        assertEquals("99",list3[7],"Wrong");
        
        
    }
    }

