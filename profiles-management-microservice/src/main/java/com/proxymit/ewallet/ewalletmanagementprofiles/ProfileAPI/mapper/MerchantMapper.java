package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.mapper;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.Merchant;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.MerchantForm;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.MerchantRessource;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.ProfilStatus;

public class MerchantMapper {


    public static MerchantRessource merchantoRessource(Merchant merchant) {
        return MerchantRessource.builder()
                .id(merchant.getId())
                .name(merchant.getName())
                .phoneNumber(merchant.getPhoneNumber())
                .email(merchant.getEmail())
                .image(merchant.getImage())
                .tradeRegister(merchant.getTradeRegister())
                .rib(merchant.getRib())
                .status(merchant.getStatus())
                .createdOn(merchant.getCreatedOn().toLocalDate())
                .supervisor(merchant.getSupervisor())
                .build();

    }


    public static Merchant merchantFormToMerchant(MerchantForm merchantForm) {
        return Merchant.builder()
                .name(merchantForm.getName())
                .phoneNumber(merchantForm.getPhoneNumber())
                .password(merchantForm.getPassword())
                .email(merchantForm.getEmail())
                .image(merchantForm.getImage())
                .status(ProfilStatus.ACTIVATED)
                .tradeRegister(merchantForm.getTradeRegister())
                .rib(merchantForm.getRib())
                .supervisor(null)
                .build();

    }


}

