package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyFormUpdate {

    private String name;
    private String userName;
    private String password;
    private String email;
}
