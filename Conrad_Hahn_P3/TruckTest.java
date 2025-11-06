import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

/**
 * The test class TruckTest.
 *
 * @author  Conrad Hahn
 * @version 5/18/2025
 */
public class TruckTest
{
    /**
     * Default constructor for test class WarehouseTest
     */
    public TruckTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() throws IOException
    {
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
     * tests Truck constructor  getLocation and getID
     */
    @Test
    public void testTruckConstructorAndAccessor() {
        MyList<Shipment> empty = new MyList<>();
        Truck tester = new Truck(2, 3, 4, empty);
        //getLocation should return location that was set
        assertArrayEquals(new int[]{2, 3}, tester.getLocation(), "Test 1 Failed");
        //id should be a positive value
        assertTrue(tester.log_status() > 0, "Test 2 Failed");
    }

    /**
     * tests finished method
     */
    @Test
    public void testTruckFinished() {
        MyList<Shipment> empty = new MyList<>();
        Truck tester = new Truck(0, 0, 5, empty);
        //with no orders the truck should be finished
        assertTrue(tester.finished(), "Test 1 Failed");
        //with one order it should no longer be finished
        MyList<Shipment> sh = new MyList<>();
        Warehouse w = new Warehouse(0, 0, 1);
        Shipment s = new Shipment(w, w, 1);
        sh.add(s);
        Truck tester2 = new Truck(0, 0, 5, sh);
        assertFalse(tester2.finished(), "Test 2 Failed");
    }

    /**
     * tests Truck movement toward pickup warehouse
     */
    @Test
    public void testTruckMovement() {
        Warehouse src = new Warehouse(5, 0, 1);
        Warehouse dst = new Warehouse(6, 0, 1);
        Shipment s = new Shipment(src, dst, 1);
        MyList<Shipment> sh = new MyList<>();
        sh.add(s);
        int capacity = 4;
        Truck tester = new Truck(0, 0, capacity, sh); // speed 2
        int[] start = tester.getLocation();
        tester.action(); // move toward src
        //x should increase by the speed which is 2
        assertEquals(start[0] + tester.getSpeed(), tester.getLocation()[0], "Test 1 Failed");
    }
    
    /**
     * tests full load-unload cycle 
     */
    @Test
    public void testTruckLoadUnloadCycle() {
        Warehouse w = new Warehouse(0, 0, 1);
        MyList<Shipment> sh = new MyList<>();
        Shipment s = new Shipment(w, w, 1);
        sh.add(s);
        Truck tester = new Truck(0, 0, 5, sh);
        //truck should enter warehouse and pickup then dropoff the shipment
        //takes 6 ticks: move, load, move, unload, move back, unload
        for (int i = 0; i < 6; i++) {
            tester.action();
        }
        //after 6 cycles the truck should be finished
        assertTrue(tester.finished(), "Test 1 Failed");
    }
    

    /**
     * tests that log_status writes to file in proper format and returns ID
     */
    @Test
    public void testTruckLogStatus() throws IOException {
        MyList<Shipment> empty = new MyList<>();
        Truck tester = new Truck(0, 0, 5, empty);
        Warehouse w1 = new Warehouse(1,1,2);
        Warehouse w2 = new Warehouse(0,0,2);
        Shipment stest = new Shipment(w1,w2,3);
        w1.addShipment(stest);
        empty.add(stest);
        Truck tester2 = new Truck(1, 1, 3, empty);
        int id = tester.getID();
        //test that is returns the id
        assertEquals(id, tester.log_status(), "Test 1 Failed");
        //confirm file exists
        File f = new File("MapLOG.log");
        assertTrue(f.exists(), "Test 2 Failed");
        //read the file to test output
        
        Scanner scnr = new Scanner(f);
        //the first line would be the cycle so need second
        String log = scnr.nextLine();
        //expecting truck with its own id, 75,32 for coordinates, a size of 5 and therefore speed of 1
        assertEquals("Truck "+id+", [0,0] , Cargo:0/5, Speed:1",log,"Test 3 Failed");
        //call until truck has shipment
        tester2.action();
        tester2.action();
        tester2.action();
        tester2.action();
        tester2.action();
        tester2.log_status();
        log = scnr.nextLine();
        log+= scnr.nextLine();
        id = tester2.getID();
        //expecting now a truck with 1,1 position with full cargo and speed 3 with the shipment on board with size 3 and id's relating to the shipment and warehouses
        assertEquals("Truck "+id+", [1,1] , Cargo:3/3, Speed:3 (Id "+stest.getID()+" Source: "+w1.getId()+", Going: "+w2.getId()+", Size:3)",log,"Test 4 Failed");
    }
}
