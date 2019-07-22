package com.proxym.core.dao;

import java.util.List;

public interface FeatureRoleDao {

	/**
	 * Used to save FeatureRole list
	 * 
	 * @param authorities
	 */
	void save(List<FeatureRole> featureRole);

	/**
	 * Used to update FeatureRole list
	 * 
	 * @param authorities
	 */
	void update(List<FeatureRole> featureRole);

	/**
	 * Used to retrieve FeatureRole list
	 * 
	 * @return
	 */
	List<FeatureRole> getFeatureRoles();

	/**
	 * Used to update FeatureRole for giving feature
	 * 
	 * @param feature
	 * @param role
	 */
	void updateFeatureRole(Role role, Feature feature);

	/**
	 * Return role' FeatureRole
	 * 
	 * @param user
	 * @return
	 */
	List<FeatureRole> getFeatureRoleByRole(Role role);
	/**
	 * Used to delete role'FeatureRole
	 * @param userName
	 */
	void deleteFeatureRoleByRole(Role role);
	
	/**
	 * Get FeatureRole By featureCode
	 * 
	 * @param roleName
	 */
	List<FeatureRole> getFeatureRoleByFeature(Feature feature);
	
	FeatureRole findOneByFeatureAndRole(Feature feature, Role role);
	
	FeatureRole getByFeatureNameAndRoleName(String feature, String role);
	
}
