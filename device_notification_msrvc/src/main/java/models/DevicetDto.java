package models;

import lombok.Data;
import models.enums.device_status;
import java.util.Date;



@Data
public class DevicetDto {

    private String id ;



    private String phone;


    private  String Serial;


    private Date last_connection;


    private  String merchantid;


    private String userid;

    private String notification_token;



    private String name;

    private String os;


    private device_status status;


    private String Joined_on ;
}
