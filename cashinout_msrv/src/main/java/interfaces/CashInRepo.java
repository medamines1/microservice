package interfaces;

import models.CashIn;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CashInRepo extends JpaRepository<CashIn, String> {
    CashIn getById(String id);
}
