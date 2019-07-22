package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.mapper;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class Wallet {

    private  String id ;

    private String profileId;


    private String merchantid;


    private BigDecimal balance;


    private String expires ;
}
