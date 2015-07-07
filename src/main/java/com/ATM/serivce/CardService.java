package com.ATM.serivce;

public interface CardService {

    Boolean isBlockedCard(String cardNumber);

    Boolean isValidPinNumber(String cardNumber, String pinNumber);
}
