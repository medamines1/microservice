package models;


import lombok.ToString;
import models.enums.device_status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Data
@Document(collection = "Device")
@ToString
public class Device {

    @Field
    @Id
    @Min(0)
    private String id = UUID.randomUUID().toString();


    @Field
    @Size(min=8,max=8)
    private String phone;

    @Field
    private  String Serial;

    @Field
    private Date last_connection;

    @Field
    private  String merchantid;

    @Field
    private String userid;

    @Field
    private String notification_token;

    @Field
    @Size(min=2,max=10)
    private String name;

    @Field
    private String os;

    @Field
    private device_status status;

    @Field
    private String Joined_on = new java.sql.Date(Calendar.getInstance().getTime().getTime()).toString();

    public static device_status resolveEnumFromstring(String value){
        if (value.equals("Enabled") )
            return  device_status.Enabled;
        return  device_status.Disabled;

    }

}
