package controller;

import ReqNResp.ResponseModel;
import ReqNResp.response_status;

import mapper.BaseMapper;

import models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import service.Dao.ITransactionService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/transaction")
public class TransactionMainControllers {

    @Autowired
    private ITransactionService iTransactionService;

    @GetMapping(value = "/findById")
        public ResponseModel getImpl(@Param("id") String id) throws Exception {
            return new ResponseModel<>(response_status.success, BaseMapper.DevicetToDto(iTransactionService.get(id)));
    }

    @DeleteMapping(value = "/delById")
    public ResponseModel deleteImpl(@Param("id") String id) throws Exception {
        iTransactionService.delete(id);
            return  new ResponseModel<>(response_status.success,"");
    }

    @PutMapping(value = "/updById")
    public ResponseModel updateImpl(@Param("id") String id,@Param("param") String param,@Param("value") String value ) throws Exception {
        iTransactionService.update(id,param,value);
            return  new ResponseModel<>(response_status.success,"");
    }


    @PostMapping(value = "/insert")
    public ResponseModel insertImpl(@Param("Transacion") Transaction transaction, HttpServletRequest request) throws Exception {

        iTransactionService.insert(transaction);
            return  new ResponseModel<>(response_status.success,"");
    }


    @GetMapping(value = "/getAll")
    public ResponseModel getAllImpl() {
            return new ResponseModel<>(response_status.success, BaseMapper.DevicetToDto(iTransactionService.getAll()));
    }

}
