package service.Dao;

import java.util.List;

public interface Dao<T> {

    T get(String id) throws Exception;

    List<T> m_get(String id);

    List<T> u_get(String id);

    List<T> comp_get(String id);

    List<T> getAll();

    void save(T t);

    void delete(T t);

}