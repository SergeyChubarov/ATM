package com.ATM.domain;

import com.ATM.utils.OperationCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "OPERATION")
public class Operation {
    private Long id;
    private Date date;
    private OperationCode code;
    private BigDecimal amountWithdrawn;
    private Card card;

    public Operation() {
    }

    public Operation(Long id, Date date, OperationCode operationCode, BigDecimal amountWithdrawn, Card card) {
        this.id = id;
        this.date = date;
        this.code = operationCode;
        this.amountWithdrawn = amountWithdrawn;
        this.card = card;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "CODE")
    public OperationCode getCode() {
        return code;
    }

    public void setCode(OperationCode code) {
        this.code = code;
    }

    @Column(name = "AMOUNT_WITHDRAWN")
    public BigDecimal getAmountWithdrawn() {
        return amountWithdrawn;
    }

    public void setAmountWithdrawn(BigDecimal amountWithdrawn) {
        this.amountWithdrawn = amountWithdrawn;
    }

    @ManyToOne
    @JoinColumn(name = "NUMBER")
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operation)) return false;

        Operation operation = (Operation) o;

        if (amountWithdrawn != null ? !amountWithdrawn.equals(operation.amountWithdrawn) : operation.amountWithdrawn != null)
            return false;
        if (card != null ? !card.equals(operation.card) : operation.card != null) return false;
        if (code != operation.code) return false;
        if (date != null ? !date.equals(operation.date) : operation.date != null) return false;
        if (id != null ? !id.equals(operation.id) : operation.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (amountWithdrawn != null ? amountWithdrawn.hashCode() : 0);
        result = 31 * result + (card != null ? card.hashCode() : 0);
        return result;
    }
}
