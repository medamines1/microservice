package com.proxym.bo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.proxym.bo.mapper.FeatureRoleMapper;
import com.proxym.bo.model.FeatureRoleModel;
import com.proxym.bo.service.FeatureRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxym.core.dao.FeatureDao;
import com.proxym.core.dao.FeatureRoleDao;
import com.proxym.core.dao.RoleDao;

@Service
public class FeatureRoleServiceIml implements FeatureRoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeatureRoleServiceIml.class);
	private final FeatureRoleDao featureRoleDao;
	private final FeatureDao featureDao;
	private final RoleDao roleDao;

	@Autowired
	public FeatureRoleServiceIml(FeatureRoleDao featureRoleDao, FeatureDao featureDao,
			RoleDao roleDao) {
		this.featureRoleDao = featureRoleDao;
		this.featureDao = featureDao;
		this.roleDao = roleDao;
	}
	
	
	@Override
	public void save(List<FeatureRoleModel> featureRoles) {
		
//		LOGGER.info("[FeatureRoleServiceIml] save");
		featureRoleDao.save(FeatureRoleMapper
				.listFeatureRoleModelToListFeatureRoleEntity(featureRoles));
		}

	@Override
	public List<FeatureRoleModel> getFeatureRoles() {
//		LOGGER.info("[FeatureRoleServiceIml] getFeatureRoles");
		return FeatureRoleMapper
				.listFeatureRoleEntityToListFeatureRoleModel(featureRoleDao.getFeatureRoles());
	}


	@Override
	public void deleteFeatureRoles(String role) {
//		LOGGER.info("[FeatureRoleServiceIml] deleteFeatureRoles");
		Role r = roleDao.findOneByName(role);
		featureRoleDao.deleteFeatureRoleByRole(r);
		
	}


	@Override
	public List<FeatureRoleModel> getFeatureRolesByRoleName(String roleName) {
//		LOGGER.info("[FeatureRoleServiceIml] getFeatureRolesByRoleName");

		Role role = roleDao.findOneByName(roleName);
		if(role != null)
			return FeatureRoleMapper.listFeatureRoleEntityToListFeatureRoleModel(featureRoleDao.getFeatureRoleByRole(role));
		else
			return new ArrayList<FeatureRoleModel>();
	}


	@Override
	public List<FeatureRoleModel> getFeatureRoleByFeatureCode(String code) {
		LOGGER.info("[FeatureRoleServiceIml] getFeatureRoleByFeatureCode");

		Feature feature = featureDao.findOneByCode(code);
		if(feature != null)
			return FeatureRoleMapper.listFeatureRoleEntityToListFeatureRoleModel(featureRoleDao.getFeatureRoleByFeature(feature));
		else
			return new ArrayList<FeatureRoleModel>();
	}


	@Override
	public FeatureRoleModel findOneByFeatureAndRole(String code, String roleName) {
		LOGGER.info("[FeatureRoleServiceIml] findOneByFeatureAndRole");
		//Feature feature = featureDao.findOneByCode(code);
		//Role role = roleDao.findOneByName(roleName);
		return FeatureRoleMapper.FeatureRoleEntityToFeatureRoleModel(featureRoleDao.getByFeatureNameAndRoleName(code, roleName));
	}

//	@Override
//	public void updateFeatureRoles(String userName, String roleName) {
//		LOGGER.info("[FeatureRoleServiceIml] updateFeatureRoles");
//		
//	}

	

}
