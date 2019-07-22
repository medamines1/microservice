package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.dao;


import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MerchantRepository extends JpaRepository<Merchant, String> {

    Merchant findByPhoneNumber(String phoneNumber);
}
