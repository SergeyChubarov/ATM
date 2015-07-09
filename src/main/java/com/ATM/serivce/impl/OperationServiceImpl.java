package com.ATM.serivce.impl;

import com.ATM.dao.OperationDao;
import com.ATM.domain.Card;
import com.ATM.domain.Operation;
import com.ATM.serivce.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationDao operationDao;

    public void saveBalanceOperation(String cardNumber, String code) {
        Card card = new Card();
        card.setNumber(cardNumber);
        Operation operation = new Operation();
        operation.setCard(card);
        operation.setCode(code);
        operation.setDate(new Date());
        operationDao.save(operation);
    }

    public void saveWithdrawOperation(Operation operation) {
        operation.setDate(new Date());
        operationDao.save(operation);
    }
}
