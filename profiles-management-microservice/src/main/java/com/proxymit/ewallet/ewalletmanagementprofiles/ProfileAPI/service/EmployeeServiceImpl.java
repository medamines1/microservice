package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.service;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.*;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.dao.EmployeeRepository;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.mapper.EmployeeMapper;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.mapper.Wallet;
import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.response_status;
import com.proxymit.ewallet.ewalletmanagementprofiles.feigns.WalletFeign;
import com.proxymit.ewallet.ewalletmanagementprofiles.keycloak.KeycloakRegistrationService;
import com.proxymit.ewallet.ewalletmanagementprofiles.keycloak.KeycloakUserCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private  KeycloakRegistrationService keycloakRegistrationService;

    @Autowired
    WalletFeign walletFeign;

    @Override
    public List<EmployeeRessource> getAllEmployees() {

        List<EmployeeRessource> employeeRessources = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            employeeRessources.add(EmployeeMapper.employeeToRessource(employee));
        }
        return employeeRessources;
    }

    @Override
    public EmployeeRessource getEmployee(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent())
            throw new RuntimeException("employee not found");
        return EmployeeMapper.employeeToRessource(employee.get());
    }

    @Override
    public EmployeeRessource getEmployeeByPhoneNumber(String phoneNumber) {
        Employee employee = employeeRepository.findByPhoneNumber(phoneNumber);
        if (employee == null)
            throw new RuntimeException("employee doesn't exist");
        return EmployeeMapper.employeeToRessource(employee);
    }


    @Override
    public EmployeeRessource createEmployee(EmployeeForm employeeForm) throws Exception {
        Employee employeeTest = employeeRepository.findByPhoneNumber(employeeForm.getPhoneNumber());
        if (employeeTest != null)
            throw new RuntimeException("employee already exist");
        Employee employee = EmployeeMapper.employeeFormToEmployee(employeeForm);
        employee.setPassword(bCryptPasswordEncoder.encode(employeeForm.getPassword()));
        employee.setCreatedOn(LocalDateTime.now());
        KeycloakUserCreated keyUserCreated = keycloakRegistrationService.addEmployee(employeeForm);
        employee.setId(keyUserCreated.getId());
        employeeRepository.save(employee);
        System.out.println(employee.getCreatedOn());


        ResponseModel rs = walletFeign.createWallet(employee.getId());
        if (rs.getStatus().equals(response_status.fail))
            throw  new Exception("fail to create wallet due to " + rs.getErr());



        return EmployeeMapper.employeeToRessource(employee);
    }

    @Override
    public EmployeeRessource updateEmployee(String id, String param,String value) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent())
            throw new RuntimeException("employee doesn't exist");

        System.out.println(employee.get()  + " fff "+ param+ " fff "+ value);
        switch (param) {
            case "phoneNumber": employee.get().setPhoneNumber(value); break;
            case "password": employee.get().setPassword(value); break;
            case "email": employee.get().setEmail(value); break;
            case "image": employee.get().setImage(value); break;
            case "firstName": employee.get().setFirstName(value); break;
            case "lastName": employee.get().setLastName(value); break;
            case "idCompany": employee.get().setIdCompany(value); break;
            case "idCategory": employee.get().setIdCategory(value);  break;

        }

        System.out.println(employee.get().getId() + "d " + employee.get().getIdCompany());
        keycloakRegistrationService.updateEmployee(id,EmployeeMapper.employeeToForm(employee.get()));
        employeeRepository.save(employee.get());


        System.out.println(employee.get().getId() + "d2 " + employee.get().getIdCompany());
        return EmployeeMapper.employeeToRessource(employee.get());
    }

    @Override
    public EmployeeRessource deleteEmployee(String id) throws Exception {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent())
            throw new RuntimeException("employee doesn't exist");
        keycloakRegistrationService.deleteEmployee(id);
        employeeRepository.delete(employee.get());


        ResponseModel rs = walletFeign.deleteWallet(id);
        if (rs.getStatus().equals(response_status.fail))
            throw  new Exception("fail to delete wallet due to " + rs.getErr());


        return EmployeeMapper.employeeToRessource(employee.get());


    }

    @Override
    public EmployeeRessource switchStatusOfEmployee(String id, String profilStatus) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (!existingEmployee.isPresent())
            throw new RuntimeException("employee doesn't exist");
        profilStatus.toUpperCase();
        if (profilStatus.equals(" "))
            throw new RuntimeException("status doesn't exist");
        existingEmployee.get().setStatus(ProfilStatus.valueOf(profilStatus));
        employeeRepository.saveAndFlush(existingEmployee.get());
        return EmployeeMapper.employeeToRessource(existingEmployee.get());
    }

    @Override
    public EmployeeRessource affectEmploeeToCategory(String idEmployee,String idCategory) {
        Optional<Employee> existingEmployee = employeeRepository.findById(idEmployee);
        if (!existingEmployee.isPresent())
            throw new RuntimeException("employee doesn't exist");
        existingEmployee.get().setIdCategory(idCategory);
        employeeRepository.saveAndFlush(existingEmployee.get());
        return EmployeeMapper.employeeToRessource(existingEmployee.get());
    }

    @Override
    public List<EmployeeRessource> getAllEmployeeBelongToCategory(String idCategory) {

        List<Employee> employees = employeeRepository.findByIdCategory(idCategory);
        if (employees.isEmpty())
            throw new RuntimeException("there is no employee belongs to this category");
        List<EmployeeRessource> employeeRessources = new ArrayList<>();
        for (Employee employee : employees)
        {
            employeeRessources.add(EmployeeMapper.employeeToRessource(employee));
        }
        return employeeRessources;
    }

    @Override
    public List<EmployeeRessource> getAllEmployeeBelongToCompany(List<Long> idsOfCategories) {
        List<Employee> employees = employeeRepository.getByIdCategoryIn(idsOfCategories);
        List<EmployeeRessource> employeeRessources = new ArrayList<>();
        for (Employee employee : employees)
        {
            employeeRessources.add(EmployeeMapper.employeeToRessource(employee));
        }
        return employeeRessources;
    }

    public Employee findByphoneNumber(String ph){
        return employeeRepository.findByphoneNumber(ph);
    }



}
