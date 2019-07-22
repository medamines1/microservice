package service;

import models.Wallet;

import java.util.List;

public interface IWalletService {

    Wallet get(String id) throws Exception;

    Wallet getByUserId(String id) throws Exception;

    List<Wallet> getAll();

    void save(String userid);

    void insert(String id) throws Exception;

    void delete(String id) throws Exception;

    void update(String id, String param, String Value) throws Exception;

    void deleteByid(String profileId);





}
