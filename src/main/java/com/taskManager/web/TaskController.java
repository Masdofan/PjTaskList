package com.taskManager.web;

import com.taskManager.dto.SubtaskDto;
import com.taskManager.dto.TaskUpdateDto;
import com.taskManager.model.CommentEntity;
import com.taskManager.service.CommentService;
import com.taskManager.service.TaskService;
import com.taskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/taskPage")
@RequiredArgsConstructor
public class TaskController {

    private final UserService userService;
    private final TaskService taskService;
    private final CommentService commentService;

    @GetMapping
    public ModelAndView task(Integer taskId) {
        ModelAndView modelAndView = new ModelAndView("taskPage");
        modelAndView.addObject("task", taskService.getTaskById(taskId));
        modelAndView.addObject("updateDto", new TaskUpdateDto());
        modelAndView.addObject("commL", commentService.getCommsByTaskId(taskId));
        modelAndView.addObject("acc", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        modelAndView.addObject("comment", new CommentEntity());
        modelAndView.addObject("subtask", new SubtaskDto());
        modelAndView.addObject("subtasks", taskService.getSubsByMainId(taskId));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateDto") TaskUpdateDto updateDto, Integer taskId) {
        taskService.update(taskId, updateDto);
        return "redirect:/homepage";
    }

    @PostMapping("/leftComm")
    public String leftComm(@ModelAttribute(name = "comment") CommentEntity comment, Integer taskId, Integer userId){
        comment.setTask(taskService.getTaskById(taskId));
        comment.setAuthor(userService.getById(userId));
         commentService.save(comment);
        return "redirect:/homepage";
    }

    @PostMapping("/duplicate")
    public String duplicate(Integer taskId) {
        taskService.duplicate(taskService.getTaskById(taskId));
        return "redirect:/homepage";
    }

    @PostMapping("/saveSub")
    public String createSubtask(@ModelAttribute(name = "subtask") SubtaskDto subtaskDto, Integer taskId){
        subtaskDto.setMainTask(taskService.getTaskById(taskId));
        taskService.saveSub(subtaskDto);
        return "redirect:/homepage";
    }

    @PostMapping("/delete")
    public String delete(Integer taskId) {
        taskService.deleteById(taskId);
        return "redirect:/homepage";
    }

}
