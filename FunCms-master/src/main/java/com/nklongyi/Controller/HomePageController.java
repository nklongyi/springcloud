package com.nklongyi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主要用于前端页面的展示
 * Created by longyi on 2018-03-31.
 */
@Controller
public class HomePageController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String checkTheClientType(){
        return "hello";
    }

}
