package service.servviceImp;

import ReqNResp.ResponseModel;
import feigns.NotifFeign;
import feigns.ProfileFeign;
import lombok.extern.slf4j.Slf4j;
import mapper.Profil;
import models.Notification;
import models.Transaction;
import models.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.Dao.ITransactionService;
import service.IWalletService;
import service.TransactionDao;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Slf4j
public class TransactionServiceImp implements ITransactionService {

    @Autowired
    IWalletService walletService;

    @Autowired
    TransactionDao<Transaction> transactionDao;

    @Autowired
    private NotifFeign notifFeign;

    @Autowired
    private ProfileFeign profileFeign;

    @Override
    public Transaction get(String id) throws Exception {
        Transaction rs =  transactionDao.get(id);
        if (rs ==null)
            throw  new Exception("Transaction doesn't Exist !");
        return  rs;
    }
//    @Override
//    public Transaction getByUserId(String id) throws Exception {
//        Transaction rs =  transactionDao.get(id);
//        if (rs ==null)
//            throw  new Exception("Transaction doesn't Exist !");
//        return  rs;
//    }



    @Override
    public List<Transaction> getAll() {
        return transactionDao.getAll();
    }

    @Override
    public void save(Transaction transaction)  {transactionDao.save(transaction); }

    @Override
    public Transaction insert(Transaction transaction) throws Exception {


        if (transactionDao.get(transaction.getId()) !=null )
            throw  new Exception("Transaction Already Exist !");
            ResponseModel<Profil>  rs =  profileFeign.getEmployee(transaction.getReceiver());

            log.info("receiver : "+ rs.getResult());
        if (rs.getResult() == null)
           throw new  Exception("Receiver doesn't Exist !" + rs.getErr());
        Wallet wallet = walletService.getByUserId(transaction.getSender());
       if (wallet.getBalance().compareTo(transaction.getAmount()) < 0)
           throw  new Exception("insufficient  Balance ");

        walletService.update(transaction.getReceiver(),"PlusAmount",transaction.getAmount().toString());
        walletService.update(transaction.getSender(),"MinusAmount",transaction.getAmount().toString());


        //noification

        Notification notif = new Notification();

        notif.setBody(transaction.getSender() + " sent to you " + transaction.getAmount());
        notif.setUserid(transaction.getReceiver());

        notifFeign.insert(transaction.getReceiver(),notif);

        notif.setBody("Successfully  sent " + transaction.getAmount() + " to " + transaction.getReceiver());
        notif.setUserid(transaction.getSender());

        notifFeign.insert(transaction.getSender(),notif);


        transactionDao.save(transaction);
        return transaction;
    }

    @Override
    public void delete(String id) throws Exception {
        transactionDao.delete(get(id));
    }

    @Override
    public void update(String id, String param , String Value) throws Exception {
        Transaction rs = this.get(id);

        switch (param) {
            case "amount": rs.setAmount(new BigDecimal(Value)); break;
            case "sender": rs.setSender(Value); break;
            case "receiver": rs.setReceiver(Value); break;
            case "status": rs.setStatus_tansaction(Transaction.resolveEnumFromstring(Value)); break;
            case "last_connection":
                DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                rs.setCreated_on(new Date(formatter.parse(Value).getTime()).toString()); break;
        }
        transactionDao.save(rs);

    }



}
