package com.proxym.api.services;

import com.proxym.api.ReqNResp.ResponseModel;
import com.proxym.api.ReqNResp.response_status;
import com.proxym.api.controller.LoginController;
import com.proxym.api.models.CashInDto;
import com.proxym.api.models.CashOutDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;



@Service
public class cashOutService implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    private CashOutDto[] data;


    RestTemplate restTemplate = new RestTemplate();


    public CashOutDto[] getAllData() throws IOException {


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);


        ResponseModel<CashOutDto[]> data =  restTemplate.exchange("http://127.0.0.1:9092/cashOut/getAll", HttpMethod.GET, entity,
                 new ParameterizedTypeReference<ResponseModel<CashOutDto[]>>() {}).getBody();

        System.out.print(data);

        return data.getResult();
    }

    public response_status perform(CashOutDto cashOutDto,String status){


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://127.0.0.1:9092/cashOut/perform")
                .queryParam("id", cashOutDto.getId())
                .queryParam("status", status);


        ResponseModel data =  restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                new ParameterizedTypeReference<ResponseModel>() {}).getBody();

        return data.getStatus();
    }

    public String getNumOfCashOut() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://127.0.0.1:9092/cashOut/getNumOfCashOut");


        ResponseModel data =  restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                new ParameterizedTypeReference<ResponseModel>() {}).getBody();
        if (data.getStatus().equals(response_status.success))
            return data.getResult().toString();
        else
            return "Fail";

    }
}
