package service.servviceImp;

import models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.Dao.Dao;
import service.Dao.IDeviceService;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DeviceServiceImp implements IDeviceService {

    @Autowired
    Dao<Device> daoDevice;

    @Override
    public Device get(String id) throws Exception {
        Device rs =  daoDevice.get(id);
        if (rs ==null)
            throw  new Exception("device doesn't Exist !");
        return  rs;
    }

    @Override
    public List<Device> m_get(String id) {
        return daoDevice.m_get(id);
    }

    @Override
    public List<Device> u_get(String id) {
        return daoDevice.u_get(id);
    }

    @Override
    public List<Device> getAll() {
        return daoDevice.getAll();
    }

    @Override
    public void save(Device device) {
        daoDevice.save(device);
    }

    @Override
    public void insert(Device device) throws Exception {
        if (daoDevice.get(device.getId()) !=null )
            throw  new Exception("device Already Exist !");
        daoDevice.save(device);
    }

    @Override
    public void delete(String id) throws Exception {
        daoDevice.delete(get(id));
    }

    @Override
    public void update(String id, String param , String Value) throws Exception {
        Device rs = this.get(id);

        switch (param) {
            case "name": rs.setName(Value); break;
            case "phone": rs.setPhone(Value); break;
            case "serial": rs.setSerial(Value); break;
            case "status": rs.setStatus(Device.resolveEnumFromstring(Value)); break;
            case "os": rs.setOs(Value); break;

            case "last_connection":
                DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                rs.setLast_connection(new Date(formatter.parse(Value).getTime())); break;
        }
        daoDevice.save(rs);

    }



}
