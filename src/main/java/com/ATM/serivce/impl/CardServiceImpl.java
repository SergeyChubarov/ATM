package com.ATM.serivce.impl;

import com.ATM.dao.CardDao;
import com.ATM.domain.Card;
import com.ATM.serivce.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class CardServiceImpl implements CardService {

    private final static Integer MAX_PIN_NUMBER_INVALID_ATTEMPTS = 4;

    @Autowired
    CardDao cardDao;

    @Override
    public Boolean isBlockedCard(String cardNumber) {
        Card card = cardDao.getByNumber(cardNumber);
        Boolean isBlocked = card.getIsBlocked();
        // reset invalid pin number attempts in case of card is not in blocked state
        if (!isBlocked) {
            cardDao.setPinInvalidAttemptsByNumber(cardNumber, 0);
        }
        return isBlocked;
    }

    @Override
    public Boolean isValidPinNumber(String cardNumber, String pinNumber) {
        Card card = cardDao.getByNumber(cardNumber);
        if (card.getPinNumber().equals(pinNumber)) {
            return true;
        }
        checkPinNumberInvalidAttempts(card);
        return false;
    }

    private void checkPinNumberInvalidAttempts(Card card) {
        Integer invalidPinAttemptsCount = card.getInvalidPinAttemptsCount();
        String cardNumber = card.getNumber();
        if (invalidPinAttemptsCount >= MAX_PIN_NUMBER_INVALID_ATTEMPTS) {
            cardDao.blockCardByNumber(cardNumber);
        } else {
            cardDao.setPinInvalidAttemptsByNumber(cardNumber, ++invalidPinAttemptsCount);
        }
    }
}
