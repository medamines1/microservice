package com.proxym.bo.model;



public class FeatureRoleModel {
	private FeatureModel feature;
	
    private RoleModel role;

    public FeatureRoleModel() {

    }

    public FeatureRoleModel(FeatureModel feature, RoleModel role) {
        this.feature = feature;
        this.role = role;
    }

	public FeatureModel getFeature() {
		return feature;
	}

	public void setFeature(FeatureModel feature) {
		this.feature = feature;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}
	
	
}
