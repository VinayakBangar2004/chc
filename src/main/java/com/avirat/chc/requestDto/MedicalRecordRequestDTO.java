package com.avirat.chc.requestDto;

import java.util.List;

public class MedicalRecordRequestDTO {

    private Long doctorRegNo;

    private List<MedicineInfoRequestDTO> medicineInfoRequestDTOList;

    private PatientRequestDTO patientRequestDTO;
}
