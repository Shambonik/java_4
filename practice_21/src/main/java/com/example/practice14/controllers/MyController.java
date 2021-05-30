package com.example.practice14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {
    @GetMapping(value = "/main")
    public String main(){
        return "main";
    }
}
