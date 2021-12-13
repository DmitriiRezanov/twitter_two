package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Community;
import com.example.servingwebcontent.domain.Message;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.MessageRepo;
import com.example.servingwebcontent.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/community/")
public class CommunityController {

    private final CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @Autowired
    private MessageRepo messageRepo;

    @Value("${upload.path}") //ищем в application.properties переменную upload.path и вставляем ее в переменную
    private String uploadPath;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("communities", communityService.getAll());
        return "communities";
    }

    @GetMapping("{id}")
    public String getById(Model model, @PathVariable Long id) {
        Iterable<Message> messages = messageRepo.findMessageByCommunityId(id);
        model.addAttribute("community", communityService.getById(id));
        model.addAttribute("messages", messages);
        return "community";
    }

    //Добавление сообщения
    @PostMapping ("{id}")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model, Model model2,
            @RequestParam("file") MultipartFile file) throws IOException {
        Message message = new Message(text, tag, user);

        if ( file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()){ //если дирректории не существует, то создаем ее
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();//создаем уникальное имя файла

            file.transferTo(new File(uploadPath + "/" + resultFilename)); //загружаем файл

            message.setFilename(resultFilename);
        }

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        model2.addAttribute("community", communityService.getById(44L));
        return "community";
    }

    @PostMapping()
    public String create(Model model, @RequestParam String name) {
        if (!name.equals("")){
            communityService.create(name);
        }
        model.addAttribute("communities", communityService.getAll());
        return "communities";
    }
}
