package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.service;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.dao.CompanyRepository;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.*;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.mapper.CategoryMapper;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.mapper.CompanyMapper;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak.KeycloakRegistrationService;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak.KeycloakUserCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository ;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private KeycloakRegistrationService keycloakRegistrationService;

    @Override
    public List<CompanyRessource> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyRessource> companyRessources = new ArrayList<>();
        for(Company company : companies){
            companyRessources.add(CompanyMapper.companyToRessource(company));
        }
        return companyRessources;
    }

    @Override
    public CompanyRessource getCompany(String id) {
        Optional<Company> company = companyRepository.findById(id);
        if (!company.isPresent())
            throw new RuntimeException("company not found");
        return CompanyMapper.companyToRessource(company.get());
    }

    @Override
    public CompanyRessource getCompanyByUserName(String userName) {
        Company company = companyRepository.findByUserName(userName);
        if (company == null)
            throw new RuntimeException("company doesn't exist");
        return CompanyMapper.companyToRessource(company);
    }

    @Override
    public CompanyRessource createCompany(CompanyForm companyForm) throws Exception {
        Company companyTest = companyRepository.findByUserName(companyForm.getUserName());
        if (companyTest != null)
            throw new RuntimeException("company already exist");
        Company company = CompanyMapper.companyFormToCompany(companyForm);
        company.setPassword(bCryptPasswordEncoder.encode(companyForm.getPassword()));
        company.setCreatedOn(LocalDateTime.now());
        KeycloakUserCreated keyUserCreated = keycloakRegistrationService.addCompany(companyForm);
        company.setId(keyUserCreated.getId());
        company.setBalance((double) 0);
        companyRepository.save(company);
        System.out.println(company.getCreatedOn());
        return CompanyMapper.companyToRessource(company);
    }

    @Override
    public CompanyRessource updateCompany(String id, CompanyFormUpdate companyFormUpdate) {
        Optional<Company> existingCompany = companyRepository.findById(id);
        if (!existingCompany.isPresent())
            throw new RuntimeException("company doesn't exist");
        if (!(companyFormUpdate.getName().equals("")) && !(companyFormUpdate.getName() == null))
            existingCompany.get().setName(companyFormUpdate.getName());
        if (!(companyFormUpdate.getUserName().equals("")) && !(companyFormUpdate.getUserName() == null))
            existingCompany.get().setUserName(companyFormUpdate.getUserName());
        if (!(companyFormUpdate.getPassword().equals("")) && ! (companyFormUpdate.getPassword() == null))
            existingCompany.get().setPassword(bCryptPasswordEncoder.encode(companyFormUpdate.getPassword()));
        if (!(companyFormUpdate.getEmail().equals("")) && !(companyFormUpdate.getEmail() == null))
            existingCompany.get().setEmail(companyFormUpdate.getEmail());


        keycloakRegistrationService.updateCompany(id,companyFormUpdate);
        companyRepository.saveAndFlush(existingCompany.get());
        return CompanyMapper.companyToRessource(existingCompany.get());
    }


    @Override
    public CompanyRessource deleteCompany(String id) throws Exception {
        Optional<Company> company = companyRepository.findById(id);
        if (!company.isPresent())
            throw new RuntimeException("company doesn't exist");
        keycloakRegistrationService.deleteCompany(id);
        companyRepository.delete(company.get());
        return CompanyMapper.companyToRessource(company.get());
    }

    @Override
    public List<CategoryRessource> getAllCategoryBelongToCompany(String idCompany) {
        Optional<Company> existingCompany = companyRepository.findById(idCompany);
        if (!existingCompany.isPresent())
            throw new RuntimeException("company doesn't exist");
        List<CategoryUser> categories = existingCompany.get().getCategories();
        List<CategoryRessource> categoriesRessources = new ArrayList<>();
        for (CategoryUser category : categories)
        {
            categoriesRessources.add(CategoryMapper.categoryToRessource(category));
        }
        return categoriesRessources;
    }

    @Override
    public List<Long> getAllIdsofCategories(String idCompany) {
        Optional<Company> company = companyRepository.findById(idCompany);
        if (!company.isPresent())
            throw new RuntimeException("company doesn't exist");
        List<Long> ids = new ArrayList<>();
        for (CategoryUser categoryUser : company.get().getCategories() )
        {
            ids.add(categoryUser.getId());
        }
        return ids;
    }

    @Override
    public CompanyRessource addAmount(String id, Double amount) {
        Optional<Company> company = companyRepository.findById(id);
        if (!company.isPresent())
            throw new RuntimeException("company doesn't exist");
        Double oldAmount = company.get().getBalance();
        Double newAmount = oldAmount += amount;
        company.get().setBalance(newAmount);
        companyRepository.saveAndFlush(company.get());
        return CompanyMapper.companyToRessource(company.get());
    }
}
