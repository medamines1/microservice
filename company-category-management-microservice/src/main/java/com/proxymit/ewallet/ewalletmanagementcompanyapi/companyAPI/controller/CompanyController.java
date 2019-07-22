package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.controller;


import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CompanyForm;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.response_status;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.*;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.service.CompanyService;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak.KeycloackTokensService;
import com.proxymit.ewallet.ewalletmanagementcompanyapi.keycloak.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private Environment environment;


    @Autowired
    private KeycloackTokensService keycloackTokensService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping("/loginCompany")
    public ResponseModel loginEmployee(@RequestBody LoginForm loginForm) {

        return new ResponseModel<>(response_status.success, keycloackTokensService.getToken(loginForm.getUserName(), loginForm.getPassword()));
    }

    @CrossOrigin
    @GetMapping("/categoriesIds/{idCompany}")
    public ExchangeValues getAllIdsofCategories(@PathVariable String idCompany)
    {
        List<Long> ids =  companyService.getAllIdsofCategories(idCompany);
        ExchangeValues exchangeValue =  ExchangeValues.builder()
                .ids(ids)
                .port(Integer.parseInt(environment.getProperty("local.server.port"))).build();

        logger.info("{}", exchangeValue);
        return exchangeValue;

    }

    @GetMapping("/companies")
    public ResponseModel getAllCompanies() {
        return new ResponseModel<>(response_status.success,  companyService.getAllCompanies());
    }


    @GetMapping("/company/{id}")
    public ResponseModel getCompany(@PathVariable String id) {
        return new ResponseModel<>(response_status.success, companyService.getCompany(id));

    }
    @GetMapping("/getAllCategories/{idComapny}")
    public ResponseModel getAllCategoryBelongToCompany(@PathVariable String idComapny){
        return new ResponseModel<>(response_status.success, companyService.getAllCategoryBelongToCompany(idComapny));

    }
    @CrossOrigin
    @PostMapping("/addCompany")
    public ResponseModel createCompany( @RequestBody CompanyForm companyForm) throws Exception {
        return new ResponseModel<>(response_status.success, companyService.createCompany(companyForm));
    }

    @PutMapping("/company/{id}")
    public ResponseModel updateCompany(@PathVariable String id, @RequestBody CompanyFormUpdate companyFormUpdate) {
        return new ResponseModel<>(response_status.success, companyService.updateCompany(id, companyFormUpdate));
    }

    @DeleteMapping("/company/{id}")
    public ResponseModel deleteCompany (@PathVariable String id) throws Exception {
        return new ResponseModel<>(response_status.success,  companyService.deleteCompany(id));
    }

    @PutMapping("/company/{id}/add/{amount}")
    public ResponseModel updateBalance(@PathVariable String id, @PathVariable Double amount) {
        return new ResponseModel<>(response_status.success, companyService.addAmount(id, amount));
    }

}
