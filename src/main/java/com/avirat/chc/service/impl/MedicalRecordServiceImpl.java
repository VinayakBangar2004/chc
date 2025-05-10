package com.avirat.chc.service.impl;

import com.avirat.chc.entity.MedicalRecordEntity;
import com.avirat.chc.entity.PatientInfoEntity;
import com.avirat.chc.entity.UserEntity;
import com.avirat.chc.repo.MedicalRecordRepo;
import com.avirat.chc.repo.UserRepo;
import com.avirat.chc.requestDto.MedicalRecordRequestDTO;
import com.avirat.chc.service.MedicalRecordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MedicalRecordRepo medicalRecordRepo;

    @Override
    public boolean validUserAndDoctor(String userName, Long healthCardNo, Long doctorRegNO) {
        UserEntity userData =userRepo.getUserDataForCheck(userName,healthCardNo).orElse(null);
       UserEntity doctorDetails= userRepo.findBydoctorRegNo(doctorRegNO).orElse(null);

       if (userData!=null && doctorDetails!=null)
           return true;
       else
           return false;
    }

    @Override
    public String createNewMedicalRecord(MedicalRecordRequestDTO medicalRecordRequestDTO,Long healthCardNo) {

        //dto -> entity->full fill ->save
        MedicalRecordEntity medicalRecordEntity= modelMapper.map(medicalRecordRequestDTO, MedicalRecordEntity.class);

            //create date
       String currentDate= LocalDate.now().toString();
       medicalRecordEntity.setCreatedDate(currentDate);

       //patient cha object
       UserEntity userEntity=userRepo.findByhealthCardNo(healthCardNo).orElseThrow(()->new RuntimeException("user is not found"));

       //pull the patient object from medical record
      PatientInfoEntity patientEntity = medicalRecordEntity.getPatientEntity();

      patientEntity.setUserName(userEntity.getUserName());
      patientEntity.setUserDob(userEntity.getUserDob());
      patientEntity.setGender(userEntity.getGender());
      patientEntity.setHealthCardNo(userEntity.getHealthCardNo());

      medicalRecordRepo.save(medicalRecordEntity);

        return "";
    }
}
