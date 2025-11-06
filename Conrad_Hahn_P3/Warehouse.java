import java.io.*;

/**
 * Class for Warehouses with loading docks, queued trucks, and inventory
 *
 * @author Conrad Hahn
 * @version 5/18/2025
 */

class Warehouse implements Schedule {
    private static int nextID = 1;
    private final int id, x, y, docks;
    protected final Queue<Truck> queue = new Queue<>();
    private final MyList<Shipment> inventory = new MyList<>();

     /**
     * creates a warehouse at x,y with a number of docks
     *
     * @param x x-coordinate on map
     * @param y y-coordinate on map
     * @param docks number of loading docks
     */
    public Warehouse(int x, int y, int docks) {
        this.id = nextID++;
        this.x = x; this.y = y; this.docks = docks;
    }

    /**
     * gets this warehouses ID
     *
     * @return warehouse ID
     */
    public int getId() { 
        return id; 
    }
    
    /**
     * gets x-coordinate
     *
     * @return x position
     */
    public int getX() { 
        return x; 
    }

    /**
     * gets y-coordinate
     *
     * @return y position
     */
    public int getY() { 
        return y; 
    }

    /**
     * serves, up to the number of docks, trucks in first in first out order
     */
    @Override
    public void action() {
        int served = 0;
        while (served < docks && !queue.isEmpty()) {
            queue.dequeue();
            served++;
        }
    }

    /**
     * logs this warehouses state to the global log.
     *
     * @return this warehouses ID if successful, -1 otherwise
     */
    @Override
    public int log_status() {
        try (FileWriter fw = new FileWriter("MapLOG.log", true)) {
            fw.write("WareHouse "+id+", ["+x+", "+y+"], Docks:"+docks+", "+inventory.toString()+"\n");
        } catch (IOException e) {
            return -1;
        }
        return id;
    }

    /**
     * adds a truck to the waiting queue
     *
     * @param t the truck arriving
     */
    public void arrive(Truck t){ 
        queue.enqueue(t); 
    }

    /**
     * adds a shipment to inventory
     *
     * @param s the shipment to store
     */
    public void addShipment(Shipment s) {
        inventory.add(s); 
    }

    /**
     * removes a shipment from inventory
     *
     * @return the shipment removed or null if none are left
     */
    public Shipment removeShipment() { 
        if(inventory.isEmpty()){
            return null; 
        }else{
            return inventory.removeAt(0); 
        }
    }
}

