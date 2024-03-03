package com.taskManager.web;

import com.taskManager.dto.TaskDto;
import com.taskManager.model.enums.TaskStatus;
import com.taskManager.service.TaskService;
import com.taskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ModelAndView home(Integer userId, Boolean isDescEmpty, TaskStatus status) {
        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("task", new TaskDto());
        modelAndView.addObject("users", userService.getUsers());
        modelAndView.addObject("acc", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (userId != null) {
            modelAndView.addObject("tasks", taskService.getTasksByExec(userId));
        } else if (isDescEmpty != null) {
            if (!isDescEmpty) {
                modelAndView.addObject("tasks", taskService.getTasksByDescEmpty());
            } else {
                modelAndView.addObject("tasks", taskService.getTasksByDescNotEmpty());
            }
        } else if (status != null) {
            modelAndView.addObject("tasks", taskService.getTasksByStatus(status));
        } else {
            modelAndView.addObject("tasks", taskService.getTasks());
        }
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "task") TaskDto task, BindingResult result) {
        taskService.save(task);
        return "redirect:/homepage";
    }

}
