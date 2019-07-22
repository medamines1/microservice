package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities;

import lombok.*;

import java.time.LocalDate;


@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantRessource {


    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String image;
    private String tradeRegister;
    private String rib;
    private ProfilStatus status;
    private LocalDate createdOn;
    private Merchant supervisor;
}
