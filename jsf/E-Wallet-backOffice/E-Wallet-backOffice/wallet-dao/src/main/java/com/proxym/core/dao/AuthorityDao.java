package com.proxym.core.dao;

import java.util.List;

/**
 *
 * @author med-amine.ben-ahmed
 *
 */
public interface AuthorityDao {

	/**
	 * Used to save Authority list
	 *
	 * @param authorities
	 */
	void save(List<Authority> authorities);

	/**
	 * Used to update Authority list
	 *
	 * @param authorities
	 */
	void update(List<Authority> authorities);

	/**
	 * Used to retrieve Authority list
	 *
	 * @return
	 */
	List<Authority> getAuthorities();

	/**
	 * Used to update Authority for giving user
	 *
	 * @param user
	 * @param role
	 */
	void updateAuthority(User user, Role role);

	/**
	 * Return user' authority
	 *
	 * @param user
	 * @return
	 */
	Authority getAuthorityByUser(User user);
	/**
	 * Used to delete user'Authority
	 * @param userName
	 */
	void deleteAuthorityByUser(User user);

	/**
	 * Get Authority By roleName
	 *
	 * @param roleName
	 */
	List<Authority> getAuthorityByRole(Role role);

}
