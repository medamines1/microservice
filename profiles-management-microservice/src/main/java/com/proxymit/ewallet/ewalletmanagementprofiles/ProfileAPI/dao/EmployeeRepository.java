package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.dao;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findByPhoneNumber(String phoneNumber);
    List<Employee> findByIdCategory(String id);
    Employee findByphoneNumber(String phoneNumber);

    List<Employee> getByIdCategoryIn(List<Long> ids);


}
