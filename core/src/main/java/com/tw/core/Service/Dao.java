package com.tw.core.service;

import com.tw.core.dao.PersonDao;
import com.tw.core.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaohang on 7/13/15.
 */
@Service
public class Dao {
    @Autowired
    private PersonDao personDao;

    public List<Person> getAllPerson(){
        return personDao.getAllPerson();
    }

    public void addPerson(Person onePerson){
        personDao.addPerson(onePerson);
    }

    public void deletePerson(int index){
        personDao.deletePerson(index);
    }

    public void updatePerson(Person onePerson, int index){
        personDao.updatePerson(onePerson, index);
    }

    public boolean getPersonPasswordCorrect(String name, String password){return personDao.getPersonPasswordCorrect(name, password);}
}
