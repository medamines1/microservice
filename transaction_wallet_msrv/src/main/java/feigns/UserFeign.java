package feigns;


import ReqNResp.ResponseModel;
import mapper.Profil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient("ewallet-management-profil:8000/employee")
public interface UserFeign  {
    @GetMapping("/employees")
    List<Profil> getEmployees();

    @GetMapping("/getById/{id}")
    ResponseModel<Profil> getEmployeeById(@PathVariable("id") String id);
}
