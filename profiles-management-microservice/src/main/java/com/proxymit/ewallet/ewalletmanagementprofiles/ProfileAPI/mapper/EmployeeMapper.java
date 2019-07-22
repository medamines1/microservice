package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.mapper;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.*;

public class EmployeeMapper {


    public static EmployeeRessource employeeToRessource(Employee employee) {
        return EmployeeRessource.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .phoneNumber(employee.getPhoneNumber())
                .email(employee.getEmail())
                .image(employee.getImage())
                .status(employee.getStatus())
                .createdOn(employee.getCreatedOn().toLocalDate().toString())
                .idCategory(employee.getIdCategory())
                .idCompany(employee.getIdCompany())
                .build();

    }
//    public static EmployeeRessourceFeign employeeToRessourceFeign(Employee employee) {
//        return EmployeeRessourceFeign.builder()
//                .id(employee.getId())
//                .firstName(employee.getFirstName())
//                .lastName(employee.getLastName())
//                .phoneNumber(employee.getPhoneNumber())
//                .password(employee.getPassword())
//                .email(employee.getEmail())
//                .image(employee.getImage())
//                .status(employee.getStatus())
//                .createdOn(employee.getCreatedOn().toLocalDate())
//                .idCategory(employee.getIdCategory())
//                .build();
//
//    }


    public static  Employee employeeFormToEmployee( EmployeeForm employeeForm) {
        return Employee.builder()
                .firstName(employeeForm.getFirstName())
                .lastName(employeeForm.getLastName())
                .phoneNumber(employeeForm.getPhoneNumber())
                .email(employeeForm.getEmail())
                .image(employeeForm.getImage())
                .status(ProfilStatus.ACTIVATED)
                .idCompany(employeeForm.getIdCompany())
                .idCategory(employeeForm.getIdCategory())
                .build();
    }

    public static EmployeeForm employeeToForm(Employee employee) {
        return EmployeeForm.builder()

                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .phoneNumber(employee.getPhoneNumber())
                .password(employee.getPassword())
                .email(employee.getEmail())
                .image(employee.getImage())
                .idCompany(employee.getIdCompany())
                .build();

    }


}
