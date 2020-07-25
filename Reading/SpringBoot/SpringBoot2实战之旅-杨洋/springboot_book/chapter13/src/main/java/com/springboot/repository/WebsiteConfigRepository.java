package com.springboot.repository;

import com.springboot.entity.WebsiteConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteConfigRepository extends JpaRepository<WebsiteConfig, Long> {
}
