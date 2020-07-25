package com.springboot.service;

import com.springboot.entity.WebsiteAccess;

import java.util.Date;
import java.util.List;

public interface WebsiteAccessService {

    WebsiteAccess getByAccessDateIs(Date accessDate);

    void save(WebsiteAccess websiteAccess);

    Integer sumWebsiteAccess(Date date,Integer days);

    List<WebsiteAccess> findChartsWebsiteAccess();
}
