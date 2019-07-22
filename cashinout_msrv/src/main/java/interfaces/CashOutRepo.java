package interfaces;

import models.CashOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CashOutRepo extends JpaRepository<CashOut, String> {
    CashOut getById(String id);
}
