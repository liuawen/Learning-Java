package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "websiteConfig")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebsiteConfig implements Serializable {
    private static final long serialVersionUID = 7023358255818152969L;
    @Id
    private Long Id;
    private String blogName;
    private String authorName;
    private Long aboutPageArticleId;
    private String recordNumber;
    private String domainName;
    private String emailUsername;
}
