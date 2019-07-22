package models;


import lombok.Data;
import models.enums.Status_tansaction;


@Data
public class TransactionDto {

    private String id ;

    private  String sender;

    private  String receiver;

    private Status_tansaction status;


    private String Joined_on ;
}
