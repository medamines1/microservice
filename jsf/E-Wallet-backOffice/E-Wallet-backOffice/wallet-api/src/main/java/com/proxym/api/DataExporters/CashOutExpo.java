package com.proxym.api.DataExporters;

import com.proxym.api.models.CashInDto;
import com.proxym.api.models.CashOutDto;
import com.proxym.api.services.cashInService;
import com.proxym.api.services.cashOutService;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "CashOutExpo")
@Data
public class CashOutExpo implements Serializable {

    private CashOutDto[] data;

    @ManagedProperty("#{cashOutService}")
    private cashOutService service;

    @PostConstruct
    public void init()  {
        try {
            data = service.getAllData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CashOutDto[] getData() {
        return data;
    }


}
