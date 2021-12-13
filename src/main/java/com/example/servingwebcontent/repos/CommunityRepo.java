package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Community;
import com.example.servingwebcontent.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface CommunityRepo extends CrudRepository<Community, Long> {

}
