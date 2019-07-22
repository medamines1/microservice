package com.proxym.api.models;

import com.proxym.api.models.enums.Status_cash;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CashInDto {


    private  String id ;

    private  String comp_id;

    private BigDecimal amount;

    private Status_cash status;

    private String created_on;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComp_id() {
        return comp_id;
    }

    public void setComp_id(String comp_id) {
        this.comp_id = comp_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public Status_cash getStatus() {
        return status;
    }

    public void setStatus(Status_cash status) {
        this.status = status;
    }
}
