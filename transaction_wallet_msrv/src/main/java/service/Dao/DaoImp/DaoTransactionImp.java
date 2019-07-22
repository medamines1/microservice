package service.Dao.DaoImp;


import models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import repo.TransactionRepo;

import service.TransactionDao;

import java.util.ArrayList;
import java.util.List;


@Repository
public class DaoTransactionImp  implements TransactionDao<Transaction> {

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public Transaction get(String id) { return transactionRepo.getById(id); }


    @Override
    public List<Transaction> getAll() {
        List<Transaction> list = new ArrayList<>();
        transactionRepo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void save(Transaction device) {
        transactionRepo.save(device);
    }


    @Override
    public void delete(Transaction device) {
        transactionRepo.delete(device);
    }
}
