package repos.interfaces;



import models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NotifyRepo extends MongoRepository<Notification, String> {
    List<Notification> findNotifByMerchantid(String id);
    List<Notification> findNotifByUserid(String id);
    Notification getByid(String id);

    @Query(value = "{ 'companyid' : ?0 }")
    List<Notification> findNotifByCompid(String id);


}
