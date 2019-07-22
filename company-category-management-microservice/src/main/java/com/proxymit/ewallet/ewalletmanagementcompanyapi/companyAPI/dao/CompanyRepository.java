package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.dao;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company,String> {

    @Query("select c from  company c where c.userName like ?1 ")
    Company findByUserName(String userName);

}
