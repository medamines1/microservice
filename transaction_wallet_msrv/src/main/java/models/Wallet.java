package models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.UUID;

@Data
@Entity(name = "wallet")
@Table(name = "wallet")
@ToString
@NoArgsConstructor
public class Wallet {


    @Id
    @Column(name="id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private  String id = UUID.randomUUID().toString();

    @Column
    private String profileId;

    @Column
    @PositiveOrZero
    private BigDecimal balance;

    @Column
    private BigDecimal locked;

    @Column
    private String expires =new java.sql.Date(Calendar.getInstance().getTime().getTime()).toLocalDate().plusYears(1).toString(); // add + time to expire
}
