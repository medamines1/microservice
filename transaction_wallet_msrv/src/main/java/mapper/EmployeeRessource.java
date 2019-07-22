package mapper;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeRessource {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String image;
    private LocalDate createdOn;
    private ProfilStatus status;

}
