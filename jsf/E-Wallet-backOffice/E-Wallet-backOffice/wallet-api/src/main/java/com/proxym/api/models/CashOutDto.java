package com.proxym.api.models;


import com.proxym.api.models.enums.Status_cash;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;


@Data
@ToString
public class CashOutDto {

    private  String id;

    private  String merchant_id;

    private BigDecimal amount;

    private Status_cash status;

    private String created_on ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
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
