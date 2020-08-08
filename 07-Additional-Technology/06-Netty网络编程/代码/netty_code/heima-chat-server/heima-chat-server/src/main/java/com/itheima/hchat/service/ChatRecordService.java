package com.itheima.hchat.service;

import com.itheima.hchat.pojo.TbChatRecord;

import java.util.List;

public interface ChatRecordService {
    /**
     * 将聊天记录保存到数据库中
     * @param chatRecord
     */
    void insert(TbChatRecord chatRecord);

    /**
     * 根据用户id和好友id将聊天记录查询出来
     * @param userid 用户id
     * @param friendid 好友id
     * @return 聊天记录列表
     */
    List<TbChatRecord> findByUserIdAndFriendId(String userid, String friendid);

    /**
     * 根据用户id，查询发给他的未读消息记录
     * @param userid 用户id
     * @return 未读消息列表
     */
    List<TbChatRecord> findUnreadByUserid(String userid);

    /**
     * 设置消息为已读
     * @param id 聊天记录的id
     */
    void updateStatusHasRead(String id);
}
