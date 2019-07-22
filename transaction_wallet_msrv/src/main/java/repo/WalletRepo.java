package repo;

import models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface WalletRepo  extends JpaRepository<Wallet, String> {

    List<Wallet> findWalletByProfileId(String id);


    Wallet getById(String id);

    @Query("select w from wallet w where w.profileId = ?1 ")
    Wallet getByprofileId(String profileId);

    @Modifying
    @Query("delete from wallet w where profileId = ?1")
    void deleteByid(String profileId);
}
