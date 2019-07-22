package com.proxym.bo.service.impl;

import com.proxym.core.dao.PasswordResetDao;
import com.proxym.bo.model.LdapUser;
import com.proxym.bo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proxym.bo.mapper.UserMapper;
import com.proxym.bo.service.UserService;
import com.proxym.core.dao.UserDao;
import com.proxym.core.dao.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final int EXPIRATION = 60 * 24;
    private final UserDao userDao;
    private final PasswordResetDao passwordResetDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordResetDao passwordResetDao) {
        this.userDao = userDao;
        this.passwordResetDao = passwordResetDao;
    }

    @Override
    public void save(List<UserModel> users) {
        userDao.save(UserMapper.listUserModelToListUserEntity(users));
    }

    @Override
    public UserModel findOneByUserName(String userName) {
        return UserMapper.userEntityToUserModel(userDao.findOneByUserName(userName));
    }

    @Override
    public List<UserModel> findAll() {
        return UserMapper.listUserEntityToListUserModel(userDao.findAll());
    }

    @Override
    public void saveLdapUser(LdapUser user) {
/*        List<User> users = new ArrayList<>();
        UserModel userModel = UserMapper.ldapUserToUserEntity(user);
        users.add(UserMapper.userModelToUserEntity(userModel));
        userDao.save(users)*/
        ;

    }

    @Override
    public UserModel findOneByEmail(String email) {
        return UserMapper.userEntityToUserModel(userDao.findOneByEmail(email));
    }

    @Override
    public void save(User user) {
        if (user.getCreatedOn() == null)
            user.setCreatedOn(new Date());
        userDao.save(user);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordReset passwordReset = PasswordReset.builder()
                .expiryDate(calculateExpiryDate(EXPIRATION))
                .token(token)
                .user(user).build();
        passwordResetDao.createPasswordResetTokenForUser(passwordReset);
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    @Override
    public PasswordReset getPasswordResetToken(String token) {
        return passwordResetDao.getPasswordResetToken(token);
    }

    @Override
    public void deletePasswordResetToken(PasswordReset passwordReset) {
        passwordResetDao.deletePasswordToken(passwordReset);
    }
}
