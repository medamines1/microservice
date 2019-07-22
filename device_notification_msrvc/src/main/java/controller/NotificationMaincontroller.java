package controller;

import ReqNResp.ResponseModel;
import ReqNResp.response_status;
import com.mongodb.lang.Nullable;
import lombok.extern.slf4j.Slf4j;
import mapper.BaseMapper;

import models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import service.servviceImp.NotificationServiceImp;

import java.util.List;
import java.util.Map;


@RestController
@Slf4j
@RequestMapping("/notification")
public class NotificationMaincontroller {

    @Autowired
    private NotificationServiceImp notificationServiceImp;


    @GetMapping(value = "/findById")
    public ResponseModel getImpl(@RequestParam("id") String id) throws Exception {
            return  new ResponseModel<>(response_status.success, BaseMapper.NotiftToDto(notificationServiceImp.get(id)));

    }

    @GetMapping(value = "/delById")
    public ResponseModel deleteImpl(@RequestParam("id") String id) throws Exception {
                notificationServiceImp.delete(id);
            return  new ResponseModel<>(response_status.success,"");
    }

    @PutMapping(value = "/updById")
    public ResponseModel updateImpl(@RequestParam("id") String id, @RequestParam("param") String param, @RequestParam("value") String value ) throws Exception {
            notificationServiceImp.update(id,param,value);
            return  new ResponseModel<>(response_status.success,"");
    }


    @PostMapping(value = "/insert")
    public ResponseModel insertImpl(@RequestParam ("topic")   String topic, @Param ("notification") Notification w) throws Exception {
        log.error(w+ "\n" + topic);
        notificationServiceImp.insert(w,  topic);
            return  new ResponseModel<>(response_status.success,w);
    }

    @GetMapping(value = "/getAllById")
    public ResponseModel getAllImplById(@RequestHeader Map<String, String> headers) {
        String auth = Utils.userUtils.getId( headers.get("authorization").split(" ")[1]);

        List<Notification> li =  notificationServiceImp.getByUseridOrMerchantid(auth);
            log.error(li.toString());

            return new ResponseModel<>(response_status.success, BaseMapper.NotiftToDto(li));
    }


    @GetMapping(value = "/getAllByCompId")
    public ResponseModel getAllImplByCompId(@RequestHeader Map<String, String> headers) {
        String auth = Utils.userUtils.getId( headers.get("authorization").split(" ")[1]);
        List<Notification> li =  notificationServiceImp.getByCompid(auth);
        return new ResponseModel<>(response_status.success, BaseMapper.NotiftToDto(li));
    }
}
