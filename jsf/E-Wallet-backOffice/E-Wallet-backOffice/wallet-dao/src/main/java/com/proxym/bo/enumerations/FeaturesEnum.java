package com.proxym.bo.enumerations;

import org.springframework.context.MessageSourceResolvable;

import java.util.ArrayList;
import java.util.List;

public enum FeaturesEnum implements MessageSourceResolvable {

    DASHBOARD("CNT000","Dashboard","/dashbord",null, "fa fa-dashboard", true),
    /*USERS("CNT010" , "Users" , "/usermanagement" , DASHBOARD , "" , true),
    USERS_FILTER("CNT020" , "Users filter" , "/usermanagement/filter" , USERS , "" , true),
    DISPLAY_USER("CNT021", "Display user management", "/usermanagement", USERS, "", true),
    EDIT_USER("CNT022", "Activate/Desactivate user management", "/usermanagement", USERS, "", true),
    DETAILS_USER("CNT023", "Display details user management", "/usermanagement/getuserprofile", USERS, "", true),*/
//    SEND_MESSAGE_USER("CNT024", "Send message to  USER", "/usermanagement", USERS, "", true),
//    DISPLAY_DEVICE_USER("CNT025", "Display Device  user ", "/usermanagement", USERS, "", true),
//    UPDATE_USER_STATUS("CNT026", "Update normal profile status", "#", USERS, "", true),
//    UPDATE_USER_DEVICES("CNT117", "Update OCI User Devices", "#", USERS, "", true),
//    DELETE_USER_DEVICES("CNT118", "Delete OCI User Devices", "#", USERS, "", true),
//    EXPORT_USER("CNT026", "Export  User", "#", USERS, "", true),

    /*MERCHANTS("CNT030" , "Merchants" , "/merchantManagement" , DASHBOARD , "" , true),
    DETAILS_MERCHANT("CNT033" , "Merchants" , "/merchantManagement" , MERCHANTS , "" , true),
    DISPLAY_NORMAL_MERCHANTS_DASHBOARD("CNT031" ,"Display Normal Merchant dashboard" , "#" , MERCHANTS , "" , true),
    NORMAL_MERCHANTS_DASHBOARD_REQUESTS_FILTER("CNT0311" ,"Display Normal Merchant filter and requests" , "/merchantManagement/normal/requests" , MERCHANTS , "" , true),
    NORMAL_MERCHANTS_DASHBOARD_REQUESTS_FILTER_DISPLAY_INFOS("CNT03112" ,"Normal merchant display infos" , "#" , MERCHANTS , "" , true),
    NORMAL_MERCHANTS_DASHBOARD_UPDATE("CNT03114" ,"Normal merchant change status" , "#" , MERCHANTS , "" , true),
    NORMAL_MERCHANTS_DASHBOARD_UPDATE_DELETE_DOC("CNT03120" ,"Normal merchant delete doc" , "#" , MERCHANTS , "" , true),
    NORMAL_MERCHANTS_DASHBOARD_UPDATE_STATUS_DOC("CNT03121" ,"Normal merchant update status document" , "#" , MERCHANTS , "" , true),
    NORMAL_MERCHANTS_DASHBOARD_UPLOAD_DOC("CNT03122" ,"Normal merchant upload document" , "#" , MERCHANTS , "" , true),

    TRUSTED_MERCHANTS_DASHBOARD_UPDATE("CNT03111" ,"Trusted merchant change status" , "#" , MERCHANTS , "" , true),
    TRUSTED_MERCHANTS_DASHBOARD_UPDATE_DELETE_DOC("CNT03117" ,"Trusted merchant delete doc" , "#" , MERCHANTS , "" , true),
    TRUSTED_MERCHANTS_DASHBOARD_UPDATE_STATUS_DOC("CNT03118" ,"Trusted merchant update status document" , "#" , MERCHANTS , "" , true),
    TRUSTED_MERCHANTS_DASHBOARD_UPLOAD_DOC("CNT03119" ,"Trusted merchant upload document" , "#" , MERCHANTS , "" , true),
    TRUSTED_MERCHANTS_DASHBOARD_REQUESTS_FILTER_DISPLAY_INFOS("CNT03113" ,"Trusted merchant display infos" , "#" , MERCHANTS , "" , true),
    TRUSTED_MERCHANTS("CNT040" , "Trusted Merchants" , "/trustedMerchantManagement" , DASHBOARD , "" , true),
    DISPLAY_TRUSTED_MERCHANTS_DASHBOARD("CNT041" ,"Display Trusted Merchant dashboard" , "#" , MERCHANTS , "" , true),
    DETAILS_TRUSTED_MERCHANT("CNT042" , "Merchants" , "/merchantManagement" , MERCHANTS , "" , true),
    TRUSTED_NORMAL_MERCHANTS_DASHBOARD_REQUESTS_FILTER("CNT043" ,"Display Trusted Merchant filter and requests" , "/trustedMerchantManagement/filter" , MERCHANTS , "" , true),*/


    USER_MANAGEMENT("CNT100", "User Management", "#", null, "fa fa-users", true),

    BO_USER_MANAGEMENT("CNT120", "BO User Management", "/bousermanagement", USER_MANAGEMENT, "", true),
    DISPLAY_BO_USER("CNT121", "Display BO Users", "/bousermanagement", BO_USER_MANAGEMENT, "", true),
    ADD_BO_USER("CNT122", "ADD BO Users", "/bousermanagement/add", BO_USER_MANAGEMENT, "", true),
    EDIT_BO_USER("CNT123", "EDIT BO User", "#", BO_USER_MANAGEMENT, "", true),
    DELETE_BO_USER("CNT124", "Delete BO User", "#", BO_USER_MANAGEMENT, "", true),
    EXPORT_BO_USER("CNT125", "Export BO User", "#", BO_USER_MANAGEMENT, "", true),
    ENABLEDISABLE_BO_USER("CNT126", "Enable/Disable BO User", "#", BO_USER_MANAGEMENT, "", true),
  //****************

/*    TRANSACTION_MANAGEMENT("CNT500","Transaction Management","/transaction",null, "fa fa-exchange", true),
    TRANSACTION_HISTORY("CNT510", "Transaction History", "/transaction/history", TRANSACTION_MANAGEMENT, "", true),
    DISPLAY_TRANSACTION_MANAGEMENT("CNT511", "Transaction History", "/transaction/history", TRANSACTION_HISTORY, "", true),
    CASHIN_CASHOUT_OPERATION("CNT520", "Cash In/Cash out Operations", "/cashInOut", TRANSACTION_MANAGEMENT, "", true),
    DISPLAY_CASHIN_CASHOUT_OPERATION("CNT521", "Cash In/Cash out Operations", "/cashInOut", CASHIN_CASHOUT_OPERATION, "", true),*/

    //********


//    ***************************Transactions*****************


    ROLE_MANAGEMENT("CNT200", "Roles Management", "#", null, "fa fa-users", true),

    BO_ROLE_MANAGEMENT("CNT210", "BO Roles Management", "/rolemanagement", ROLE_MANAGEMENT, "", true),
    DISPALY_BO_ROLE("CNT211", "Display BO Roles", "/rolemanagement", BO_ROLE_MANAGEMENT, "", true),
    ADD_BO_ROLE("CNT212", "Add BO Role", "/rolemanagement", BO_ROLE_MANAGEMENT, "", true),
    EDIT_BO_ROLE_ACCESS("CNT213", "Edit Module Access List", "#", BO_ROLE_MANAGEMENT, "", true),
    DELETE_BO_ROLE("CNT214", "Delete BO Role", "#", BO_ROLE_MANAGEMENT, "", true),
    EDIT_BO_ROLE("CNT215", "Add BO Role", "/rolemanagement", BO_ROLE_MANAGEMENT, "", true),

   /* OCI_ROLE_MANAGEMENT("CNT220", "OCI Roles Management", "/ocisegmentmanagement", ROLE_MANAGEMENT, "", false),
    DISPALY_OCI_ROLE("CNT221", "Display OCI Roles", "/ocisegmentmanagement", OCI_ROLE_MANAGEMENT, "", false),
    EDIT_OCI_ROLE_ACCESS("CNT222", "Edit Module Access List", "/segmentaccessmanagement", OCI_ROLE_MANAGEMENT, "", false),

    CONFIGURATIONS("CNT300", "Configuration", "#", null, "fa fa-cog", false),*/


//	CRM_TEAM_PER_REQUEST_TYPE("CNT390", "CRM team per request type","#", CONFIGURATIONS, "", false),

/*    CONTENT_MANAGEMENT_SYSTEM("CNT400", "Content Management System", "#", null, "fa fa-square", true),

    OTP_BIO_ACCESS_MATRIX("CNT310", "OTP Access Matrix", "/otpconfig", CONFIGURATIONS, "", true),
    DISPLAY_OTP_BIO_ACCESS_MATRIX("CNT311", "Dispaly OTP/BIO access matrix", "/otpconfig", OTP_BIO_ACCESS_MATRIX, "", true),
    EDIT_OTP_BIO_ACCESS_MATRIX("CNT312", "Edit OTP/BIO access matrix", "/otpconfig", OTP_BIO_ACCESS_MATRIX, "", true),*/


/*    FAQ("CNT690", "FAQ Management", "/faq", CONTENT_MANAGEMENT_SYSTEM, "", true),
    DISPLAY_FAQ("CNT691", "Display Faq", "/faq", FAQ, "", true),
    ADD_FAQ("CNT692", "Add Faq", "#", FAQ, "", true),
    EDIT_FAQ("CNT693", "Edit Faq", "#", FAQ, "", true),
    DELETE_FAQ("CNT694", "Delete Faq", "#", FAQ, "", true),*/



   /* MERCHANT("CNT620", "Merchant Management", "/generic/Merchant", CONTENT_MANAGEMENT_SYSTEM, "", false),
    DISPLAY_MERCHANT("CNT621", "Dispaly Merchant", "/generic/Merchant", MERCHANT, "", false),
    ADD_MERCHANT("CNT622", "Add Merchant", "/Merchant", MERCHANT, "", false),
    EDIT_MERCHANT("CNT623", "Edit Merchant", "/Merchant", MERCHANT, "", false),
    DELETE_MERCHANT("CNT624", "Delete Merchant", "/Merchant", MERCHANT, "", false),*/

    LOGGING("CNT700", "Logging", "#", null, "fa fa-file", true),
    LOGGING_EXCEPTION("CNT710", "Logging Exception", "/loggingexception", LOGGING, "", false),
    DISPLAY_LOGGING_EXCEPTION("CNT711", "Display Logging Exception", "/loggingexception", LOGGING_EXCEPTION, "", false),
    DOWNLOAD_LOGGING_EXCEPTION("CNT712", "Download Logging Exception", "/loggingexception", LOGGING_EXCEPTION, "", false),

  /*  LOGGING_EVENT("CNT720", "Logging Event", "/loggingevent", LOGGING, "", true),
    DISPLAY_LOGGING_EVENT("CNT721", "Display Logging Event", "/loggingevent", LOGGING_EVENT, "", true),
    DOWNLOAD_LOGGING_EVENT("CNT722", "Download Logging Event", "/loggingevent", LOGGING_EVENT, "", true),*/

/*    LOGGING_BO_ACTION("CNT740", "BO User Action", "/loggingbouseraction", LOGGING, "", true),
    DISPLAY_LOGGING_BO_ACTION("CNT741", "Display BO User Action", "/loggingbouseraction", LOGGING_BO_ACTION, "", true),
    DOWNLOAD_LOGGING_BO_ACTION("CNT742", "Download BO User Action", "/loggingbouseraction", LOGGING_BO_ACTION, "", true),*/


    PROPRETIES_SETTINGS("CNT800", "Settings", "#", null, "fa fa-cogs", true),



    PASSWORD_RULES("CNT820", "Password Rules", "/paswordrules", PROPRETIES_SETTINGS, "", false),
    DISPLAY_PASSWORD_RULES("CNT821", "display Password Rules", "/paswordrules", PASSWORD_RULES, "", false),
    EDIT_PASSWORD_RULES("CNT822", "edit Password Rules", "/paswordrules", PASSWORD_RULES, "", false);

    /*OCIB_ERROR("CNT730", "AGB Errors", "/errorCode", PROPRETIES_SETTINGS, "", false),
    ERROR_DISPLAY("CNT731", "Display error middelware", "/errorCode", OCIB_ERROR, "", true),
    NEW_ERROR_DISPLAY("CNT732", "Display new error middelware", "/errorCode/new", OCIB_ERROR, "", true),
    NEW_ERROR("CNT733", "New error middelware", "#", OCIB_ERROR, "", true),
    EDIT_ERROR_DISPPLAY("CNT734", "Display edit error middelware", "/errorCode/update", OCIB_ERROR, "", true),
    EDIT_ERROR("CNT735", "Edit error Middelware", "#", OCIB_ERROR, "", true),
    DELETE_ERROR("CNT736", "Delete error middelware", "#", OCIB_ERROR, "", true),*/


   /* DEFAULT_VALUE_CONFIG_CUSTOMERS("CNT350", "Customers Parameters", "/parameters", PROPRETIES_SETTINGS, "", true),
    DISPLAY_DEFAULT_PARAMETERS_CUSTOMERS("CNT351", "display default parameters", "/parameters", DEFAULT_VALUE_CONFIG_CUSTOMERS, "", true),
    EDIT_DEFAULT_PARAMETERS_CUSTOMERS("CNT352", "edit default parameters", "#", DEFAULT_VALUE_CONFIG_CUSTOMERS, "", true),

    DEFAULT_VALUE_CONFIG_TRUSTED_MERCHANTS("CNT353", "Trusted Merchant Parameters", "/parameters/merchant", PROPRETIES_SETTINGS, "", true),
    DISPLAY_DEFAULT_PARAMETERS_TUSTED_MERCHANTS("CNT354", "display Trusted Merchant parameters", "/parameters/merchant", DEFAULT_VALUE_CONFIG_TRUSTED_MERCHANTS, "", true),
    EDIT_DEFAULT_PARAMETERS_MERCHANTS("CNT355", "edit Trusted Merchant parameters", "#", DEFAULT_VALUE_CONFIG_TRUSTED_MERCHANTS, "", true),

    DEFAULT_VALUE_CONFIG_MERCHANTS("CNT370", "Merchant Parameters", "/parametersMerchant/merchant", PROPRETIES_SETTINGS, "", true),
    EDIT_DEFAULT_PARAMETERS_NORMAL_MERCHANTS("CNT371", "edit Merchant parameters", "#", DEFAULT_VALUE_CONFIG_MERCHANTS, "", true),


    DISPLAY_DEFAULT_PARAMETERS_TRUSTED_MERCHANTS("CNT3531" , "Trusted Merchant default parametes" , "" , DEFAULT_VALUE_CONFIG_TRUSTED_MERCHANTS, "" , true),
    ADD_DEFAULT_PARAMETERS_TRUSTED_MERCHANTS("CNT3532" , "Add trusted merchant official document" , "" , DEFAULT_VALUE_CONFIG_TRUSTED_MERCHANTS, "" , true),
    EDIT_DEFAULT_PARAMETERS_TRUSTED_MERCHANTS("CNT3533" , "Edit trusted merchant offical document" , "" , DEFAULT_VALUE_CONFIG_TRUSTED_MERCHANTS, "" , true),

    DISPLAY_DEFAULT_PARAMETERS_MERCHANTS("CNT3571" , "Merchant default parametes" , "" , DEFAULT_VALUE_CONFIG_MERCHANTS, "" , true),
    ADD_DEFAULT_PARAMETERS_MERCHANTS("CNT3572" , "Add merchant official document" , "" , DEFAULT_VALUE_CONFIG_MERCHANTS, "" , true),
    EDIT_DEFAULT_PARAMETERS_MERCHANT("CNT3573" , "Edit merchant offical document" , "" , DEFAULT_VALUE_CONFIG_MERCHANTS, "" , true),

    ABOUT_ELM("CNT356","About Elm Pay","/about",PROPRETIES_SETTINGS,"",true),
    DISPLAY_DEFAULT_EDIT_ABOUT("CNT357", "display About Elm Pay", "/about", ABOUT_ELM, "", true),
    EDIT_DEFAULT_EDIT_ABOUT("CNT358", "edit About Elm Pay", "#", ABOUT_ELM, "", true),

    TERMS_AND_CONDITION("CNT359","Terms And Conditions","/termeAndConditions",PROPRETIES_SETTINGS,"",true),
    DISPLAY_DEFAULT_EDIT_TERM_AND_CONDITION ("CNT360", "display Terms And Conditions", "/termeAndConditions", TERMS_AND_CONDITION, "", true),
    EDIT_DEFAULT_EDIT_TERM_AND_CONDITION ("CNT361", "edit Terms And Conditions", "#", TERMS_AND_CONDITION, "", true);*/


    /**
     * the feature code
     */
    private String code;
    /**
     * the feature name
     */
    private String name;

    /**
     * the feature path
     */
    private String path;


    /**
     * the feature icon
     */
    private String icon;

    /**
     * the feature path
     */
    private Boolean isVisible;


    /**
     * the feature parent
     */
    private FeaturesEnum parent;

    /**
     * @param code
     * @param name
     * @param path
     * @param icon
     * @param isVisible
     * @param parent
     */
    FeaturesEnum(String code, String name, String path, FeaturesEnum parent, String icon, Boolean isVisible) {
        this.code = code;
        this.name = name;
        this.path = path;
        this.icon = icon;
        this.isVisible = isVisible;
        this.parent = parent;
    }

    private FeaturesEnum() {
    }


    public String getPath() {
        return path;
    }


    public void setPath(String path) {
        this.path = path;
    }


    /**
     * @return the code
     * @author radhouene.gniwa
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     * @author radhouene.gniwa
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     * @author radhouene.gniwa
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     * @author radhouene.gniwa
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the parent
     * @author radhouene.gniwa
     */
    public FeaturesEnum fils() {
        return parent;
    }

    /**
     * @param parent the parent to set
     * @author radhouene.gniwa
     */
    public void setParent(FeaturesEnum parent) {
        this.parent = parent;
    }

    /**
     * @return features codes
     * @author radhouene.gniwa
     */
    public static List<String> getFeaturesCodes() {
        ArrayList<String> features = new ArrayList<String>();
        for (FeaturesEnum c : FeaturesEnum.values()) {
            features.add(c.getCode());
        }
        return features;
    }


    public FeaturesEnum getParent() {
        return parent;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getVisible() {
        return isVisible;
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }

    /**
     * @return features names
     * @author radhouene.gniwa
     */
    public static List<String> getFeaturesNames() {
        ArrayList<String> features = new ArrayList<String>();
        for (FeaturesEnum c : FeaturesEnum.values()) {
            features.add(c.getName());
        }
        return features;
    }

    public static FeaturesEnum getFeaturesByCode(String code) {
        for (FeaturesEnum c : FeaturesEnum.values()) {
            if (c.getCode().equals(code))
                return c;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.code + "_" + this.name;
    }

    @Override
    public String[] getCodes() {
        return new String[]{"enum.features." + getName()};
    }

    @Override
    public Object[] getArguments() {
        return null;
    }

    @Override
    public String getDefaultMessage() {
        return getName();
    }
}