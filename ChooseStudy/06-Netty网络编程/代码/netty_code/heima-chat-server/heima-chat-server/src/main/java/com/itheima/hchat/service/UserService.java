package com.itheima.hchat.service;

import com.itheima.hchat.pojo.TbUser;
import com.itheima.hchat.pojo.vo.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    /**
     * 返回数据库中的所有用户
     * @return
     */
    List<TbUser> findAll();

    /**
     * 用来登录检查，检查用户名和密码是否匹配
     * @param username 用户名
     * @param password 密码
     * @return 如果登录成功返回用户对象，否则返回null
     */
    User login(String username, String password);

    /**
     * 注册用户，将用户信息保存到数据库中
     * 如果抛出异常则，注册失败，否则，注册成功
     * @param user 用户信息
     */
    void register(TbUser user);

    /**
     * 上传头像
     * @param file 客户端上传的文件
     * @param userid 用户id
     * @return 如果上传成功，返回用户信息。否则返回null
     */
    User upload(MultipartFile file, String userid);

    /**
     * 更新昵称
     * @param id 用户的id
     * @param nickname 昵称
     */
    void updateNickname(String id, String nickname);

    /**
     * 根据用户id查找用户信息
     * @param userid 用户id
     * @return 用户对象
     */
    User findById(String userid);

    /**
     * 根据用户名搜索用户（好友搜索）
     * 在搜索用户的时候不需要进行校验
     * @param userid 用户id
     * @param friendUsername 好友的用户名
     * @return 如果搜索到好友，就返回用户对象，否则返回null
     */
    User findByUsername(String userid, String friendUsername);
}
