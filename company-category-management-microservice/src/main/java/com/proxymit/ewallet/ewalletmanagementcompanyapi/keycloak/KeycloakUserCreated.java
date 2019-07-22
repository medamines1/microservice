package com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KeycloakUserCreated {

    private String id ;
    private String userName;
    private String email;
}
