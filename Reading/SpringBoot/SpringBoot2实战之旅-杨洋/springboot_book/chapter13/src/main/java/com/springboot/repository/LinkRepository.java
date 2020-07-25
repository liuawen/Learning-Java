package com.springboot.repository;

import com.springboot.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LinkRepository extends JpaRepository<Link, Long> {

}
