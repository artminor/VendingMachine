/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.service.InsufficientFundsException;
import com.sg.vendingmachinespringmvc.service.NoItemInventoryException;
import com.sg.vendingmachinespringmvc.service.VendingMachinePersistenceException;
import com.sg.vendingmachinespringmvc.service.VendingMachineServiceLayer;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jun
 */
@Controller

public class VendingMachineController {

    VendingMachineServiceLayer service;

    @Inject
    public VendingMachineController(VendingMachineServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("deposit", service.displayDeposit());
        try {
            model.addAttribute("itemButtons", service.getAllItems());
        } catch (VendingMachinePersistenceException ex) {
            model.addAttribute("msg", ex.getMessage());
        }
        model.addAttribute("itemId", service.getItemChoice());
        return "index";
    }

    @RequestMapping(value = "/chooseItem/{itemId}", method = RequestMethod.GET)
    public String chooseItem(@PathVariable("itemId") int itemId) {
        service.setItemChoice(itemId);
        return "redirect:/";
    }

    @RequestMapping(value = "/addDollar", method = RequestMethod.GET)
    public String addDollar() {
        service.addDollar();
        return "redirect:/";
    }

    @RequestMapping(value = "/addQuarter", method = RequestMethod.GET)
    public String addQuarter() {
        service.addQuarter();
        return "redirect:/";
    }

    @RequestMapping(value = "/addDime", method = RequestMethod.GET)
    public String addDime() {
        service.addDime();
        return "redirect:/";
    }

    @RequestMapping(value = "/addNickel", method = RequestMethod.GET)
    public String addNickel() {
        service.addNickel();
        return "redirect:/";
    }

    @RequestMapping(value = "/vendItem", method = RequestMethod.GET)
    public String vendItem(Model model) {
        try {
            model.addAttribute("change", service.vendItem());
            model.addAttribute("msg", service.displayMsg());
        } catch (NoItemInventoryException ex) {
            model.addAttribute("msg", ex.getMessage());
        } catch (InsufficientFundsException ex) {
            model.addAttribute("msg", ex.getMessage());
        } catch (VendingMachinePersistenceException ex) {
            model.addAttribute("msg", ex.getMessage());
        }
        return index(model);
    }

    @RequestMapping(value = "/returnChange", method = RequestMethod.GET)
    public String returnChange(Model model) {
        service.returnChange();
        return index(model);
    }

}
