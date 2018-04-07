package com.nklongyi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by longyi on 2017/8/22.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String showAdminIndex(){
        return "admin/index";
    }
}
