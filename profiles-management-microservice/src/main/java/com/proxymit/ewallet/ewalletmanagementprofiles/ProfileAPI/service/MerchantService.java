package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.service;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.MerchantForm;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.MerchantRessource;

import java.util.List;

public interface MerchantService {

    List<MerchantRessource> getAllMerchant();

    MerchantRessource getMerchant(String id);

    MerchantRessource getMerchantByPhoneNumber(String phoneNumber);

    MerchantRessource createMerchant(MerchantForm merchantForm) throws Exception;

    MerchantRessource updateMerchant(String id, MerchantForm merchantForm);

    MerchantRessource deleteMerchant(String id) throws Exception;

    MerchantRessource switchStatusOfMerchant(String id, String profilStatus);

    MerchantRessource affectSuperviseeToSupervisor(String idSupervisee, String idSupervisor);

    MerchantRessource removeSuperviseeFromSupervisor(String idSupervisee, String idSupervisor);

    List<MerchantRessource> getAllSuperviseesOfMerchant(String idSupervisor);

    MerchantRessource getSupervisorOfMerchant(String idSupervisee);

}
