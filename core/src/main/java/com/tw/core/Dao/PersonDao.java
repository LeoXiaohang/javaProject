package com.tw.core.dao;

import com.tw.core.entity.Person;
import com.tw.core.util.Md5;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao {
    public static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public boolean getPersonPasswordCorrect(String userName, String password) {
        Session session = sessionFactory.openSession();
//        Query query = session.createSQLQuery("select password from person where name = '"+userName+"'").addEntity(Person.class);
//        Query query = session.createQuery("from Person where name = '"+userName+"' and password = '"+password+"'");
        Query query = session.createQuery("select count(*) from Person p where p.name=:name and p.password =:password");
        query.setParameter("name", userName);
        String psd = Md5.getMd5(password);
        query.setParameter("password", psd);
        Long judge = (Long) query.uniqueResult();
        session.close();
        return judge != 0;
    }


    public List<Person> getAllPerson() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Person");
        System.out.println(1111);
        List<Person> persons = query.list();
        session.close();

        return persons;
    }


    public void addPerson(Person onePerson) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(onePerson);
            tx.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deletePerson(int index) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person p = (Person) session.get(Person.class, index);
            session.delete(p);

            tx.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updatePerson(Person onePerson, int index) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person p = (Person) session.get(Person.class, index);
            p.setName(onePerson.getName());
            p.setSex(onePerson.getSex());
            p.setEmail(onePerson.getEmail());
            p.setAge(onePerson.getAge());

            tx.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
