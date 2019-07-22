package service.servviceImp;

import models.JoinRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import repos.interfaces.JoinRqRepo;
import service.Dao.Dao;
import service.Dao.IJoinRqService;

import java.util.List;

@Service
public class JoinRqServiceImp implements IJoinRqService {

    @Autowired
    Dao<JoinRequest> joinRequestDao;

    @Autowired
    JoinRqRepo joinRqRepo;

    @Override
    public JoinRequest get(String id) throws Exception {
        JoinRequest rs = joinRequestDao.get(id);
        if (rs == null)
            throw new Exception("JoinRequest doesn't Exist !");
        return rs;
    }

    @Override
    public List<JoinRequest> m_get(String id) {
        return joinRqRepo.findByComp(id);
    }

    @Override
    public List<JoinRequest> u_get(String id) {
        return joinRqRepo.findByUser(id);
    }

    @Override
    public List<JoinRequest> getByCompId(String id) {
        return joinRqRepo.findByComp(id);
    }

    @Override
    public List<JoinRequest> getAll() {
        return joinRequestDao.getAll();
    }

    @Override
    public void save(  JoinRequest joinRequest) {
        joinRequestDao.save(joinRequest);
    }

    @Override
    public void insert( JoinRequest joinRequest) throws Exception {
        if (joinRequestDao.get(joinRequest.getId()) != null)
            throw new Exception("JoinRequest Already Exist !");
        joinRequestDao.save(joinRequest);
    }

    @Override
    public void delete(String id) throws Exception {
        joinRequestDao.delete(get(id));
    }

    @Override
    public void update(String id, String param,  String Value) throws Exception {
        JoinRequest rs = this.get(id);

        if ("status".equals(param)) {
            rs.setStatus(JoinRequest.resolveEnumFromstring(Value));
            joinRequestDao.save(rs);
        }

    }

}
