package com.taskManager.web;

import com.taskManager.dto.TaskUpdateDto;
import com.taskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/taskPage")
    public ModelAndView task(Integer taskId) {
        ModelAndView modelAndView = new ModelAndView("taskPage");
        modelAndView.addObject("task", taskService.getTaskById(taskId));
        modelAndView.addObject("updateDto", new TaskUpdateDto());
        modelAndView.addObject("commL", taskService.getComms());
        modelAndView.addObject("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute(name = "updateDto") TaskUpdateDto updateDto, Integer taskId) {
        taskService.update(taskId, updateDto);
        return task(taskId);
    }

}
