package com.taskManager.web;

import com.taskManager.dto.TaskDto;
import com.taskManager.model.TaskEntity;
import com.taskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class HomeController {

    private final TaskService taskService;

    @GetMapping("/homepage")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("task", new TaskDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute(name = "task") TaskDto task, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("main");

        taskService.save(task);

        return modelAndView;
    }

}
