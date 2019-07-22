package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.dao;

import com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities.CategoryUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryUser,Long> {


}
