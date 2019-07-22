package com.proxym.bo.mapper;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import com.proxym.bo.model.UserActionModel;

public class UserActionMapper {

	
	  /**
     * Map UserAction to UserActionModel
     * @param UserAction
     * @return
     */
    public static UserActionModel mapToUserActionModel(UserAction userAction) {

    	UserActionModel model =  UserActionModel.newBuilder()
    			.id(userAction.getId())
    			.action(userAction.getAction())
    			.actionData(userAction.getActionData())
    			.exceptionData(userAction.getExceptionData())
    			.actionDate(userAction.getActionDate())
    			.username(userAction.getUsername())
    			.isSuccess(userAction.getIsSuccess())
    			.build();

        return model;
    }

    /**
     * Map list of UserAction to UserActionModel list
     * @param UserActions
     * @return
     */
    public static List<UserActionModel> mapToUserActinModels(List<UserAction> userActions) {
        List<UserActionModel> list = new ArrayList<>();
        if (userActions != null && !userActions.isEmpty())
        	list.addAll(userActions.stream().map(action -> mapToUserActionModel(action)).collect(toList()));
        return list;
    }
    
    
    
    
    
    
    
    /**
     * Map UserActionModel to UserAction
     * @param UserActionModel
     * @return
     */
    public static UserAction mapToUserAction(UserActionModel userActionModel) {

    	UserAction entity =  (userActionModel == null ? null : UserAction.newBuilder()
    			.id(userActionModel.getId())
    			.action(userActionModel.getAction())
    			.actionData(userActionModel.getActionData())
    			.exceptionData(userActionModel.getExceptionData())
    			.actionDate(userActionModel.getActionDate())
    			.username(userActionModel.getUsername())
    			.isSuccess(userActionModel.getIsSuccess())
    			.build());

        return entity;
    }

    /**
     * Map list of UserAction to UserActionModel list
     * @param UserActions
     * @return
     */
    public static List<UserAction> mapToUserActionEntities(List<UserActionModel> userActions) {
        List<UserAction> list = new ArrayList<>();
        if (userActions != null && !userActions.isEmpty())
        	list.addAll(userActions.stream().map(action -> mapToUserAction(action)).collect(toList()));
        return list;
    }
}
