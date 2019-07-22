package controller;

import ReqNResp.ResponseModel;
import ReqNResp.response_status;
import lombok.extern.slf4j.Slf4j;
import mapper.BaseMapper;
import models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.Dao.IDeviceService;

import javax.servlet.http.HttpServletRequest;


@RestController
@Slf4j
@RequestMapping("/device")
public class DevicesMainControllers {

    @Autowired
    private IDeviceService deviceService;


    private RestTemplate restTemplate;


    @GetMapping(value = "/findById")
        public ResponseModel getImpl(@RequestParam("id") String id, HttpServletRequest request) throws Exception {
            return new ResponseModel<>(response_status.success, BaseMapper.DevicetToDto(deviceService.get(id)));
    }

    @DeleteMapping(value = "/delById")
    public ResponseModel deleteImpl(@RequestParam("id") String id) throws Exception {
                deviceService.delete(id);
            return  new ResponseModel<>(response_status.success,"");
    }

    @PutMapping(value = "/updById")
    public ResponseModel updateImpl(@RequestParam("id") String id,@Param("param") String param,@RequestParam("value") String value ) throws Exception {
        deviceService.update(id,param,value);
            return  new ResponseModel<>(response_status.success,"");
    }


    @PostMapping(value = "/insert")
    public ResponseModel insertImpl(@RequestParam("device") Device device) throws Exception {
        deviceService.insert(device);
            return  new ResponseModel<>(response_status.success,"");
    }


    @GetMapping(value = "/getAll")
    public ResponseModel getAllImpl() {
            return new ResponseModel<>(response_status.success, BaseMapper.DevicetToDto(deviceService.getAll()));
    }

}
