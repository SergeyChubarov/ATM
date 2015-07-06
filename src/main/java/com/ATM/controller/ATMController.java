package com.ATM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ATMController {

    @RequestMapping(value = "/card/{cardNumber}/isBlocked", method = RequestMethod.GET)
    @ResponseBody
    public Boolean checkCardState(@PathVariable("cardNumber") String cardNumber) {
        // check state if true set 0 to attempts
        return true;
    }

}
