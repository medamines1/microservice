package models;


import lombok.Data;
import lombok.ToString;
import models.enums.Status_cash;

import java.math.BigDecimal;


@Data
@ToString
public class CashOutDto {

    private  String id;

    private  String merchant_id;

    private BigDecimal amount;

    private Status_cash status ;

    private String created_on ;
}
