package com.douban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lhw2 on 2017/4/29.
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){

        return "index";
    }
}

