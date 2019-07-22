package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import models.Notification;
import org.springframework.web.bind.annotation.*;
import service.FcmClient;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@Slf4j
public class RegistryController {

    private final FcmClient fcmClient;

    public RegistryController(FcmClient fcmClient) {
        this.fcmClient = fcmClient;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> register(@RequestBody Mono<String> token, HttpServletRequest request) {
        log.info(token + " was received");
        return token.doOnNext(t -> this.fcmClient.subscribe(request.getHeader("user_id"), t)).then();
    }


    @PostMapping("/send")
    public void register(@RequestBody Notification notification,String topic,String background_body , String title ) throws ExecutionException, InterruptedException {
        ObjectMapper oMapper = new ObjectMapper();

        @SuppressWarnings("unchecked")
        Map<String,String> data = oMapper.convertValue(notification, HashMap.class);
        data.remove("seen");
        data.put("seen",notification.getSeen().toString());
        fcmClient.send(data,topic,background_body,title);
    }
}
