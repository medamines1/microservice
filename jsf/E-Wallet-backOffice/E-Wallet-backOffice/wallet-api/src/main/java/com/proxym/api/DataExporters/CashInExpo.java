package com.proxym.api.DataExporters;

import com.proxym.api.models.CashInDto;
import com.proxym.api.services.cashInService;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "CashInExpo")
@Data
public class CashInExpo implements Serializable {

    private CashInDto[] data;

    @ManagedProperty("#{cashINService}")
    private cashInService service;

    @PostConstruct
    public void init()  {
        try {
            data = service.getAllData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CashInDto[] getData() {
        return data;
    }


}
