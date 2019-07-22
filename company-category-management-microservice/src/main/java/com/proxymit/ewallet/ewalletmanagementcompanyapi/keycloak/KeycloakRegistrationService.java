package com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak;


import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.response_status;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyFormUpdate;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.feign.WalletFeign;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
@Service
@Slf4j
public class KeycloakRegistrationService {

    @Value("${keycloak-host}")
    private  String serverUrl ;

    @Autowired
    WalletFeign walletFeign;

    public  KeycloakUserCreated  addCompany(CompanyForm companyForm) throws Exception {

        log.info("--------------- keycloak host is : "+ serverUrl);
        Keycloak kc = KeycloakBuilder.builder()
                .serverUrl(serverUrl + "/auth")
                .realm("master")
                .username("admin")
                .password("password")
                .clientId("admin-cli")
                .resteasyClient(
                        new ResteasyClientBuilder()
                                .connectionPoolSize(10).build()
                ).build();

        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername(companyForm.getUserName());
        user.setEmail(companyForm.getEmail());
        //user.setEmail(employeeForm.getEmail());

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(companyForm.getPassword());

        RealmResource realmResource = kc.realm("ewallet");
        UsersResource userResource = realmResource.users();
        Response response = userResource.create(user);
        log.info("saving user *************---- : " +companyForm);

        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
        log.info("saving user *************---- : " +userId);
        List<UserRepresentation> userReturned = userResource.search(companyForm.getUserName());
        userResource.get(userId).resetPassword(passwordCred);

        RoleRepresentation role = realmResource.roles()//
                .get("USER").toRepresentation();

        userResource.get(userId).roles().realmLevel() //
                .add(Arrays.asList(role));

        UserRepresentation userCreated =  userResource.get(userId).toRepresentation();
        System.out.println(userCreated.toString());

        KeycloakUserCreated keycloakUserCreated =  KeycloakUserCreated.builder()
                .id(userCreated.getId())
                .userName(userCreated.getUsername())
                .email(userCreated.getEmail())
                .build();

        ResponseModel rs = walletFeign.createWallet(userId);
        if (rs.getStatus().equals(response_status.fail))
            throw  new Exception("fail to create wallet due to " + rs.getErr());


        return keycloakUserCreated ;
    }

    public  KeycloakUserCreated  updateCompany(String id , CompanyFormUpdate companyFormUpdate)
    {
        Keycloak kc = KeycloakBuilder.builder()
                .serverUrl(serverUrl + "/auth/")
                .realm("master")
                .username("admin")
                .password("password")
                .clientId("admin-cli")
                .resteasyClient(
                        new ResteasyClientBuilder()
                                .connectionPoolSize(10).build()
                ).build();

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(companyFormUpdate.getPassword());

        UserResource userResource = kc.realm("ewallet").users().get(id);
        UserRepresentation user = userResource.toRepresentation();
        if (!(companyFormUpdate.getUserName() == null) && ! companyFormUpdate.getUserName().equals("") ) {
            user.setUsername(companyFormUpdate.getUserName());
            user.setEmail(companyFormUpdate.getEmail());
            userResource.update(user);
        }
        if (!((companyFormUpdate.getPassword() == null) && !(companyFormUpdate.getPassword().equals(""))))
            userResource.resetPassword(passwordCred);
        System.out.println(userResource.toRepresentation().toString());
        UserRepresentation userupdated =  userResource.toRepresentation();


        KeycloakUserCreated keycloakUserCreated =  KeycloakUserCreated.builder()
                .id(userupdated.getId())
                .userName(userupdated.getUsername())
                .userName(userupdated.getEmail())
                .build();
        return keycloakUserCreated ;
    }


    public  void   deleteCompany(String id) throws Exception {
        Keycloak kc = KeycloakBuilder.builder()
                .serverUrl(serverUrl + "/auth/")
                .realm("master")
                .username("admin")
                .password("password")
                .clientId("admin-cli")
                .resteasyClient(
                        new ResteasyClientBuilder()
                                .connectionPoolSize(10).build()
                ).build();

            ResponseModel rs = walletFeign.deleteWallet(id);
            if (rs.getStatus().equals(response_status.fail))
                throw  new Exception("fail to delete wallet due to " + rs.getErr());


        UserResource userResource = kc.realm("ewallet").users().get(id);
        userResource.remove();

    }

}
