package com.proxym.core.dao;


import java.util.List;

public interface RoleDao {

    Role save(Role role);

    List<Role> findAll();

    Role findOneByName(String name);

    Boolean delete(Role role);
}
