package com.ATM.serivce;

import com.ATM.domain.Card;
import com.ATM.model.PinNumberDetailsModel;
import com.ATM.model.WithdrawDetailsModel;

import java.math.BigDecimal;

public interface CardService {

    Boolean isBlockedCard(String cardNumber);

    PinNumberDetailsModel isValidPinNumber(String cardNumber, String pinNumber);

    Card getCard(String cardNumber);

    WithdrawDetailsModel withdraw(String cardNumber, String operationCode, BigDecimal withdrawalAmount);
}
