package com.itheima.hchat.service.impl;

import com.itheima.hchat.mapper.TbFriendMapper;
import com.itheima.hchat.mapper.TbFriendReqMapper;
import com.itheima.hchat.mapper.TbUserMapper;
import com.itheima.hchat.pojo.*;
import com.itheima.hchat.pojo.vo.FriendReq;
import com.itheima.hchat.pojo.vo.User;
import com.itheima.hchat.service.FriendService;
import com.itheima.hchat.util.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FriendServiceImpl implements FriendService{

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private TbFriendMapper friendMapper;
    @Autowired
    private TbUserMapper userMapper;
    @Autowired
    private TbFriendReqMapper friendReqMapper;

    @Override
    public void sendRequest(String fromUserid, String toUserid) {
        // 检查是否允许添加好友
        TbUser friend = userMapper.selectByPrimaryKey(toUserid);

        checkAllowToAddFriend(fromUserid, friend);

        // 添加好友请求
        TbFriendReq friendReq = new TbFriendReq();
        friendReq.setId(idWorker.nextId());
        friendReq.setFromUserid(fromUserid);
        friendReq.setToUserid(toUserid);
        friendReq.setCreatetime(new Date());
        friendReq.setStatus(0);

        friendReqMapper.insert(friendReq);
    }

    /**
     * 检查是否允许添加好友
     * @param userid 要添加好友的用户id
     * @param friend 要添加的好友
     */
    private void checkAllowToAddFriend(String userid, TbUser friend) {
        // 1. 用户不能添加自己为好友
        if(friend.getId().equals(userid)) {
            throw new RuntimeException("不能添加自己为好友");
        }

        // 2. 用户不能重复添加
        // 如果用户已经添加该好友，就不能再次添加
        TbFriendExample friendExample = new TbFriendExample();
        TbFriendExample.Criteria friendCriteria = friendExample.createCriteria();

        friendCriteria.andUseridEqualTo(userid);
        friendCriteria.andFriendsIdEqualTo(friend.getId());

        List<TbFriend> friendList = friendMapper.selectByExample(friendExample);
        if(friendList != null && friendList.size() > 0) {
            throw new RuntimeException(friend.getUsername() + "已经是您的好友了");
        }

        // 3. 判断是否已经提交好友申请，如果已经提交好友申请，就直接抛出运行时异常
        TbFriendReqExample friendReqExample = new TbFriendReqExample();
        TbFriendReqExample.Criteria friendReqCritieria = friendReqExample.createCriteria();

        // 当前用户发送的好友请求
        friendReqCritieria.andFromUseridEqualTo(userid);
        friendReqCritieria.andToUseridEqualTo(friend.getId());
        // 而且这个请求时没有被处理的
        friendReqCritieria.andStatusEqualTo(0);

        List<TbFriendReq> friendReqList = friendReqMapper.selectByExample(friendReqExample);

        if(friendReqList != null && friendReqList.size() > 0) {
            throw new RuntimeException("已经申请过了");
        }
    }

    @Override
    public List<FriendReq> findFriendReqByUserid(String userid) {
        // 根据用户的id查询对应的好友请求
        TbFriendReqExample example = new TbFriendReqExample();
        TbFriendReqExample.Criteria criteria = example.createCriteria();

        criteria.andToUseridEqualTo(userid);
        criteria.andStatusEqualTo(0);

        List<TbFriendReq> tbFriendReqList = friendReqMapper.selectByExample(example);
        List<FriendReq> friendReqList = new ArrayList<FriendReq>();

        // 根据好友请求，将发起好友请求的用户信息返回
        for (TbFriendReq tbFriendReq : tbFriendReqList) {
            TbUser tbUser = userMapper.selectByPrimaryKey(tbFriendReq.getFromUserid());
            FriendReq friendReq = new FriendReq();
            BeanUtils.copyProperties(tbUser, friendReq);
            // 设置好友请求的id
            friendReq.setId(tbFriendReq.getId());

            friendReqList.add(friendReq);
        }

        return friendReqList;
    }

    @Override
    public void acceptFriendReq(String reqid) {
        System.out.println(reqid);
        // 1. 将好友请求的status标志设置为1，表示已经处理了该好友请求
        TbFriendReq friendReq = friendReqMapper.selectByPrimaryKey(reqid);
        friendReq.setStatus(1);
        friendReqMapper.updateByPrimaryKey(friendReq);

        // 2. 互相添加好友，在tb_friend表中应该添加两条记录
        TbFriend friend1 = new TbFriend();
        friend1.setId(idWorker.nextId());
        friend1.setUserid(friendReq.getFromUserid());
        friend1.setFriendsId(friendReq.getToUserid());
        friend1.setCreatetime(new Date());

        TbFriend friend2 = new TbFriend();
        friend2.setId(idWorker.nextId());
        friend2.setUserid(friendReq.getToUserid());
        friend2.setFriendsId(friendReq.getFromUserid());
        friend2.setCreatetime(new Date());

        friendMapper.insert(friend1);
        friendMapper.insert(friend2);
    }

    @Override
    public void ignoreFriendReq(String reqid) {
        TbFriendReq tbFriendReq = friendReqMapper.selectByPrimaryKey(reqid);
        tbFriendReq.setStatus(1);

        friendReqMapper.updateByPrimaryKey(tbFriendReq);
    }

    @Override
    public List<User> findFriendByUserid(String userid) {
        // 根据userid查询tb_friend表中的数据
        TbFriendExample friendExample = new TbFriendExample();
        TbFriendExample.Criteria criteria = friendExample.createCriteria();

        criteria.andUseridEqualTo(userid);

        List<TbFriend> tbFriendList = friendMapper.selectByExample(friendExample);

        List<User> friendList = new ArrayList<User>();

        // 遍历好友列表，将好友的用户信息查询出来
        for (TbFriend tbFriend : tbFriendList) {
            // 根据好友的id将他对应的用户信息查询出来
            TbUser tbUser = userMapper.selectByPrimaryKey(tbFriend.getFriendsId());
            User friend = new User();
            BeanUtils.copyProperties(tbUser, friend);

            friendList.add(friend);
        }

        return friendList;
    }
}
