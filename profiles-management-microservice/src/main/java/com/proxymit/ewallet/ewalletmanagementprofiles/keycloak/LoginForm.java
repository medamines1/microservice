package com.proxymit.ewallet.ewalletmanagementprofiles.keycloak;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {

    private String phoneNumber;
    private String password;
}
