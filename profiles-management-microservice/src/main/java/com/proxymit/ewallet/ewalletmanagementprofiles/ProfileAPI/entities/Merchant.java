package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Merchant extends Profil {

    private String name;
    private String tradeRegister;
    private String rib;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Merchant supervisor;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supervisor")
    @JsonIgnore
    private List<Merchant> supervisees = new ArrayList<>();

    @Builder
    public Merchant(String id, String phoneNumber, String email, String password, String image, LocalDateTime createdOn, ProfilStatus status, String name, String tradeRegister, String rib, Merchant supervisor) {
        super(id, phoneNumber, email, password, image, createdOn, status);
        this.name = name;
        this.tradeRegister = tradeRegister;
        this.rib = rib;
        this.supervisor = supervisor;
    }

    public void addSupervisee(Merchant supervisee) {
        this.supervisees.add(supervisee);
    }

    public void removeSupervisees(Merchant supervisee) {
        this.supervisees.remove(supervisee);
    }
}
