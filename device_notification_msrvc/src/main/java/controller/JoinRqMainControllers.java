package controller;

import ReqNResp.ResponseModel;
import ReqNResp.response_status;
import lombok.extern.slf4j.Slf4j;
import mapper.BaseMapper;
import models.Device;
import models.JoinRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.Dao.IDeviceService;
import service.Dao.IJoinRqService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
@Slf4j
@RequestMapping("/joinrq")
public class JoinRqMainControllers {

    @Autowired
    private IJoinRqService iJoinRqService;


    private RestTemplate restTemplate;


    @GetMapping(value = "/findById/{id}")
        public ResponseModel findById(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
            log.info(request.getHeader("user_id"));
            return new ResponseModel<>(response_status.success, iJoinRqService.get(id));
    }

    @GetMapping(value = "/findByCompId/")
    public ResponseModel findByCompId(@RequestHeader Map<String, String> headers)  {
        String id = Utils.userUtils.getId( headers.get("authorization").split(" ")[1]);
        return new ResponseModel<>(response_status.success, iJoinRqService.getByCompId(id));
    }

    @GetMapping(value = "/findByUserId")
    public ResponseModel findByUserId(@RequestHeader Map<String, String> headers)  {
        // Extracting sender id from jwt
        String id = Utils.userUtils.getId( headers.get("authorization").split(" ")[1]);
        log.info("user id is : " + id);
        return new ResponseModel<>(response_status.success, iJoinRqService.u_get(id));
    }


    @DeleteMapping(value = "/delById")
    public ResponseModel deleteImpl(@Param("id") String id) throws Exception {
        iJoinRqService.delete(id);
            return  new ResponseModel<>(response_status.success,"");
    }

    @PutMapping(value = "/updByUserId/{id}/{param}/{value}")
    public ResponseModel updateImpl(@PathVariable("id") String id,@PathVariable("param") String param,@PathVariable("value") String value ) throws Exception {
        System.out.println(id+ param + value);
        iJoinRqService.update(id,param,value);
            return  new ResponseModel<>(response_status.success,"");
    }


    @PostMapping(value = "/insert")
    public ResponseModel insertImpl(@RequestHeader Map<String, String> headers,@RequestBody String userid) throws Exception {
        // Extracting sender id from jwt
        String auth = Utils.userUtils.getId( headers.get("authorization").split(" ")[1]);
        JoinRequest joinRequest = new JoinRequest();

        if (userid == null )
            throw  new Exception("User is null ");

        //Fix this Later
        userid = userid.replace("userid=","");

        joinRequest.setUser(userid);
        joinRequest.setComp(auth);
        //you add control whether request already exist
        // insert to DB
        iJoinRqService.insert(joinRequest);

            return  new ResponseModel<>(response_status.success,userid + " was added.");
    }


    @GetMapping(value = "/getAll")
    public ResponseModel getAllImpl() {
            return new ResponseModel<>(response_status.success, iJoinRqService.getAll());
    }

}
