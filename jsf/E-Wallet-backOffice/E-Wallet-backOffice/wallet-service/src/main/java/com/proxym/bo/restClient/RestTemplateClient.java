package com.proxym.bo.restClient;

import com.elm.commons.utilities.errors.errorcode.ElmErrorCodeResource;
import com.elm.commons.utilities.exceptions.RestBackendException;
import com.elm.commons.utilities.response.GenericResponse;
import com.elm.commons.utilities.response.body.BooleanResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.elm.commons.utilities.response.body.ListResponse;
import com.elm.commons.utilities.response.body.ObjectResponse;
import com.elm.commons.utilities.response.body.PaginatedListResponse;
import com.elm.commons.utilities.response.enumerations.DocumentSettingTypeEnum;
import com.elm.commons.utilities.response.enumerations.ProfileVerificationRequirementStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import resources.core.*;
import resources.core.configuration.OTPConfigFeatureResource;
import resources.core.configuration.ServiceEnumResource;
import resources.core.configuration.UpdateIsUserEnabled;
import resources.settings.ElmSettingsResources;
import resources.settings.TerminalStatus;

@Component
public class RestTemplateClient {

    private CustomRestTemplate boCustomRestTemplate = new CustomRestTemplate();
    @Value("${uri.ws.server}")
    private String server;
    @Value("${uri.ws.port}")
    private String port;
    @Value("${uri.ws.module}")
    private String module;

    @Value("${uri.ws.otpconfig}")
    private String otpConfigFeature;

    @Value("${uri.ws.indivUser}")
    private String indivUser;

    @Value("${uri.ws.trustedMerchantById}")
    private String trustedMerchant;

    @Value("${uri.ws.normalMerchantBId}")
    private String normalMerchant;

    @Value("${uri.ws.normalFilter}")
    private String normalFilter;

    @Value("${uri.ws.trustedFilter}")
    private String trustedFilter;

    @Value("${uri.ws.settings}")
    private String settings;

    @Value("${uri.ws.documentSettings}")
    private String docSettingType;

    @Value("${uri.ws.document}")
    private String document;

    @Value("${uri.ws.documentSettingsTypeName}")
    private String findByTypeAndName;

    @Value("${uri.ws.documentUpload}")
    private String documentUpload;

    @Value("${uri.ws.updateDocument}")
    private String updateDoc;

    @Value("${uri.ws.faq}")
    private String faq;

    @Value("${uri.ws.logging}")
    private String logging;

    @Value("${uri.ws.errorCodes}")
    private String errorCodes;


    @Value("${uri.ws.parameters}")
    private String parameters;
    @Value("${uri.ws.about}")
    private String about;

    @Value("${uri.ws.chart}")
    private String chart;

    @Value("${uri.ws.chartM}")
    private String chartM;

    @Value("${uri.ws.chartMaxDate}")
    private String maxDateSub;

    @Value("${uri.ws.termsAndCondition}")
    private String terme;

    @Value("${uri.ws.getUserById}")
    private String getUserById;

    @Value("${uri.ws.profileBanks}")
    private String banks;

    @Value("${uri.ws.allMerchants}")
    private String merchants;

    @Value("${uri.ws.cashInOutFilter}")
    private String cashInOut;

    /***********************************
     * OCI User Management
     ***************************/

    public List<UserResource> listOCIUsers() throws RestBackendException {
        String uri = getUri(indivUser) + "/getall";
        ListResponse<UserResource> listResponse = (ListResponse<UserResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<UserResource>>>() {
                        });
        return listResponse.getList();
    }

    public List<UserResource> listOCISubUsers(String customerNumber) throws RestBackendException {
        String uri = getUri(indivUser) + "/getallSubUsers?customerNumber=" + customerNumber;
        ListResponse<UserResource> listResponse = (ListResponse<UserResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<UserResource>>>() {
                        });
        return listResponse.getList();
    }

    public UserResource findUserByUsername(String username) throws RestBackendException {
        String uri = getUri(indivUser) + "?username=" + username;
        ObjectResponse<UserResource> response = (ObjectResponse<UserResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ObjectResponse<UserResource>>>() {
                        });
        return response.getObject();
    }

    public List<DeviceResource> listDevicesOCIUser(String username) throws RestBackendException {
        String uri = getUri(indivUser) + "/devices?username=" + username;
        ListResponse<DeviceResource> listResponse = (ListResponse<DeviceResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<DeviceResource>>>() {
                        });
        return listResponse.getList();
    }

    public BooleanResponse updateOCIUserEnabled(String username, Boolean enabled) throws RestBackendException {
        String uri = getUri(indivUser) + "/updateisenabled";
        UpdateIsUserEnabled updateObject = new UpdateIsUserEnabled(username, enabled);
        BooleanResponse response = (BooleanResponse) boCustomRestTemplate.putObjectGetGenericResponseBody(uri,
                updateObject, new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
                });
        return response;
    }

    public BooleanResponse updateOCIUserDeviceActivation(String username, String deviceId, Boolean enabled)
            throws RestBackendException {
        String uri = getUri(indivUser) + "/device/updateactivation";
        UpdateDeviceResource updateObject = UpdateDeviceResource.newBuilder().deviceId(deviceId).username(username)
                .isEnabled(enabled).build();
        BooleanResponse response = (BooleanResponse) boCustomRestTemplate.putObjectGetGenericResponseBody(uri,
                updateObject, new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
                });
        return response;
    }

    public PaginatedListResponse paginatedIndivUser(int page, int size, String search) throws RestBackendException {
        //todo to verify params
        String uri = getUri(indivUser) + "?page=" + page + "&size=" + size + "&" + search;
        PaginatedListResponse<ProfilesBoResource> listResponse = (PaginatedListResponse<ProfilesBoResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<PaginatedListResponse<ProfilesBoResource>>>() {
                        });
        return listResponse;
    }

    public PaginatedListResponse paginatedNormalMerchantProfile(int page, int size, String search) throws RestBackendException {
        //todo to verify params
        String uri = getUri(normalFilter) + "?page=" + page + "&size=" + size + "&" + search;
        PaginatedListResponse<ProfileResource> listResponse = (PaginatedListResponse<ProfileResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<PaginatedListResponse<ProfileResource>>>() {
                        });
        return listResponse;
    }

    public PaginatedListResponse paginatedTrustedMerchantProfile(int page, int size, String search) throws RestBackendException {
        //todo to verify params
        String uri = getUri(trustedFilter) + "?page=" + page + "&size=" + size + "&" + search;
        PaginatedListResponse<ProfileResource> listResponse = (PaginatedListResponse<ProfileResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<PaginatedListResponse<ProfileResource>>>() {
                        });
        return listResponse;
    }

    public ProfileResource getMerchantById(String id) throws RestBackendException {
        String uri = getUri(trustedMerchant) + "?id=" + id;
        ObjectResponse<ProfileResource> response = (ObjectResponse<ProfileResource>) boCustomRestTemplate.getGenericResponseBody(
                uri, new ParameterizedTypeReference<GenericResponse<ObjectResponse<ProfileResource>>>() {
                });
        return response.getObject();
    }

    public ProfileResource getNormalMerchantById(String id) throws RestBackendException {
        String uri = getUri(normalMerchant) + "?id=" + id;
        ObjectResponse<ProfileResource> response = (ObjectResponse<ProfileResource>) boCustomRestTemplate.getGenericResponseBody(
                uri, new ParameterizedTypeReference<GenericResponse<ObjectResponse<ProfileResource>>>() {
                });
        return response.getObject();
    }

    public List<OTPConfigFeatureResource> listConfigOTPFeatureResources() throws RestBackendException {
        String uri = getUri(otpConfigFeature) + "/otpmatrix";
        ListResponse<OTPConfigFeatureResource> listResponse = (ListResponse<OTPConfigFeatureResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<OTPConfigFeatureResource>>>() {
                        });
        return listResponse.getList();
    }

    public List<ServiceEnumResource> listConfigService() throws RestBackendException {
        String uri = getUri(otpConfigFeature) + "/allservices";
        ListResponse<ServiceEnumResource> listResponse = (ListResponse<ServiceEnumResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<ServiceEnumResource>>>() {
                        });
        return listResponse.getList();
    }

    public BooleanResponse updatelistConfigOTPFeatureResources(List<OTPConfigFeatureResource> listFeature)
            throws RestBackendException {
        String uri = getUri(otpConfigFeature) + "/otpmatrix";
        BooleanResponse response = (BooleanResponse) boCustomRestTemplate.putObjectGetGenericResponseBody(uri,
                listFeature, new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
                });
        return response;
    }

    public BooleanResponse updateProfile(ProfileResource profileResource) {
        String uri = getUri("updateInfoMerchant");
        BooleanResponse response = (BooleanResponse) boCustomRestTemplate.putObjectGetGenericResponseBody(uri, profileResource,
                new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
                });
        return response;
    }


    //	// ***********************************************FAQ****************************************
//
    public List<FaqResource> listOfFaqs() {
        String uri = getUri(faq) + "/allBo";
        ListResponse<FaqResource> listResponse = (ListResponse<FaqResource>) boCustomRestTemplate.getGenericResponseBody(
                uri, new ParameterizedTypeReference<GenericResponse<ListResponse<FaqResource>>>() {
                });
        return listResponse.getList();
    }

    public Boolean addFaq(FaqResource faqResource) throws RestBackendException {
        String uri = getUri(faq) + "";
        BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.postObjectGetGenericResponseBody(uri, faqResource,
                new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
                });
        return resp.isSuccess();
    }

    public Boolean deleteFaq(FaqResource faqResource) throws RestBackendException {
        String uri = getUri(faq) + "";
        BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.deleteObjectGetGenericResponseBody(uri, faqResource,
                new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
                });
        return resp.isSuccess();

    }

    public FaqResource getFaqById(String id) throws RestBackendException {
        String uri = getUri(faq) + "/" + id;
        ObjectResponse<FaqResource> response = (ObjectResponse<FaqResource>) boCustomRestTemplate.getGenericResponseBody(
                uri, new ParameterizedTypeReference<GenericResponse<ObjectResponse<FaqResource>>>() {
                });
        return response.getObject();
    }

    public void updateFaq(FaqResource faqResource) throws RestBackendException {
        String uri = getUri(faq) + "";
        boCustomRestTemplate.putObject(uri, faqResource);
    }

    // ****************************************Parameters
    // ************************************

    public List<String> getMethods() throws RestBackendException {
        String uri = getUri(logging) + "/exception/methods";
        ListResponse<String> listResponse = (ListResponse<String>) boCustomRestTemplate.getGenericResponseBody(uri,
                new ParameterizedTypeReference<GenericResponse<ListResponse<String>>>() {
                });
        return listResponse.getList();

    }

    public List<TerminalStatus> getAllTerminals() throws RestBackendException {
        String uri = getUri(settings) + "/status";
        ListResponse<TerminalStatus> listResponse = (ListResponse<TerminalStatus>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<TerminalStatus>>>() {
                        });
        return listResponse.getList();
    }

    // ******************************Elm error
    // code*******************************************************

    public List<ElmErrorCodeResource> listOfCodes() throws RestBackendException {
        String uri = getUri(errorCodes) + "";
        ListResponse<ElmErrorCodeResource> listResponse = (ListResponse<ElmErrorCodeResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<ElmErrorCodeResource>>>() {
                        });
        return listResponse.getList();
    }

    public Boolean deleteErrorCode(ElmErrorCodeResource ocibErrorCodeResource) throws RestBackendException {
        String uri = getUri(errorCodes) + "";
        BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.deleteObjectGetGenericResponseBody(uri,
                ocibErrorCodeResource, new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
                });
        return resp.isSuccess();
    }

    public ElmErrorCodeResource getErrorById(String id) throws RestBackendException {
        String uri = getUri(errorCodes) + "/" + id;
        ObjectResponse<ElmErrorCodeResource> response = (ObjectResponse<ElmErrorCodeResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ObjectResponse<ElmErrorCodeResource>>>() {
                        });
        return response.getObject();
    }

    public Boolean addError(ElmErrorCodeResource ocibErrorCodeResource) throws RestBackendException {
        String uri = getUri(errorCodes) + "";
        BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.postObjectGetGenericResponseBody(uri,
                ocibErrorCodeResource, new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
                });
        return resp.isSuccess();
    }

    public void updateError(ElmErrorCodeResource ocibErrorCodeResource) throws RestBackendException {
        String uri = getUri(errorCodes) + "";
        boCustomRestTemplate.putObject(uri, ocibErrorCodeResource);
    }


    public List<ParametersResource> listOfParameters() throws RestBackendException {
        String uri = getUri(parameters) + "/customerParam";
        ListResponse<ParametersResource> listResponse = (ListResponse<ParametersResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<ParametersResource>>>() {
                        });
        return listResponse.getList();
    }

    public List<ParametersResource> listOfMerchantParameters() throws RestBackendException {
        String uri = getUri(parameters) + "/merchantParam";
        ListResponse<ParametersResource> listResponse = (ListResponse<ParametersResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<ParametersResource>>>() {
                        });
        return listResponse.getList();
    }

    public void updateExistingParameter(ParametersResource parametersResource) throws RestBackendException {
        String uri = getUri(parameters) + "";
        boCustomRestTemplate.putObject(uri, parametersResource);
    }


    /*******************************
     * Logging
     ****************************************************/

    public PaginatedListResponse listOfLoggingException(int page, int size, String search) throws RestBackendException {
        String uri = getUri(logging) + "/exception?page=" + page + "&size=" + size + "&sort=eventDate,desc&" + search;
        PaginatedListResponse<LoggingExceptionResource> listResponse = (PaginatedListResponse<LoggingExceptionResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<PaginatedListResponse<LoggingExceptionResource>>>() {
                        });
        return listResponse;
    }

    public PaginatedListResponse listOfLoggingEvent(int page, int size, String search) throws RestBackendException {
        String uri = getUri(logging) + "/event?page=" + page + "&size=" + size + "&sort=requestTime,desc&" + search;
        PaginatedListResponse<LogRestResource> listResponse = (PaginatedListResponse<LogRestResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<PaginatedListResponse<LogRestResource>>>() {
                        });
        return listResponse;
    }

    public LoggingDataResource loggingEventDataValues() throws RestBackendException {
        String uri = getUri(logging) + "/event/datavalues";
        ObjectResponse<LoggingDataResource> response = (ObjectResponse<LoggingDataResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ObjectResponse<LoggingDataResource>>>() {
                        });
        return response.getObject();
    }


    /***********************************************************
     * error codes
     *
     * @throws RestBackendException
     **********************************************/

//	public List<ElmErrorCodeResource> listOfCodes() throws RestBackendException {
//		String uri = getUri(errorCodes) + "";
//		ListResponse<ElmErrorCodeResource> listResponse = (ListResponse<ElmErrorCodeResource>) boCustomRestTemplate
//				.getGenericResponseBody(uri,
//						new ParameterizedTypeReference<GenericResponse<ListResponse<ElmErrorCodeResource>>>() {
//						});
//		return listResponse.getList();
//	}
//
//	public Boolean deleteErrorCode(ElmErrorCodeResource ElmErrorCodeResource) throws RestBackendException {
//		String uri = getUri(errorCodes) + "";
//		BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.deleteObjectGetGenericResponseBody(uri,
//				ElmErrorCodeResource, new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
//				});
//		return resp.isSuccess();
//	}
//
//	public ElmErrorCodeResource getErrorById(String id) throws RestBackendException {
//		String uri = getUri(errorCodes) + "/" + id;
//		ObjectResponse<ElmErrorCodeResource> response = (ObjectResponse<ElmErrorCodeResource>) boCustomRestTemplate
//				.getGenericResponseBody(uri,
//						new ParameterizedTypeReference<GenericResponse<ObjectResponse<ElmErrorCodeResource>>>() {
//						});
//		return response.getObject();
//	}
//
//	public Boolean addError(ElmErrorCodeResource ElmErrorCodeResource) throws RestBackendException {
//		String uri = getUri(errorCodes) + "";
//		BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.postObjectGetGenericResponseBody(uri,
//				ElmErrorCodeResource, new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
//				});
//		return resp.isSuccess();
//	}
//
//	public void updateError(ElmErrorCodeResource ElmErrorCodeResource) throws RestBackendException {
//		String uri = getUri(errorCodes) + "";
//		boCustomRestTemplate.putObject(uri, ElmErrorCodeResource);
//	}

    /***********************************************************
     * Settings
     *
     * @throws RestBackendException
     **********************************************/

    public List<ElmSettingsResources> getSettingsByProvider(String provider) throws RestBackendException {
        String uri = getUri(settings) + "/" + provider;
        ListResponse<ElmSettingsResources> listResponse = (ListResponse<ElmSettingsResources>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<ElmSettingsResources>>>() {
                        });
        return listResponse.getList();
    }

    /***********************************************************
     * Officiel documents setting
     *
     * @throws RestBackendException
     **********************************************/

    public List<DocumentSettingsResource> getDocumentByType(DocumentSettingTypeEnum type) throws RestBackendException {
        String uri = getUri(docSettingType) + "?type=" + type;
        ListResponse<DocumentSettingsResource> listResponse = (ListResponse<DocumentSettingsResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ListResponse<DocumentSettingsResource>>>() {
                        });
        return listResponse.getList();
    }

    public Boolean addDocumentRequirement(DocumentSettingsResource resource) {
        String uri = getUri(updateDoc) + "";
        BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.postObjectGetGenericResponseBody(uri, resource,
                new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
                });
        return resp.isSuccess();
    }

    public List<DocumentSettingsResource> listOfDocuments() {
        String uri = getUri(document) + "/all";
        ListResponse<DocumentSettingsResource> listResponse = (ListResponse<DocumentSettingsResource>) boCustomRestTemplate.getGenericResponseBody(
                uri, new ParameterizedTypeReference<GenericResponse<ListResponse<DocumentSettingsResource>>>() {
                });
        return listResponse.getList();
    }


    public DocumentSettingsResource findByNameAndType(String name, DocumentSettingTypeEnum type) {
        String uri = getUri(findByTypeAndName) + "?name=" + name + "&type=" + type;
        ObjectResponse<DocumentSettingsResource> response = (ObjectResponse<DocumentSettingsResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ObjectResponse<DocumentSettingsResource>>>() {
                        });
        return response.getObject();
    }

    public DocumentSettingsResource findDocumentById(String id) {
        String uri = getUri(updateDoc) + "/" + id;
        ObjectResponse<DocumentSettingsResource> response = (ObjectResponse<DocumentSettingsResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ObjectResponse<DocumentSettingsResource>>>() {
                        });
        return response.getObject();
    }

    public void updateOfficialDoc(DocumentSettingsResource resource) {
        String uri = getUri(updateDoc) + "";
        boCustomRestTemplate.putObject(uri, resource);
    }

    public FileDownloadResource findDocumentInfos(String documentId, String profileId) {
        String uri = getUri(documentUpload) + "/downloadDoc" + "?documentId=" + documentId + "&profileId=" + profileId;
        ObjectResponse<FileDownloadResource> response = (ObjectResponse<FileDownloadResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ObjectResponse<FileDownloadResource>>>() {
                        });
        return response.getObject();
    }

    public void updateDocumentStatus(String documentId, String profileId, ProfileVerificationRequirementStatus status, String adminName) throws RestBackendException {
        String uri = getUri(documentUpload) + "/update" + "?documentId=" + documentId + "&profileId=" + profileId + "&status=" + status + "&adminName=" + adminName;
        boCustomRestTemplate.putObject(uri, documentUpload);
    }

    public Boolean deleteDocument(String document, String profileId) {
        String uri = getUri(documentUpload) + "/delete" + "?documentId=" + document + "&profileId=" + profileId;
        BooleanResponse resp = boCustomRestTemplate.getBooleanResponse(uri);
        return resp.isSuccess();
    }

    public Boolean uplaodDocument(InputStream is, String fileName, UploadDocumentResource resource) throws IOException {
        String uri = getUri(documentUpload) + "/trusted";
        BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.postObjWithListFiles(uri, resource, is, fileName, new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
        });
        return resp.isSuccess();
    }


    public Boolean findIfDocumentIsAqquired(String document, String profileId) {
        String uri = getUri(documentUpload) + "/isAquired" + "?documentId=" + document + "&profileId=" + profileId;
        BooleanResponse resp = boCustomRestTemplate.getBooleanResponse(uri);
        return resp.isSuccess();
    }

    public ProfileVerificationTypeRequirmentResource findProfileVerificationReq(String documentId, String profileId) {
        String uri = getUri(documentUpload) + "/getProfileVerification" + "?documentId=" + documentId + "&profileId=" + profileId;
        ObjectResponse<ProfileVerificationTypeRequirmentResource> response = (ObjectResponse<ProfileVerificationTypeRequirmentResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ObjectResponse<ProfileVerificationTypeRequirmentResource>>>() {
                        });
        return response.getObject();
    }


    public void updateAbout(AboutResource aboutResource) {
        String uri = getUri(about);
        System.out.println("*****************************Update************************** " + uri);
        boCustomRestTemplate.putObject(uri, aboutResource);
    }

    public AboutResource aboutElm() throws RestBackendException {
        String uri = getUri(about);
        System.out.println("******************************************************* " + uri);
        ObjectResponse<AboutResource> response = (ObjectResponse<AboutResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ObjectResponse<AboutResource>>>() {
                        });
        return response.getObject();
    }


    /***********************************************************
     * cahrts
     *
     * @throws RestBackendException
     **********************************************/
    public List<ChartDataResource> profileDailyChart(String code) {
        String uri = getUri(chart) + "?profileCatagoryCode=" + code;
        ListResponse<ChartDataResource> listResponse = (ListResponse<ChartDataResource>) boCustomRestTemplate.getGenericResponseBody(
                uri, new ParameterizedTypeReference<GenericResponse<ListResponse<ChartDataResource>>>() {
                });
        return listResponse.getList();
    }

    public List<ChartDataResource> profileMonthlyChart(String code) {
        String uri = getUri(chartM) + "?profileCatagoryCode=" + code;
        ListResponse<ChartDataResource> listResponse = (ListResponse<ChartDataResource>) boCustomRestTemplate.getGenericResponseBody(
                uri, new ParameterizedTypeReference<GenericResponse<ListResponse<ChartDataResource>>>() {
                });
        return listResponse.getList();
    }

    public MaxDateResource getMaxDate() throws RestBackendException {
        String uri = getUri(maxDateSub);
        ObjectResponse<MaxDateResource> response = (ObjectResponse<MaxDateResource>) boCustomRestTemplate.getGenericResponseBody(
                uri, new ParameterizedTypeReference<GenericResponse<ObjectResponse<MaxDateResource>>>() {
                });
        return response.getObject();
    }


    public TermsAndConditionsResource termeConditionElm() throws RestBackendException {
        String uri = getUri(terme);
        System.out.println("******************** Terme&Condition *********************** " + uri);
        ObjectResponse<TermsAndConditionsResource> response = (ObjectResponse<TermsAndConditionsResource>) boCustomRestTemplate
                .getGenericResponseBody(uri,
                        new ParameterizedTypeReference<GenericResponse<ObjectResponse<TermsAndConditionsResource>>>() {
                        });
        return response.getObject();
    }

    public void updateTermsAndConditions(TermsAndConditionsResource termsAndConditionsResource) {
        String uri = getUri(terme);
        System.out.println("*****************************Update terms and conditions resource ************************** " + uri);
        boCustomRestTemplate.putObject(uri, termsAndConditionsResource);
    }

    public ProfileResource getUserByID(String id) throws RestBackendException {
        String uri = getUri(getUserById) + "?id=" + id;
        System.out.println("******************** Get User by Id *********************** " + uri);
        ObjectResponse<ProfileResource> response = (ObjectResponse<ProfileResource>) boCustomRestTemplate.getGenericResponseBody(
                uri, new ParameterizedTypeReference<GenericResponse<ObjectResponse<ProfileResource>>>() {
                });
        return response.getObject();
    }

    public List<BankResource> getProfilebanks(GetProfileBanksRessource profileId) throws RestBackendException {
        String uri = getUri(banks);
        System.out.println("******************** Get Profile Banks *********************** " + uri);
        ListResponse<BankResource> response = (ListResponse<BankResource>) boCustomRestTemplate.postObjectGetGenericResponseBody(
                uri, profileId, new ParameterizedTypeReference<GenericResponse<ListResponse<BankResource>>>() {
                });
        return response.getList();
    }


    public List<MerchantResource> getAllMerchants() throws RestBackendException {
        String uri = getUri(merchants);
        System.out.println("******************** Get All Merchants *********************** " + uri);
        ListResponse<MerchantResource> response = (ListResponse<MerchantResource>) boCustomRestTemplate.postObjectGetGenericResponseBody(
                uri, null, new ParameterizedTypeReference<GenericResponse<ListResponse<MerchantResource>>>() {
                });
        return response.getList();
    }


//
//	public List<ElmSettingsResources> getAllSettings() throws RestBackendException {
//		String uri = getUri(settings);
//		ListResponse<ElmSettingsResources> listResponse = (ListResponse<ElmSettingsResources>) boCustomRestTemplate
//				.getGenericResponseBody(uri,
//						new ParameterizedTypeReference<GenericResponse<ListResponse<ElmSettingsResources>>>() {
//						});
//		return listResponse.getList();
//	}
//
//	public Boolean updateSetting(ElmSettingsResources setting) throws RestBackendException {
//		String uri = getUri(settings) + "";
//		BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.putObjectGetGenericResponseBody(uri, setting,
//				new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
//				});
//		return resp.isSuccess();
//	}
//
//    public List<TerminalStatus> getAllTerminals() throws RestBackendException {
//        String uri = getUri(settings) + "/status";
//        ListResponse<TerminalStatus> listResponse = (ListResponse<TerminalStatus>) boCustomRestTemplate
//                .getGenericResponseBody(uri,
//                        new ParameterizedTypeReference<GenericResponse<ListResponse<TerminalStatus>>>() {
//                        });
//        return listResponse.getList();
//    }


    /**********************************
     * Legal Notice
     ******************************************/

//	public List<LegalNoticeResource> getAllLegalNotice() throws RestBackendException {
//		String uri = getUri(legalnotice) + "";
//		ListResponse<LegalNoticeResource> listResponse = (ListResponse<LegalNoticeResource>) boCustomRestTemplate
//				.getGenericResponseBody(uri,
//						new ParameterizedTypeReference<GenericResponse<ListResponse<LegalNoticeResource>>>() {
//						});
//		return listResponse.getList();
//	}
//
//	public Boolean updateLegalNotice(LegalNoticeResource resource) throws RestBackendException {
//		String uri = getUri(this.legalnotice) + "";
//		BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.putObjectGetGenericResponseBody(uri, resource,
//				new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
//				});
//		return resp.isSuccess();
//	}
//
//	public Boolean saveLegalNotice(LegalNoticeResource resource) throws RestBackendException {
//		String uri = getUri(this.legalnotice) + "";
//		BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.postObjectGetGenericResponseBody(uri, resource,
//				new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
//				});
//		return resp.isSuccess();
//	}
//
//	public Boolean deleteLegalNotice(LegalNoticeResource resource) throws RestBackendException {
//		String uri = getUri(this.legalnotice) + "";
//		BooleanResponse resp = (BooleanResponse) boCustomRestTemplate.deleteObjectGetGenericResponseBody(uri, resource,
//				new ParameterizedTypeReference<GenericResponse<BooleanResponse>>() {
//				});
//		return resp.isSuccess();
//	}
    private String getUri(String service) {
        return server + ":" + port + "/" + module + "/" + service;
    }
}