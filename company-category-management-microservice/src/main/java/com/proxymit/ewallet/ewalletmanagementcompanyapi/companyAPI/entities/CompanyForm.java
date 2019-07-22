package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyForm {

    private String name;
    private String userName;
    private String password;
    private String email;
//    private Double balance;
}
