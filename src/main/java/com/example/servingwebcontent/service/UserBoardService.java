package com.example.servingwebcontent.service;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.domain.UserMessage;

import java.util.List;

public interface UserBoardService {

    List<UserMessage> getAllByUser(Long userId);

    void sendMessage(String text);
}
