package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/5.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        System.out.println("xxxxx");
        return "index";
    }
}
