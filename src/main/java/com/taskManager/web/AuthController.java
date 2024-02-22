package com.taskManager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/authorization")
    public String auth() {
        return "authorization";
    }

}
