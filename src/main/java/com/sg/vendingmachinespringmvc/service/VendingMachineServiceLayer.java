/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Jun
 */
public interface VendingMachineServiceLayer {

    List<Item> getAllItems() throws VendingMachinePersistenceException;

    Item getItem(int itemId) throws VendingMachinePersistenceException;

    Change vendItem() throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException;

    BigDecimal DepositMoney(BigDecimal money) throws VendingMachinePersistenceException;

    void addDollar();

    void addQuarter();

    void addDime();

    void addNickel();

    void setMyMoney(BigDecimal myMoney);

    BigDecimal displayDeposit();

    int getItemChoice();

    String displayMsg();

    Change displayChange();

    void setItemChoice(int itemId);

    public void returnChange();

}
