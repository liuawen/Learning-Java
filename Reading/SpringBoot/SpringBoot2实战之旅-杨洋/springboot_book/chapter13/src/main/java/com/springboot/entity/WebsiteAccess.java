package com.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "websiteAccess")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebsiteAccess implements Serializable {
    private static final long serialVersionUID = 6948407037095536818L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date accessDate;
    private Integer accessCount;
}
