package com.proxym.api.services;

import com.proxym.api.ReqNResp.ResponseModel;
import com.proxym.api.ReqNResp.response_status;
import com.proxym.api.controller.LoginController;
import com.proxym.api.models.CashInDto;
import com.proxym.api.models.CashOutDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.primefaces.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;


@Service
public class cashInService implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    private CashInDto[] data;


    RestTemplate restTemplate = new RestTemplate();


    public CashInDto[] getAllData() throws IOException {




        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        ResponseModel<CashInDto[]> data =  restTemplate.exchange("http://127.0.0.1:9092/cashIn/getAll", HttpMethod.GET, entity,
                 new ParameterizedTypeReference<ResponseModel<CashInDto[]>>() {}).getBody();

        System.out.print(data);

        return data.getResult();
    }


    public response_status perform(CashInDto cashInDto,String status){
        restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://127.0.0.1:9092/cashIn/perform")
                .queryParam("id", cashInDto.getId())
                .queryParam("status", status);


        ResponseModel data =  restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                new ParameterizedTypeReference<ResponseModel>() {}).getBody();

        return data.getStatus();
    }

    public String getNumOfCashIn() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://127.0.0.1:9092/cashIn/getNumOfCashIn");


        ResponseModel data =  restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
                new ParameterizedTypeReference<ResponseModel>() {}).getBody();
        if (data.getStatus().equals(response_status.success))
            return data.getResult().toString();
        else
            return "Fail";

    }
}

