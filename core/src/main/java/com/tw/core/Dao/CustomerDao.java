package com.tw.core.dao;

import com.tw.core.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaohang on 7/20/15.
 */
@Repository
public class CustomerDao {
    public List<CustomerDao> getAllCustomer(){
        Session session = SessionUtil.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<CustomerDao> customers = session.createQuery("from Customer").list();
        tx.commit();
        session.close();
        return customers;
    }
}
