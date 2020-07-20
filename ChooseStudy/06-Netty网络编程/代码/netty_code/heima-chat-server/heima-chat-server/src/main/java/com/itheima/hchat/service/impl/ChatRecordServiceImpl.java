package com.itheima.hchat.service.impl;

import com.itheima.hchat.mapper.TbChatRecordMapper;
import com.itheima.hchat.pojo.TbChatRecord;
import com.itheima.hchat.pojo.TbChatRecordExample;
import com.itheima.hchat.service.ChatRecordService;
import com.itheima.hchat.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ChatRecordServiceImpl implements ChatRecordService{

    @Autowired
    private TbChatRecordMapper chatRecordMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public void insert(TbChatRecord chatRecord) {
        chatRecord.setId(idWorker.nextId());
        chatRecord.setHasRead(0);
        chatRecord.setCreatetime(new Date());
        chatRecord.setHasDelete(0);

        chatRecordMapper.insert(chatRecord);
    }

    @Override
    public List<TbChatRecord> findByUserIdAndFriendId(String userid, String friendid) {
        // 需要：
        TbChatRecordExample example = new TbChatRecordExample();

        TbChatRecordExample.Criteria criteria1 = example.createCriteria();
        TbChatRecordExample.Criteria criteria2 = example.createCriteria();

        // 将 userid -> friendid的聊天记录查询出来
        criteria1.andUseridEqualTo(userid);
        criteria1.andFriendidEqualTo(friendid);
        criteria1.andHasDeleteEqualTo(0);

        // 将 friendid -> userid的聊天记录查询出来
        criteria2.andUseridEqualTo(friendid);
        criteria2.andFriendidEqualTo(userid);
        criteria2.andHasDeleteEqualTo(0);

        example.or(criteria1);
        example.or(criteria2);

        // 将发给userid的所有聊天记录设置为已读
        TbChatRecordExample exampleQuerySendToMe = new TbChatRecordExample();
        TbChatRecordExample.Criteria criteriaQuerySendToMe = example.createCriteria();

        criteriaQuerySendToMe.andFriendidEqualTo(userid);
        criteriaQuerySendToMe.andHasReadEqualTo(0);

        List<TbChatRecord> tbChatRecords = chatRecordMapper.selectByExample(exampleQuerySendToMe);
        for (TbChatRecord tbChatRecord : tbChatRecords) {
            tbChatRecord.setHasRead(1);
            chatRecordMapper.updateByPrimaryKey(tbChatRecord);
        }


        return chatRecordMapper.selectByExample(example);
    }

    @Override
    public List<TbChatRecord> findUnreadByUserid(String userid) {
        TbChatRecordExample example = new TbChatRecordExample();
        TbChatRecordExample.Criteria criteria = example.createCriteria();

        // 设置查询发给userid的消息
        criteria.andFriendidEqualTo(userid);
        criteria.andHasReadEqualTo(0);

        return chatRecordMapper.selectByExample(example);
    }

    @Override
    public void updateStatusHasRead(String id) {
        TbChatRecord tbChatRecord = chatRecordMapper.selectByPrimaryKey(id);
        tbChatRecord.setHasRead(1);

        chatRecordMapper.updateByPrimaryKey(tbChatRecord);
    }
}
