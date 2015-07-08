package com.ATM.serivce.impl;

import com.ATM.dao.CardDao;
import com.ATM.domain.Card;
import com.ATM.domain.Operation;
import com.ATM.model.PinNumberDetailsModel;
import com.ATM.serivce.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class CardServiceImpl implements CardService {

    private final static Integer MAX_PIN_NUMBER_INVALID_ATTEMPTS = 3;

    @Autowired
    CardDao cardDao;

    public Boolean isBlockedCard(String cardNumber) {
        Card card = cardDao.getByNumber(cardNumber);
        Boolean isBlocked = card.getIsBlocked();
        // reset invalid pin number attempts in case of card is not in blocked state
        if (!isBlocked) {
            cardDao.setPinInvalidAttemptsByNumber(cardNumber, 0);
        }
        return isBlocked;
    }

    public PinNumberDetailsModel isValidPinNumber(String cardNumber, String pinNumber) {
        PinNumberDetailsModel model = new PinNumberDetailsModel();
        Card card = cardDao.getByNumber(cardNumber);
        if (card.getPinNumber().equals(pinNumber) && !card.getIsBlocked()) {
            model.isValidPinNumber = true;
            return model;
        }
        model.isValidPinNumber = false;
        Integer invalidPinAttemptsCount = card.getInvalidPinAttemptsCount();
        // check for invalid pin number attempts
        if (invalidPinAttemptsCount.equals(MAX_PIN_NUMBER_INVALID_ATTEMPTS)) {
            if (!card.getIsBlocked()) {
                cardDao.blockCardByNumber(cardNumber);
            }
            model.isBlockedCard = true;
        } else {
            invalidPinAttemptsCount += 1;
            cardDao.setPinInvalidAttemptsByNumber(cardNumber, invalidPinAttemptsCount);
            model.isBlockedCard = false;
            model.invalidAttemptsCount = invalidPinAttemptsCount;
        }
        return model;
    }

    public Card getCard(String cardNumber) {
        return cardDao.getByNumber(cardNumber);
    }

    public void saveBalanceOperation(String cardNumber, String operationCode) {

    }
}
