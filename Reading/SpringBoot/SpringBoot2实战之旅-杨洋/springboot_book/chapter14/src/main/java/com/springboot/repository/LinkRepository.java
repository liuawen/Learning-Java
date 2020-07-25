package com.springboot.repository;

import com.springboot.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface LinkRepository extends JpaRepository<Link, Long>, JpaSpecificationExecutor<Link> {

}
