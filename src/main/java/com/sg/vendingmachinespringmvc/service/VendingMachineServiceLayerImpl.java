/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;
    private BigDecimal myMoney;
    private Change change;
    private int itemChoice;
    private String msg;

    @Inject
    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
        this.myMoney = new BigDecimal("0.00");
        this.msg = "";
        this.change = null;
        this.itemChoice = 0;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(int itemId) throws VendingMachinePersistenceException {
        return dao.getItem(itemId);
    }

    @Override
    public Change vendItem() throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException {
        Item boughtItem = getItem(itemChoice);
        Change c = null;
        if (boughtItem == null) {
            throw new NoItemInventoryException("No such item.");
        }

        if (boughtItem.getCount() > 0) {
            boughtItem.buyOne();
            dao.vendItem(boughtItem);
            msg = "Thank you!";
            if (myMoney.compareTo(boughtItem.getPrice()) < 0) {
                throw new InsufficientFundsException("Insufficient funds. Please deposit: $", boughtItem.getPrice().subtract(myMoney));
            }
            myMoney = myMoney.subtract(boughtItem.getPrice());
            c = new Change(myMoney);
            this.myMoney = new BigDecimal("0.00");
        } else {
            throw new NoItemInventoryException("No more " + boughtItem.getName() + " in vending machine.");
        }

        return c;
    }

    @Override
    public BigDecimal DepositMoney(BigDecimal money) throws VendingMachinePersistenceException {
        //adding money to current BigDecimal
        this.myMoney = this.myMoney.add(money);
        return this.myMoney;
    }

    @Override
    public void addDollar() {
        this.myMoney = this.myMoney.add(new BigDecimal("1.00"));
    }

    @Override
    public void addQuarter() {
        this.myMoney = this.myMoney.add(new BigDecimal(".25"));
    }

    @Override
    public void addDime() {
        this.myMoney = this.myMoney.add(new BigDecimal(".10"));
    }

    @Override
    public void addNickel() {
        this.myMoney = this.myMoney.add(new BigDecimal(".05"));
    }

    @Override
    public BigDecimal displayDeposit() {
        return this.myMoney;
    }

    @Override
    public String displayMsg() {
        return msg;
    }

    @Override
    public Change displayChange() {
        return change;
    }

    @Override
    public int getItemChoice() {
        return itemChoice;
    }

    @Override
    public void setItemChoice(int id) {
        this.itemChoice = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void setMyMoney(BigDecimal myMoney) {
        this.myMoney = myMoney;
    }

    public void setChange(Change change) {
        this.change = change;
    }

    @Override
    public void returnChange() {
        myMoney = new BigDecimal("0.00");
        change = null;
        itemChoice = 0;
    }

}
