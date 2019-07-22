package com.proxym.bo.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.proxym.bo.model.FeatureModel;
import com.proxym.bo.model.FeatureRoleModel;
import com.proxym.bo.model.RoleModel;

public class FeatureRoleMapper {
	
	 public static FeatureRoleModel FeatureRoleEntityToFeatureRoleModel(FeatureRole featureRole) {
	    	FeatureRoleModel fr = new FeatureRoleModel();
	    	FeatureModel feature = FeatureMapper.featureEntityToFeatureModel(featureRole.getFeature());
	    	RoleModel role = RoleMapper.roleEntityToRoleModel(featureRole.getRole());
	    	fr.setRole(role);
	    	fr.setFeature(feature);	    	
	        return fr;//new AuthorityModel(UserMapper.userEntityToUserModel(authority.getUser()), RoleMapper.roleEntityToRoleModel(authority.getRole()));
	    }

	    public static FeatureRole featureRoleModelToFeatureRoleEntity(FeatureRoleModel featureRoleModel) {
	    	FeatureRole fr = new FeatureRole();
	    	Feature feature= FeatureMapper.featureModelToFeatureEntity(featureRoleModel.getFeature());
	    	Role role = RoleMapper.roleModelToRoleEntity(featureRoleModel.getRole());
	    	fr.setFeature(feature);
	    	fr.setRole(role);
	        return fr;
	    }

	    public static List<FeatureRoleModel> listFeatureRoleEntityToListFeatureRoleModel(List<FeatureRole> featureRoles) {
	    	List<FeatureRoleModel> models = new ArrayList<FeatureRoleModel>();
	    	for (FeatureRole entity: featureRoles){
	    		models.add(FeatureRoleEntityToFeatureRoleModel(entity));
	    	}
//	    	if(authorities!= null && !authorities.isEmpty()){
//	    		System.err.println("**size**"+authorities.size());
//	    		models.addAll(authorities.stream().map(authority -> authorityEntityToAuthorityModel(authority)).collect(Collectors.toList()));
//	    	}
	        return models;
	    }

	    public static List<FeatureRole> listFeatureRoleModelToListFeatureRoleEntity(List<FeatureRoleModel> featureRoleModels) {
	        return featureRoleModels.stream().map(featureRoleModel -> featureRoleModelToFeatureRoleEntity(featureRoleModel)).collect(Collectors.toList());
	    }

}
