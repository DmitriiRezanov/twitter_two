package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Community;
import com.example.servingwebcontent.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface CommunityRepo extends CrudRepository<Community, Long> {
}
