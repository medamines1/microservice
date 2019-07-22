package io.kubeless;



import java.util.Date;
import java.util.UUID;


public class JoinRequest {


    private  String id = UUID.randomUUID().toString();


    private String comp;


    private  String user;

    private rq_status status;


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
