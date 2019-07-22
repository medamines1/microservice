package feigns;


import ReqNResp.ResponseModel;
import mapper.Profil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("ewallet-management-profil:8000/profile")
public interface ProfileFeign {


    @GetMapping("/getById/{id}")
    ResponseModel<Profil> getEmployee(@PathVariable String id);
}
