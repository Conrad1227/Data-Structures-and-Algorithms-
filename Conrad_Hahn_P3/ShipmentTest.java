

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

/**
 * The test class ShipmentTest.
 *
 * @author  Conrad Hahn
 * @version 5/188/2025
 */
public class ShipmentTest
{
    /**
     * Default constructor for test class ShipmentTest
     */
    public ShipmentTest()
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
     * tests Shipment constructors and toString
     */
    @Test
    public void testConstructors() {
        Warehouse w1 = new Warehouse(0, 0, 1);
        Warehouse w2 = new Warehouse(1, 1, 1);
        Shipment sRand = new Shipment(w1, w2);
        //random size in [1,3]
        assertTrue(sRand.getSize() >= 1 && sRand.getSize() <= 3, "Test 1 Failed");
        Shipment stester = new Shipment(w1, w2, 5);
        //size should be what it was set to 
        assertEquals(5, stester.getSize(), "Test 2 Failed");
        //ID should be positive
        assertTrue(stester.getID() > 0, "Test 3 Failed");
        //testing toString expecting id plus the size and if it been picked up
        assertEquals("Shipment"+stester.getID()+"(5,false)",stester.toString(), "Test 4 Failed");
        
    }

    /**
     * Test Shipment pickUp(), hasBeenPickedUp(), getLocation(), and getDistance().
     */
    @Test
    public void testShipmentPickupAndDistance() {
        Warehouse w1 = new Warehouse(0, 0, 1);
        Warehouse w2 = new Warehouse(3, 4, 1);
        Shipment s = new Shipment(w1, w2, 2);
        // Test 1: not picked up initially
        assertFalse(s.hasBeenPickedUp(), "Test 1 Failed");
        // Test 2: initial location = pickup
        assertEquals(w1, s.getLocation(), "Test 2 Failed");
        s.pickUp();
        // Test 3: hasBeenPickedUp after pickUp
        assertTrue(s.hasBeenPickedUp(), "Test 3 Failed");
        // Test 4: location after pickUp = dropoff
        assertEquals(w2, s.getLocation(), "Test 4 Failed");
        // Test 5: getDistance returns correct hypotenuse
        int[] loc = {0, 0};
        double dist = s.getDistance(loc);
        assertEquals(5.0, dist, 1e-6, "Test 5 Failed");
    }

    /**
     * Test Shipment.compareTo priority ordering.
     */
    @Test
    public void testShipmentCompareTo() {
        Warehouse w = new Warehouse(0, 0, 1);
        Shipment s1 = new Shipment(w, w, 1); // older
        Shipment s2 = new Shipment(w, w, 1); // newer
        MyList<Shipment> empty = new MyList<>();
        Truck t = new Truck(0, 0, 5, empty);
        s1.setTruck(t);
        s2.setTruck(t);
        // Test 1: s2 should have higher priority (newer)
        assertTrue(s2.compareTo(s1) < 0, "Test 1 Failed");
    }
    
    /**
     * tests Shipments log_status
     */
    @Test
    public void testLog_Status() {
        try{
        Warehouse w1 = new Warehouse(0, 0, 1);
        Warehouse w2 = new Warehouse(1, 1, 1);
        Shipment stester = new Shipment(w1, w2, 5);
        stester.log_status();
        File f = new File("MapLOG.log");
        assertTrue(f.exists(), "Test 2 Failed");
        //read the file to test output
        Scanner scnr = new Scanner(f);
        //the first line would be the cycle so need second
        String log = scnr.nextLine();
        //should have same id for shipment, source and going warehouses, and current warehouse
        assertEquals("Shipment "+stester.getID()+", Source:"+w1.getId()+", Going:"+w2.getId()+", Size:5 In Warehouse: "+w1.getId(),log,"Test 5 Failed");
        w1.addShipment(stester);
        MyList<Shipment> ships = new MyList<>();
        Truck trtester = new Truck(0,0,5,ships);
        trtester.addOrder(stester);
        trtester.action();
        trtester.action();
         stester.pickUp();
         stester.log_status();
         log = scnr.nextLine();
        //now should be in truck 
        assertEquals("Shipment "+stester.getID()+", Source:"+w1.getId()+", Going:"+w2.getId()+", Size:5, In Truck: "+trtester.getID(),log, "Test 6 Failed");
        trtester.action();
        trtester.action();
        trtester.action();
        trtester.action();
        trtester.action();
        trtester.clear();
         stester.log_status();
         log = scnr.nextLine();
        //now should be at final warehouse
        assertEquals("Shipment "+stester.getID()+", Source:"+w1.getId()+", Going:"+w2.getId()+", Size:5 In Warehouse: "+w2.getId(),log, "Test 7 Failed");
    }catch(Exception e){}
    }
    
}
