package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.UserMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserMessageRepo extends CrudRepository<UserMessage, Long> {

    List<UserMessage> findUserMessageByUserId(Long userId);
}
