package com.taskManager.web;

import com.taskManager.dto.TaskDto;
import com.taskManager.service.TaskService;
import com.taskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@Controller
@RequestMapping("/homepage")
public class HomeController {

    private final TaskService taskService;

    private final UserService userService;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("task", new TaskDto());
        modelAndView.addObject("tasks", taskService.getTasks());
        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "task") TaskDto task, BindingResult result) {
        taskService.save(task);
        return "redirect:/homepage";
    }

}
