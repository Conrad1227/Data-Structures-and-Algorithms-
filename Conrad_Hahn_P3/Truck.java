import java.io.IOException;
import java.io.*;

/**
 * Truck class that carries out deliveries
 *
 * @author Conrad Hahn
 * @version 5/18/2025
 */
class Truck implements Schedule {
    private static int nextID = 1;
    private final int id;
    private int[] loc = new int[2];
    private final int capacity, speed;
    private int load = 0;
    private  Stack<Shipment> onboard = new Stack<>();
    private  MyList<Shipment> orders = new MyList<>();
    private Shipment next;
    private double timer;
    private int state;
    private int cycle;

    /**
     * Construct a truck at a location with capacity
     *
     * @param x starting x-coordinate
     * @param y starting y-coordinate
     * @param capacity maximum amount of cargo the truck can hold
     */
    public Truck(int x, int y, int capacity) {
        this.id = nextID++;
        this.loc[0] = x; 
        this.loc[1] = y;
        this.capacity = capacity;
        this.speed = 6 - capacity;
        this.state = 0;
        this.timer = 0;
        this.cycle = 0;
    }
    
    
    /**
     * Construct a truck at a location with capacity and shipments for testing
     *
     * @param x starting x-coordinate
     * @param y starting y-coordinate
     * @param capacity maximum amount of cargo the truck can hold
     * @param shipList list of shipments assigned to this truck used for testing
     */
    public Truck(int x, int y, int capacity, MyList<Shipment> shipList) {
        this.id = nextID++;
        this.loc[0] = x; 
        this.loc[1] = y;
        this.capacity = capacity;
        this.speed = 6 - capacity;
        for (int i = 0; i < shipList.numvals(); i++) {
            Shipment s = shipList.get(i);
            if (s.getSize() <= capacity) {
                s.setTruck(this);
                orders.add(s);
            }
        }
        this.state = 0;
        this.timer = 0;
        this.cycle = 0;
    }

    /**
     * gets the current location of this truck
     *
     * @return an array [x,y] for the location
     */
    public int[] getLocation() { 
        return new int[]{ loc[0], loc[1] };
    }


    /**
     * preforms one of three possible moves depening on the location of the truck
     * move, queue, or transfer
     * uses states to keep track of what to do next
     */
    @Override
    public void action() {
        cycle++;
        if (timer > 0) {
            timer--;
            if (timer <= 0) {
                completeTransfer();
            }
            return;
        }
        if (next != null && loc[0] == getTarget().getX() && loc[1] == getTarget().getY()) {
            state = 4;
            queueDock();
            return;
        }
        if (state == 0 || next == null){
            chooseNext();
        }
        if (state == 1){
            moveOneStep();
        }
    }

    /**
     * determines the target warehouse 
     * dropoff if carrying, else pickup
     *
     * @return the next Warehouse target
     */
    public Warehouse getTarget() {
        if(onboard.isEmpty()){
            return next.getLocation();
        }else{
            return onboard.peek().getLocation();
        }
    }

    /**
     * adds a shipment to this trucks order list
     *
     * @param s the shipment to add
     */
    public void addOrder(Shipment s) {
        s.setTruck(this);
        orders.add(s);
    }

    /**
     * chooses the next shipment task based on priority
     */
    private void chooseNext() {
        if (!onboard.isEmpty()) {
            next = onboard.peek();
        } else if (!orders.isEmpty()) {
            Shipment best = null;
            for (int i = 0; i < orders.numvals(); i++) {
                Shipment s = orders.get(i);
                if (best == null || s.compareTo(best) < 0){
                    best = s;
                }
            }
            if (best != null) {
                next = best;
                // remove best
                for (int i = 0; i < orders.numvals(); i++) {
                    if (orders.get(i) == best) {
                        orders.removeAt(i);
                        break;
                    }
                }
            }
        }
        if (next != null){
            state = 1; 
        }
    }

    /**
     * moves the truck towards the target warehouse by its speed in miles.
     */
    private void moveOneStep() {
        Warehouse w = getTarget();
        int dx = w.getX() - loc[0];
        if (dx != 0) {
            loc[0] += Math.signum(dx) * Math.min(speed, Math.abs(dx));
        }else {
            int dy = w.getY() - loc[1];
            loc[1] += Math.signum(dy) * Math.min(speed, Math.abs(dy));
        }
    }

    /**
     * queues a truck at a dock and prepares it for transfer
     */
    private void queueDock() {
        Warehouse w = getTarget();
        w.arrive(this);
        prepareTransfer();
    }

    /**
     * determines load/unload timing and set state
     */
    private void prepareTransfer() {
        Warehouse w = getTarget();
        if (!onboard.isEmpty() && onboard.peek().getLocation() == w) {
            state = 3;
            timer = onboard.peek().getSize();
        } else {
            state = 2;
            timer = next.getSize();
        }
    }

    /**
     * completes a load or unload of shipments
     */
    private void completeTransfer() {
        if (state == 2) { //loading
            // remove the shipment from its source warehouse and add it to truck
            Warehouse src = next.getLocation();
            src.removeShipment();
            next.pickUp();
            onboard.push(next);
            load += next.getSize();
        } else if (state == 3) {  // unloading
            // pop the shipment off the truck, then add it to the destination warehouse
            Shipment done = onboard.pop();
            load -= done.getSize();
            Warehouse dst = done.getLocation();
            dst.addShipment(done);
        }
        // reset for the next call
        next  = null;
        state = 0;
    }

    /**
     * checks if all tasks are complete
     *
     * @return true if no pending or onboard shipments remain
     */
    public boolean finished() {
        return next == null && orders.isEmpty() && onboard.isEmpty();
    }
    
    /**
     * clears the orders and onboard lists for testing
     */
    public void clear(){
        onboard = new Stack<>();
        orders = new MyList<>();
    }
    
    /**
     * logs this trucks ID to the global log
     *
     * @return this truck's ID
     */
    @Override public int log_status(){
        try(FileWriter fw=new FileWriter("MapLOG.log",true)){
            fw.write("Truck "+id+", [" + loc[0] + "," + loc[1] + "] , Cargo:" + load +"/" + capacity + ", Speed:" + speed + "\n");
            for(int i=0;i<onboard.size();i++){
                Shipment s=onboard.pop();
                fw.write(" (Id " + s.getID() + " Source: " + s.getSourceID() + ", Going: " + s.getDestID() + ", Size:" + s.getSize() + ")\n");
                onboard.push(s);
            }
        }catch(IOException e){
            return -1;
        }
        return id;
    }

    /**
     * gets this trucks speed
     *
     * @return the current speed of the truck
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * gets this trucks id
     *
     * @return the ID of this truck
     */
    public int getID() {
        return id;
    }
    
    /**
     * string representation of truck and ID
     *
     * @return string with truck id
     */
    @Override
    public String toString() {
        return "Truck: " + id;
    }
}
