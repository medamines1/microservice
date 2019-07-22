package com.proxym.bo.service;

import java.util.List;

import com.proxym.bo.model.AuthorityModel;

/**
 * 
 * @author med-amine.ben-ahmed
 *
 */
public interface AuthorityService {

	/**
	 * Save a new Authorities list
	 * 
	 * @param autorities
	 */
	void save(List<AuthorityModel> autorities);

	/**
	 * Return Authorities
	 * 
	 * @return
	 */
	List<AuthorityModel> getAuthorities();

	/**
	 * Update Authority for giving User
	 * 
	 * @param userName
	 * @param roleName
	 */
	void updateAuthority(String userName, String roleName);

	/**
	 * 
	 * @param userName
	 */
	void deleteAuthority(String userName);
	
	/**
	 * Get Authority By roleName
	 * 
	 * @param roleName
	 */
	List<AuthorityModel> getAuthorityByRoleName(String roleName);
	
	/**
	 * Get Authority By userName
	 * 
	 * @param userName
	 */
	AuthorityModel getAuthorityByUserName(String userName);

	void update(String userName,List<Authority> authorities);
}
