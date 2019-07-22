package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyRessource {

    private String id;
    private String name;
    private String userName;
    private String createdOn;
    private String email;
    private Double balance;
    //private List<CategoryUser> categories;
}
