package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.controller;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.response_status;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/categories")
    public ResponseModel getAllCategories()
    {
        return new ResponseModel<>(response_status.success, categoryService.getAllCategories());
    }


    @GetMapping("/category/{id}")
    public ResponseModel getCategory(@PathVariable Long id) {
        return new ResponseModel<>(response_status.success, categoryService.getCategory(id));

    }

    @PostMapping("/addCategory/{idCompany}")
    public ResponseModel createCategory(@PathVariable String idCompany, @RequestBody CategoryForm categoryForm) {
        return new ResponseModel<>(response_status.success, categoryService.createCategory(idCompany, categoryForm));
    }

    @PutMapping("/updateCategory/{idCategory}")
    public ResponseModel updateCategory(@PathVariable Long idCategory, @RequestParam String name) {
        return new ResponseModel<>(response_status.success, categoryService.updateCategory(idCategory, name));
    }

    @PutMapping("/updateCategoryBycategForm/{idCategory}")
    public ResponseModel updateCategoryBycategForm(@PathVariable Long idCategory, @RequestBody CategoryForm ca) {
        categoryService.updateCategory(idCategory, ca);
        return new ResponseModel<>(response_status.success, null);
    }
    @DeleteMapping("/category/{id}")
    public ResponseModel deleteCategory(@PathVariable Long id) {
        return new ResponseModel<>(response_status.success, categoryService.deleteCategory(id));
    }


}
