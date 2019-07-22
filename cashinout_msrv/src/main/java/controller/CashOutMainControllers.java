package controller;

import ReqNResp.ResponseModel;
import ReqNResp.response_status;
import mapper.BaseMapper;
import models.CashIn;
import models.CashOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import service.Dao.ICashInService;
import service.Dao.ICashOutService;


@RestController
@RequestMapping(value = "/cashOut")
public class CashOutMainControllers {

    @Autowired
    private ICashOutService cashOutService;


    @GetMapping(value = "/findById")
        public ResponseModel getImpl(@Param("id") String id) throws Exception {
            return new ResponseModel<>(response_status.success, BaseMapper.CashOutToDto(cashOutService.get(id)));
    }

    @DeleteMapping(value = "/delById")
    public ResponseModel deleteImpl(@Param("id") String id) throws Exception {
        cashOutService.delete(id);
            return  new ResponseModel<>(response_status.success,"");
    }

    @PutMapping(value = "/updById")
    public ResponseModel updateImpl(@Param("id") String id,@Param("param") String param,@Param("value") String value ) throws Exception {
        cashOutService.update(id,param,value);
            return  new ResponseModel<>(response_status.success,"");
    }


    @PostMapping(value = "/insert")
    public ResponseModel insertImpl(@Param("device") CashOut cashOut) throws Exception {
        cashOutService.insert(cashOut);
            return  new ResponseModel<>(response_status.success,"");
    }


    @GetMapping(value = "/getAll")
    public ResponseModel getAllImpl() {
            return new ResponseModel<>(response_status.success, BaseMapper.CashOutToDto(cashOutService.getAll()));
    }

    @GetMapping(value = "/perform")
    public ResponseModel perform(@Param("id") String id,@Param("status") String status) throws Exception {
        cashOutService.Perform(id,status);
        return new ResponseModel<>(response_status.success,"");
    }

    @GetMapping(value = "/getNumOfCashOut")
    public ResponseModel getNumOfCashIn() throws Exception {
        return new ResponseModel<>(response_status.success,cashOutService.getNumOfCashOut());
    }

}
