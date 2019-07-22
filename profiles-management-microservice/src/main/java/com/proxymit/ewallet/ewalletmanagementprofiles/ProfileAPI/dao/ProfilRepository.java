package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.dao;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfilRepository extends JpaRepository<Profil, String> {

    Profil findByPhoneNumber(String phoneNumber);
}
