
/**
 * Runs a random simulation
 *
 * @author Conrad Hahn
 * @version 5/18/2025
 */
public class SimDriver {
    /**
     * constructs a random starting set of trucks, shipments, and warehouses, then runs the simulation until all
     * trucks finish, and prints the number of cycles executed.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Cycle simulation = new Cycle();
        System.out.println("Starting random simulation");
        //run until no trucks remain or it gets too long
        Boolean success = simulation.runSim();
        if(success){
            int totalCycles = simulation.log_status();
            System.out.println("Simulation completed in " + totalCycles + " cycles.");
        }else{
            System.out.println("Simulation ran for too long");
        }
    }
}
