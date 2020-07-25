package com.springboot.service;

import com.springboot.entity.WebsiteAccess;

import java.util.Date;

public interface WebsiteAccessService {

    WebsiteAccess getByAccessDateIs(Date accessDate);

    void save(WebsiteAccess websiteAccess);
}
