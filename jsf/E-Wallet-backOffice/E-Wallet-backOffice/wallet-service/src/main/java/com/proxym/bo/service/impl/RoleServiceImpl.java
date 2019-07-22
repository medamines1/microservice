package com.proxym.bo.service.impl;

import com.elm.commons.utilities.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxym.bo.mapper.RoleMapper;
import com.proxym.bo.model.RoleModel;
import com.proxym.bo.service.RoleService;
import com.proxym.core.dao.RoleDao;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<RoleModel> getAllRoles() {
        return RoleMapper.listRoleEntityToListRoleModel(roleDao.findAll());
    }

    @Override
    public RoleModel findOneByName(String name) {
        Role role = roleDao.findOneByName(name);
        if (role == null)
            throw new DataNotFoundException("role",name,"role");
//            return null;
        else
            return RoleMapper.roleEntityToRoleModel(role);
    }

    @Override
    public RoleModel save(RoleModel role) {
        Role r = roleDao.save(RoleMapper.roleModelToRoleEntity(role));
        if (r == null)
            return null;
        else
            return RoleMapper.roleEntityToRoleModel(r);
    }

    @Override
    public Boolean delete(RoleModel role) {

        return roleDao.delete(RoleMapper.roleModelToRoleEntity(role));

    }
}
