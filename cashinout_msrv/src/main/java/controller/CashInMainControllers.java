package controller;

import ReqNResp.ResponseModel;
import ReqNResp.response_status;
import mapper.BaseMapper;
import models.CashIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import service.Dao.ICashInService;


@RestController
@RequestMapping(value = "/cashIn")
public class CashInMainControllers {

    @Autowired
    private ICashInService cashInService;


    @GetMapping(value = "/cashIn/findById")
        public ResponseModel getImpl(@Param("id") String id) throws Exception {
            return new ResponseModel<>(response_status.success, BaseMapper.CAshIntToDto(cashInService.get(id)));
    }

    @DeleteMapping(value = "/delById")
    public ResponseModel deleteImpl(@Param("id") String id) throws Exception {
        cashInService.delete(id);
            return  new ResponseModel<>(response_status.success,"");
    }

    @PutMapping(value = "/updById")
    public ResponseModel updateImpl(@Param("id") String id,@Param("param") String param,@Param("value") String value ) throws Exception {
        cashInService.update(id,param,value);
            return  new ResponseModel<>(response_status.success,"");
    }


    @PostMapping(value = "/insert")
    public ResponseModel insertImpl(@Param("device") CashIn cashIn) throws Exception {
        System.out.println(cashIn);
        try {
            cashInService.insert(cashIn);
        }catch (Exception e){

            System.out.println(cashIn);
        }

            return  new ResponseModel<>(response_status.success,"");
    }


    @GetMapping(value = "/getAll")
    public ResponseModel getAllImpl() {
            return new ResponseModel<>(response_status.success, BaseMapper.CAshIntToDto(cashInService.getAll()));
    }


    @GetMapping(value = "/perform")
    public ResponseModel perform(@Param("id") String id,@Param("status") String status) throws Exception {
            cashInService.Perform(id,status);
        return new ResponseModel<>(response_status.success,"");
    }

    @GetMapping(value = "/getNumOfCashIn")
    public ResponseModel getNumOfCashIn() throws Exception {
        return new ResponseModel<>(response_status.success,cashInService.getNumOfCashIn());
    }

}
