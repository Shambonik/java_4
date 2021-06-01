package com.example.practice14.controllers;

import com.example.practice14.models.User;
import com.example.practice14.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;


@Controller
@RequiredArgsConstructor
public class MyController {
    private final UserService userService;

    @GetMapping(value = "/main")
    public String main(){
        return "main";
    }

    @GetMapping("/login")
    public String getPage(@AuthenticationPrincipal User user){
        if(user!=null){
            return "redirect:/main";
        }
        return "login";
    }

    @GetMapping("/registration")
    public String getPage(@AuthenticationPrincipal User user, Model model){
        if(user!=null){
            return "redirect:/main";
        }
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        if(!userService.addUser(user)){
            model.put("message", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
