package service.Dao;


import models.CashIn;

import java.util.List;

public interface ICashInService {

    CashIn get(String id) throws Exception;

    List<CashIn> getAll();

    void save(CashIn t);

    void insert(CashIn cashIn) throws Exception;

    void delete(String id) throws Exception;

    void update(String id, String param, String Value) throws Exception;

    void Perform(String id,String status) throws  Exception;

    int getNumOfCashIn() throws  Exception;


}
