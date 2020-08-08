package com.xuecheng.framework.domain.course;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2018/2/10.
 */
@Data
@ToString
@Entity
@Table(name="course_pre")
@GenericGenerator(name = "jpa-assigned", strategy = "assigned")
public class CoursePre implements Serializable {
    private static final long serialVersionUID = -916357110051689488L;
    @Id
    @GeneratedValue(generator = "jpa-assigned")
    @Column(length = 32)
    private String id;
    private String name;
    private String users;
    private String mt;
    private String st;
    private String grade;
    private String studymodel;
    private String description;
    private String pic;//图片
    private Date timestamp;//时间戳
    private String charge;
    private String valid;
    private String qq;
    private Float price;
    private Float price_old;
    private Date expires;
    private String teachplan;//课程计划


}
