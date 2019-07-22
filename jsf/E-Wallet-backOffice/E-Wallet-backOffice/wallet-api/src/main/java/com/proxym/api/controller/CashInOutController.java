package com.proxym.api.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.ManagedBean;
import java.util.Optional;

@Controller
@ManagedBean
@Slf4j
public class CashInOutController {

    @GetMapping("/cashin")
    public ModelAndView cashin(@RequestParam Optional<String> error){
        return new ModelAndView("cashin", "error", error);
    }

    @GetMapping("/cashout")
    public ModelAndView cashout(@RequestParam Optional<String> error){
        return new ModelAndView("cashout", "error", error);
    }
}
