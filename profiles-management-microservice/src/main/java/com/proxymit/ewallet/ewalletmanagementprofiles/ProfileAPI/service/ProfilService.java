package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.service;


import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.Profil;

public interface ProfilService {

    Profil getProfilByPhoneNumber(String phoneNumber);

    Profil getProfilByid(String id);
}
