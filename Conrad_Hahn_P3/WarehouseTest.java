
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.io.*;

/**
 * The test class WarehouseTest.
 *
 * @author  Conrad Hahn
 * @version 5/18/2025
 */
public class WarehouseTest
{
    /**
     * Default constructor for test class WarehouseTest
     */
    public WarehouseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() throws IOException {
        try (FileWriter fw = new FileWriter("MapLOG.log", false)) {
        }
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
     * tests Warehouse getters
     */
    @Test
    public void testWarehouseGetters() {
        Warehouse wtester = new Warehouse(7, 8, 3);
        //getX should return X cord
        assertEquals(7, wtester.getX(), "Test 1 Failed");
        //getY should return Y cord
        assertEquals(8, wtester.getY(), "Test 2 Failed");
        //getId should be positive
        assertTrue(wtester.getId() > 0, "Test 3 Failed");
    }

    /**
     * tests Warehouse inventory last in first out system
     */
    @Test
    public void testWarehouseInventory() {
        Warehouse wtest1 = new Warehouse(0, 0, 1);
        Warehouse wtest2 =  new Warehouse(0, 0, 2);
        Shipment s1 = new Shipment(wtest1, wtest2, 1);
        Shipment s2 = new Shipment(wtest1, wtest2, 2);
        wtest1.addShipment(s1);
        wtest1.addShipment(s2);
        //removeShipment returns first added
        assertEquals(s1, wtest1.removeShipment(), "Test 1 Failed");
        //next removeShipment should return the next value
        assertEquals(s2, wtest1.removeShipment(), "Test 2 Failed");
        //removeShipment on empty returns null
        assertNull(wtest1.removeShipment(), "Test 3 Failed");
    }

    /**
     * tests Warehouse arrive and action serving dock limits
     */
    @Test
    public void testWarehouseArriveAndServe() {
        Warehouse wtester = new Warehouse(0, 0, 1);
        MyList<Shipment> empty = new MyList<>();
        Truck t1 = new Truck(0, 0, 5, empty);
        Truck t2 = new Truck(0, 0, 5, empty);
        wtester.arrive(t1);
        wtester.arrive(t2);
        //two trucks in queue
        assertEquals(2, wtester.queue.size(), "Test 1 Failed");
        wtester.action();
        //after action with 1 dock, one remains
        assertEquals(1, wtester.queue.size(), "Test 2 Failed");
    }

    /**
     * tests Warehouse log_status returns ID
     */
    @Test
    public void testWarehouseLogStatus() {
        Warehouse wtest = new Warehouse(0, 0, 1);
        int id = wtest.getId();
        try{
            File f = new File("MapLOG.log");
            f.delete();
            f.createNewFile();
            //log_status returns ID
            assertEquals(id, wtest.log_status(), "Test 1 Failed");
            Scanner scnr = new Scanner(f);
            String log = scnr.nextLine();
            //expecting Warehouse with position 0,0 and 1 dock with no shipments
            //id is unknown due to how I kept track of them
            assertEquals("WareHouse "+id+", [0, 0], Docks:1, []",log,"Test 2 Failed");
            Shipment stest = new Shipment(wtest,wtest,2);
            wtest.addShipment(stest);
            wtest.log_status();
            log = scnr.nextLine();
            //should be the same except now shipment of size 2 should be in the inventory
            assertEquals("WareHouse "+id+", [0, 0], Docks:1, [Shipment"+stest.getID()+"(2,false)]",log,"Test 2 Failed");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
