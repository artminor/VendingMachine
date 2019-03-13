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
public class Change {

    Item item;

    private int quarters = 0, dimes = 0, nickels = 0, pennies = 0;

    public Change(BigDecimal deposit) {

//        enums
        BigDecimal one = Coins.PENNY.getCoin();
        BigDecimal five = Coins.NICKLE.getCoin();
        BigDecimal ten = Coins.DIME.getCoin();
        BigDecimal twentyFive = Coins.QUARTER.getCoin();
        BigDecimal oneHundred = new BigDecimal("100");

        //w/o enums
//        BigDecimal one = new BigDecimal("1");
//        BigDecimal five = new BigDecimal("5");
//        BigDecimal ten = new BigDecimal("10");
//        BigDecimal twentyFive = new BigDecimal("25");
//        BigDecimal oneHundred = new BigDecimal("100");
        BigDecimal customerChange = deposit.multiply(oneHundred);

        while (customerChange.floatValue() > 0) {
            if (customerChange.floatValue() >= 25) {
                customerChange = customerChange.subtract(twentyFive);
                quarters++;
            } else if (customerChange.floatValue() >= 10) {
                customerChange = customerChange.subtract(ten);
                dimes++;
            } else if (customerChange.floatValue() >= 5) {
                customerChange = customerChange.subtract(five);
                nickels++;
            } else {
                customerChange = customerChange.subtract(one);
                pennies++;
            }

        }
        //pennies = deposit.intValue();
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }

}
