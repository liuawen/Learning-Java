package com.itheima.hchat.service.impl;

import com.itheima.hchat.mapper.TbFriendMapper;
import com.itheima.hchat.mapper.TbFriendReqMapper;
import com.itheima.hchat.mapper.TbUserMapper;
import com.itheima.hchat.pojo.*;
import com.itheima.hchat.pojo.vo.User;
import com.itheima.hchat.service.UserService;
import com.itheima.hchat.util.FastDFSClient;
import com.itheima.hchat.util.IdWorker;
import com.itheima.hchat.util.QRCodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.omg.SendingContext.RunTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.management.RuntimeErrorException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private FastDFSClient fastDFSClient;
    @Autowired
    private Environment env;
    @Autowired
    private QRCodeUtils qrCodeUtils;
    @Autowired
    private TbFriendMapper friendMapper;
    @Autowired
    private TbFriendReqMapper friendReqMapper;

    @Override
    public List<TbUser> findAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User login(String username, String password) {

        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {

            TbUserExample example = new TbUserExample();
            TbUserExample.Criteria criteria = example.createCriteria();

            criteria.andUsernameEqualTo(username);

            List<TbUser> userList = userMapper.selectByExample(example);
            if(userList != null && userList.size() == 1) {
                // 对密码进行校验
                String encodingPassword = DigestUtils.md5DigestAsHex(password.getBytes());
                if(encodingPassword.equals(userList.get(0).getPassword())) {
                    User user = new User();
                    BeanUtils.copyProperties(userList.get(0), user);

                    return user;
                }
            }
        }


        return null;
    }

    @Override
    public void register(TbUser user) {
        try {
            // 1. 判断这个用户名是否存在
            TbUserExample example = new TbUserExample();
            TbUserExample.Criteria criteria = example.createCriteria();

            criteria.andUsernameEqualTo(user.getUsername());

            List<TbUser> userList = userMapper.selectByExample(example);
            if(userList != null && userList.size() > 0) {
                throw new RuntimeException("用户已存在");
            }

            // 2. 将用户信息保存到数据库中
            // 使用雪花算法来生成唯一ID
            user.setId(idWorker.nextId());
            // 对密码进行MD5加密
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            user.setPicSmall("");
            user.setPicNormal("");
            user.setNickname(user.getUsername());

            // 生成二维码，并且将二维码的路径保存到数据库中
            // 要生成二维码中的字符串
            String qrcodeStr = "hichat://" + user.getUsername();
            // 获取一个临时目录，用来保存临时的二维码图片
            String tempDir = env.getProperty("hcat.tmpdir");
            String qrCodeFilePath = tempDir + user.getUsername() + ".png";
            qrCodeUtils.createQRCode(qrCodeFilePath, qrcodeStr);

            // 将临时保存的二维码上传到FastDFS
            String url = env.getProperty("fdfs.httpurl") +
                    fastDFSClient.uploadFile(new File(qrCodeFilePath));

            user.setQrcode(url);
            user.setCreatetime(new Date());

            userMapper.insert(user);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("注册失败");
        }
    }

    @Override
    public User upload(MultipartFile file, String userid) {
        try {
            // 返回在FastDFS中的URL路径，这个路径是不带http://192.168.25.133/..
            String url = fastDFSClient.uploadFace(file);
            // 在FastDFS上传的时候，会自动生成一个缩略图
            // 文件名_150x150.后缀
            String[] fileNameList = url.split("\\.");
            String fileName = fileNameList[0];
            String ext = fileNameList[1];

            String picSmallUrl = fileName + "_150x150." + ext;

            String prefix = env.getProperty("fdfs.httpurl");
            TbUser tbUser = userMapper.selectByPrimaryKey(userid);

            // 设置头像大图片
            tbUser.setPicNormal(prefix + url);
            // 设置头像小图片
            tbUser.setPicSmall(prefix + picSmallUrl);
            // 将新的头像URL更新到数据库中
            userMapper.updateByPrimaryKey(tbUser);

            // 将用户信息返回到Controller
            User user = new User();
            BeanUtils.copyProperties(tbUser, user);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateNickname(String id, String nickname) {
        if(StringUtils.isNotBlank(nickname)) {
            TbUser tbUser = userMapper.selectByPrimaryKey(id);
            tbUser.setNickname(nickname);
            userMapper.updateByPrimaryKey(tbUser);
        }
        else {
            throw new RuntimeException("昵称不能为空");
        }
    }

    @Override
    public User findById(String userid) {
        TbUser tbUser = userMapper.selectByPrimaryKey(userid);
        User user = new User();
        BeanUtils.copyProperties(tbUser, user);

        return user;
    }

    @Override
    public User findByUsername(String userid, String friendUsername) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(friendUsername);

        List<TbUser> userList = userMapper.selectByExample(example);
        TbUser friend = userList.get(0);

        User friendUser = new User();
        BeanUtils.copyProperties(friend, friendUser);

        return friendUser;
    }
}
