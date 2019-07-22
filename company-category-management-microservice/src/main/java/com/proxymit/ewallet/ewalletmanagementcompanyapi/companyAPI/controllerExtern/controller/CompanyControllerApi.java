package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.controllerExtern.controller;


import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.response_status;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyFormUpdate;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.service.CompanyService;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak.KeycloackTokensService;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.controllerExtern.controller.Utils.userUtils;

@RestController
@RequestMapping("/companyApi/")
public class CompanyControllerApi {

    @Autowired
    private CompanyService companyService;



    @Autowired
    private KeycloackTokensService keycloackTokensService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/companies")
    public ResponseModel getAllCompanies() {
        return new ResponseModel<>(response_status.success,  companyService.getAllCompanies());
    }

    @GetMapping("/getAllCategories")
    public ResponseModel getAllCategoryBelongToCompany(@RequestHeader Map<String, String> headers) throws Exception {
        // Extracting sender id from jwt
        String auth = userUtils.getId( headers.get("authorization").split(" ")[1]);
        return new ResponseModel<>(response_status.success, companyService.getAllCategoryBelongToCompany(auth));

    }
    @CrossOrigin
    @PostMapping("/addCompany")
    public ResponseModel createCompany( @RequestBody CompanyForm companyForm) throws Exception {
        return new ResponseModel<>(response_status.success, companyService.createCompany(companyForm));
    }

    @PutMapping("/company/")
    public ResponseModel updateCompany(@RequestHeader Map<String, String> headers,@RequestBody CompanyFormUpdate companyFormUpdate) {

        String id = userUtils.getId( headers.get("authorization").split(" ")[1]);
        return new ResponseModel<>(response_status.success, companyService.updateCompany(id, companyFormUpdate));
    }

    @DeleteMapping("/company/")
    public ResponseModel deleteCompany (@RequestHeader Map<String, String> headers) throws Exception {
        String id = userUtils.getId( headers.get("authorization").split(" ")[1]);
        return new ResponseModel<>(response_status.success,  companyService.deleteCompany(id));
    }

    @PutMapping("/company/add/{amount}")
    public ResponseModel updateBalance(@RequestHeader Map<String, String> headers, @PathVariable Double amount) {
        String id = userUtils.getId( headers.get("authorization").split(" ")[1]);
        return new ResponseModel<>(response_status.success, companyService.addAmount(id, amount));
    }

}
