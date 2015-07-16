package com.tw.core.controll;

import com.tw.core.service.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xiaohang on 7/14/15.
 */
@Controller
@RequestMapping("/")
public class inController {
    @Autowired
    private Dao dao;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam String userName, String password) {

        if(dao.getPersonPasswordCorrect(userName, password) == true) {
            return new ModelAndView("afterLogin");
        }
        else {
            return new ModelAndView("login");
        }
    }
}
