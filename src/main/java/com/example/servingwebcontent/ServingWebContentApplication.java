package com.example.servingwebcontent;

import com.example.servingwebcontent.domain.Community;
import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.CommunityRepo;
import com.example.servingwebcontent.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
public class ServingWebContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

    @Component
    public static class EntityLoader {

        @Autowired
        UserRepo userRepo;

        @Autowired
        CommunityRepo communityRepo;

        @PostConstruct
        public void initApiUserData() {
            if (userRepo.findByUsername("admin") == null){
                Set<Role> set = new HashSet<Role>();
                set.add(Role.ADMIN);
                User u = new User();
                u.setRoles(set);
                u.setActive(true);
                u.setUsername("admin");
                u.setPassword("admin");
                userRepo.save(u);

                Community community = new Community();
                community.setName("Default community");
                communityRepo.save(community);

            }
        }

    }
}