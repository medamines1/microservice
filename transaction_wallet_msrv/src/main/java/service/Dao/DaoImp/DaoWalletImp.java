package service.Dao.DaoImp;


import repo.WalletRepo;
import models.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import service.Dao.Dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository("WalletImp")
public class DaoWalletImp implements Dao<Wallet> {

     @Autowired
     WalletRepo walletRepo;

    @Override
    public Wallet get(String id) { return walletRepo.getById(id); }

    @Override
    public Wallet getByUserId(String id) throws Exception {
        return  walletRepo.getByprofileId(id);
    }


    @Override
    public List<Wallet> u_get(String id) {
        return walletRepo.findWalletByProfileId(id);
    }

    @Override
    public List<Wallet> m_get(String id) {
        return walletRepo.findWalletByProfileId(id);
    }

    @Override
    public List<Wallet> getAll() {
        List<Wallet> list = new ArrayList<>();
        walletRepo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void save(String userid) {
        Wallet w = new Wallet();
        w.setProfileId(userid);
        w.setBalance(new BigDecimal(0));
        walletRepo.save(w);
    }

    @Override
    public void save(Wallet wallet) {
        walletRepo.save(wallet);
    }


    @Override
    public void delete(Wallet wallet) {
        walletRepo.delete(wallet);
    }
}
