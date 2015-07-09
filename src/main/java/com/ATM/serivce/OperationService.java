package com.ATM.serivce;

import com.ATM.domain.Operation;

public interface OperationService {

    void saveBalanceOperation(String cardNumber, String code);

    void saveWithdrawOperation(Operation operation);
}
