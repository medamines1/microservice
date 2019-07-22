package service.servviceImp;

import models.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import repo.WalletRepo;
import service.Dao.Dao;
import service.IWalletService;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Repository
@Transactional
public class WalletServiceImp implements IWalletService {

    @Autowired
            @Qualifier("WalletImp")
    Dao<Wallet> walletDao;


    @Autowired
    private WalletRepo walletRepo;

    @Override
    public Wallet get(String id) throws Exception {
        Wallet rs =  walletDao.get(id);
        if (rs ==null)
            throw  new Exception("wallet doesn't Exist !");
        return  rs;
    }

    @Override
    public Wallet getByUserId(String id) throws Exception {
        Wallet rs =  walletDao.getByUserId(id);
        if (rs ==null)
            throw  new Exception("wallet doesn't Exist ! for user : " + id);
        return  rs;
    }


    @Override
    public List<Wallet> getAll() {
        return walletDao.getAll();
    }

    @Override
    public void save(String id) {
        walletDao.save(id);
    }

    @Override
    public void insert(String id)  {
        walletDao.save(id);
    }

    @Override
    public void delete(String id) throws Exception {
        System.out.println(id+"------------------" + get(id));
        walletDao.delete(get(id));
    }

    @Override
    public void update(String id, String param , String Value) throws Exception {
        Wallet rs = this.getByUserId(id);
        BigDecimal newBig;
        switch (param) {

            case "balance": rs.setBalance(new BigDecimal(Value)); break;
            case "MinusAmount":
                 newBig = rs.getBalance().subtract(new BigDecimal(Value));
                if (newBig.compareTo(new BigDecimal(0))  <0 )
                    throw  new Exception("insufficient amount");
                rs.setBalance(newBig); break;

            case "PlusAmount":
               newBig = rs.getBalance().add(new BigDecimal(Value));
                rs.setBalance(newBig); break;
            case "locked": rs.setLocked(new BigDecimal(Value)); break;
            case "expires":
                DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                rs.setExpires(new Date(formatter.parse(Value).getTime()).toString()); break;
        }
        walletDao.save(rs);
    }


    public void deleteByid(String profileId){
        walletRepo.deleteByid(profileId);
    }

}
