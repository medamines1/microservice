package com.proxym.bo.mapper;



import java.util.List;
import java.util.stream.Collectors;

import com.proxym.bo.model.RoleModel;

public class RoleMapper {

    public static RoleModel roleEntityToRoleModel(Role role) {
        return new RoleModel(role.getName(), role.getDesignation());
    }

    public static Role roleModelToRoleEntity(RoleModel roleModel) {
        return new Role(roleModel.getName(), roleModel.getDesignation());
    }

    public static List<RoleModel> listRoleEntityToListRoleModel(List<Role> roles) {
        return roles.stream().map(role -> roleEntityToRoleModel(role)).collect(Collectors.toList());
    }

    public static List<Role> listRoleModelToListRoleEntity(List<RoleModel> roleModels) {
        return roleModels.stream().map(roleModel -> roleModelToRoleEntity(roleModel)).collect(Collectors.toList());
    }
}
