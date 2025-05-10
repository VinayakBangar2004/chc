package com.avirat.chc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USER_INFO")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",nullable = false, unique = true)
    private Integer userId;

    //User Name :
    @Column(name = "USER_ID",nullable = false,unique = true)
    private String userName;

    //First Name :
    @Column(name = "FIRST_NAME",nullable = false)
    private String firstName;

    //Last Name :
    @Column(name = "LAST_NAME",nullable = false)
    private String  lastName;

    //password :
    @Column(name = "USER_PASSWORD",nullable = false, unique = true)
    private String password;

    //email
    @Column(name = "EMAIL_ID",nullable = false, unique = true)
    private String email;

    //contact
    @Column(name = "CONTACT_NO",nullable = false, unique = true)
    private Long contactNo;

    //Role
    @Column(name = "USER_ROLE",nullable = false)
    private String role;

    //health card id
    @Column(name = "HEALTH_ID",nullable = false,unique = true)
    private Long healthCardNo;

    //DOB
    @Column(name = "USER_DOB",nullable = false)
    private String userDob;

    //Address
    @Column(name = "USER_ADDRESS",nullable = false)
    private String address;

    //Gender
    @Column(name = "USER_GENDER",nullable = false)
    private String gender;

    @Column(name = "DOCTOR_REG",nullable = true)
    private Long doctorRegNo;

}
