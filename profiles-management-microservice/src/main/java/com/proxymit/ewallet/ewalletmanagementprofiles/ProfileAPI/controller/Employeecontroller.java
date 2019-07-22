package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.controller;

import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.communication.EmployeeServiceProxy;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.communication.ExchangeValues;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities.EmployeeForm;
import com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.service.EmployeeService;
import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.ResponseModel;
import com.proxymit.ewallet.ewalletmanagementprofiles.ReqNResp.response_status;
import com.proxymit.ewallet.ewalletmanagementprofiles.keycloak.KeycloackTokensService;
import com.proxymit.ewallet.ewalletmanagementprofiles.keycloak.LoginForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("employee")
@Api(value = "E_Wallet", description = "Operations pertaining to manage employees")
public class Employeecontroller {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeServiceProxy proxy;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private KeycloackTokensService keycloackTokensService;


    @PostMapping("/loginEmployee")
    public ResponseModel loginEmployee(@RequestBody LoginForm loginForm) {
        return new ResponseModel<>(response_status.success, keycloackTokensService.getToken(loginForm.getPhoneNumber(), loginForm.getPassword()));

    }


    @GetMapping("/allEmployeesOfCompany/{idCompany}")
    public ResponseModel getAllEmployeeBelongToCompany(@PathVariable String idCompany)
    {
        ExchangeValues response = proxy.getAllIdsofCategories(idCompany);
        logger.info("{}", response.getPort());
        return new ResponseModel<>(response_status.success,employeeService.getAllEmployeeBelongToCompany(response.getIds()));
    }

    @PutMapping("/affect/employee/{idEmployee}/toCategory/{idCategory}")
    public ResponseModel affectEmploeeToCategory(@PathVariable String idEmployee, @PathVariable String idCategory) {
        return new ResponseModel<>(response_status.success, employeeService.affectEmploeeToCategory(idEmployee,idCategory));
    }

    @GetMapping("/allEmployees/{idCategory}")
    public ResponseModel getAllEmployeeBelongToCategory(@PathVariable String idCategory)
    {
        return new ResponseModel<>(response_status.success, employeeService.getAllEmployeeBelongToCategory(idCategory));
    }

    @ApiOperation(value = "create new employee")
    @PostMapping("/registerEmployee")
    public ResponseModel createEmployee(@RequestBody EmployeeForm employeeForm) throws Exception {
        return new ResponseModel<>(response_status.success,employeeService.createEmployee(employeeForm));
    }

    @ApiOperation(value = "retrieve all employees")
    @GetMapping("/employees")
    public ResponseModel getAllEmployees() {
        return new ResponseModel<>(response_status.success,employeeService.getAllEmployees());
    }

    @ApiOperation(value = "retrieve one  employee")
    @GetMapping("/getById/{id}")
    public ResponseModel getEmployee(@PathVariable String id) {
        return new ResponseModel<>(response_status.success,employeeService.getEmployee(id));
    }

    @ApiOperation(value = "update an employee")
    @PutMapping("/update")
    public ResponseModel updateEmployee(@RequestHeader Map<String, String> headers, @RequestParam("param") String param , @RequestParam("value") String value) {
        String id = Utils.userUtils.getId( headers.get("authorization").split(" ")[1]);
        return new ResponseModel<>(response_status.success,employeeService.updateEmployee(id, param,value));
    }

    @ApiOperation(value = "delete an employee")
    @DeleteMapping("/delete/{id}")
    public ResponseModel deleteEmployee(@PathVariable String id) throws Exception {
        return new ResponseModel<>(response_status.success,employeeService.deleteEmployee(id));
    }

    @ApiOperation(value = "switch the status of an employee")
    @PutMapping("/employee/switchStatusEmployee/{id}")
    public ResponseModel switchStatus(@PathVariable String id, @RequestParam String status) {
        return new ResponseModel<>(response_status.success,employeeService.switchStatusOfEmployee(id, status));
    }

    @GetMapping("/employee/byphone/{phone}")
    public ResponseModel getByphone(@PathVariable("phone") String ph){
        return new ResponseModel<>(response_status.success,employeeService.getEmployeeByPhoneNumber(ph));

    }

//    @PutMapping("/employee/switchStatusEmployee/{id}")
//    public Employee switchStatus(@PathVariable String id,@RequestBody HashMap<String, String> profilStatus)
//    {
//       return ProfileAPI.switchStatusOfEmployee(id,profilStatus);
//    }

}
