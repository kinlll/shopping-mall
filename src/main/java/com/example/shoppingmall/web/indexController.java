package com.example.shoppingmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String index(){

//        int i = 9/0;
        return "index";
    }

    @GetMapping("/index")
    public String inde(){
        return "index";
    }
}
