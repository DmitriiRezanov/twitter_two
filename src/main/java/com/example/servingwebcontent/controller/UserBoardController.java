package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.service.UserBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/userBoard/")
public class UserBoardController {

    private final UserBoardService userBoardService;

    @Autowired
    public UserBoardController(UserBoardService userBoardService) {
        this.userBoardService = userBoardService;
    }

    @GetMapping("{id}")
    public String getAllUserMessage(Model model, @PathVariable Long id) {
        model.addAttribute("messages", userBoardService.getAllByUser(id));
        return "userBoard";
    }

    @PostMapping("{id}")
    public String sendMessage(Model model, @PathVariable Long id, @RequestParam String text) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(id.equals(user.getId())) {
            userBoardService.sendMessage(text);
        }
        model.addAttribute("messages", userBoardService.getAllByUser(user.getId()));
        return "userBoard";
    }
}
