package com.avirat.chc.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MEDICINE_INFO")
public class MedicineInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MEDICINE_INFO_ID")
    private String medicineInfoId;

    @Column(name = "MEDICINE_NAME",nullable = false,length = 200)
    private String medicineName;


    @OneToOne
    private DoseEntity doseEntity;

    @Column(name = "NO_OF_DAYS",nullable = false)
    private Integer days;

    @Column(name = "REMARK",nullable = false,length = 500)
    private String Remark;
}
