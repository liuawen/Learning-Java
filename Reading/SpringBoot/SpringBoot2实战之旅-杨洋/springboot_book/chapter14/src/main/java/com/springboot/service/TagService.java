package com.springboot.service;

import com.springboot.entity.Pages;
import com.springboot.entity.Tag;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface TagService {

    Page<Tag> findAllBySearch(Pages pages, Long tagId, String tagName);

    Tag saveTag(Tag tag);

    void deleteTagByTagId(Long tagId);

    Tag findTagByTagName(String tagName);

    Integer countByTagInputDate(Date tagInputdate);

    Long count();


}
