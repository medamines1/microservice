package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private String userid;


    private String merchantid;


    private  String companyid;


    private String id = UUID.randomUUID().toString();


    private String title;


    private  String body;


    private  Boolean seen;

    private  String created_on = new Date().toString();



}
