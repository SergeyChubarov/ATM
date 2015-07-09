package com.ATM.controller;

import com.ATM.domain.Card;
import com.ATM.domain.Operation;
import com.ATM.model.WithdrawDetailsModel;
import com.ATM.serivce.CardService;
import com.ATM.serivce.OperationService;
import com.ATM.utils.ControllerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
    public String balanceOperation(Model model,
                             @RequestParam(value="cardNumber") String cardNumber,
                             @RequestParam(value="operationCode") String operationCode) {
        if (!ControllerValidator.isValidCardNumber(cardNumber) || cardService.isBlockedCard(cardNumber)) {
            throw new RuntimeException("Card is invalid or blocked");
        }
        operationService.saveBalanceOperation(cardNumber, operationCode);
        model.addAttribute("card", cardService.getCard(cardNumber));
        return "balance";
    }

    @RequestMapping(value = "/withdrawal", method = RequestMethod.GET)
    public String withdrawalOperation(Model model,
                                      @RequestParam(value="cardNumber") String cardNumber) {
        if (!ControllerValidator.isValidCardNumber(cardNumber) || cardService.isBlockedCard(cardNumber)) {
            throw new RuntimeException("Card is invalid or blocked");
        }
        model.addAttribute("cardNumber", cardNumber);
        return "withdrawal";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    @ResponseBody
    public WithdrawDetailsModel withdraw(@RequestParam(value = "cardNumber") String cardNumber,
                         @RequestParam(value = "operationCode") String operationCode,
                         @RequestParam(value = "withdrawalAmount") Integer withdrawalAmount) {
        if (!ControllerValidator.isValidCardNumber(cardNumber) || cardService.isBlockedCard(cardNumber)) {
            throw new RuntimeException("Card is invalid or blocked");
        }
        return cardService.withdraw(cardNumber, operationCode, BigDecimal.valueOf(withdrawalAmount));
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String getReport(Model model,
                                   @RequestParam(value="cardNumber") String cardNumber,
                                   @RequestParam(value="balance") BigDecimal balance,
                                   @RequestParam(value="withdrawalAmount") BigDecimal withdrawalAmount) {
        if (!ControllerValidator.isValidCardNumber(cardNumber) || cardService.isBlockedCard(cardNumber)) {
            throw new RuntimeException("Card is invalid or blocked");
        }
        model.addAttribute("cardNumber", cardNumber);
        model.addAttribute("balance", balance);
        model.addAttribute("withdrawalAmount", withdrawalAmount);
        return "report";
    }

}
