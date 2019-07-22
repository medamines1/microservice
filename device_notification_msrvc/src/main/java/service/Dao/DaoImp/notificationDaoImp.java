package service.Dao.DaoImp;


import models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repos.interfaces.NotifyRepo;

import service.Dao.Dao;

import java.util.List;

@Repository
public class notificationDaoImp implements Dao<Notification> {

    @Autowired
    NotifyRepo notifyRepo;

    @Override
    public Notification get(String id) { return notifyRepo.getByid(id); }

    @Override
    public List<Notification> m_get(String id) {
        return notifyRepo.findNotifByMerchantid(id);
    }

    @Override
    public List<Notification> u_get(String id) {
        return notifyRepo.findNotifByUserid(id);
    }

    @Override
    public List<Notification> comp_get(String id) {
        return notifyRepo.findNotifByCompid(id);
    }

    @Override
    public List<Notification> getAll() {
        return notifyRepo.findAll();
    }

    @Override
    public void save(Notification device) {
        notifyRepo.save(device);
    }


    @Override
    public void delete(Notification device) {
        notifyRepo.delete(device);
    }
}
