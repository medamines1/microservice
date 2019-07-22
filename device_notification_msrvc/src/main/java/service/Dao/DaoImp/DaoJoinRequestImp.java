package service.Dao.DaoImp;


import models.JoinRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import repos.interfaces.JoinRqRepo;
import service.Dao.Dao;

import java.util.List;

@Transactional
@Repository("JoinRequestImp")
public class DaoJoinRequestImp implements Dao<JoinRequest> {

    @Autowired
    JoinRqRepo joinRqRepo;

    @Override
    public JoinRequest get(String id) { return joinRqRepo.getById(id); }


    @Override
    public List<JoinRequest> u_get(String id) {
        return joinRqRepo.findByUser(id);
    }

    @Override
    public List<JoinRequest> comp_get(String id) {
        return joinRqRepo.findByComp(id);
    }

    @Override
    public List<JoinRequest> m_get(String id) {
        return joinRqRepo.findByUser(id);
    }

    @Override
    public List<JoinRequest> getAll() {
        return joinRqRepo.findAll();
    }

    @Override
    public void save(JoinRequest joinRequest) {
        joinRqRepo.save(joinRequest);
    }


    @Override
    public void delete(JoinRequest joinRequest) {
        joinRqRepo.delete(joinRequest);
    }
}
