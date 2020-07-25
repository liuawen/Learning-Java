package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

    private static final long serialVersionUID = 4967006908141911451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String articleName;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String articleContent;
    private String articleAuthors;
    @Temporal(TemporalType.DATE)
    private Date articleInputDate;
    private Integer articleReadingTime;
    private Integer isTop;
    private Integer isEnable;

    @ManyToMany
    @JoinTable(name = "articleTag", joinColumns = {@JoinColumn(name = "articleId")}, inverseJoinColumns = {@JoinColumn(name = "tagId")})
    private List<Tag> tagList;

    //项目内使用，非数据库字段
    @Transient
    private int imageNo;
    @Transient
    private String articleIntroduction;
    @Transient
    private String articleShowContent;

}
