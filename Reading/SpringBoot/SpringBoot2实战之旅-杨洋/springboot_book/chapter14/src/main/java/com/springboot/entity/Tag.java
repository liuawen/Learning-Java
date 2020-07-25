package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {

    private static final long serialVersionUID = -7536613142331362542L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    private String tagName;
    @Temporal(TemporalType.DATE)
    private Date tagInputDate;

    @ManyToMany(cascade = { CascadeType.REFRESH})
    @JoinTable(name = "articleTag", joinColumns = {@JoinColumn(name = "tagId")}, inverseJoinColumns = {@JoinColumn(name = "articleId")})
    private List<Article> articleList;

    public Tag(String tagName) {
        this.tagName = tagName;
    }
}
