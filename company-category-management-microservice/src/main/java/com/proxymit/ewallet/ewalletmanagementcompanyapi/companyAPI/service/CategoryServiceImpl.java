package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.service;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.dao.CategoryRepository;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.dao.CompanyRepository;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryRessource;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryUser;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.Company;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<CategoryRessource> getAllCategories() {
        List<CategoryUser> categoriesUsers = categoryRepository.findAll();
        List<CategoryRessource> categoriesRessources = new ArrayList<>();
        for (CategoryUser categoryUser : categoriesUsers) {
            categoriesRessources.add(CategoryMapper.categoryToRessource(categoryUser));
        }
        return categoriesRessources;
    }

    @Override
    public CategoryRessource getCategory(Long id) {
        Optional<CategoryUser> categoryUser = categoryRepository.findById(id);
        if (!categoryUser.isPresent())
            throw new RuntimeException("category not found");
        return CategoryMapper.categoryToRessource(categoryUser.get());
    }

    @Override
    public CategoryRessource createCategory(String idCompany, CategoryForm categoryForm) {

        Optional<Company> company = companyRepository.findById(idCompany);
        if (!company.isPresent())
            throw new RuntimeException("company not found");
        List<CategoryUser> categoriesUsers = company.get().getCategories();
        for (CategoryUser categoryUser : categoriesUsers) {
            if (categoryUser.getName().equals(categoryForm.getName()))
                throw new RuntimeException("category already  exist");
        }
        CategoryUser categoryUser = CategoryMapper.categoryFormToCategory(categoryForm);
        company.get().getCategories().add(categoryUser);
        categoryUser.setCompany(company.get());
        categoryRepository.saveAndFlush(categoryUser);
        companyRepository.saveAndFlush(company.get());
        return CategoryMapper.categoryToRessource(categoryUser);
    }

    @Override
    public CategoryRessource updateCategory(Long id, String name) {
        Optional<CategoryUser> existingCategory = categoryRepository.findById(id);
        if (!existingCategory.isPresent())
            throw new RuntimeException("category doesn't exist");
        List<CategoryUser> categoriesUsers = existingCategory.get().getCompany().getCategories();
        for (CategoryUser categoryUser : categoriesUsers) {
            if (categoryUser.getName().equals(name))
                throw new RuntimeException("category already exist");
        }
        if (!(name.equals("")) && !(name == null))
            existingCategory.get().setName(name);
        categoryRepository.saveAndFlush(existingCategory.get());
        return CategoryMapper.categoryToRessource(existingCategory.get());
    }

    @Override
    public void updateCategory(Long id, CategoryForm ca) {
        Optional<CategoryUser> categoryUser = categoryRepository.findById(id);
        if (categoryUser.isPresent() ) {
            categoryUser.get().setName(ca.getName());
            categoryUser.get().setBalance(ca.getBalance());
            categoryUser.get().setDescription(ca.getDescription());
            categoryRepository.saveAndFlush(categoryUser.get());
        }
    }

    @Override
    public CategoryRessource deleteCategory(Long id) {
        Optional<CategoryUser> categoryUser = categoryRepository.findById(id);
        if (!categoryUser.isPresent())
            throw new RuntimeException("category doesn't exist");
        categoryRepository.delete(categoryUser.get());
        return CategoryMapper.categoryToRessource(categoryUser.get());
    }




}
