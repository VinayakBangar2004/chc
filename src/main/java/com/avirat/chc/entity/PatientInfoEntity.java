package com.avirat.chc.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PATIENT_INFO")
public class PatientInfoEntity {

    @Id
    @Column(name = "HEALTH_ID",nullable = false,unique = true)
    private Long healthCardNo;

    @Column(name = "USER_NAME", nullable = false,unique = true)
    private String userName;

    @Column(name = "Patient_DOB", nullable = false)
    private String userDob;

    @Column(name = "PATIENT_AGE",nullable = false)
    private Integer age;

    @Column(name = "PATIENT_WEIGHT",nullable = false)
    private Integer weight;

    @Column(name = "GENDER",nullable = false)
    private String gender;

    @Column(name = "BLOOD_PRESSURE",nullable = false)
    private String  bloodPressure;

    @Column(name = "BLOOD_GROUP",nullable = false)
    private String bloodGroup;

}
