package com.ATM.serivce;

import com.ATM.model.PinNumberDetailsModel;

public interface CardService {

    Boolean isBlockedCard(String cardNumber);

    PinNumberDetailsModel isValidPinNumber(String cardNumber, String pinNumber);
}
