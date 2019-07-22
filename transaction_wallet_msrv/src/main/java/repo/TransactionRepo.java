package repo;

import models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String> {
    List<Transaction> findDeviceBySender(String id);
    List<Transaction> findDeviceByReceiver(String id);
    Transaction getById(String id);
}
