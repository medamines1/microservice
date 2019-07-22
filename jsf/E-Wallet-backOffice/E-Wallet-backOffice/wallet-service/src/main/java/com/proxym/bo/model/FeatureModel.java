package com.proxym.bo.model;

import java.util.ArrayList;
import java.util.List;



public class FeatureModel {

	
	private String code;

	private String name;
	
	private String path;

	private String icon;

	private FeatureModel parentFeature;

	private List<FeatureModel> childrenFeatures = new ArrayList<>(); 

	private List<ActionModel> actions = new ArrayList<>();

	private List<FeatureRoleModel> featureRoles = new ArrayList<>();
 

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FeatureModel getParentFeature() {
		return parentFeature;
	}

	public void setParentFeature(FeatureModel parentFeature) {
		this.parentFeature = parentFeature;
	}

	public List<FeatureModel> getChildrenFeatures() {
		return childrenFeatures;
	}

	public void setChildrenFeatures(List<FeatureModel> childrenFeatures) {
		this.childrenFeatures = childrenFeatures;
	}

	public List<ActionModel> getActions() {
		return actions;
	}

	public void setActions(List<ActionModel> actions) {
		this.actions = actions;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	

	public List<FeatureRoleModel> getFeatureRoles() {
		return featureRoles;
	}

	public void setFeatureRoles(List<FeatureRoleModel> featureRoles) {
		this.featureRoles = featureRoles;
	}

	public FeatureModel(String code, String name,String path, FeatureModel parentFeature, List<FeatureModel> childrenFeatures,
			List<ActionModel> actions) {
		super();
		this.code = code;
		this.name = name;
		this.path = path;
		this.parentFeature = parentFeature;
		this.childrenFeatures = childrenFeatures;
		this.actions = actions;
	}

	public FeatureModel(String code, String name, String path, List<FeatureModel> childrenFeatures, String icon) {
		super();
		this.code = code;
		this.name = name;
		this.path = path;
		this.childrenFeatures = childrenFeatures;
		this.icon = icon;
	}
	
	
	public FeatureModel(String code, String name,String path, FeatureModel parentFeature) {
		super();
		this.code = code;
		this.name = name;
		this.path = path;
		this.parentFeature = parentFeature;
	}

	
	

	public FeatureModel(String code, String name, String path, List<FeatureModel> childrenFeatures, List<ActionModel> actions) {
		super();
		this.code = code;
		this.name = name;
		this.path = path;
		this.childrenFeatures = childrenFeatures;
		this.actions = actions;
	}

	public FeatureModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeatureModel(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	
	
	
	
	

}
