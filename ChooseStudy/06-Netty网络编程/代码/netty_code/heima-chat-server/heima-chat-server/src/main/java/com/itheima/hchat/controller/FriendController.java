package com.itheima.hchat.controller;

import com.itheima.hchat.pojo.TbFriendReq;
import com.itheima.hchat.pojo.vo.FriendReq;
import com.itheima.hchat.pojo.vo.Result;
import com.itheima.hchat.pojo.vo.User;
import com.itheima.hchat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @RequestMapping("sendRequest")
    public Result sendRequest(@RequestBody TbFriendReq friendReq) {
        try {
            friendService.sendRequest(friendReq.getFromUserid(), friendReq.getToUserid());
            return new Result(true, "已申请");
        }
        catch(RuntimeException e) {
            return new Result(false, e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "申请好友失败");
        }
    }

    @RequestMapping("/findFriendReqByUserid")
    public List<FriendReq> findFriendReqByUserid(String userid) {
        return friendService.findFriendReqByUserid(userid);
    }

    @RequestMapping("/acceptFriendReq")
    public Result acceptFriendReq(String reqid) {
        try {
            friendService.acceptFriendReq(reqid);
            return new Result(true, "添加好友成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加好友失败");
        }
    }

    @RequestMapping("/ignoreFriendReq")
    public Result ignoreFriendReq(String reqid) {
        try {
            friendService.ignoreFriendReq(reqid);
            return new Result(true, "忽略好友请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "忽略好友请求失败");
        }
    }

    @RequestMapping("/findFriendByUserid")
    public List<User> findFriendByUserid(String userid) {
        try {
            return friendService.findFriendByUserid(userid);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<User>();
        }
    }
}
