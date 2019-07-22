package service.Dao;

import models.Wallet;

import java.util.List;

public interface Dao<T> {

    T get(String id) throws Exception;

    T getByUserId(String id) throws Exception;

    List<T> m_get(String id);

    List<T> u_get(String id);

    List<T> getAll();

    void save(String id);

    void save(Wallet wallet);
    void delete(T t);
}