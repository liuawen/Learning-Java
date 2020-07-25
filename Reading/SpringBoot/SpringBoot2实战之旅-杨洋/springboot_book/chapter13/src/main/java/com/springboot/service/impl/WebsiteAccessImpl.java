package com.springboot.service.impl;

import com.springboot.entity.WebsiteAccess;
import com.springboot.repository.WebsiteAccessRepository;
import com.springboot.service.WebsiteAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WebsiteAccessImpl implements WebsiteAccessService {

    @Autowired
    private WebsiteAccessRepository websiteAccessRepository;

    @Override
    public WebsiteAccess getByAccessDateIs(Date accessDate) {
        return websiteAccessRepository.getByAccessDateIs(accessDate);
    }

    @Override
    public void save(WebsiteAccess websiteAccess) {
        websiteAccessRepository.save(websiteAccess);
    }
}
