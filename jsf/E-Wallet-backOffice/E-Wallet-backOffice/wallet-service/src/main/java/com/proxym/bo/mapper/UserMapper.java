package com.proxym.bo.mapper;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.proxym.bo.model.AuthorityModel;
import com.proxym.bo.model.RoleModel;
import com.proxym.bo.model.UserModel;

public class UserMapper {

    public static UserModel userEntityToUserModel(User user) {

        UserModel userModel = UserModel.builder()
//                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .enabled(user.isEnabled())
//                .status(user.getStatus())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .lastConnected(user.getLastConnected())
                .email(user.getEmail())
                .createdOn(user.getCreatedOn())
                .build();

        List<Authority> authority = user.getAutorities();
        List<AuthorityModel> authorityModel = new ArrayList<AuthorityModel>();
        for (Authority authori : authority) {
            if ((authori.getRole() != null) && (authori.getUser() != null)) {
                RoleModel role = RoleMapper.roleEntityToRoleModel(authori.getRole());
                authorityModel.add(new AuthorityModel(userModel, role));
            }
        }
        userModel.setAutorities(authorityModel);
        return userModel;
    }

    public static User userModelToUserEntity(UserModel userModel) {
        User user = User.builder()
//                .id(userModel.getId())
                .userName(userModel.getUserName())
                .firstname(userModel.getFirstname())
                .lastname(userModel.getLastname())
                .password(userModel.getPassword())
                .email(userModel.getEmail())
                .enabled(userModel.isEnabled())
//                .status(userModel.getStatus())
                .lastConnected(userModel.getLastConnected())
                .createdOn(userModel.getCreatedOn())
                .build();
        return user;
    }

    public static List<UserModel> listUserEntityToListUserModel(List<User> users) {
        return users.stream().map(user -> userEntityToUserModel(user)).collect(Collectors.toList());
    }

    public static List<User> listUserModelToListUserEntity(List<UserModel> userModels) {
        return userModels.stream().map(userModel -> userModelToUserEntity(userModel)).collect(Collectors.toList());
    }

/*    public static List<UserModel> listLdapUserToListUserEntity(List<LdapUser> ldapUsers) {
        List<UserModel> users = new ArrayList();
        for (int i = 0; i < ldapUsers.size(); i++) {
            users.add(ldapUserToUserEntity(ldapUsers.get(i)));
        }
        return users;
    }*/

/*    public static UserModel ldapUserToUserEntity(LdapUser ldapUser) {
        RoleModel role = ldapUser.getRole();
        UserModel user = new UserModel(ldapUser.getUserName(), ldapUser.getPassword(), true);
        AuthorityModel autority = new AuthorityModel(user, role);
        List<AuthorityModel> autorities = new ArrayList<AuthorityModel>() {{
            add(autority);
        }};
        user.setAutorities(autorities);
        return user;
    }*/


}
