package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "company")
@Builder
@Table(name = "company")
public class Company {

    @Id
    private String id;
    private String name;
    @Column(nullable = false, unique = true)
    private String userName;
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDateTime createdOn;
    private Double balance;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "company")
    @JsonIgnore
    private List<CategoryUser> categories = new ArrayList<>();
}