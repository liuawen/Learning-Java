package com.xuecheng.framework.domain.portalview;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by admin on 2018/2/27.
 */
@Data
@ToString
@Document(collection = "pre_view_course_media")
public class PreViewCourseMedia implements Serializable{

    @Id
    @Column(name="teachplan_id")
    private String teachplanId;

    @Column(name="media_id")
    private String mediaId;

    @Column(name="media_fileoriginalname")
    private String mediaFileOriginalName;

    @Column(name="media_url")
    private String mediaUrl;
    private String courseId;

}
