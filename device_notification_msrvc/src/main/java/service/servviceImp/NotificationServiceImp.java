package service.servviceImp;


import lombok.extern.slf4j.Slf4j;
import models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import repos.interfaces.NotifyRepo;
import service.Dao.Dao;
import service.Dao.INotificationService;
import service.FcmClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class NotificationServiceImp implements INotificationService {

    @Autowired
    Dao<Notification> notificationDao;

    private FcmClient fcmClient;

    @Autowired
    public NotificationServiceImp(FcmClient fcmClient) {
        this.fcmClient = fcmClient;
    }

    @Override
    public Notification get(String id) throws Exception {
        Notification rs =  notificationDao.get(id);
        if (rs ==null)
            throw  new Exception("Notification doesn't Exist !");
        return  rs;
    }

    @Override
    public List<Notification> m_get(String id) {
       return notificationDao.m_get(id);
    }

    @Override
    public List<Notification> u_get(String id) {
        return notificationDao.u_get(id);
    }

    @Override
    public List<Notification> getAll() {
        return notificationDao.getAll();
    }

    @Override
    public void save(Notification notification) {
        notificationDao.save(notification);
    }

    @Override
    public void insert(Notification notification,String topic) throws Exception {

        notification.setSeen(Boolean.FALSE);
        notificationDao.save(notification);

        Map<String, String> data = new HashMap<>();
        data.put("id", notification.getId());
        data.put("body",  notification.getBody());
        data.put("companyId",notification.getCompanyid());
        data.put("UserId",notification.getUserid());
        data.put("MerchantId",notification.getMerchantid());
        data.put("title", notification.getTitle());
        data.put("seen",notification.getSeen().toString());
        data.put("created_on",notification.getCreated_on());
        data.put("joke", "this is a joke  " + notification.getBody());
        data.put("seq", String.valueOf(notification.getId() + ":" + notification.getCompanyid()));
        data.put("ts", String.valueOf(System.currentTimeMillis()));

        log.info(data.toString());

       // fcmClient.send( data, topic,notification.getBody(),notification.getTitle());
    }

    @Override
    public void delete(String id) throws Exception {
        notificationDao.delete(get(id));
    }

    @Override
    public void update(String id, String param , String Value) throws Exception {
        Notification rs = this.get(id);

        switch (param) {
            case "title": rs.setTitle(Value); break;
            case "body": rs.setBody(Value); break;
            case "seen": rs.setSeen(Boolean.valueOf(Value)); break;
        }
        notificationDao.save(rs);

    }

    @Override
    public List<Notification> getByUseridOrMerchantid(String id) {
        List<Notification> rs = notificationDao.u_get(id);
        if (rs == null)
            rs = notificationDao.m_get(id);
        return  rs;
    }



    @Override
    public List<Notification> getByCompid(String id) {
        List<Notification> rs = notificationDao.comp_get(id);
        return  rs;
    }

}
