package feigns;


import ReqNResp.ResponseModel;
import mapper.Profil;
import models.Notification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("device-notification-microservice-service:8085/notification")
public interface NotifFeign {

    @PostMapping("/insert")
    ResponseModel<Notification> insert(@RequestParam ("topic")   String topic, @Param("notification") Notification w);
}
