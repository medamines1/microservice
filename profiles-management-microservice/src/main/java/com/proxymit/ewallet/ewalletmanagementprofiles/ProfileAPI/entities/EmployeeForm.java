package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeForm {

    private String phoneNumber;
    private String email;
    private String password;
    private String image;
    private String firstName;
    private String lastName;
    private String idCompany;
    private String idCategory;

}

