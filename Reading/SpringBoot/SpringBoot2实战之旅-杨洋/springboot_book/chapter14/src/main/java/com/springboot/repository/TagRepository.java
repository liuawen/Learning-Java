package com.springboot.repository;

import com.springboot.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;


public interface TagRepository extends JpaRepository<Tag, Long> , JpaSpecificationExecutor<Tag> {

    Tag findByTagName(String tagName);

    Integer countByTagInputDate(Date tagInputdate);
}
