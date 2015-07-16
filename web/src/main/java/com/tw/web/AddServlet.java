package com.tw.web;


import com.tw.core.entity.Person;
import com.tw.core.dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaohang on 7/10/15.
 */
public class AddServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PersonDao user = new PersonDao();
        List<Person> persons = user.getAllPerson();
        req.setAttribute("persons", persons);
        req.getRequestDispatcher("/index.jsp").forward(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PersonDao user = new PersonDao();
        Person onePerson = new Person();

////        onePerson.setId(Integer.parseInt(req.getParameter("id")));
        onePerson.setName(req.getParameter("name"));
        onePerson.setSex(req.getParameter("sex"));
        onePerson.setEmail(req.getParameter("email"));
        onePerson.setAge(Integer.parseInt(req.getParameter("age")));
        user.addPerson(onePerson);
        System.out.println("####"+onePerson.getName()+onePerson.getId());
        doGet(req, res);

    }
}

