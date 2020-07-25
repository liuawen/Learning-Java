package com.springboot.init;

import com.springboot.entity.Role;
import com.springboot.entity.User;
import com.springboot.entity.WebsiteConfig;
import com.springboot.repository.RoleRepository;
import com.springboot.repository.UserRepository;
import com.springboot.repository.WebsiteConfigRepository;
import com.springboot.service.UserService;
import com.springboot.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InitData {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private WebsiteConfigService websiteConfigService;

    @PostConstruct
    private void initRoleData() {
        Role role1 = new Role(1L, "ROLE_USER", 1);
        Role role2 = new Role(2L, "ROLE_ADMIN", 1);
        Role role3 = new Role(3L, "ROLE_SUPERADMIN", 1);
        Role role4 = new Role(4L, "ROLE_SYSTEMADMIN", 1);
        List<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);
        roleList.add(role3);
        roleList.add(role4);
        roleRepository.saveAll(roleList);
        User user = userService.findUserByUserId(1L);
        if (user == null) {
            userService.saveOrUpdateUser(new User(1L, "admin", "123", "admin@springboot.cn", 1, roleList));
        }
        WebsiteConfig websiteConfig = websiteConfigService.findWebsiteConfig();
        if (websiteConfig == null) {
            websiteConfigService.saveWebsiteConfig(new WebsiteConfig(1L, "SpringBoot博客", "dalaoyang", 7L, "辽ICP备17014944号-1", "Dalaoyang.cn", "dalaoyang@aliyun.com"));
        }
    }
}
