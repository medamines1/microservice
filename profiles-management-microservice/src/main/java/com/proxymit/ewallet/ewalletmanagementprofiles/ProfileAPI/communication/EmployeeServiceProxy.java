package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.communication;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.EmployeeRessource;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name="ewallet-management-comapny", url="localhost:8100")
//@FeignClient(name="ewallet-management-comapny")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="ewallet-management-comapny")
public interface EmployeeServiceProxy {

    //@GetMapping("/categoriesIds/{idCompany}")
    @GetMapping("/ewallet-management-comapny/categoriesIds/{idCompany}")
    ExchangeValues getAllIdsofCategories(@PathVariable String idCompany);
}