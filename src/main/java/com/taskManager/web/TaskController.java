package com.taskManager.web;

import com.taskManager.model.TaskEntity;
import com.taskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/taskPage")
    public ModelAndView task(Integer taskId) {
        ModelAndView modelAndView = new ModelAndView("taskPage");
        modelAndView.addObject("task", taskService.getTaskById(taskId));
        return modelAndView;
    }

}
