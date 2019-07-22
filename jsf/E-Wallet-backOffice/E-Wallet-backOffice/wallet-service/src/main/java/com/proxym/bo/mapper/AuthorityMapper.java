package com.proxym.bo.mapper;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.proxym.bo.model.AuthorityModel;
import com.proxym.bo.model.RoleModel;
import com.proxym.bo.model.UserModel;

public class AuthorityMapper {

    public static AuthorityModel authorityEntityToAuthorityModel(Authority authority) {
    	System.err.println("****"+authority);
    	AuthorityModel autho = new AuthorityModel();
    	UserModel user = UserMapper.userEntityToUserModel(authority.getUser());
    	RoleModel role = RoleMapper.roleEntityToRoleModel(authority.getRole());
    	autho.setRole(role);
    	autho.setUser(user);
    	
        return autho;//new AuthorityModel(UserMapper.userEntityToUserModel(authority.getUser()), RoleMapper.roleEntityToRoleModel(authority.getRole()));
    }

    public static Authority authorityModelToAuthorityEntity(AuthorityModel authorityModel) {
        return new Authority(UserMapper.userModelToUserEntity(authorityModel.getUser()), RoleMapper.roleModelToRoleEntity(authorityModel.getRole()));
    }

    public static List<AuthorityModel> listAuthorityEntityToListAuthorityModel(List<Authority> authorities) {
    	List<AuthorityModel> models = new ArrayList<AuthorityModel>();
    	for (Authority entity: authorities){
    		models.add(authorityEntityToAuthorityModel(entity));
    	}

        return models;
    }

    public static List<Authority> listAuthorityModelToListAuthorityEntity(List<AuthorityModel> authorityModels) {
        return authorityModels.stream().map(authorityModel -> authorityModelToAuthorityEntity(authorityModel)).collect(Collectors.toList());
    }
}