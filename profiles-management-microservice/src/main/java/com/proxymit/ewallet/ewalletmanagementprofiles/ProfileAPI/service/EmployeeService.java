package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.service;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.EmployeeForm;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.EmployeeRessource;

import java.util.List;

public interface EmployeeService {

    List<EmployeeRessource> getAllEmployees();

    EmployeeRessource getEmployee(String id);

    EmployeeRessource getEmployeeByPhoneNumber(String phoneNumber);

    EmployeeRessource createEmployee(EmployeeForm employeeForm) throws Exception;

    EmployeeRessource updateEmployee(String id, String param,String value);

    EmployeeRessource deleteEmployee(String id) throws Exception;

    EmployeeRessource switchStatusOfEmployee(String id, String profilStatus);

    EmployeeRessource affectEmploeeToCategory(String idEmployee,String idCategory);

    List<EmployeeRessource> getAllEmployeeBelongToCategory(String idCategory);

    List<EmployeeRessource> getAllEmployeeBelongToCompany( List<Long> idsOfCategories);



}
