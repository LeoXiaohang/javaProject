package com.tw.core.controller;

import com.tw.core.entity.Customer;
import com.tw.core.service.CoaDao;
import com.tw.core.service.CusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaohang on 7/20/15.
 */
@RestController
@RequestMapping("/")
public class CustomerController {
    @Autowired
    private CusDao cusDao;

    @Autowired
    private CoaDao coaDao;


    @RequestMapping(value = "/printAllCustomer", method = RequestMethod.GET)
    public ModelAndView printCustomer(HttpServletRequest request, HttpServletResponse response){
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("isLogin") == "yes"){
            view.setViewName("customer");
            view.addObject("customers", cusDao.getAllCustomer());
        }
        else {
            response.addCookie(new Cookie("cookie", "/printAllCustomer"));
            view.setViewName("login");
        }
        return view;
    }
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response){
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("isLogin") == "yes"){
            cusDao.deleteCustomer(new Integer(request.getParameter("id")));
            view.setViewName("customer");
            view.addObject("customers", cusDao.getAllCustomer());
        }
        else {
            response.addCookie(new Cookie("cookie", "/deleteCustomer"));
            view.setViewName("login");
        }
        return view;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response){
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("isLogin") == "yes"){
            Customer customer = new Customer();
            customer.setName(request.getParameter("name"));
            cusDao.addCustomer(customer);
            view.setViewName("customer");
            view.addObject("customers", cusDao.getAllCustomer());
        }
        else {
            response.addCookie(new Cookie("cookie", "/addCustomer"));
            view.setViewName("login");
        }
        return view;
    }

    @RequestMapping(value = "/getCourse", method = RequestMethod.GET)
    public ModelAndView printCourseOfCoach(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
            view.addObject("courses", coaDao.getCoachAllCourse(cusDao.getCoachIdOfCustomer(new Integer(request.getParameter("id")))));
            view.setViewName("course");
        } else {
            response.addCookie(new Cookie("cookie", "/getCourse"));
            view.setViewName("login");
        }
        return view;
    }
}
