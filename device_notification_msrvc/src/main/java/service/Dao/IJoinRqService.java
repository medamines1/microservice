package service.Dao;


import models.JoinRequest;

import java.util.List;

public interface IJoinRqService {

    JoinRequest get(String id) throws Exception;

    List<JoinRequest> m_get(String id);

    List<JoinRequest> u_get(String id);

    List<JoinRequest> getByCompId(String id);

    List<JoinRequest> getAll();

    void save(JoinRequest joinRequest);

    void insert(JoinRequest joinRequest) throws Exception;

    void delete(String id) throws Exception;

    void update(String id, String param, String Value) throws Exception;

}
