package com.proxym.bo.service;


import java.util.List;

import com.proxym.bo.model.LdapUser;
import com.proxym.bo.model.UserModel;


public interface UserService {

    void save(List<UserModel> users);

    UserModel findOneByUserName(String userName);

    List<UserModel> findAll();

    void saveLdapUser(LdapUser user);

    UserModel findOneByEmail(String email);

    void save(User user);

    void createPasswordResetTokenForUser(User user, String token);

    PasswordReset getPasswordResetToken(String token);

    void deletePasswordResetToken(PasswordReset passwordReset);

}
