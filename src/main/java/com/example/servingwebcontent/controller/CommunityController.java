package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/community/")
public class CommunityController {

    private final CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("communities", communityService.getAll());
        return "communities";
    }

    @GetMapping("{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("communities", communityService.getById(id));
        return "community";
    }

    @PostMapping()
    public String create(Model model, @RequestParam String name) {
        communityService.create(name);
        model.addAttribute("communities", communityService.getAll());
        return "communities";
    }
}
