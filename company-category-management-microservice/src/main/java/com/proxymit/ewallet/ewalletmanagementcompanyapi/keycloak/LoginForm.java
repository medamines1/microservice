package com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {

    private String userName;
    private String password;
}
