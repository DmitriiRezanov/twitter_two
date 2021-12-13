package com.example.servingwebcontent.service;

import com.example.servingwebcontent.domain.Community;
import com.example.servingwebcontent.repos.CommunityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepo communityRepo;

    @Autowired
    public CommunityServiceImpl(CommunityRepo communityRepo) {
        this.communityRepo = communityRepo;
    }


    @Override
    public Iterable<Community> getAll() {
        return communityRepo.findAll();
    }

    @Override
    public Community getById(Long id) {
        Optional<Community> community = communityRepo.findById(id);
        if(community.isPresent()) {
            return community.get();
        }
        return null;
    }

    @Override
    public void create(String name) {
        Community community = new Community();
        community.setName(name);
        communityRepo.save(community);
    }

}
