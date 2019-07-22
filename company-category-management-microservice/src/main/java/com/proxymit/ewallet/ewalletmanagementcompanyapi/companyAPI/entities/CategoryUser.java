package com.proxymit.ewallet.ewalletmanagementcompanyapi.companyAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "categoryUser")
public class CategoryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column
    private  String description;

    @Column
    private  String balance;

    @JsonIgnore
   @Transient
   private List<EmployeeRessource> employees = new ArrayList<>();
}
