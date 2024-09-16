package com.rc4.authorizationserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {
    @GetMapping("/views")
    public String goToBank() {
        return "forward:/";
    }
}
