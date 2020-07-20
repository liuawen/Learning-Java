package com.itheima.hchat.service;

import com.itheima.hchat.pojo.vo.FriendReq;
import com.itheima.hchat.pojo.vo.User;

import java.util.List;

public interface FriendService {
    /**
     * 发送好友请求
     * @param fromUserid 申请好友的用户id
     * @param toUserid 要添加的好友id
     */
    void sendRequest(String fromUserid, String toUserid);

    /**
     * 根据用户ID查询他对应的好友请求
     * @param userid 当前登录的用户
     * @return 请求好友的用户列表
     */
    List<FriendReq> findFriendReqByUserid(String userid);

    /**
     * 接收好友请求
     * @param reqid 好友请求的id
     */
    void acceptFriendReq(String reqid);

    /**
     * 忽略好友请求
     * @param reqid 好友请求的id
     */
    void ignoreFriendReq(String reqid);

    /**
     * 查询我的好友
     * @param userid 当前登录的用户id
     * @return 好友列表
     */
    List<User> findFriendByUserid(String userid);
}
