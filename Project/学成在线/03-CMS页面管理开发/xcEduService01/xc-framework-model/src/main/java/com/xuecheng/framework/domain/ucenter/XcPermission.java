package com.xuecheng.framework.domain.ucenter;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2018/3/19.
 */
@Data
@ToString
@Entity
@Table(name="xc_permission")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcPermission {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name="roleId")
    private String role_id;
    @Column(name="menuId")
    private String menu_id;
    @Column(name="createTime")
    private Date create_time;


}
