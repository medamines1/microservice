package com.proxym.bo.model;

import java.io.Serializable;

public class AuthorityModel implements Serializable {

    private UserModel user;
    private RoleModel role;

    public AuthorityModel() {

    }

    public AuthorityModel(UserModel user, RoleModel role) {
        this.user = user;
        this.role = role;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }
}
