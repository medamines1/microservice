package service.Dao;

import models.CashIn;

import java.util.List;

public interface Dao<T> {

    T get(String id) throws Exception;

    List<T> getAll();

    void save(T t);

    void delete(T t);


}