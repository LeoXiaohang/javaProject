package com.tw.core.controll;

import com.tw.core.entity.Employee;
import com.tw.core.service.CoaDao;
import com.tw.core.service.EmpDao;
import com.tw.core.util.Md5;
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
public class UserController {

    @Autowired
    private Dao dao;

    @Autowired
    private EmpDao empDao;

    @Autowired
    private CoaDao coaDao;

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
    public ModelAndView userAdd(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
            Person onePerson = new Person();
            onePerson.setUserName(request.getParameter("userName"));
            onePerson.setPassword(Md5.getMd5(request.getParameter("password")));
            Employee employee = new Employee();
            employee.setName(request.getParameter("name"));
            employee.setDepartment(request.getParameter("department"));
            empDao.addEmployee(onePerson, employee);
            view.addObject("persons", dao.getAllPerson());
            view.setViewName("index");
        } else {
            response.addCookie(new Cookie("cookie", "/add"));
            view.setViewName("login");
        }
        return view;
    }

        @RequestMapping(value = "/delete", method = RequestMethod.GET)
        public ModelAndView userDelete ( HttpServletRequest request, HttpServletResponse response){
//            @RequestParam int id
            ModelAndView view = new ModelAndView();
            HttpSession session = request.getSession();
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
        public ModelAndView userUpdateGet ( HttpServletRequest request, HttpServletResponse response) {
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
                response.addCookie(new Cookie("cookie", "/update"));
                view.setViewName("login");
            }
            return view;
        }

        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public ModelAndView userUpdatePost ( HttpServletRequest request, HttpServletResponse response){
            ModelAndView view = new ModelAndView();
            HttpSession session = request.getSession();
            if (session.getAttribute("isLogin") == "yes") {
//                session.invalidate();
                Person onePerson = new Person();
                onePerson.setUserName(request.getParameter("userName"));
                onePerson.setPassword(request.getParameter("password"));
                dao.updatePerson(onePerson, new Integer(request.getParameter("id")));
                view.setViewName("index");
                view.addObject("persons", dao.getAllPerson());
            }else {
                response.addCookie(new Cookie("cookie", "/update"));
                view.setViewName("login");
            }
            return view;
        }

    }
