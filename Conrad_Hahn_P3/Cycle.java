import java.io.*;

/**
 * Write a description of class Cycle here.
 *
 * @author Conrad Hahn
 * @version 5/18/2025
 */
public class Cycle implements Schedule {
    public static int round;
    MyList<Truck> trucks;
    MyList<Warehouse> warehouses;
    MyList<Shipment> shipments;
    int cycle;

    /**
     * initializes random warehouses, trucks, shipments,and
     * prepares log file
     */
    public Cycle() {
        cycle = 0;
        round = 0;
        trucks = new MyList<>();
        warehouses = new MyList<>();
        shipments = new MyList<>();
        int newwhs = (int)(Math.random() * 5) + 1;
        int newtrs = (int)(Math.random() * 15) + 1;
        // generate warehouses
        for (int i = 0; i < newwhs; i++) {
            warehouses.add(new Warehouse((int)(Math.random() * 100),(int)(Math.random() * 100),(int)(Math.random() * 3) + 1));
        }
        // generate trucks and shipments
        for (int t = 0; t < newtrs; t++) {
            MyList<Shipment> ts = new MyList<>();
            int newships = (int)(Math.random() * 4) + 1;
            for (int s = 0; s < newships; s++) {
                Warehouse src = warehouses.get((int)(Math.random() * newwhs));
                Warehouse dst;
                do {
                    dst = warehouses.get((int)(Math.random() * newwhs));
                } while (dst == src);
                int sz = (int)(Math.random() * 3) + 1;
                Shipment sh = new Shipment(src, dst, sz);
                // add to warehouse inventory
                src.addShipment(sh);
                ts.add(sh);
                shipments.add(sh);
            }
            trucks.add(new Truck((int)(Math.random() * 100),(int)(Math.random() * 100),(int)(Math.random() * 4) + 2,ts));
        }
        try (FileWriter fw = new FileWriter("MapLOG.log")) {
            fw.write("ID: " + (int)(Math.random() * 1000) + " ");
        } catch (IOException e) {
            System.out.println("IO in Cycle constructor");
        }
    }

    /**
     * Testing constructor with predetermined trucks and warehouses.
     *
     * @param t pre-defined list of trucks to simulate
     * @param w pre-defined list of warehouses to simulate
     */
    public Cycle(MyList<Truck> t, MyList<Warehouse> w) {
        cycle = 0;
        round = 0;
        trucks = t;
        warehouses = w;
        try {
            File file = new File("MapLOG.log");
            file.delete();
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("ID: " + (int)(Math.random() * 1000) + " ");
            writer.close();
        } catch (IOException e) {
            System.out.println("IO in Cycle test constructor");
        }
    }

    /**
     * runs simulation until no trucks remain or it reaches the 1000th cycle
     * (capped to prevent looping simulations or ones with too many objecs)
     * 
     * @return true if the simulation happened withint 1000 cycles, false if it was looping or exceeded 1000
     */
    public boolean runSim() {
        int count=0;
        while (!trucks.isEmpty() || count>1000) {
            action();
            count++;
        }
        if(count<1000){
            return true;
        }else{
            return false;
        }
    }

    /**
     * runs simulation up to a fixed number of cycles
     *
     * @param num number of cycles
     */
    public void runSim(int num) {
        for (int i = 0; i < num && !trucks.isEmpty(); i++) {
            action();
        }
    }

    /**
     * performs one simulation hour: each truck acts, remove finished, log state
     */
    @Override
    public void action() {
        cycle++;
        round++;
        for (int i = 0; i < trucks.numvals(); i++) {
            Truck t = trucks.get(i);
            t.action();
            if (t.finished()) { 
                trucks.removeAt(i); i--;
            }
        }
        log_status();
    }

    /**
     * appends the map and entities state to the log file
     *
     * @return 1 on success, -1 on error
     */
    @Override
    public int log_status() {
        try {
            FileWriter file = new FileWriter("MapLOG.log", true);
            file.write("Cycle: " + cycle + "\n");
            file.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
            return -1;
        }
        for (int i = 0; i < trucks.numvals(); i++){
            trucks.get(i).log_status();
        }
        for (int i = 0; i < warehouses.numvals(); i++) {
            warehouses.get(i).log_status();
        }
        for (int i = 0; i < shipments.numvals(); i++) {
            shipments.get(i).log_status();
        }
        return cycle;   
    }

    /**
     * Get the current list of trucks for testing
     *
     * @return the list of active trucks
     */
    public MyList<Truck> getTrucks() {
        return trucks;
    }
}

