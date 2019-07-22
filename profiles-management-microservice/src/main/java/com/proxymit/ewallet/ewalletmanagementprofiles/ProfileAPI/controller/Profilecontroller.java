package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.controller;

import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.response_status;
import com.proxymit.ewallet.ewalletmanagementprofiles.keycloak.KeycloakRegistrationService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
public class Profilecontroller {

    @Autowired
    private KeycloakRegistrationService keycloakRegistrationService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "retrieve one  profile")
    @GetMapping("/getById/{id}")
    public ResponseModel getEmployee(@PathVariable String id) {
        return new ResponseModel<>(response_status.success,keycloakRegistrationService.getById(id));
    }

}
