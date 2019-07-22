package com.proxym.core.dao;



import java.util.List;

//import com.elm.commons.utilities.exceptions.DataNotFoundException;


public interface UserDao {

    void save(List<User> users);
//    User findOneByUserName(String userName) throws DataNotFoundException;
User findOneByUserName(String userName);
    List<User> findAll();
    void update(User user);
    void save(User user);
    void delete(User user);
//    User findOneByEmail(String eMail) throws DataNotFoundException;
    User findOneByEmail(String eMail);
}
