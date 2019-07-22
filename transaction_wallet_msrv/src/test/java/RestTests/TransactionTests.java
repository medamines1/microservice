package RestTests;

import lombok.extern.slf4j.Slf4j;
import models.Transaction;
import models.enums.Status_tansaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import service.Dao.ITransactionService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Slf4j
public class TransactionTests {
    @MockBean
    private ITransactionService iTransactionService;

    private List<Transaction> li = new ArrayList<>();

     @Before
     public void BeforeTestingTransaction() throws Exception {

         for (int i = 0;i<=2;i++) {
             Transaction t = new Transaction();
             t.setAmount(new BigDecimal(500));
             t.setSender(UUID.randomUUID().toString());
             t.setReceiver(UUID.randomUUID().toString());
             t.setStatus_tansaction(Status_tansaction.Success);
             iTransactionService.save(t);
             li.add(t);
         }
     }

    @Test
    public  void TestForTransaction() throws Exception {
         Mockito.when(iTransactionService.getAll()).thenReturn(li);
        System.out.println(li.size());
        System.out.println(iTransactionService.getAll().size());

        assertEquals(li.size(),iTransactionService.getAll().size());



    }
}
