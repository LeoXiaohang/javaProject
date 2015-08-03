package com.tw.core.controller;

import com.tw.core.service.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.CookieValue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by xiaohang on 7/14/15.
 */
@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private Dao dao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView userLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@CookieValue("cookie") String path,
                                  @RequestParam String userName, String password, HttpServletRequest request, HttpServletResponse response) {
        if (dao.getPersonPasswordCorrect(userName, password) == true) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", "yes");
            if (path != "/hello") {
                return new ModelAndView("redirect:" + path);
            } else {
                return new ModelAndView("redirect:/hello");
            }
        } else {
            return new ModelAndView("login");
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView userLogout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("isLogin", "no");
        return new ModelAndView("login");
    }

}
