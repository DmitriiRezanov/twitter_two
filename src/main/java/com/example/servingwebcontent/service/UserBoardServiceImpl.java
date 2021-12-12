package com.example.servingwebcontent.service;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.domain.UserMessage;
import com.example.servingwebcontent.repos.UserMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserBoardServiceImpl implements UserBoardService{

    private final UserMessageRepo userMessageRepo;

    @Autowired
    public UserBoardServiceImpl(UserMessageRepo userMessageRepo) {
        this.userMessageRepo = userMessageRepo;
    }

    @Override
    public List<UserMessage> getAllByUser(Long userId) {
        return userMessageRepo.findUserMessageByUserId(userId);
    }

    @Override
    public void sendMessage(String text) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserMessage userMessage = new UserMessage();
        userMessage.setUser(user);
        userMessage.setText(text);
        userMessage.setDate(new Date());
        userMessageRepo.save(userMessage);
    }
}
