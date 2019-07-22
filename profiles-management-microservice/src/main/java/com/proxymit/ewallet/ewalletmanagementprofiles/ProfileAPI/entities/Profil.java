package com.proxymit.ewallet.ewalletmanagementprofiles.ProfileAPI.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Profil {

//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid")
//    @Column(columnDefinition = "CHAR(32)")
    @Id
    @ApiModelProperty(notes = "The database generated UUID for new user")
    @Column(length=40)
    private String id;
    @Column(length=40,nullable = false, unique = true)
    @ApiModelProperty(notes = "The phone number of user is required and it is unique")
    private String phoneNumber;
    private String email;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ApiModelProperty(notes = "The path of the user image")
    private String image;
    @CreationTimestamp
    @ApiModelProperty(notes = "the date of the creation of the user")
    private LocalDateTime createdOn;
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(notes = "The status of user is by default is actived")
    private ProfilStatus status ;




}
