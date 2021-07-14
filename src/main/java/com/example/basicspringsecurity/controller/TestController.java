package com.example.basicspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping(value = "/index")
    public String index(){
        return "home/index";
    }

    @GetMapping(value = "/about")
    public String about(){
        return "home/about";
    }

    @GetMapping(value = "/admin")
    public String admin(){
        return "home/admin";
    }

}
