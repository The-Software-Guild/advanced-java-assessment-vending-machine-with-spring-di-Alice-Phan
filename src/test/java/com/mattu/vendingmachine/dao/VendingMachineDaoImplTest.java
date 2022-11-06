
package com.mattu.vendingmachine.dao;

import com.sal.vendingmachine.dao.VendingMachineDao;
import com.sal.vendingmachine.dao.VendingMachineDaoImpl;
import com.sal.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author salajrawi
 */
public class VendingMachineDaoImplTest {
    
    public static VendingMachineDao testDao;
    
    public VendingMachineDaoImplTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
        testDao = new VendingMachineDaoImpl();
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        testDao = new VendingMachineDaoImpl();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

    /**
     * Test of getItem method, of class VendingMachineDaoImpl.
     */
    @org.junit.jupiter.api.Test
    public void testGetItem() throws Exception {
     //implement
        String name = "Boba tea";
        BigDecimal cost = new BigDecimal("5.95");
        int count = 5;
        Item item = new Item(name, cost, count);

        testDao.addItem(item);

        Item getItem = testDao.getItem(item.getName());

        // Check if the data is equal
        assertEquals(item.getName(), getItem.getName(), "Checking the name of the item.");

    }

    /**
     * Test of listAllItems method, of class VendingMachineDaoImpl.
     */
    @org.junit.jupiter.api.Test
    public void testListAllItems() throws Exception {
        List<Item> testList = testDao.listAllItems();


        String nameTest1 = "Boba tea";
        BigDecimal costTest1 = new BigDecimal("5.95");
        int countTest1 = 5;
        Item itemTest1 = new Item(nameTest1, costTest1, countTest1);

        String nameTest2 = "Yogurt";
        BigDecimal costTest2 = new BigDecimal("4.99");
        int countTest2 = 10;
        Item itemTest2 = new Item(nameTest2, costTest2, countTest2);

        // add the item
        testDao.addItem(itemTest1);
        testDao.addItem(itemTest2);

        assertFalse(testList.isEmpty(), "The list should include all items.");


    }

    /**
     * Test of changeInventoryCount method, of class VendingMachineDaoImpl.
     */
    @org.junit.jupiter.api.Test
    public void testChangeInventoryCount() throws Exception {
      //implement





    }
    
}
