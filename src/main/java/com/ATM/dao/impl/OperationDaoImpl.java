package com.ATM.dao.impl;

import com.ATM.dao.OperationDao;
import com.ATM.domain.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OperationDaoImpl implements OperationDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Operation operation) {
        getSession().saveOrUpdate(operation);
    }
}
