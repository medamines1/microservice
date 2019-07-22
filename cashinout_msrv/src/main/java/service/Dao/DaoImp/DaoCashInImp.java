package service.Dao.DaoImp;


import interfaces.CashInRepo;
import models.CashIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import service.Dao.Dao;

import java.util.ArrayList;
import java.util.List;

@Repository("cashIn")
public class DaoCashInImp  implements Dao<CashIn> {

    @Autowired
    private CashInRepo cashInRepo;


    @Override
    public CashIn get(String id) { return cashInRepo.getById(id); }


    @Override
    public List<CashIn> getAll() {
        List<CashIn> list = new ArrayList<>();
        cashInRepo.findAll().forEach(list::add);
        return list ;
    }

    @Override
    public void save(CashIn cashIn) {
        cashInRepo.save(cashIn);
    }


    @Override
    public void delete(CashIn cashIn) {
        cashInRepo.delete(cashIn);
    }


}
