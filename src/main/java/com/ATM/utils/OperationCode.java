package com.ATM.utils;

public enum OperationCode {
    Balance(1),
    Withdraw(2);

    private Integer operationCode;

    OperationCode(Integer operationCode) {
        this.operationCode = operationCode;
    }

    public Integer getOperationCode() {
        return operationCode;
    }
}
