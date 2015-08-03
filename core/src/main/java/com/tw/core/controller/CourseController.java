package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.service.CoaDao;
import com.tw.core.service.CouDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class CourseController {
    @Autowired
    private CouDao couDao;

    @Autowired
    private CoaDao coaDao;

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    public ModelAndView printSubject(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
            view.addObject("coachs", coaDao.selector());
            view.setViewName("subject");
            view.addObject("courses", couDao.getAllCourse());
        } else {
            response.addCookie(new Cookie("cookie", "/subject"));
            view.setViewName("login");
        }
        return view;
    }

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public ModelAndView addSubject(HttpServletRequest request, HttpServletResponse response, @RequestParam int coach) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
            Course course = new Course();
            course.setCoach(coaDao.getCoach(coach));
            course.setCourse(request.getParameter("course"));
            course.setTime(request.getParameter("time"));
            couDao.addSubject(course);
            view.setViewName("subject");
            view.addObject("courses", couDao.getAllCourse());
            view.addObject("coachs", coaDao.selector());
        } else {
            response.addCookie(new Cookie("cookie", "/addSubject"));
            view.setViewName("login");
        }
        return view;
    }

    @RequestMapping(value = "/deleteSubject", method = RequestMethod.GET)
    public ModelAndView deleteSubject(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
            couDao.deleteCourse(new Integer(request.getParameter("id")));
            view.setViewName("subject");
            view.addObject("courses", couDao.getAllCourse());
            view.addObject("coachs", coaDao.selector());
        } else {
            response.addCookie(new Cookie("cookie", "/subject"));
            view.setViewName("login");
        }
        return view;
    }
}
