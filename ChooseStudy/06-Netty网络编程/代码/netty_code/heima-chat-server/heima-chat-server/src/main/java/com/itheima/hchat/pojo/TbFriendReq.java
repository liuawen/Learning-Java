package com.itheima.hchat.pojo;

import java.util.Date;

public class TbFriendReq {
    private String id;

    private String fromUserid;

    private String toUserid;

    private Date createtime;

    private String message;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFromUserid() {
        return fromUserid;
    }

    public void setFromUserid(String fromUserid) {
        this.fromUserid = fromUserid == null ? null : fromUserid.trim();
    }

    public String getToUserid() {
        return toUserid;
    }

    public void setToUserid(String toUserid) {
        this.toUserid = toUserid == null ? null : toUserid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}