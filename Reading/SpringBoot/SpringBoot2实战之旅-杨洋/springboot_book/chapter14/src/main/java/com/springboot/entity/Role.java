package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 3392729947020278189L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String roleName;
    private Integer isEnable;

    @Transient
    private Integer isHave;

    public Role(Long roleId,String roleName, Integer isEnable) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.isEnable = isEnable;
    }
}
