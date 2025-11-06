
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class for Lab_8
 *
 * @author  Conrad Hahn
 * @version 4/8/2025
 */
public class Lab_8Test
{
    /**
     * Default constructor for test class Lab_8Test
     */
    public Lab_8Test()
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
     * Tests the evaluatePostfix method of main
     */
    @Test
    public void testEvaluatePostfix(){

        Lab_8 test = new Lab_8();
        try{
            //basic test with normal postfix notation with different operators
            String tester = "5 4 3 2 * + -";
            assertEquals(-5, test.evaluatePostfix(tester),"Test 1 Fail");
            //testing an incorrect value due
            String tester2 = "4 5 2 * +";
            assertNotEquals(28, test.evaluatePostfix(tester2),"Test 2 Fail");
        }
        catch(Exception e){

        }
        //testing divide by 0 expecting ExpressionFormatException through arithmatic exception
        String tester3 = "2 / 0";
        assertThrows(ExpressionFormatException.class, () -> {
                    test.evaluatePostfix(tester3);
            });
        //testing unused opperands expecting ExpressionFormatException
        String tester4 = "+ + + + +";
        assertThrows(ExpressionFormatException.class, () -> {
                    test.evaluatePostfix(tester4);
            });

    }

    /**
     * 
     * Tests the simpleInfixToPostfix method of main
     */
    @Test
    public void testSimpleInfixToPostfix(){

        Lab_8 test = new Lab_8();
        try{
            //basic test with basic opperations
            String tester = "2 * 3 + 4 - 5";
            assertEquals(" 2 3 * 4 + 5 -" , test.simpleInfixToPostfix(tester),"Test 1 Fail");
            //Making sure order of operations are correct
            String tester2 = "1 * 2 + 4 - 4";
            assertNotEquals("1 2 - 4 + 4 *",test.simpleInfixToPostfix(tester2),"Test 2 Fail");
        }
        catch(Exception e){

        }
        //test with parenthasis epecting exception
        String tester3 = "2 * ( 5 - 4 )";
        assertThrows(ExpressionFormatException.class, () -> {
                    test.simpleInfixToPostfix(tester3);
            });
    }

    /**
     * 
     * Tests the infixToPostfix method of main
     */
    @Test
    public void testInfixToPostfix(){
        Lab_8 test = new Lab_8();
        try{
            //test with just parenthasis
            String tester = "2 * (4 - 5)";
            assertEquals("2 4 5 - *" , test.infixToPostfix(tester),"Test 1 Fail");
            //test with exponential
            String tester2 = "2 ^ 2 + 3";
            assertEquals("2 2 ^ 3 +" , test.infixToPostfix(tester2),"Test 2 Fail");
             //testing not equals with both opperands making sure parenthasis are being accounted
            String tester3 = "2 ^ ( 4 + 5 )";
            assertEquals( " 2 4 ^ 5 +", test.infixToPostfix(tester2),"Test 3 Fail");
        }catch(Exception e){

        }
    }

    /**
     * 
     * Tests the evaluateInfix method of main
     */
    @Test
    public void testEvaluateInfix(){
        Lab_8 test = new Lab_8();
        try{
            //test with just parenthasis
            String tester = "2 * (4 - 5)";
            assertEquals( -2, test.evaluateInfix(tester),"Test 1 Fail");
            //test with exponential
            String tester2 = "2 ^ 2 + 3";
            assertEquals(7 , test.evaluateInfix(tester2),"Test 2 Fail");
            //testing not equals with both opperands making sure parenthasis are being accounted
            String tester3 = "2 ^ ( 4 + 5 )";
            assertEquals( 21 , test.evaluateInfix(tester2),"Test 3 Fail");
            
        }catch(Exception e){

        }
    }
}
