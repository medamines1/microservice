package models;


import lombok.Data;

import java.math.BigDecimal;


@Data
public class WalletDto {

    private  String id ;

    private String profileId;


    private BigDecimal balance;


    private String expires ;
}
