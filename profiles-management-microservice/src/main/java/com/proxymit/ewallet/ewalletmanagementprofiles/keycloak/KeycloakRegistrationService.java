package com.proxymit.ewallet.ewalletmanagementprofiles.keycloak;


import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.EmployeeForm;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.MerchantForm;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.Profil;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Service
public class KeycloakRegistrationService {


    @Value("${keycloak-host}")
    private  String serverUrl ;

    public  KeycloakUserCreated  addEmployee(EmployeeForm employeeForm)
    {

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
        user.setUsername(employeeForm.getPhoneNumber());
        user.setEmail(employeeForm.getEmail());

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(employeeForm.getPassword());

        RealmResource realmResource = kc.realm("ewallet");
        UsersResource userResource = realmResource.users();
        Response response = userResource.create(user);

        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
        List<UserRepresentation> userReturned = userResource.search(employeeForm.getPhoneNumber());
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
        return keycloakUserCreated ;
    }

    public  KeycloakUserCreated  addMerchant(MerchantForm merchantForm)
    {
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
        user.setUsername(merchantForm.getPhoneNumber());
        user.setEmail(merchantForm.getEmail());

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(merchantForm.getPassword());

        RealmResource realmResource = kc.realm("ewallet");
        UsersResource userResource = realmResource.users();
        Response response = userResource.create(user);

        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
        List<UserRepresentation> userReturned = userResource.search(merchantForm.getPhoneNumber());
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
        return keycloakUserCreated ;
    }

    public  KeycloakUserCreated  updateEmployee(String id ,EmployeeForm employeeForm)
    {
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

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(employeeForm.getPassword());

        UserResource userResource = kc.realm("ewallet").users().get(id);
        UserRepresentation user = userResource.toRepresentation();

        if (!(employeeForm.getPhoneNumber().equals("")) && ! (employeeForm.getPhoneNumber() == null))
            user.setUsername(employeeForm.getPhoneNumber());
        if (!(employeeForm.getEmail().equals("")) && ! (employeeForm.getEmail() == null))
            user.setEmail(employeeForm.getEmail());

        userResource.update(user);
        if (!(employeeForm.getPassword().equals("")) && ! (employeeForm.getPassword() == null))
            userResource.resetPassword(passwordCred);


        System.out.println(userResource.toRepresentation().toString());
        UserRepresentation userupdated =  userResource.toRepresentation();


        KeycloakUserCreated keycloakUserCreated =  KeycloakUserCreated.builder()
                .id(userupdated.getId())
                .userName(userupdated.getUsername())
                .build();
        return keycloakUserCreated ;
    }


    public  void   deleteEmployee(String id)
    {
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


        UserResource userResource = kc.realm("ewallet").users().get(id);
        userResource.remove();

    }

    public  KeycloakUserCreated  updateMerchant(MerchantForm merchantForm,String idMerchant)
    {
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

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(merchantForm.getPassword());

        UserResource userResource = kc.realm("ewallet").users().get(idMerchant);
        UserRepresentation user = userResource.toRepresentation();
        if (!(merchantForm.getPhoneNumber().equals("")) && ! (merchantForm.getPhoneNumber() == null))
            user.setUsername(merchantForm.getPhoneNumber());
        if (!(merchantForm.getEmail().equals("")) && ! (merchantForm.getEmail() == null))
            user.setEmail(merchantForm.getEmail());

        userResource.update(user);
        if (!(merchantForm.getPassword().equals("")) && ! (merchantForm.getPassword() == null))
            userResource.resetPassword(passwordCred);

        System.out.println(userResource.toRepresentation().toString());
        UserRepresentation userupdated =  userResource.toRepresentation();


        KeycloakUserCreated keycloakUserCreated =  KeycloakUserCreated.builder()
                .id(userupdated.getId())
                .userName(userupdated.getUsername())
                .build();
        return keycloakUserCreated ;
    }


    public  void   deleteMerchant(String id)
    {
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


        UserResource userResource = kc.realm("ewallet").users().get(id);
        userResource.remove();

    }


    public  Profil   getById(String id) {
        Profil p;
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

        UserResource user = kc.realm("ewallet").users().get(id);

        if (user != null){
            p = new Profil();
            p.setId(id);
            return p;
            }
        else
            return  null;

    }

}
