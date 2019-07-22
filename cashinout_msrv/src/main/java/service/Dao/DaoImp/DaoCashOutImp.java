package service.Dao.DaoImp;


import interfaces.CashOutRepo;
import models.CashOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import service.Dao.Dao;

import java.util.ArrayList;
import java.util.List;


@Repository("cashOut")
public class DaoCashOutImp implements Dao<CashOut> {

    @Autowired
    private CashOutRepo cashOutRepo;


    @Override
    public CashOut get(String id) { return cashOutRepo.getById(id); }


    @Override
    public List<CashOut> getAll() {
        List<CashOut> list = new ArrayList<>();
        cashOutRepo.findAll().forEach(list::add);
        return list ;
    }

    @Override
    public void save(CashOut device) {
        cashOutRepo.save(device);
    }


    @Override
    public void delete(CashOut device) {
        cashOutRepo.delete(device);
    }
}
