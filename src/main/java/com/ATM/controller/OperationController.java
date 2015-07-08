package com.ATM.controller;

import com.ATM.serivce.CardService;
import com.ATM.serivce.OperationService;
import com.ATM.utils.ControllerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String checkPinNumber(Model model,
                                 @RequestParam(value="cardNumber") String cardNumber) {
        if (!ControllerValidator.isValidCardNumber(cardNumber) || cardService.isBlockedCard(cardNumber)) {
            throw new RuntimeException("Card is invalid or blocked");
        }
        model.addAttribute("cardNumber", cardNumber);
        return "operations";
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public String getBalance(Model model,
                             @RequestParam(value="cardNumber") String cardNumber,
                             @RequestParam(value="operationCode") String operationCode) {
        if (!ControllerValidator.isValidCardNumber(cardNumber) || cardService.isBlockedCard(cardNumber)) {
            throw new RuntimeException("Card is invalid or blocked");
        }
        operationService.saveBalanceOperation(cardNumber, operationCode);
        model.addAttribute("card", cardService.getCard(cardNumber));
        return "balance";
    }

}
