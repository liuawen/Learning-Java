package com.springboot.service;

import com.springboot.entity.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    Tag findByTagName(String tagName);
}
