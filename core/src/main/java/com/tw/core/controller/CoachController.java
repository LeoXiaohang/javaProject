package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.service.CoaDao;
import com.tw.core.service.CusDao;
import com.tw.core.service.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaohang on 7/19/15.
 */
@RestController
@RequestMapping("/")
public class CoachController {

    @Autowired
    private Dao dao;

    @Autowired
    private CoaDao coaDao;

    @Autowired
    private CusDao cusDao;

    @RequestMapping(value = "/coach", method = RequestMethod.GET)
    public ModelAndView printCoach(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
            view.setViewName("coach");
            view.addObject("coachs", coaDao.getAllCoach());
            view.addObject("customerId", request.getParameter("id"));
        } else {
            response.addCookie(new Cookie("cookie", "/coach"));
            view.setViewName("login");
        }
        return view;
    }

    @RequestMapping(value = "/selectCoach", method = RequestMethod.GET)
    public ModelAndView selectOneCoach(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
            int id = cusDao.saveCoachOfCustomer(new Integer(request.getParameter("id")), new Integer(request.getParameter("customerId")));
            view.addObject("id", id);
            view.addObject("courses", coaDao.getCoachAllCourse(id));
            view.setViewName("course");
        } else {
            response.addCookie(new Cookie("cookie", "/selectCoach"));
            view.setViewName("login");
        }
        return view;
    }



    @RequestMapping(value = "/selectCoach", method = RequestMethod.POST)
    public ModelAndView selectCoach(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//                session.invalidate();
            Course course = new Course();
            course.setCourse(request.getParameter("course"));
            course.setTime(request.getParameter("time"));
            coaDao.saveCourseOfCoach(new Integer(request.getParameter("id")), course);

            view.setViewName("course");
            view.addObject("courses", coaDao.getCoachAllCourse(new Integer(request.getParameter("id"))));
        } else {
            response.addCookie(new Cookie("cookie", "/selectCoach"));
            view.setViewName("login");
        }
        return view;
    }


}
