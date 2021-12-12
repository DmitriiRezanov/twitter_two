package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Message;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*  */
@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Value("${upload.path}") //ищем в application.properties переменную upload.path и вставляем ее в переменную
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model)
    {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()){
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }
//
//    //Добавление сообщения
//    @PostMapping ("/community/*")
//    public String add(
//            @AuthenticationPrincipal User user,
//            @RequestParam String text,
//            @RequestParam String tag, Map<String, Object> model,
//            @RequestParam("file") MultipartFile file) throws IOException {
//        Message message = new Message(text, tag, user);
//
//        if ( file != null && !file.getOriginalFilename().isEmpty()) {
//            File uploadDir = new File(uploadPath);
//
//            if (!uploadDir.exists()){ //если дирректории не существует, то создаем ее
//                uploadDir.mkdir();
//            }
//
//            String uuidFile = UUID.randomUUID().toString();
//            String resultFilename = uuidFile + "." + file.getOriginalFilename();//создаем уникальное имя файла
//
//            file.transferTo(new File(uploadPath + "/" + resultFilename)); //загружаем файл
//
//            message.setFilename(resultFilename);
//        }
//
//        messageRepo.save(message);
//
//        Iterable<Message> messages = messageRepo.findAll();
//        model.put("messages", messages);
//        return "/community/";
//    }
}