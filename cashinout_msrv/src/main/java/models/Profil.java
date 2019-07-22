package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.enums.ProfilStatus;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Profil {

    private String id;

    private String phoneNumber;

    private String email;

    private String password;

    private String image;

    private String createdOn;

    private ProfilStatus status;

}