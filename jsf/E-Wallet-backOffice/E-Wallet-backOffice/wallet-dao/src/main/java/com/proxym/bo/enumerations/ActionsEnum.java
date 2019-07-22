package com.proxym.bo.enumerations;

public enum ActionsEnum {

	DISPLAY_DASHBOARD("Login","welcome",FeaturesEnum.DASHBOARD.getCode()),
	/*EDIT_USER("UserManagement", "#", FeaturesEnum.EDIT_USER.getCode()),
	DETAILS_USER("UserManagement", "showUserDetails", FeaturesEnum.DETAILS_USER.getCode()),*/
	/*UPDATE_USER_STATUS("UserManagement", "showUserDetails", FeaturesEnum.UPDATE_USER_STATUS.getCode()),
	SEND_MESSAGE_USER("UserManagement", "#", FeaturesEnum.SEND_MESSAGE_USER.getCode()),
	DISPLAY_DEVICE_USER("UserManagement", "#", FeaturesEnum.DISPLAY_DEVICE_USER.getCode()),*/
//	EXPORT_USER("UserManagement", "#", FeaturesEnum.EXPORT_USER.getCode()),
//	UPDATE_USER_DEVICES("UserManagement", "#", FeaturesEnum.UPDATE_USER_DEVICES.getCode()),
//	DISPLAY_USER_DASHBOARD("UserManagement", "display", FeaturesEnum.USERS.getCode()),
//	DISPLAY_USER_FILTER("UserManagement", "display", FeaturesEnum.USERS_FILTER.getCode()),
	/*DISPLAY_NORMAL_MERCHANT_DASHBOARD("MerchantManagement","display" , FeaturesEnum.DISPLAY_NORMAL_MERCHANTS_DASHBOARD.getCode()),
	FILTER_REQUEST_NORMAL_MERCHANT_DASHBOARD("MerchantManagement","filter and requests" , FeaturesEnum.NORMAL_MERCHANTS_DASHBOARD_REQUESTS_FILTER.getCode()),
	NORMAL_MERCHANTS_DASHBOARD_REQUESTS_FILTER_DISPLAY_INFOS("MerchantManagement","display infors",FeaturesEnum.NORMAL_MERCHANTS_DASHBOARD_REQUESTS_FILTER_DISPLAY_INFOS.getCode()),
	DETAILS_MERCHANT("UserManagement", "showMerchantDetails", FeaturesEnum.DETAILS_MERCHANT.getCode()),
	DISPLAY_TRUSTED_MERCHANT_DASHBOARD("MerchantManagement","display" , FeaturesEnum.DISPLAY_TRUSTED_MERCHANTS_DASHBOARD.getCode()),
	FILTER_REQUEST_TRUSTED_MERCHANT_DASHBOARD("MerchantManagement","filter and requests" , FeaturesEnum.TRUSTED_NORMAL_MERCHANTS_DASHBOARD_REQUESTS_FILTER.getCode()),
	TRUSTED_MERCHANTS_DASHBOARD_UPDATE("MerchantManagement" , "Update Trusted merchant display" , FeaturesEnum.TRUSTED_MERCHANTS_DASHBOARD_UPDATE.getCode()),
	TRUSTED_MERCHANTS_DASHBOARD_UPDATE_DELETE_DOC("MerchantManagement" , "Delete offical doc trusted merchant" ,FeaturesEnum.TRUSTED_MERCHANTS_DASHBOARD_UPDATE_DELETE_DOC.getCode()),
	TRUSTED_MERCHANTS_DASHBOARD_UPLOAD_DOC("MerchantManagement" , "Upload offical doc trusted merchant" ,FeaturesEnum.TRUSTED_MERCHANTS_DASHBOARD_UPLOAD_DOC.getCode()),
	TRUSTED_MERCHANTS_DASHBOARD_UPDATE_STATUS_DOC("MerchantManagement" , "Update official doc status trusted merchant" ,FeaturesEnum.TRUSTED_MERCHANTS_DASHBOARD_UPDATE_STATUS_DOC.getCode()),
	NORMAL_MERCHANTS_DASHBOARD_UPDATE("MerchantManagement" , "Update Normal merchant display" , FeaturesEnum.NORMAL_MERCHANTS_DASHBOARD_UPDATE.getCode()),
	NORMAL_MERCHANTS_DASHBOARD_UPDATE_DELETE_DOC("MerchantManagement" , "Delete offical doc normal merchant" ,FeaturesEnum.NORMAL_MERCHANTS_DASHBOARD_UPDATE_DELETE_DOC.getCode()),
	NORMAL_MERCHANTS_DASHBOARD_UPLOAD_DOC("MerchantManagement" , "Upload offical doc normal merchant" ,FeaturesEnum.NORMAL_MERCHANTS_DASHBOARD_UPLOAD_DOC.getCode()),
	NORMAL_MERCHANTS_DASHBOARD_UPDATE_STATUS_DOC("MerchantManagement" , "Update official doc status normal merchant" ,FeaturesEnum.NORMAL_MERCHANTS_DASHBOARD_UPDATE_STATUS_DOC.getCode()),


	AMOUNT_MAX_MANAGEMENT("amountMaxManagement","display",FeaturesEnum.CONFIGURATIONS.getCode()),
*/
	DISPLAY_BO_USER("UserBOManagement","display",FeaturesEnum.DISPLAY_BO_USER.getCode()),
	ADD_BO_USER("AddUserBo","addUser",FeaturesEnum.ADD_BO_USER.getCode()),
	EDIT_BO_USER("UserBOManagement","updateUserRole",FeaturesEnum.EDIT_BO_USER.getCode()),
	DELETE_BO_USER("UserBOManagement","deleteUserRole",FeaturesEnum.DELETE_BO_USER.getCode()),
	EXPORT_BO_USER("UserBOManagement","#",FeaturesEnum.EXPORT_BO_USER.getCode()),
	ENABLEDISABLE_BO_USER("EnableDisableBoUser","#",FeaturesEnum.ENABLEDISABLE_BO_USER.getCode()),
//    EMAIL_SMS_MANAGEMENT("emailsmsmanagement","display",FeaturesEnum.CONTENT_MANAGEMENT_SYSTEM.getCode()),


	DISPALY_BO_ROLE("RoleManagement","display",FeaturesEnum.DISPALY_BO_ROLE.getCode()),
	ADD_BO_ROLE("RoleManagement","save",FeaturesEnum.ADD_BO_ROLE.getCode()),
	EDIT_BO_ROLE_ACCESS("RoleAccessManagement","display",FeaturesEnum.EDIT_BO_ROLE_ACCESS.getCode()),
	EDIT_BO_ROLE("RoleAccessManagement","save",FeaturesEnum.EDIT_BO_ROLE.getCode()),
	DELETE_BO_ROLE("RoleManagement","delete",FeaturesEnum.DELETE_BO_ROLE.getCode()),

//	DISPLAY_OTP_BIO_ACCESS_MATRIX("OtpConfig","display",FeaturesEnum.DISPLAY_OTP_BIO_ACCESS_MATRIX.getCode()),
//	EDIT_OTP_BIO_ACCESS_MATRIX("OtpConfig","updateOtpFeature",FeaturesEnum.EDIT_OTP_BIO_ACCESS_MATRIX.getCode()),


/*	DISPLAY_FAQ("FAQ" , "display" ,  FeaturesEnum.DISPLAY_FAQ.getCode()),
	ADD_FAQ("FAQ" , "addFaq" , FeaturesEnum.ADD_FAQ.getCode()),
	EDIT_FAQ("FAQ" , "updateFaq" , FeaturesEnum.EDIT_FAQ.getCode()),
	DELETE_FAQ("FAQ" , "deleteFaq" , FeaturesEnum.DELETE_FAQ.getCode()),*/



	/*ADD_DEFAULT_PARAMETERS_TRUSTED_MERCHANTS("Default Trusted Merchant parameter" , "add document" , FeaturesEnum.ADD_DEFAULT_PARAMETERS_TRUSTED_MERCHANTS.getCode()),
	ADD_DEFAULT_PARAMETERS_MERCHANTS("Default Merchant parameter" , "add document" , FeaturesEnum.ADD_DEFAULT_PARAMETERS_MERCHANTS.getCode()),*/






	/*DISPLAY_DEFAULT_PARAMETERS_CUSTOMERS("Customers parameters" , "display" , FeaturesEnum.DISPLAY_DEFAULT_PARAMETERS_CUSTOMERS.getCode()),
	EDIT_DEFAULT_PARAMETERS_CUSTOMERS("Customers parameters" , "onRowEdit" , FeaturesEnum.EDIT_DEFAULT_PARAMETERS_CUSTOMERS.getCode()),

	DISPLAY_DEFAULT_PARAMETERS_MERCHANTS("Default parameters" , "display" , FeaturesEnum.DISPLAY_DEFAULT_PARAMETERS_TRUSTED_MERCHANTS.getCode()),
	EDIT_DEFAULT_PARAMETERS_MERCHANTS("Default parameters" , "onRowEditMerchant" , FeaturesEnum.EDIT_DEFAULT_PARAMETERS_MERCHANTS.getCode()),


	ERROR_DISPLAY("Error middelware" , "display" , FeaturesEnum.ERROR_DISPLAY.getCode()),
	NEW_ERROR_DISPLAY("Error middelware" , "newErrorCode" , FeaturesEnum.NEW_ERROR_DISPLAY.getCode()),
	NEW_ERROR("Error middelware" , "addErrorCode" , FeaturesEnum.NEW_ERROR.getCode()),
	EDIT_ERROR_DISPPLAY_CUSTOMERS("Error middelware" , "getErrorCode" , FeaturesEnum.DISPLAY_DEFAULT_PARAMETERS_CUSTOMERS.getCode()),
	EDIT_ERROR_DISPPLAY_MERCHANTS("Error middelware" , "getErrorCode" , FeaturesEnum.DISPLAY_DEFAULT_PARAMETERS_TRUSTED_MERCHANTS.getCode()),
	EDIT_ERROR("Error middelware" , "updateError", FeaturesEnum.EDIT_ERROR.getCode()),
	DELETE_ERROR("Error middelware" , "deleteErrorCode" , FeaturesEnum.DELETE_ERROR.getCode()),

	DISPLAY_MERCHANT("Merchant", "display", FeaturesEnum.DISPLAY_MERCHANT.getCode()),
	ADD_MERCHANT("Merchant", "saveOrEdit", FeaturesEnum.ADD_MERCHANT.getCode()),
	EDIT_MERCHANT("Merchant", "saveOrEdit", FeaturesEnum.EDIT_MERCHANT.getCode()),
	DELETE_MERCHANT("Merchant", "delete", FeaturesEnum.DELETE_MERCHANT.getCode()),

	DISPLAY_About("About", "display", FeaturesEnum.DISPLAY_DEFAULT_EDIT_ABOUT.getCode()),
//	ADD_About("About", "saveOrEdit", FeaturesEnum.EDIT_DEFAULT_EDIT_ABOUT.getCode()),
	EDIT_About("About", "saveOrEdit", FeaturesEnum.EDIT_DEFAULT_EDIT_ABOUT.getCode()),

	DISPLAY_TERMS_AND_CONDITIONS("TermsAndConditions", "display", FeaturesEnum.DISPLAY_DEFAULT_EDIT_TERM_AND_CONDITION.getCode()),
	//	ADD_TERMS_AND_CONDITIONS("TermsAndConditions", "saveOrEdit", FeaturesEnum.DISPLAY_DEFAULT_EDIT_TERM_AND_CONDITION.getCode()),
	EDIT_TERMS_AND_CONDITIONS("TermsAndConditions", "saveOrEdit", FeaturesEnum.DISPLAY_DEFAULT_EDIT_TERM_AND_CONDITION.getCode()),
*/
	DISPLAY_LOGGING_EXCEPTION("LoggingException", "display",  FeaturesEnum.DISPLAY_LOGGING_EXCEPTION.getCode()),
	DOWNLOAD_LOGGING_EXCEPTION("LoggingException", "download",  FeaturesEnum.DOWNLOAD_LOGGING_EXCEPTION.getCode()),

/*	DISPLAY_LOGGING_EVENT("LoggingEvent", "display",  FeaturesEnum.DISPLAY_LOGGING_EVENT.getCode()),
	DOWNLOAD_LOGGING_EVENT("LoggingEvent", "download",  FeaturesEnum.DOWNLOAD_LOGGING_EVENT.getCode()),*/
	
/*	DISPLAY_LOGGING_BO_ACTION("LoggingBOUserAction", "display",  FeaturesEnum.DISPLAY_LOGGING_BO_ACTION.getCode()),
	DOWNLOAD_LOGGING_BO_ACTION("LoggingBOUserAction", "download",  FeaturesEnum.DOWNLOAD_LOGGING_BO_ACTION.getCode()),*/

	
	DISPLAY_PASSWORD_RULES("PasswordRules", "display", FeaturesEnum.DISPLAY_PASSWORD_RULES.getCode()),
	EDIT_PASSWORD_RULES("PasswordRules", "edit", FeaturesEnum.EDIT_PASSWORD_RULES.getCode());

/*	DISPLAY_TRANSACTION_MANAGEMENT("Transactions history" , "display" , FeaturesEnum.DISPLAY_TRANSACTION_MANAGEMENT.getCode()),
	DISPLAY_CASHIN_CASHOUT_OPERATION("Cash in / Cash out operations" , "display" , FeaturesEnum.DISPLAY_CASHIN_CASHOUT_OPERATION.getCode());*/

	
	
	/**
	 * the controller name
	 */
	String controllerName;
	/**
	 * the action name
	 */
	String actionName;
	/**
	 * the corresponding feature code
	 */
	String featureCode;

	/**
	 * Constructor
	 * @author nasreddine.jrebi
	 * @param controllerName
	 * @param actionName
	 * @param featureCode
	 */
	private ActionsEnum(String controllerName, String actionName, String featureCode) {
		this.controllerName = controllerName;
		this.actionName = actionName;
		this.featureCode = featureCode;
	}
	
	/**
	 * @return the controllerName
	 */
	public String getControllerName() {
		return controllerName;
	}

	/**
	 * @param controllerName the controllerName to set
	 */
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * @param actionName the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * @return the featureCode
	 */
	public String getFeatureCode() {
		return featureCode;
	}

	/**
	 * @param featureCode the feature code to set
	 */
	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}
	
	/**
	 * fetch feature code that corresponding a controller and a action names
	 * @author radhouene.gniwa
	 * @param controllerName
	 * @param actionName
	 * @return
	 */
	public static String findFeatureCode(String controllerName, String actionName){
		String featureCode = null;
		for (ActionsEnum c : ActionsEnum.values()) {
	        if (c.getControllerName().equals(controllerName) && c.getActionName().equals(actionName)) {
	        	featureCode = c.getFeatureCode();
	            break ;
	        }
	    }
		return featureCode;
	}
	
}