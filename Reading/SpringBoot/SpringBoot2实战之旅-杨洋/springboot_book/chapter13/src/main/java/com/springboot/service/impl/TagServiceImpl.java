package com.springboot.service.impl;

import com.springboot.entity.Tag;
import com.springboot.repository.TagRepository;
import com.springboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    @Cacheable(value = "tag")
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findByTagName(String tagName) {
        return tagRepository.findByTagName(tagName);
    }
}
