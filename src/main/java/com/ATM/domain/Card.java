package com.ATM.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARD")
public class Card {
    private String number;
    private String pinNumber;
    private Integer pinNumberAttemptsCount;

    public Card(String number, String pinNumber, Integer pinNumberAttemptsCount) {
        this.number = number;
        this.pinNumber = pinNumber;
        this.pinNumberAttemptsCount = pinNumberAttemptsCount;
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

    @Column(name = "PIN_NUMBER_ATTEMPTS_COUNT")
    public Integer getPinNumberAttemptsCount() {
        return pinNumberAttemptsCount;
    }

    public void setPinNumberAttemptsCount(Integer pinNumberAttemptsCount) {
        this.pinNumberAttemptsCount = pinNumberAttemptsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (number != null ? !number.equals(card.number) : card.number != null) return false;
        if (pinNumber != null ? !pinNumber.equals(card.pinNumber) : card.pinNumber != null) return false;
        if (pinNumberAttemptsCount != null ? !pinNumberAttemptsCount.equals(card.pinNumberAttemptsCount) : card.pinNumberAttemptsCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (pinNumber != null ? pinNumber.hashCode() : 0);
        result = 31 * result + (pinNumberAttemptsCount != null ? pinNumberAttemptsCount.hashCode() : 0);
        return result;
    }
}
