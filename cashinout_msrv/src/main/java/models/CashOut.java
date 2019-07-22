package models;


import lombok.Data;
import lombok.ToString;
import models.enums.Status_cash;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Data
@Entity
@ToString
@Table
public class CashOut {

    @Id
    @Column(columnDefinition = "CHAR(36)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private  String id;

    private  String merchant_id;

    private BigDecimal amount;

    private Status_cash status =  Status_cash.Pending;

    private String created_on =new java.sql.Date(Calendar.getInstance().getTime().getTime()).toString();
}
