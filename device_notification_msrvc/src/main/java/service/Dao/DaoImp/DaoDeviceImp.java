package service.Dao.DaoImp;

import models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repos.interfaces.DeviceRepo;
import service.Dao.Dao;

import java.util.List;
@Transactional
@Repository("DeviceImp")
public class DaoDeviceImp  implements Dao<Device> {

    @Autowired
    DeviceRepo deviceRepo;

    @Override
    public Device get(String id) { return deviceRepo.getById(id); }


    @Override
    public List<Device> u_get(String id) {
        return deviceRepo.findDeviceByUserid(id);
    }

    @Override
    public List<Device> comp_get(String id) {
        return deviceRepo.findDeviceByCompid(id);
    }

    @Override
    public List<Device> m_get(String id) {
        return deviceRepo.findDeviceByMerchantid(id);
    }

    @Override
    public List<Device> getAll() {
        return deviceRepo.findAll();
    }

    @Override
    public void save(Device device) {
        deviceRepo.save(device);
    }


    @Override
    public void delete(Device device) {
        deviceRepo.delete(device);
    }
}
