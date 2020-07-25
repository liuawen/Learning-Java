package com.dalaoyang.entity;


import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "LockInfo",
        uniqueConstraints={@UniqueConstraint(columnNames={"tag"},name = "uk_tag")})
public class Lock {

    public final static Integer LOCKED_STATUS = 1;
    public final static Integer UNLOCKED_STATUS = 0;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 锁的标示，以订单为例，可以锁订单id
     */
    @Column(nullable = false)
    private String tag;

    /**
     * 过期时间
     */
    @Column(nullable = false)
    private Date expirationTime;

    /**
     * 锁状态，0，未锁，1，已经上锁
     */
    @Column(nullable = false)
    private Integer status;

    public Lock(String tag, Date expirationTime, Integer status) {
        this.tag = tag;
        this.expirationTime = expirationTime;
        this.status = status;
    }

    public Lock() {
    }
}
