package com.dalaoyang.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebsiteAccessInfo implements Serializable {

    private static final long serialVersionUID = 8368920608346637109L;
    private Integer id;
    private Date accessDate;
    private Integer accessCount;

    public Date getAccessDate() {
        Date date = accessDate;
        return date;
    }

    public void setAccessDate(Date accessTime) {
        this.accessDate = (Date) accessTime.clone();
    }

}
