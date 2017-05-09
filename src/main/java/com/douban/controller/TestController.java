package com.douban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lhw2 on 2017/4/29.
 */
@Controller
public class TestController {
    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "longView")
    public String longView(){
        return "longView";
    }

    @RequestMapping(value = "pinglun")
    public String pinglun(){
        return "pinglun";
    }

    @RequestMapping(value = "ranking")
    public String ranking(){
        return "Rangking";
    }

    @RequestMapping(value = "review")
    public String review(){
        return "Review";
    }

}

