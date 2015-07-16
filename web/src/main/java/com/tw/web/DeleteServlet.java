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
 * Created by xiaohang on 7/9/15.
 */
public class DeleteServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        PrintWriter out = res.getWriter();

        PersonDao user = new PersonDao();
        int index = new Integer(req.getParameter("id"));
        user.deletePerson(index);
        List<Person> persons = user.getAllPerson();
        System.out.println("#######" + persons.size());

        req.setAttribute("persons", persons);

        req.getRequestDispatcher("/index.jsp").forward(req, res);



    }
}
