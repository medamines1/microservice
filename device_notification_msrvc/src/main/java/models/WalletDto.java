package models;


import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;


@Data
public class WalletDto {

    private  String id ;

    private String userid;


    private String merchantid;



    private BigDecimal balance;


    private String expires ;
}
