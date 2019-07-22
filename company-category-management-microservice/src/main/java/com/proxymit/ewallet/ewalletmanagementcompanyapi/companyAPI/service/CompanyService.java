package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.service;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryRessource;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyFormUpdate;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyRessource;

import java.util.List;

public interface CompanyService {

    List<CompanyRessource> getAllCompanies();

    CompanyRessource getCompany(String id);

    CompanyRessource getCompanyByUserName(String userName);

    CompanyRessource createCompany(CompanyForm companyForm) throws Exception;

    CompanyRessource updateCompany(String id, CompanyFormUpdate companyFormUpdate);

    CompanyRessource deleteCompany(String id) throws Exception;

    List<CategoryRessource> getAllCategoryBelongToCompany(String idCompany);

    List<Long> getAllIdsofCategories(String idCompany);

    CompanyRessource addAmount(String id, Double amount);

}
