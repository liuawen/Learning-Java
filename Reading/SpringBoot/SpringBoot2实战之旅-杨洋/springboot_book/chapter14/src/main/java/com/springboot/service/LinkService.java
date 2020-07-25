package com.springboot.service;

import com.springboot.entity.Link;
import com.springboot.entity.Pages;
import org.springframework.data.domain.Page;


public interface LinkService {

    Page<Link> findAllBySearch(Pages pages, Long linkId, String linkName);

    Link findLinkByLinkId(Long linkId);

    void saveOrUpdateLink(Link link);

    void deleteLink(Long linkId);

    Long count();
}
