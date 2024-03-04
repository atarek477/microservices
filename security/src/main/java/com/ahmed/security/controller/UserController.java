package com.ahmed.security.controller;


import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController{
    @GetMapping("/login/user")
    public String login() {
        return "login-user";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/welcome")
    public String welcome(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String role = userDetails.getAuthorities().toString();
        if (role.contains("MERCHANT")) {
            model.addAttribute("message", "Welcome Merchant");
        } else if (role.contains("CUSTOMER")) {
            model.addAttribute("message", "Welcome Customer");
        }
        return "welcome";
    }
}
