package com.ATM.dao.impl;

import com.ATM.dao.CardDao;
import com.ATM.domain.Card;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDaoImpl implements CardDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Card getByNumber(String cardNumber) {
        Query query = getSession().createQuery("from Card where number = :cardNumber");
        List cards = query.setParameter("cardNumber", cardNumber).list();
        if (cards.isEmpty() || cards.get(0) == null) {
            throw new RuntimeException("No cards found for card number: " + cardNumber);
        }
        return (Card) cards.get(0);
    }

    @Override
    public void blockCardByNumber(String cardNumber) {
        Query query = getSession().createQuery("update Card set isBlocked = true where number = :cardNumber");
        query.setString("cardNumber", cardNumber).executeUpdate();
    }

    @Override
    public void setPinInvalidAttemptsByNumber(String cardNumber, Integer attempts) {
        Query query = getSession().createQuery("update Card set invalidPinAttemptsCount = :attempts where number = :cardNumber");
        query
                .setString("cardNumber", cardNumber)
                .setInteger("attempts", attempts)
                .executeUpdate();
    }
}
