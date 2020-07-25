package com.springboot.repository;

import com.springboot.entity.WebsiteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface WebsiteAccessRepository extends JpaRepository<WebsiteAccess, Long> {

    WebsiteAccess getByAccessDateIs(Date accessDate);
}
