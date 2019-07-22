package service.Dao;


import models.Notification;
import java.util.List;


public interface INotificationService {

    Notification get(String id) throws Exception;

    List<Notification> m_get(String id);

    List<Notification> u_get(String id);

    List<Notification> getAll();

    void save(Notification t);

    void insert(Notification notification,String topic) throws Exception;

    void delete(String id) throws Exception;

    void update(String id, String param, String Value) throws Exception;


    List<Notification> getByUseridOrMerchantid(String id);

    List<Notification> getByCompid(String id);

}
