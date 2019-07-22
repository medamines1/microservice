package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.mapper;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.Company;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyRessource;

public class CompanyMapper {

    public static CompanyRessource companyToRessource(Company company)
    {
        return CompanyRessource.builder()
                .id(company.getId())
                .name(company.getName())
                .userName(company.getUserName())
                .createdOn(company.getCreatedOn().toLocalDate().toString())
                .email(company.getEmail())
                .balance(company.getBalance())
                .build();
    }

    public static Company companyFormToCompany(CompanyForm companyForm)
    {
        return Company.builder()
                .name(companyForm.getName())
                .userName(companyForm.getUserName())
                .password(companyForm.getPassword())
                .build();
    }
}
