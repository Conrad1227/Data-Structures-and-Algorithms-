import java.util.Scanner;
import java.util.EmptyStackException;
import java.io.*;
/**
 * Write a description of class Lab_8 here.
 *
 * @author Conrad Hahn
 * @version 4/7/2025
 */
public class Lab_8
{

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args) throws Exception
    {
        try{
            Scanner  filereader= new Scanner(new File(args[0]));
            FileWriter filewriter = new FileWriter(args[1]);  
            BufferedWriter buffer = new BufferedWriter(filewriter);
            String line="";
            while(filereader.hasNextLine()){
                line = filereader.nextLine();
                evaluateInfix(line);
                buffer.write(line + " = " + evaluateInfix(line));
                buffer.newLine();
            }
            buffer.close();
        }catch(IOException e){
            System.err.print(e);
        }
    }

    /**
     * Evaluates given String according to postfix rules, assuming
     * delimination by whitespace and int values.
     * 
     * @param text expression to be evaluated
     * @return evaluated value according to int arithmetic
     * @throws ExpressionFormatExpression if text is not a valid postfix expression
     */
    public static int evaluatePostfix(String text) throws ExpressionFormatException{
        Scanner scanner = new Scanner(text);
        BasicStack<Integer> s = new ArrayBasedStack<Integer>();
        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                // if token is an operand, push it on the stack
                s.push(scanner.nextInt());
            } else {
                // otherwise, perform the operation on the top two elements
                Operator op = getOperator(scanner.next());
                try{
                    // note the order is important
                    int rhs = s.pop();
                    int lhs = s.pop();

                    s.push(doOperation(op, lhs, rhs));
                }catch (EmptyStackException e){
                    // there weren't two operands on the stack
                    throw new ExpressionFormatException("Missing operand for " + op);
                }
            }
        } 
        // result should be the only item on
        // the stack
        if (s.size() != 1){
            throw new ExpressionFormatException("Unused operands");
        }
        return s.pop();
    }

    /**
     * Converts the given String to its corresponding Operator value.
     * 
     * @param op String to convert
     * @return corresponding Operator
     * @throws IllegalArgumentException if op is not a supported operator
     */
    public static Operator getOperator(String op) {
        switch (op) {
            case "+": return Operator.PLUS;
            case "-": return Operator.MINUS;
            case "*": return Operator.TIMES;
            case "/": return Operator.DIVIDE;
            case "^": return Operator.POWER;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * Applies the given operator to the given ints.
     * 
     * @param op operator to apply
     * @param lhs left operand
     * @param rhs right operand
     * @return evaluated value
     * @throws ExpressionFormatException if trying to divide by 0
     */
    public static int doOperation(Operator op, int lhs, int rhs) throws ExpressionFormatException {
        try{
            switch (op) {
                case PLUS: return lhs + rhs;
                case MINUS: return lhs - rhs;
                case TIMES: return lhs * rhs;
                case DIVIDE: return lhs / rhs;
                case POWER: return (int) java.lang.Math.pow(lhs, rhs);
                default: throw new IllegalStateException(); // should never happen
            }
        } catch ( ArithmeticException e){
            throw new ExpressionFormatException("Cannot Divide by 0");
        }
    }

    /**
     * Gets the input precedent of a given operator
     * 
     * @param op the operator being evaluated
     * @return the precedent value of the operator
     */
    public static int getPrec(String op) {
        switch (op) {
            case "+": return 1;
            case "-": return 1;
            case "*": return 2;
            case "/": return 2;
            case "%": return 2;
            case "^": return 4;
            case "(": return 5;
            case ")": return 0;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * Gets the stack precedent of a given operator
     * 
     * @param op the operator being evaluated
     * @return the stack precedent value of the operator
     */
    public static int getStackPrec(String op) {
        switch (op) {
            case "+": return 1;
            case "-": return 1;
            case "*": return 2;
            case "/": return 2;
            case "%": return 2;
            case "^": return 3;
            case "(": return -1;
            case ")": return 0;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * Converts an equation from infix notation to postfix as long as it doesnt use parathesis or exponentials
     * 
     * @param infix the infix notation equation being converted
     * @return converted string
     * @throws ExpressionFormatException if using an unacceptable operator
     */
    public static String simpleInfixToPostfix(String infix) throws ExpressionFormatException {
        Scanner scnr = new Scanner(infix);
        BasicStack<String> opstack = new ArrayBasedStack<String>();
        String postfix = "";
        while(scnr.hasNext()){
            String token = scnr.next();
            if(isInt(token)){//run into int
                postfix = postfix + " " + token;
            }else if(token.equals( ")") || token.equals( "(") || token.equals( "^")){ //illegal op
                throw new ExpressionFormatException("Illegal operator used");
            }else{ //legal op
                while(!opstack.isEmpty() && getPrec(token) <= getPrec(opstack.peek())){
                    postfix = postfix + " " + opstack.pop();
                }
                opstack.push(token);
            }
        }
        while(!opstack.isEmpty()){
            postfix = postfix +" " + opstack.pop();
        }
        return postfix;
    }

    /**
     * checks if a string is an int
     * 
     * @param s the string that is being checked
     * @return if the string is an int or not

     */
    private static Boolean isInt(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * Converts an equation from infix notation to postfix with any operator
     * 
     * @param infix the infix notation equation being converted
     * @return converted string
     */
    public static String infixToPostfix(String infix){
        Scanner scnr = new Scanner(infix);
        BasicStack<String> opstack = new ArrayBasedStack<String>();
        String postfix = "";
        while(scnr.hasNext()){
            String token = scnr.next();
            if(isInt(token)){
                postfix = postfix + " " + token;
            }else if(token.equals(")")){
                while(!token.equals("(")){
                    postfix = postfix +" "+ opstack.pop();
                }
                opstack.pop();
            }else{
                while(!opstack.isEmpty() && getPrec(token) <= getStackPrec(opstack.peek())){
                    postfix = postfix + " " + opstack.pop();
                }
                opstack.push(token);
            }
        }
        while(!opstack.isEmpty()){
            postfix = postfix +" " + opstack.pop();
        }
        return postfix;
    }

    /**
     * evaluates an infix equation using postfix notation
     * 
     * @param in the equation being evaluated
     * @return the answer to the equation
     */
    public static int evaluateInfix(String in){
        String postfix = infixToPostfix(in);
        int out = 0;
        try{
            out = evaluatePostfix(postfix);
        }catch(Exception e){

        }
        return out;
    }
}
