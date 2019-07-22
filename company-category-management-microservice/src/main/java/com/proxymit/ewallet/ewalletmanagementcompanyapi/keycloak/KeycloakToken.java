package com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class KeycloakToken {
    private String accessToken;
    private String AccessToken_expires_in;
    private String refresh_token;
    private String refresh_token_expires_in;
}
