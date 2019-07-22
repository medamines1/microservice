package models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import models.enums.Status_tansaction;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;



@Data
@ToString
@Entity(name = "Transaction")
@Table(name = "Transaction")
@NoArgsConstructor
public class Transaction {

    @Id
    @Column(name="id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;


    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "status_transaction")
    private Status_tansaction status_tansaction;

    @Column(name = "Sender")
    private  String sender;

    @Column(name = "Receiver")
    private  String receiver;


    @Column(name = "joined_on")
    private String Created_on = new java.sql.Date(Calendar.getInstance().getTime().getTime()).toString();

    public static Status_tansaction resolveEnumFromstring(String value){
        if (value.equals("fail") )
            return  Status_tansaction.Fail;
        return  Status_tansaction.Success;
    }

}
