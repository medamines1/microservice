package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeRessource {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String image;
    private String createdOn;
    private ProfilStatus status;
    private String idCategory;
    private String idCompany;

}
