package com.example.servingwebcontent.service;

import com.example.servingwebcontent.domain.Community;

public interface CommunityService {
    Iterable<Community> getAll();

    Community getById(Long id);

    void create(String name);
}
