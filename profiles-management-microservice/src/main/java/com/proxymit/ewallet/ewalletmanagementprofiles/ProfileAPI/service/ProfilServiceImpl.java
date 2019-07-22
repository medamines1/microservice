package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.service;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.Profil;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.dao.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfilServiceImpl implements ProfilService {

    @Autowired
    private ProfilRepository profilRepository;

    @Override
    public Profil getProfilByPhoneNumber(String phoneNumber) {
        Profil profil = profilRepository.findByPhoneNumber(phoneNumber);
        if (profil == null)
            throw new RuntimeException("profil doesn't exist");
        return profil;
    }

    @Override
    public Profil getProfilByid(String id) {
        return null;
    }
}
