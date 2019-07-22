package models;


import lombok.Data;
import models.enums.Status_cash;


import java.math.BigDecimal;



@Data
public class CashInDto {


    private  String id ;

    private  String comp_id;

    private BigDecimal amount;

    private Status_cash status ;

    private String created_on;
}
