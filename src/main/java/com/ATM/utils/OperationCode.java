package com.ATM.utils;

public enum OperationCode {
    Balance("B"),
    Withdraw("W");

    private String operationCode;

    OperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationCode() {
        return operationCode;
    }
}
