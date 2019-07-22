package models;

import lombok.Data;
import models.enums.rq_status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.UUID;

@Document
@Data
public class JoinRequest {

    @Id
    @Field("id")
    private  String id = UUID.randomUUID().toString();

    @Field("comp")
    private String comp;

    @Field("user")
    private  String user;

    @Field
    private rq_status status = rq_status.Pending;

    @Field
    private String created_On= new Date().toString();;


    public static rq_status  resolveEnumFromstring(String rq) throws Exception {
        switch (rq)      {
            case "Pending": return  rq_status.Pending;
            case "Accepted": return  rq_status.Accepted;
            case "Refused": return  rq_status.Refused;
            default:
                throw  new Exception("invalid choice");
        }
    }
}
