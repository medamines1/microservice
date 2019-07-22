package feign;

import models.Profil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="ewallet-management-profil",url="ewallet-management-profil:8000")
public interface FProfile {

    @GetMapping("/employees")
    List<Profil> getEmployees();

    @GetMapping("/employee/employee/{id}")
    Profil getEmployeeById(@PathVariable("id") String id);

}
