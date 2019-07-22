package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryForm {

    private String name;
    private String balance;
    private String description;
}
