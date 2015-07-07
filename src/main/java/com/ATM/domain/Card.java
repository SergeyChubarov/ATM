package com.ATM.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CARD")
public class Card {
    private String number;
    private String pinNumber;
    private Integer invalidPinAttemptsCount;
    private Boolean isBlocked;
    private BigDecimal balance;
    private List<Operation> operations;

    public Card() {
    }

    public Card(String number, String pinNumber, Integer invalidPinAttemptsCount, Boolean isBlocked, BigDecimal balance, List<Operation> operations) {
        this.number = number;
        this.pinNumber = pinNumber;
        this.invalidPinAttemptsCount = invalidPinAttemptsCount;
        this.isBlocked = isBlocked;
        this.balance = balance;
        this.operations = operations;
    }

    @Id
    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(name = "PIN_NUMBER")
    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    @Column(name = "INVALID_PIN_ATTEMPTS_COUNT")
    public Integer getInvalidPinAttemptsCount() {
        return invalidPinAttemptsCount;
    }

    public void setInvalidPinAttemptsCount(Integer invalidPinAttemptsCount) {
        this.invalidPinAttemptsCount = invalidPinAttemptsCount;
    }

    @Column(name = "IS_BLOCKED")
    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Column(name = "BALANCE")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @OneToMany(mappedBy = "card")
    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (isBlocked != null ? !isBlocked.equals(card.isBlocked) : card.isBlocked != null) return false;
        if (number != null ? !number.equals(card.number) : card.number != null) return false;
        if (pinNumber != null ? !pinNumber.equals(card.pinNumber) : card.pinNumber != null) return false;
        if (invalidPinAttemptsCount != null ? !invalidPinAttemptsCount.equals(card.invalidPinAttemptsCount) : card.invalidPinAttemptsCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (pinNumber != null ? pinNumber.hashCode() : 0);
        result = 31 * result + (invalidPinAttemptsCount != null ? invalidPinAttemptsCount.hashCode() : 0);
        result = 31 * result + (isBlocked != null ? isBlocked.hashCode() : 0);
        return result;
    }
}
