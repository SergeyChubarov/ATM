package com.ATM.utils;

public class ControllerValidator {
    public static Boolean isValidCardNumber(String cardNumber) {
        return !(cardNumber.length() < 16);
    }

    public static Boolean isValidPinNumber(String pinNumber) {
        return !(pinNumber.length() < 4);
    }
}
