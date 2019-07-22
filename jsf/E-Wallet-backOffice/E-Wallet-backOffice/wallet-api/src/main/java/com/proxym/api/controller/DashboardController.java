package com.proxym.api.controller;


import com.proxym.api.services.cashInService;
import com.proxym.api.services.cashOutService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.ManagedBean;
import java.util.Optional;

@Controller
@ManagedBean
@Slf4j
public class DashboardController {

    @Autowired
    private cashInService cashinService;

    @Autowired
    private cashOutService cashoutService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @GetMapping(value = {"/dash",""})
    public ModelAndView index(@RequestParam Optional<String> error){

        LOGGER.info("started from / ");
        ModelAndView modelAndView = new ModelAndView("dashboard", "error", error);

        String Cashins = cashinService.getNumOfCashIn();

        String Cashouts = cashoutService.getNumOfCashOut();

        modelAndView.addObject("Cashins",Cashins);
        modelAndView.addObject("Cashouts",Cashouts);


        return  modelAndView;
    }


}
