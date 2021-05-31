package com.example.practice14.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class MyController {

    @GetMapping(value = "/main")
    public String main(){
        return "main";
    }

}
