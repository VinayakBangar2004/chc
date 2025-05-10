package com.avirat.chc.service;

import com.avirat.chc.requestDto.MedicalRecordRequestDTO;

public interface MedicalRecordService {
    public  boolean validUserAndDoctor(String userName,Long healthCardNo,Long doctorRegNO);

    public String createNewMedicalRecord(MedicalRecordRequestDTO medicalRecordRequestDTO,Long healthCardNo);
}
