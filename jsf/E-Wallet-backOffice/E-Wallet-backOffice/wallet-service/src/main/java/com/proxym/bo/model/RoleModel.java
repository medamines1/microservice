package com.proxym.bo.model;

import java.util.ArrayList;
import java.util.List;

public class RoleModel {

    private String name;
    private String designation;
    private List<AuthorityModel> autorities = new ArrayList<>();

    public RoleModel(String name, String designation) {
        this.name = name;
        this.designation = designation;
  
    }
    public RoleModel(String name, String designation, List<AuthorityModel> autorities) {
    	this.name = name;
    	this.designation = designation;
    	this.autorities = autorities;
    }

    public RoleModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<AuthorityModel> getAutorities() {
        return autorities;
    }

    public void setAutorities(List<AuthorityModel> autorities) {
        this.autorities = autorities;
    }
}
