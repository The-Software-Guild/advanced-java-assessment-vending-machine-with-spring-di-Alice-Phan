
package com.mattu.vendingmachine.service;

import com.sal.vendingmachine.service.VendingMachineServiceImpl;
import com.sal.vendingmachine.service.VendingMachineItemInventoryException;
import com.sal.vendingmachine.service.VendingMachineService;
import com.sal.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sal.vendingmachine.dao.AuditDao;
import com.sal.vendingmachine.dao.AuditDaoImpl;
import com.sal.vendingmachine.dao.VendingMachineDao;
import com.sal.vendingmachine.dao.VendingMachineDaoImpl;
import com.sal.vendingmachine.dao.VendingMachineException;
import com.sal.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author salajrawi
 */
public class VendingMachineServiceImplTest {
    
    public static VendingMachineService service;
    
    public VendingMachineServiceImplTest() {

         // wire service layer object to stub DAOs
//        VendingMachineDao dao =  ;
//        AuditDao auditDao = new AuditDaoImpl();
//
//        service = new VendingMachineServiceImpl(dao, auditDao);


        /*
          Instantiate the ApplicationContext
          We have to hand the name of the fie configuration file which is applicationContext.xml
          When the vending machine service layer test is constructed, we're going to ask the spring container, we're gonna instantiate this application context
          It's gonna find the application context xml, and it's going to parse through the beans
          Assign the service instance to the vending machine service layer so that we can use the test bellow
          The second parameter tells the getBean method what to cast at it, in this case it is VendingMachineService.class
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = context.getBean("serviceLayer", VendingMachineService.class);


    }
    
    @BeforeAll
    public static void setUpClass() throws VendingMachineException{
        //implement
        service = new VendingMachineServiceImpl();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws VendingMachineException {
       //implement
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getItem method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testGetItem() throws Exception {
   //implement
//        Item testItem = new Item("Cheetos",  new BigDecimal(2.99).setScale(2,RoundingMode.FLOOR), 18);

        Item testClone = new Item("Cheetos");
            testClone.setCost(new BigDecimal("2.99").setScale(2, RoundingMode.FLOOR));
            testClone.setNumInventoryItems(10);

        Item shouldBeCheetos = service.getItem("Cheetos");
//        assertNotNull(shouldBeCheetos,"Getting cheetos should not be null.");
        assertEquals(testClone, shouldBeCheetos,"Item should be cheetos." );

        Item shouldBeNull = service.getItem("Cheese cups");
        assertNull(shouldBeNull, "Getting 'cheese cups' should be null");





    }

    /**
     * Test of listAllItems method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testListAllItems() throws Exception {
        assertEquals(1, service.listAllItems().size(), "items");
    }

    /**
     * Test of changeInventoryCount method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testChangeInventoryCount(){
        Item testItem = new Item("Cheetos",  new BigDecimal(2.99).setScale(2,RoundingMode.FLOOR), 100);
        try{
            service.changeInventoryCount(testItem, 100);
            assertNotNull(testItem, "Item should not be null");
            assertEquals(100, testItem.getNumInventoryItems(), "Inventory item should be 100");
        }catch(VendingMachineException e){
            fail("No way it will go wrong");
        }

        try{
            service.changeInventoryCount(testItem, -100);
        }catch(VendingMachineException e){
            System.out.println("the value should not be negative");
        }
    }

    /**
     * Test of sellItem method, of class VendingMachineServiceImpl.
     */
    @Test
    public void testSellItem(){
         //implement}
    }
    
}
