package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Employee extends Profil {

    private String firstName;
    private String lastName;
    private String idCategory;
    private String idCompany;

    @Builder
    public Employee(String id, String phoneNumber, String email, String password, String image, LocalDateTime createdOn, ProfilStatus status, String firstName, String lastName, String  idCategory,String idCompany) {
        super(id, phoneNumber, email, password, image, createdOn, status);
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCategory = idCategory;
        this.idCompany = idCompany;
    }
}
