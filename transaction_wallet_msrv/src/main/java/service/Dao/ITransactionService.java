package service.Dao;


import models.Transaction;

import java.util.List;

public interface ITransactionService {

//    Transaction getByUserId(String id) throws Exception;

    Transaction get(String id) throws Exception;


    List<Transaction> getAll();

    void save(Transaction t) throws Exception;

    Transaction insert(Transaction device) throws Exception;

    void delete(String id) throws Exception;

    void update(String id, String param, String Value) throws Exception;

}
