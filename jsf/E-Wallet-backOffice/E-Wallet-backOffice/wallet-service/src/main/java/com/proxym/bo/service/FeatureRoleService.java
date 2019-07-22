package com.proxym.bo.service;

import java.util.List;

import com.proxym.bo.model.FeatureRoleModel;

public interface FeatureRoleService {
	
	
	void save(List<FeatureRoleModel> featureRoles);

	List<FeatureRoleModel> getFeatureRoles();

	
	//void updateFeatureRoles(String userName, String roleName);

	
	void deleteFeatureRoles(String role);
	

	List<FeatureRoleModel> getFeatureRolesByRoleName(String roleName);
	
	
	List<FeatureRoleModel> getFeatureRoleByFeatureCode(String code);
	
	FeatureRoleModel findOneByFeatureAndRole(String code, String roleName);

}
