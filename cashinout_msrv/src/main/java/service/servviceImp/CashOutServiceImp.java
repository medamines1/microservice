package service.servviceImp;

import models.CashIn;
import models.CashOut;
import models.enums.Status_cash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.Dao.Dao;
import service.Dao.ICashOutService;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class CashOutServiceImp implements ICashOutService {

    @Autowired
            @Qualifier("cashOut")
    Dao<CashOut> cashOutDao;

    @Override
    public CashOut get(String id) throws Exception {
        CashOut rs =  cashOutDao.get(id);
        if (rs ==null)
            throw  new Exception("CashIn doesn't Exist !");
        return  rs;
    }

    @Override
    public List<CashOut> getAll() {
        return cashOutDao.getAll();
    }

    @Override
    public void save(CashOut cashIn) {
        cashOutDao.save(cashIn);
    }

    @Override
    public void insert(CashOut cashIn) throws Exception {
        if (cashOutDao.get(cashIn.getId()) !=null )
            throw  new Exception("CashIn  Already Exist !");
        cashOutDao.save(cashIn);
    }

    @Override
    public void delete(String id) throws Exception {
        cashOutDao.delete(this.get(id));
    }

    @Override
    public void update(String id, String param , String Value) throws Exception {
        CashOut rs = this.get(id);

        switch (param) {
            case "amount": rs.setAmount(new BigDecimal(Value)); break;


            case "created_on":
                DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                rs.setCreated_on(new Date(formatter.parse(Value).getTime()).toString()); break;
        }
        cashOutDao.save(rs);

    }

    @Override
    public void Perform(String id,String status) throws Exception {
        CashOut cashOut =  cashOutDao.get(id);
        if (status.equals("completed"))
            cashOut.setStatus(Status_cash.Completed);
        else
            cashOut.setStatus(Status_cash.Rejected);

        cashOutDao.save(cashOut);
        //change the amount for restaurant
    }


    @Override
    public int getNumOfCashOut() throws Exception {
        return cashOutDao.getAll().size();
    }



}
