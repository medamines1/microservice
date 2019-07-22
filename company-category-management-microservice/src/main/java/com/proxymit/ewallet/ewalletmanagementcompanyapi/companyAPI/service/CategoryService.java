package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.service;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryRessource;

import java.util.List;

public interface CategoryService {

    List<CategoryRessource> getAllCategories();

    CategoryRessource getCategory(Long id);

    CategoryRessource createCategory(String idCompany, CategoryForm categoryForm);

    CategoryRessource updateCategory(Long id, String name);

    void updateCategory(Long id, CategoryForm ca);

    CategoryRessource deleteCategory(Long id);
}
