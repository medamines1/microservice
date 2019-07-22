package service.Dao;


import models.CashOut;

import java.util.List;

public interface ICashOutService {

    CashOut get(String id) throws Exception;

    List<CashOut> getAll();

    void save(CashOut t);

    void insert(CashOut cashOut) throws Exception;

    void delete(String id) throws Exception;

    void update(String id, String param, String Value) throws Exception;

    void Perform(String id,String status) throws Exception;

    int getNumOfCashOut() throws Exception;


}
