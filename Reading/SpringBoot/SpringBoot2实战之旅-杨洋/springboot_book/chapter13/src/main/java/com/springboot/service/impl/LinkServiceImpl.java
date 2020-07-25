package com.springboot.service.impl;

import com.springboot.entity.Link;
import com.springboot.repository.LinkRepository;
import com.springboot.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    @Cacheable(value = "link")
    public List<Link> findAllByIsEnable() {
        return linkRepository.findAll();
    }
}
