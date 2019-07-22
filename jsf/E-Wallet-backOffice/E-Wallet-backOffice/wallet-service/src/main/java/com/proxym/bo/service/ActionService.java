package com.proxym.bo.service;

import java.util.List;

import com.proxym.bo.model.ActionModel;
import com.proxym.bo.model.FeatureModel;

public interface ActionService {
	
	void save(List<ActionModel> actions);

	void save(ActionModel action);
	
	List<ActionModel> getActions();

	Boolean delete(List<ActionModel> actions);

	void update(List<ActionModel> actions);

	List<ActionModel> findByFeature(FeatureModel feature);
	
    ActionModel findOneByName(String name);
    
    FeatureModel findFeatureByActionId(Long id);

    ActionModel findOneByNameAndControllerName(String name,String controller);

}
