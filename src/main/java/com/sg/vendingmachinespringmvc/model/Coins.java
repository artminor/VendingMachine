/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author Jun
 */
public enum Coins {
    PENNY("1"), NICKLE("5"), DIME("10"), QUARTER("25");

    private String coin;

    private Coins(String coin) {
        this.coin = coin;
    }

    public BigDecimal getCoin() {
        return new BigDecimal(coin);
    }
}
