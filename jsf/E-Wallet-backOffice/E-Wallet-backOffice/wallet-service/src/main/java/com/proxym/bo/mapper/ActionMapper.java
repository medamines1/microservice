package com.proxym.bo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proxym.bo.model.ActionModel;

public class ActionMapper {
	
	 public static ActionModel actionEntityToActionModel(Action action) {
	        return new ActionModel(action.getId(), action.getActionName(), action.getControllerName(), FeatureMapper.featureEntityToFeatureModel(action.getFeature()));
	    }

	    public static Action actionModelToActionEntity(ActionModel actionModel) {
	    	if(actionModel.getFeature() != null)
	    		return new Action(actionModel.getId(), actionModel.getActionName(), actionModel.getControllerName(), FeatureMapper.featureModelToFeatureEntity(actionModel.getFeature()));
	    	else
	    		return new Action(actionModel.getId(), actionModel.getActionName(), actionModel.getControllerName());
	    }

	    public static List<ActionModel> listActionEntityToListActionModel(List<Action> actions) {
	        return actions.stream().map(action -> actionEntityToActionModel(action)).collect(Collectors.toList());
	    }

	    public static List<Action> listActionModelToListActioneEntity(List<ActionModel> actionModels) {
	        return actionModels.stream().map(actionModel -> actionModelToActionEntity(actionModel)).collect(Collectors.toList());
	    }

}
