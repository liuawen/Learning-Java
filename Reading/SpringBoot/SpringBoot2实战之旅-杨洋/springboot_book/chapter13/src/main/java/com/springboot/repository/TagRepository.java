package com.springboot.repository;

import com.springboot.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);
}
