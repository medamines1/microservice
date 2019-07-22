package models;

import lombok.Data;

@Data
public class NotificationDto {

    private String id;

    private String userid;


    private String merchantid;


    private  String companyid;

    private String title;


    private  String body;

    private  Boolean seen;
}
