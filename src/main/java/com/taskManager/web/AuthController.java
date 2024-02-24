package com.taskManager.web;

import com.taskManager.dto.UserDto;
import com.taskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authorization")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @GetMapping
    public ModelAndView auth() {
        ModelAndView modelAndView = new ModelAndView("authorization");
        modelAndView.addObject("signIn", new UserDto());
        return modelAndView;
    }

    @PostMapping("/signin")
    public ModelAndView signIn(@ModelAttribute(name = "signIn") UserDto userDto, BindingResult bindingResult) {
        service.save(userDto);
        return auth();
    }

}
