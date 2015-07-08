package com.ATM.controller;

import com.ATM.model.PinNumberDetailsModel;
import com.ATM.serivce.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ATMController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/card/{cardNumber}/isBlocked", method = RequestMethod.GET)
    @ResponseBody
    public Boolean checkCardState(@PathVariable("cardNumber") String cardNumber) {

        if (!isValidCardNumber(cardNumber)) {
            throw new RuntimeException("Invalid card number");
        }
        return cardService.isBlockedCard(cardNumber);
    }

    @RequestMapping(value = "/card/{cardNumber}/pin/{pinNumber}/checkPinNumber", method = RequestMethod.GET)
    @ResponseBody
    public PinNumberDetailsModel checkPinNumber(
            @PathVariable("cardNumber") String cardNumber,
            @PathVariable("pinNumber") String pinNumber) {

        if (!isValidPinNumber(pinNumber)) {
            throw new RuntimeException("Invalid pin number");
        }

        return cardService.isValidPinNumber(cardNumber, pinNumber);
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String checkPinNumber() {
        return "operations";
    }

    private Boolean isValidCardNumber(String cardNumber) {
        return !(cardNumber.length() < 16);
    }

    private Boolean isValidPinNumber(String pinNumber) {
        return !(pinNumber.length() < 4);
    }
}
