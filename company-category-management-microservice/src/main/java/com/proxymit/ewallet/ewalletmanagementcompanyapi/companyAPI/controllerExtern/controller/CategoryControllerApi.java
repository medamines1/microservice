package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.controllerExtern.controller;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.response_status;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.controllerExtern.controller.Utils.userUtils;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/categoryApi")
public class CategoryControllerApi {

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

    @PostMapping("/addCategory/")
    public ResponseModel createCategory(@RequestHeader Map<String, String> headers, @RequestBody CategoryForm categoryForm) {
        String auth = userUtils.getId( headers.get("authorization").split(" ")[1]);
        return new ResponseModel<>(response_status.success, categoryService.createCategory(auth, categoryForm));
    }

    @PutMapping("/updateCategory/{idCategory}")
    public ResponseModel updateCategory(@PathVariable Long idCategory, @RequestParam String name) {
        return new ResponseModel<>(response_status.success, categoryService.updateCategory(idCategory, name));
    }

    @DeleteMapping("/category/{id}")
    public ResponseModel deleteCategory(@PathVariable Long id) {
        return new ResponseModel<>(response_status.success, categoryService.deleteCategory(id));
    }


}
