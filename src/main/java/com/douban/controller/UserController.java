package com.douban.controller;

import com.douban.entity.po.User;
import com.douban.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by lidey on 2017/5/9.
 */

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Object register(User user,HttpSession session) {
        Map<String,Object> map = userService.register(user);
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:login");
        session.setAttribute("register_message",map);
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Object login(User user, HttpSession session) {
        Map<String,Object> map = userService.login(user.getUsername(),user.getPassword());
        ModelAndView view = new ModelAndView();
        if (map.get("status").equals("success")) {
            session.setAttribute("login",map.get("login"));
            view.setViewName("redirect:index");
        }else{
            session.removeAttribute("login");
            view.setViewName("redirect:login");
        }
        session.setAttribute("login_message",map);
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "update_user", method = RequestMethod.POST)
    public Object updateUser(User user,HttpSession session) {
        Map<String,Object> map = userService.updateUser(user);
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:update_user");
        session.setAttribute("update_message",map);
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "get_user/{id}", method = RequestMethod.GET)
    public Object getUserById(int id) {
        Map<String,Object> map = userService.getUserById(id);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "disable_user/{id}", method = RequestMethod.GET)
    public Object disableUser(int id) {
        Map<String,Object> map = userService.disableUser(id);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "get_admins", method = RequestMethod.GET)
    public Object getAdmins() {
        Map<String,Object> map = userService.getAdmins();
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "get_normals", method = RequestMethod.GET)
    public Object getNormalUsers() {
        Map<String,Object> map = userService.getNormalUsers();
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "get_disables", method = RequestMethod.GET)
    public Object getDisable() {
        Map<String,Object> map = userService.getDisabledUsers();
        return map;
    }
}
