package com.ATM.dao;

import com.ATM.domain.Card;

public interface CardDao {

    Card getByNumber(String cardNumber);

    void blockCardByNumber(String cardNumber);

    void setPinInvalidAttemptsByNumber(String cardNumber, Integer attempts);
}
