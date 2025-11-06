import java.util.Scanner;
/**
 * Class to simulate the river and its animals
 *
 * @author Conrad Hahn
 * @version 2/17/2025
 */
public class RiverSimulator
{
    /**
     * runs starting text of simulation and stops when the user selects 2
     * 
     * @param args not used
     */
    public static void main(String[] args){
        System.out.println("Welcome to CS150 River Ecosystem Simulator by Conrad Hahn");
        System.out.println();
        //loops simulator method until the user exits
        while(simulator()){
            
        }
        System.out.println("GoodBye!");
        return;
    }     
    /**
     * runs the simulation and asks user for length and number of cycles
     * 
     * @return false if user wishes to exit and true while simulator is running
     */
    public static boolean simulator(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("River Ecosystem Simulator");
        //if the selector method returns false when user wants to exit, return false
        if(!selector()){
            return false;
        }
        //asks user for length and number of cycles and stores them in local variables
        System.out.println("Creating River...");
        System.out.println("Enter the river length (int bigger than 0):");
        int lengthin = scnr.nextInt();
        System.out.println("Enter the number of cycles (int bigger than 0):"); 
        int cycles= scnr.nextInt();
        //creates new river with length specified by user
        River riverSim = new River(lengthin);
        System.out.println("Initial River:");
        //prints initial river before simulating
        riverSim.toString();
        //simulates river for the number of cycles the user specifies
        for(int i = 0; i < cycles; i++){
            //makes sure none of the spots have been updated
            riverSim.updatedSetFalse();
            for(int j = 0; j < riverSim.getSize(); j++){
                //updates every index of the river every cycle
                riverSim.updateCell(j);
            }
            //prints river as string and tells user which cycle it is
            System.out.println("River after cycle "+i+":");
            riverSim.toString();
        }
        System.out.println();
        //re runs this method so user can simulate again
        simulator();
        return true;
    }
    /**
     * asks user if they want to simulate or exit and runs accordingly
     * 
     * @return returns true if run simulation is selected and 2 if exit is selected
     */
    public static boolean selector(){
        //asks user to select if they want to simulate or exit
        System.out.println("Please choose: 1 (random river) 2 (exit)");
        Scanner scnr = new Scanner(System.in);
        String in = scnr.nextLine();
        //returns true if they want to simulate and false to exit
        if(in.equals("2")){
            return false;
        }else if(in.equals("1")){
            return true;
        } else{
            //if the user inputs anything other than 1 or 2 it asks again
            System.out.println("Invalid Selection");
            return selector();
        }
    }
}
