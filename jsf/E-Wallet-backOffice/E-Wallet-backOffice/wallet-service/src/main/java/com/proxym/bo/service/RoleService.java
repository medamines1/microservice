package com.proxym.bo.service;


import java.util.List;

import com.proxym.bo.model.RoleModel;

public interface RoleService {

    RoleModel save(RoleModel role);

    List<RoleModel> getAllRoles();

    RoleModel findOneByName(String name);

    Boolean delete(RoleModel role);
}
