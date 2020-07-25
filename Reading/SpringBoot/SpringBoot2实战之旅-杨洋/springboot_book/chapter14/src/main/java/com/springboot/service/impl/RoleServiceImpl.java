package com.springboot.service.impl;

import com.springboot.constants.Constants;
import com.springboot.entity.Role;
import com.springboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements com.springboot.service.RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByRoleId(Long roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        }
        return null;
    }

    @Override
    public List<Role> findAllByIsEnable() {
        return roleRepository.findAllByIsEnable(Constants.YES);
    }

}
