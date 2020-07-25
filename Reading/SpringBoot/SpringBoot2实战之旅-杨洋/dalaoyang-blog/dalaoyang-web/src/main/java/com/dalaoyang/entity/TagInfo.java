package com.dalaoyang.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagInfo  implements Serializable {

    private static final long serialVersionUID = -9100665445890165660L;
    private int tagId;
    private String tagName;
    private boolean isIncloud;
}
