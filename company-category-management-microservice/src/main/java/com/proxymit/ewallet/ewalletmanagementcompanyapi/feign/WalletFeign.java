package com.proxymit.ewallet.ewalletmanagementcompanyapi.feign;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.ReqNResp.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("transaction-wallet-microservice-service:8083/wallet")
public interface WalletFeign {
    @PostMapping("/insert/{id}")
    ResponseModel createWallet(@PathVariable("id") String id);

    @DeleteMapping("/deleteByUserId/{id}")
    ResponseModel deleteWallet(@PathVariable("id") String id);

}
