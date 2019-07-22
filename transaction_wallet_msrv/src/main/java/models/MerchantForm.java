package models;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantForm {

    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private String image;
    private String tradeRegister;
    private String rib;
}
