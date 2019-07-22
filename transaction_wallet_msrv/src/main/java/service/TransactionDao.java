package service;

import java.util.List;

public interface TransactionDao<T> {

    T get(String id) throws Exception;

    List<T> getAll();

    void save(T t);

    void delete(T t);
}