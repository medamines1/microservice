package service.Dao;

import models.Device;

import java.util.List;

public interface IDeviceService {

    Device get(String id) throws Exception;

    List<Device> m_get(String id);

    List<Device> u_get(String id);

    List<Device> getAll();

    void save(Device t);

    void insert(Device device) throws Exception;

    void delete(String id) throws Exception;

    void update(String id, String param , String Value) throws Exception;

}
