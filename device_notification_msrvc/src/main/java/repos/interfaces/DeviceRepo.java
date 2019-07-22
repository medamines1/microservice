package repos.interfaces;

import models.Device;
import models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepo extends MongoRepository<Device, String> {
    List<Device> findDeviceByMerchantid(String id);
    List<Device> findDeviceByUserid(String id);

    Device getById(String id);

    @Query(value = "{ 'companyid' : ?0 }")
    List<Device> findDeviceByCompid(String id);
}
