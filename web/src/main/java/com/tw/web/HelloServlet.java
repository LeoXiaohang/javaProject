package com.tw.web;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.core.dao.PersonDao;
import com.tw.core.entity.Person;

public class HelloServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//        res.setContentType("text/html;charset=utf-8");
//        PrintWriter out = res.getWriter();
//        List<entity> persons = new ArrayList<entity>();
        PersonDao user = new PersonDao();
        List<Person> persons = user.getAllPerson();
        req.setAttribute("persons", persons);
//        for (entity person: persons) {
//            out.println(person.name+" "+person.sex+" "+person.email+" "+person.sex);
//        }
        req.getRequestDispatcher("/index.jsp").forward(req, res);
//        for(int i=0; i < persons.size(); i++){
//            out.printf(persons.get(i).name+""+persons.get(i).sex+""+persons.get(i).email+""+persons.get(i).age+"<br>");
//        }
//        out.close();
    }
}