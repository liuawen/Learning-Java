package com.dalaoyang.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    private Long id;

    private String city;

    private String name;
}
