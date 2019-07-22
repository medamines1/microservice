package models;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Data
@Document(collection = "Wallet")
@ToString
public class Wallet {

    @Field
    @Id
    private  String id = UUID.randomUUID().toString();

    @Field
    private String userid;

    @Field
    private String merchantid;

    @Field
    @PositiveOrZero
    private BigDecimal balance;

    @Field
    private BigDecimal locked;

    @Field
    private String expires =new java.sql.Date(Calendar.getInstance().getTime().getTime()).toString();
}
