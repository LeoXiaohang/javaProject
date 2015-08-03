package com.tw.core.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.entity.Employee;
import com.tw.core.service.EmpDao;
import com.tw.core.util.HibernateProxyTypeAdapter;
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
import java.util.List;


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

    private Gson gson = new GsonBuilder()
//            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
            .setPrettyPrinting() //对json结果格式化.
            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String printHello(HttpServletRequest request, HttpServletResponse response) {
//        ModelAndView view = new ModelAndView();

//        HttpSession session = request.getSession();
//        if (session.getAttribute("isLogin") == "yes") {
//            session.invalidate();
//            view.setViewName("index");
//            view.addObject("persons", dao.getAllPerson());
        List persons = dao.getAllPerson();
        String data = gson.toJson(persons);
//        }
//         else {
//            response.sendRedirect("login");
//            response.addCookie(new Cookie("cookie", "/hello"));
//            view.setViewName("login");
//        }

        return data;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView user(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
            view.setViewName("add");
        } else {
            response.addCookie(new Cookie("cookie", "/add"));
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
    public ModelAndView userDelete(HttpServletRequest request, HttpServletResponse response) {
//            @RequestParam int id
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == "yes") {
//                session.invalidate();
            dao.deletePerson(new Integer(request.getParameter("id")));
            view.setViewName("index");
            view.addObject("persons", dao.getAllPerson());
        } else {
            response.addCookie(new Cookie("cookie", "/delete"));
            view.setViewName("login");
        }
        return view;
    }

//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//    public @ResponseBody Person userUpdateGet(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
////            ModelAndView view = new ModelAndView();
//        HttpSession session = request.getSession();
//        Person data = new Person();
//        if (session.getAttribute("isLogin") == "yes") {
////                session.invalidate();
////                view.setViewName("update");
//            data.setId(id);
////                view.addObject("person", onePerson);
//        } else {
////                response.addCookie(new Cookie("cookie", "/update"));
////                view.setViewName("login");
//        }
//        return data;
//    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    Person userUpdatePost(@PathVariable int id,
                          @RequestParam String userName,
                          @RequestParam String password,
                          HttpServletRequest request,
                          HttpServletResponse response) {

        HttpSession session = request.getSession();
        Person data = new Person();
        if (session.getAttribute("isLogin") == "yes") {
//                session.invalidate();
            System.out.println(id + "+++++++++++++++++++++++++++++++");
            Person onePerson = new Person();
            onePerson.setUserName(userName);
            onePerson.setPassword(Md5.getMd5(password));
            dao.updatePerson(onePerson, id);
            data = onePerson;
            data.setId(id);
            System.out.println(data.getId() + "++++++++++++++");
//
//            }
        }
        return data;
    }
}

