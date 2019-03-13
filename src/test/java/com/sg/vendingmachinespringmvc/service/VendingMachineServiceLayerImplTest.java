/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.dao.VendingMachineDaoInMemImpl;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jun
 */
public class VendingMachineServiceLayerImplTest {

    VendingMachineServiceLayer instance;

    public VendingMachineServiceLayerImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        instance = ctx.getBean("VendingMachineService", VendingMachineServiceLayer.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayerImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllItems() throws Exception {
        System.out.println("getAllItems");
        List<Item> result = instance.getAllItems();
        int lengthOfList = result.size();
        //if true then list holds 9 items
        assertEquals(9, lengthOfList);
    }

    /**
     * Test of getItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetItem_int() throws Exception {
        System.out.println("getItem");
        int itemId = 4;
        Item sampleItem = instance.getItem(itemId);
        assertEquals("Reese's", sampleItem.getName());
    }

//    /**
//     * Test of vendItem method, of class VendingMachineServiceLayerImpl.
//     */
    @Test
    public void testVendItem() throws Exception {
        System.out.println("vendItem");
        instance.setItemChoice(5);
        //if tests fail here, then whatever add method is failing with the corresponding currency
        instance.setMyMoney(new BigDecimal("1.50"));
        Change resultChange = instance.vendItem();
        //this tests for buying one item with 2 dollars assuming there is inventory
        assertEquals(0, resultChange.getNickels());
        assertEquals(0, resultChange.getDimes());
        assertEquals(0, resultChange.getPennies());
        assertEquals(1, resultChange.getQuarters());
    }

    /**
     * Test of displayDeposit method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testDisplayDeposit() {
        System.out.println("displayDeposit");
        instance.setMyMoney(new BigDecimal("1.50"));
        String result = instance.displayDeposit().toString();
        assertEquals("1.50", result);
    }

    @Test
    public void testAddDollar() {
        System.out.println("addDollar");
        instance.addDollar();
        String result = instance.displayDeposit().toString();
        assertEquals("1.00", result);
    }

    @Test
    public void testAddQuarter() {
        System.out.println("addQuarter");
        instance.addQuarter();
        String result = instance.displayDeposit().toString();
        assertEquals("0.25", result);
    }

    @Test
    public void testAddDime() {
        System.out.println("addDime");
        instance.addDime();
        String result = instance.displayDeposit().toString();
        assertEquals("0.10", result);
    }

    @Test
    public void testAddNickel() {
        System.out.println("addNickel");
        instance.addNickel();
        String result = instance.displayDeposit().toString();
        assertEquals("0.05", result);
    }

    /**
     * Test of displayMsg method, of class VendingMachineServiceLayerImpl.
     */
//    @Test
//    public void testDisplayMsg() {
//        System.out.println("displayMsg");
//        String expResult = "Thank you!";
//
//        instance.setItemChoice(5);
//        //if tests fail here, then whatever add method is failing with the corresponding currency
//        instance.setMyMoney(new BigDecimal("1.50"));
//        instance.vendItem();
//        String result = instance.displayMsg();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of displayChange method, of class VendingMachineServiceLayerImpl.
//     */
//    @Test
//    public void testDisplayChange() {
//        System.out.println("displayChange");
//        VendingMachineServiceLayerImpl instance = null;
//        Change expResult = null;
//        Change result = instance.displayChange();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getItemChoice method, of class VendingMachineServiceLayerImpl.
//     */
//    @Test
//    public void testGetItemChoice() {
//        System.out.println("getItemChoice");
//        VendingMachineServiceLayerImpl instance = null;
//        int expResult = 0;
//        int result = instance.getItemChoice();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setItemChoice method, of class VendingMachineServiceLayerImpl.
//     */
//    @Test
//    public void testSetItemChoice() {
//        System.out.println("setItemChoice");
//        int id = 0;
//        VendingMachineServiceLayerImpl instance = null;
//        instance.setItemChoice(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMsg method, of class VendingMachineServiceLayerImpl.
//     */
//    @Test
//    public void testSetMsg() {
//        System.out.println("setMsg");
//        String msg = "";
//        VendingMachineServiceLayerImpl instance = null;
//        instance.setMsg(msg);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMyMoney method, of class VendingMachineServiceLayerImpl.
//     */
//    @Test
//    public void testSetMyMoney() {
//        System.out.println("setMyMoney");
//        BigDecimal myMoney = null;
//        VendingMachineServiceLayerImpl instance = null;
//        instance.setMyMoney(myMoney);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setChange method, of class VendingMachineServiceLayerImpl.
//     */
//    @Test
//    public void testSetChange() {
//        System.out.println("setChange");
//        Change change = null;
//        VendingMachineServiceLayerImpl instance = null;
//        instance.setChange(change);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getItem method, of class VendingMachineServiceLayerImpl.
//     */
//    @Test
//    public void testGetItem_0args() {
//        System.out.println("getItem");
//        VendingMachineServiceLayerImpl instance = null;
//        Object expResult = null;
//        Object result = instance.getItem();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of returnChange method, of class VendingMachineServiceLayerImpl.
//     */
//    @Test
//    public void testReturnChange() {
//        System.out.println("returnChange");
//        VendingMachineServiceLayerImpl instance = null;
//        instance.returnChange();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
