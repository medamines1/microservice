package service.servviceImp;

import ReqNResp.ResponseModel;
import feign.FProfile;
import lombok.extern.slf4j.Slf4j;
import models.CashIn;
import models.Profil;
import models.enums.Status_cash;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.Dao.Dao;
import service.Dao.ICashInService;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CashInServiceImp implements ICashInService {

    @Autowired
    Dao<CashIn> cashInDao;
    @Autowired
    FProfile fProfile;



    @Override
    public CashIn get(String id) throws Exception {
        CashIn rs =  cashInDao.get(id);
        if (rs ==null)
            throw  new Exception("CashIn doesn't Exist !");
        return  rs;
    }

    @Override
    public List<CashIn> getAll() {
        return cashInDao.getAll();
    }

    @Override
    public void save(CashIn cashIn) {
        cashInDao.save(cashIn);
    }

    @Override
    public void insert(CashIn cashIn) throws Exception {


        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            RestTemplate restTemplate = new RestTemplate();
            ResponseModel<Profil[]> data =  restTemplate.exchange("http://ewallet-management-profil.default.svc.cluster.local:8000/companies", HttpMethod.GET, entity,
                    new ParameterizedTypeReference<ResponseModel<Profil[]>>() {}).getBody();
            log.info("getting data : " + data);
        }
        catch (Exception e){
            log.info("testing failed due " +e );
        }

        log.info("testing");



        if (cashInDao.get(cashIn.getId()) !=null )
            throw  new Exception("CAshIn  Already Exist !");
        cashInDao.save(cashIn);
    }

    @Override
    public void delete(String id) throws Exception {
        cashInDao.delete(this.get(id));
    }

    @Override
    public void update(String id, String param , String Value) throws Exception {
        CashIn rs = this.get(id);

        switch (param) {
            case "amount": rs.setAmount(new BigDecimal(Value)); break;


            case "created_on":
                DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                rs.setCreated_on(new Date(formatter.parse(Value).getTime()).toString()); break;
        }
        cashInDao.save(rs);

    }

    @Override
    public void Perform(String id,String status) throws Exception {
        CashIn cashIn =  cashInDao.get(id);
        if (status.equals("completed"))
            cashIn.setStatus(Status_cash.Completed);
        else
            cashIn.setStatus(Status_cash.Rejected);

        cashInDao.save(cashIn);

    }

    @Override
    public int getNumOfCashIn() throws Exception {
        return cashInDao.getAll().size();
    }


}
