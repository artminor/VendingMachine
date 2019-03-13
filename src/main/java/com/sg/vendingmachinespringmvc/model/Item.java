package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jun
 */
public class Item {

    private String name;
//    private String brand;
    private Integer itemId;
    private BigDecimal price;
    private int count;

    public Item() {
    }

    public Item(Integer itemId, String name, BigDecimal price, int inventory) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.count = inventory;
    }

    public Integer buyOne() {
        return count -= 1;
    }

    public Item(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
    public Integer getItemId() {
        return itemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ID: " + itemId + " | Item: "
                + name + " | Price: " + price + " | Quantity: " + count;
    }
}
