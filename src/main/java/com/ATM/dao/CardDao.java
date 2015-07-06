package com.ATM.dao;

public interface CardDao {

    Boolean isExistCardNumber(String cardNumber);

    Boolean checkPinNumber(String cardNumber, String pinNumber);
}
