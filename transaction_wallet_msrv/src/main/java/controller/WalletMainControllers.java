package controller;

import ReqNResp.ResponseModel;
import ReqNResp.response_status;
import lombok.extern.slf4j.Slf4j;
import mapper.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import repo.WalletRepo;
import service.IWalletService;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/wallet",produces = MediaType.APPLICATION_JSON_VALUE)
public class WalletMainControllers {

    @Autowired
    private IWalletService walletService;


    @GetMapping(value = "/findById/{id}")
    public ResponseModel getImpl(@PathVariable("id") String id) throws Exception {
        return new ResponseModel<>(response_status.success, BaseMapper.WalletToDto(walletService.get(id)));
    }

    @GetMapping(value = "/findByProfileId/{id}")
    public ResponseModel getByprofileId(@PathVariable("id") String id) throws Exception {
        return new ResponseModel<>(response_status.success, BaseMapper.WalletToDto(walletService.getByUserId(id)));
    }

    @DeleteMapping(value = "/delById/{id}")
    public ResponseModel deleteImpl(@PathVariable("id") String id) throws Exception {
        walletService.delete(id);
        return  new ResponseModel<>(response_status.success,"");
    }

    @DeleteMapping(value = "/deleteByUserId/{id}")
    public ResponseModel deleteByUserId(@PathVariable("id") String id) throws Exception {
        walletService.deleteByid(id);
        return  new ResponseModel<>(response_status.success,"");
    }


    @PutMapping(value = "/updById/{id}/{param}/{value}")
    public ResponseModel updateImpl(@PathVariable("id") String id,@PathVariable("param") String param,@PathVariable("value") String value ) throws Exception {
        walletService.update(id,param,value);
        return  new ResponseModel<>(response_status.success,"");
    }


    @PostMapping(value = "/insert/{id}")
    public ResponseModel insertImpl(@PathVariable("id") String id) throws Exception {
        walletService.insert(id);
        return  new ResponseModel<>(response_status.success,"");
    }


//    @GetMapping(value = "/getAll")
//    public ResponseModel getAllImpl(@RequestHeader Map<String, String> headers)  {
//        String auth = headers.get("authorization").split(" ")[1];
//         return new ResponseModel<>(response_status.success, BaseMapper.WalletToDto(walletService.getAll()));
//    }


    @GetMapping(value = "/getAll")
    public ResponseModel getAllImpl()  {
        return new ResponseModel<>(response_status.success, BaseMapper.WalletToDto(walletService.getAll()));
    }

}
