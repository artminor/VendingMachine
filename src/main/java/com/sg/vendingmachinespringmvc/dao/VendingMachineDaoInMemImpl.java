/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.service.VendingMachinePersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineDaoInMemImpl implements VendingMachineDao {

    private Map<Integer, Item> items;

    public VendingMachineDaoInMemImpl() {
        items = new HashMap<>();
        items.put(1, new Item(1, "Snickers", new BigDecimal("1.85"), 9));
        items.put(2, new Item(2, "M & Ms", new BigDecimal("1.50"), 2));
        items.put(3, new Item(3, "Pringles", new BigDecimal("2.10"), 5));
        items.put(4, new Item(4, "Reese's", new BigDecimal("1.85"), 4));
        items.put(5, new Item(5, "Pretzels", new BigDecimal("1.25"), 9));
        items.put(6, new Item(6, "Twinkies", new BigDecimal("1.95"), 3));
        items.put(7, new Item(7, "Doritos", new BigDecimal("1.75"), 11));
        items.put(8, new Item(8, "Almond Joy", new BigDecimal("1.85"), 0));
        items.put(9, new Item(9, "Trident", new BigDecimal("1.95"), 6));
    }

//    @Override
//    public Item addItem(String itemId, Item item) throws VendingMachinePersistenceException {
//        Item newItem = items.put(itemId, item);
//        writeInventory();
//        return newItem;
//    }
    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(int itemId) throws VendingMachinePersistenceException {

        return items.get(itemId);
    }

    @Override
    public Item vendItem(Item item) throws VendingMachinePersistenceException {
        //update the hashMap
        items.put(item.getItemId(), item);
        //write to inventory file

        return item;
    }

}
