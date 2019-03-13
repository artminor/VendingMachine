/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import java.math.BigDecimal;

/**
 *
 * @author Jun
 */
public class InsufficientFundsException extends Exception {

    private String message;
    private BigDecimal remaining;

    public InsufficientFundsException(String message, BigDecimal remaining) {
        this.message = message;
        this.remaining = remaining;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    @Override
    public String getMessage() {
        return message + remaining;
    }
}
