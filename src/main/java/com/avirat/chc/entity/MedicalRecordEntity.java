package com.avirat.chc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordEntity {

    @Id
    @Column(name = "RECORD_ID")
    private String medicalRecordId;

    @Column(name = "CREATED_DATAE")
    private String createdDate;

    @Column(name = "DOCTOR_REG_NO")
    private Long doctorRegNo;

    @OneToMany
    private List<MedicineInfoEntity> medicineInfoEntity;

    @ManyToOne
    private PatientInfoEntity patientEntity;

}
