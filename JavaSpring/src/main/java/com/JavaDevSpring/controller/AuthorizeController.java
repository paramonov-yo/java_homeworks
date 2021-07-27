package com.JavaDevSpring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    Authentication auth;

    @GetMapping("/")
    public String getUserName(@RequestParam(required = false) String userName, Model model) {
        try {
            auth = SecurityContextHolder.getContext().getAuthentication();
            userName = auth.getName();
            model.addAttribute("userName", userName);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Пользователя невозможно идентифицировать");
        }
        System.out.println("User name is: " + userName);
        return "home_page";
    }

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String login, Model model) {
        System.out.println("login is: " + login);
        model.addAttribute("login", login);
        return "home_page";
    }
}
