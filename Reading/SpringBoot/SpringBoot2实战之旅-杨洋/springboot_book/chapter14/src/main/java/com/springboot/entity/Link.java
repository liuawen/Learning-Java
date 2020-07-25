package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "link")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link implements Serializable {
    private static final long serialVersionUID = -4725937550197599617L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;
    private String linkName;
    private String linkUrl;
    private String remark;
}
