package com.tw.core.controll;

import org.springframework.stereotype.Controller;
import com.tw.core.entity.Person;
import com.tw.core.service.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by xiaohang on 7/13/15.
 */
@RestController
@RequestMapping("/")
public class FirstController {

    @Autowired
    private Dao dao;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView printHello(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
            view.setViewName("index");
            view.addObject("persons", dao.getAllPerson());
        } else {
            response.addCookie(new Cookie("cookie", "/hello"));
            view.setViewName("login");

        }
        return view;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView userAdd(HttpServletRequest request) {
//        @RequestParam String name, String sex, String email, String age
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
            Person onePerson = new Person();
            onePerson.setName(request.getParameter("name"));
            onePerson.setSex(request.getParameter("sex"));
            onePerson.setEmail(request.getParameter("email"));
            onePerson.setAge(Integer.parseInt(request.getParameter("age")));
            dao.addPerson(onePerson);

            view.addObject("persons", dao.getAllPerson());
            view.setViewName("index");
        } else {
            view.setViewName("login");
        }
        return view;
    }

        @RequestMapping(value = "/delete", method = RequestMethod.GET)
        public ModelAndView userDelete ( HttpServletRequest request, HttpServletResponse response){
//            @RequestParam int id
            ModelAndView view = new ModelAndView();
            HttpSession session = request.getSession();
//            if(session.getAttribute("isLogin") == null){
//                view.setViewName("login");
//            }
            if (session.getAttribute("isLogin") == "yes") {
//                session.invalidate();
                dao.deletePerson(new Integer(request.getParameter("id")));
                view.setViewName("index");
                view.addObject("persons", dao.getAllPerson());
            }
            else{
                response.addCookie(new Cookie("cookie", "/delete"));
                view.setViewName("login");
            }
            return view;
        }

        @RequestMapping(value = "/update", method = RequestMethod.GET)
        public ModelAndView userUpdate ( HttpServletRequest request) {
            ModelAndView view = new ModelAndView();
            HttpSession session = request.getSession();
            if (session.getAttribute("isLogin") == "yes") {
//                session.invalidate();
                view.setViewName("update");
                Person onePerson = new Person();
                onePerson.setId(new Integer(request.getParameter("id")));
                view.addObject("person", onePerson);
            }
            else {
                view.setViewName("login");
            }
            return view;
        }

        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public ModelAndView userUpdate ( HttpServletRequest request, HttpServletResponse response){
//            @RequestParam int id, String name, String sex, String email,int age
            ModelAndView view = new ModelAndView();
            HttpSession session = request.getSession();
            if (session.getAttribute("isLogin") == "yes") {
//                session.invalidate();
                Person onePerson = new Person();
                onePerson.setName(request.getParameter("name"));
                onePerson.setSex(request.getParameter("sex"));
                onePerson.setEmail(request.getParameter("email"));
                onePerson.setAge(Integer.parseInt(request.getParameter("age")));
                dao.updatePerson(onePerson, new Integer(request.getParameter("id")));
                view.setViewName("index");
                view.addObject("persons", dao.getAllPerson());
            }else {
                view.setViewName("login");
            }
            return view;
        }

    }
