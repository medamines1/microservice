package repos.interfaces;

import models.Device;
import models.JoinRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinRqRepo extends MongoRepository<JoinRequest, String> {


    @Query(value = "{ 'comp' : ?0 }")
    List<JoinRequest> findByComp(String comp);

    @Query(value = "{ 'user' : ?0 }")
    List<JoinRequest> findByUser(String user);

    @Query(value = "{ 'id' : ?0 }")
    JoinRequest getById(String id);

}
