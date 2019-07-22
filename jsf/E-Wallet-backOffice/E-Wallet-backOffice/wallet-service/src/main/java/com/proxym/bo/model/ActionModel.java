package com.proxym.bo.model;


public class ActionModel {

	 Long id;


	String actionName;

	String controllerName;

	FeatureModel feature;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}
	
	

	
	public FeatureModel getFeature() {
		return feature;
	}

	public void setFeature(FeatureModel feature) {
		this.feature = feature;
	}

	public ActionModel(Long id, String actionName, String controllerName) {
		super();
		this.id = id;
		this.actionName = actionName;
		this.controllerName = controllerName;
	}
	
	

	public ActionModel(Long id, String actionName, String controllerName, FeatureModel feature) {
		super();
		this.id = id;
		this.actionName = actionName;
		this.controllerName = controllerName;
		this.feature = feature;
	}

	public ActionModel(String actionName, String controllerName, FeatureModel feature) {
		super();
		this.actionName = actionName;
		this.controllerName = controllerName;
		this.feature = feature;
	}

	public ActionModel() {
		super();
	}
	
	

	
}
