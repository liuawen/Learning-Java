package com.springboot.service;

import com.springboot.entity.Link;

import java.util.List;

public interface LinkService {

    List<Link> findAllByIsEnable();
}
