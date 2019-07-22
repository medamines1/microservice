package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.mapper;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryUser;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryRessource;

public class CategoryMapper {

    public static CategoryRessource categoryToRessource(CategoryUser categoryUser)
    {
        return CategoryRessource.builder()
               .id(categoryUser.getId())
                .name(categoryUser.getName())
                .balance(categoryUser.getBalance())
                .description(categoryUser.getDescription())
               .company(categoryUser.getCompany())
                .build();
    }

    public static CategoryUser categoryFormToCategory(CategoryForm categoryForm)
    {
        return CategoryUser.builder()
                .name(categoryForm.getName())
                .balance(categoryForm.getBalance())
                .description(categoryForm.getDescription())
                .build();
    }
}
