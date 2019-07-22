package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.controller;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.MerchantForm;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.MerchantRessource;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.service.MerchantService;
import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.response_status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant")
@Api(value = "E_Wallet", description = "Operations pertaining to manage merchants")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @ApiOperation(value = "create a new merchant")
    @PostMapping("/registerMerchant")
    public ResponseModel createMerchant(@RequestBody MerchantForm merchantForm) throws Exception {
        return new ResponseModel<>(response_status.success,merchantService.createMerchant(merchantForm));
    }

    @ApiOperation(value = "retrieve all merchants")
    @GetMapping("/merchants")
    public ResponseModel getAllMerchants() {
        return new ResponseModel<>(response_status.success,merchantService.getAllMerchant());
    }

    @ApiOperation(value = "retrieve one  merchant")
    @GetMapping("/merchant/{id}")
    public ResponseModel getMerchant(@PathVariable String id) {
        return new ResponseModel<>(response_status.success,merchantService.getMerchant(id));
    }

    @ApiOperation(value = "retrieve all supervisees pertaining to a specific merchant")
    @GetMapping("/merchant/getsupervisees/{idSupervisor}")
    public ResponseModel getAllSuperviseesOfMerchant(@PathVariable String idSupervisor) {
        return new ResponseModel<>(response_status.success,merchantService.getAllSuperviseesOfMerchant(idSupervisor));
    }

    @ApiOperation(value = "retrieve the supervisor of a specific merchant")
    @GetMapping("/merchant/getsupervisor/{idSupervisee}")
    public ResponseModel getSupervisorOfMerchant(@PathVariable String idSupervisee) {
        return new ResponseModel<>(response_status.success,merchantService.getSupervisorOfMerchant(idSupervisee));
    }

    @ApiOperation(value = "update a specific merchant")
    @PutMapping("/merchant/{id}")
    public ResponseModel updateMerchant(@PathVariable String id, @RequestBody MerchantForm merchantForm) {
        return new ResponseModel<>(response_status.success,merchantService.updateMerchant(id, merchantForm));
    }

    @ApiOperation(value = "delete a specific merchant")
    @DeleteMapping("/merchant/{id}")
    public ResponseModel deleteMerchant(@PathVariable String id) throws Exception {
        return new ResponseModel<>(response_status.success,merchantService.deleteMerchant(id));
    }

    @ApiOperation(value = "switch the status of a specific merchant")
    @PutMapping("/merchant/switchStatusMerchant/{id}")
    public ResponseModel switchStatus(@PathVariable String id, @RequestParam String status) {
        return new ResponseModel<>(response_status.success,merchantService.switchStatusOfMerchant(id, status));
    }

    @ApiOperation(value = "affect an supervisse to a specific merchant")
    @PutMapping("/merchant/affect/{idSupervisee}/to/{idSupervisor}")
    public ResponseModel affectSuperviseeToSupervisor(@PathVariable String idSupervisee, @PathVariable String idSupervisor) {
        return new ResponseModel<>(response_status.success,merchantService.affectSuperviseeToSupervisor(idSupervisee, idSupervisor));
    }

    @ApiOperation(value = "remove an supervisse from a specific merchant")
    @PutMapping("/merchant/remove/{idSupervisee}/from/{idSupervisor}")
    public ResponseModel removeSuperviseeFromSupervisor(@PathVariable String idSupervisee, @PathVariable String idSupervisor) {
        return new ResponseModel<>(response_status.success,merchantService.removeSuperviseeFromSupervisor(idSupervisee, idSupervisor));
    }
}
