package com.ATM.serivce;

import com.ATM.domain.Card;
import com.ATM.model.PinNumberDetailsModel;

public interface CardService {

    Boolean isBlockedCard(String cardNumber);

    PinNumberDetailsModel isValidPinNumber(String cardNumber, String pinNumber);

    Card getCard(String cardNumber);
}
