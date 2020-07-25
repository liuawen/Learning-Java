package com.dalaoyang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebsiteSystemInfo  implements Serializable {

    private static final long serialVersionUID = 3686636427002303767L;
    int totalWebsiteVisits;
    int todayWebsiteVisits;
    int monthWebsiteVisits;
    int id;
}
