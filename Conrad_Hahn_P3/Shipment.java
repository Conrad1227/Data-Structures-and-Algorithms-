import java.util.Random;
import java.io.*;

/**
 * Class for shipments that are stored at warehouses and in trucks to be delivered
 *
 * @author Conrad Hahn
 * @version 5/18/2025
 */
class Shipment implements Comparable<Shipment>,Schedule{
    private static int nextID = 1;
    private final int id;
    private final int size;
    private final Warehouse pickup;
    private final Warehouse dropoff;
    private Truck truck;
    private boolean pickedUp;

    /**
     * creates a random-size shipment
     *
     * @param pickup  the source warehouse
     * @param dropoff the destination warehouse
     */
    public Shipment(Warehouse pickup, Warehouse dropoff) {
        this.id = nextID++;
        this.size = new Random().nextInt(3) + 1;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.pickedUp = false;
    }

    /**
     * creates a fixed-size shipment used for testing
     *
     * @param pickup  the source warehouse
     * @param dropoff the destination warehouse
     * @param size    the cargo size
     */
    public Shipment(Warehouse pickup, Warehouse dropoff, int size) {
        this.id = nextID++;
        this.size = size;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.pickedUp = false;
    }

    /**
     * get shipments ID
     *
     * @return the shipments ID
     */
    public int getID() { 
        return id; 
    }
    
    /**
     * gets starting warehouse ID
     *
     * @return the starting warehouses ID
     */
    public int getSourceID() { 
        return pickup.getId(); 
    }
    
    /**
     * gets ending warehouse ID
     *
     * @return the ending warehouses ID
     */
    public int getDestID() { 
        return dropoff.getId(); 
    }
    
    /**
     * gets the size of the shipment
     *
     * @return the size of cargo
     */
    public int getSize() { 
        return size; 
    }

    /**
     * checks if this shipment has been picked up
     *
     * @return true if already picked up,false if it hasnt
     */
    public boolean hasBeenPickedUp() { 
        return pickedUp; 
    }

    /**
     * marks the shipment as picked up.
     */
    public void pickUp() { 
        pickedUp = true; 
    }

    /**
     * gets the current warehouse of interest
     *
     * @return the pickup warehouse if not yet picked up, else dropoff
     */
    public Warehouse getLocation() { 
        if(!pickedUp){
            return pickup;
        }else{
            return dropoff; 
        }
    }

    /**
     * assign the truck holding this shipment
     *
     * @param t the truck picking up this shipment
     */
    public void setTruck(Truck newtruck) { 
        this.truck = newtruck; 
    }

    /**
     * writes the current status of the shipment to the log
     *
     * @return the id of the shipment
     */
     @Override public int log_status(){
        try(FileWriter fw=new FileWriter("MapLOG.log",true)){
            if(this.truck!=null && pickedUp==true && this.truck.finished()==false){
            fw.write("Shipment "+id+", Source:"+pickup.getId()+", Going:"+dropoff.getId()+", Size:"+size+", In Truck: " +this.truck.getID() + "\n");
        }else if(pickedUp){
            fw.write("Shipment "+id+", Source:"+pickup.getId()+", Going:"+dropoff.getId()+", Size:"+size+" In Warehouse: "+dropoff.getId() + "\n");
        }else{
            fw.write("Shipment "+id+", Source:"+pickup.getId()+", Going:"+dropoff.getId()+", Size:"+size+" In Warehouse: "+pickup.getId() + "\n");
        }
        }catch(IOException e){
            return -1;
        }
        return id;
    }
    
    @Override public void action(){}
    
    /**
     * computes the distance from a location to this shipments pickup
     *
     * @param loc x y coordinates of a specific location
     * @return the distance
     */
    public double getDistance(int[] loc) {
        Warehouse w = getLocation();
        int dx = loc[0] - w.getX(); 
        int dy = loc[1] - w.getY();
        //shortest path is hypotnuse, so that equals distance
        return Math.hypot(dx, dy);
    }

    /**
     * compares by distance + recency priority
     *
     * @param o the other shipment
     * @return negative if this has higher priority
     */
    @Override
    public int compareTo(Shipment other) {
        int[] loc = truck.getLocation();
        double d1 = getDistance(loc);
        double d2 = other.getDistance(loc);
        if (d1 < d2){
            return -1; 
        }
        if (d1 > d2) {
            return 1;
        }
        // if distances are equal prioritize the newer shipment
        return Integer.compare(other.id, this.id);
    }

    /**
     * String representation including ID, size, and pickup state
     *
     * @return formatted string of shipment data
     */
    @Override
    public String toString() {
        return "Shipment" + id + "(" + size + "," + pickedUp + ")";
    }
}

