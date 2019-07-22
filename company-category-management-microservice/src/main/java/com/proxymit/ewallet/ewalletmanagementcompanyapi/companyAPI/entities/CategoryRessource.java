package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRessource {

    private Long id;
    private String name;
    private String balance;
    private String description;
    private Company company;
}
