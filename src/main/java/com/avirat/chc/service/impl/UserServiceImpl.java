package com.avirat.chc.service.impl;

import com.avirat.chc.entity.UserEntity;
import com.avirat.chc.repo.UserRepo;
import com.avirat.chc.requestDto.UserRequestDTO;
import com.avirat.chc.responseDto.UserResponseDTO;
import com.avirat.chc.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    ModelMapper modelMapper ;

    @Autowired
    UserRepo userRepo;

    //DTO >> Entity >> save into DB
    @Override
    public String signUp(UserRequestDTO userRequestDto) {

        log.info("Sign up method is call");

        //DTO >> Entity
        UserEntity userEntity = modelMapper.map(userRequestDto, UserEntity.class);
        //Entity >> DB
         UserEntity save = userRepo.save(userEntity);
       // log.info("Data is conveted into user Entity{} {}",userEntity.getUserId(),userEntity.getUserName());
        if(save != null) {
            log.info("user data is saved sucessfully ");
            return "user is registered sucessfully";
        }
        else {
            log.info("user data is not saved");
            return "user is not registered";
        }
    }

    @Override
    public UserResponseDTO login(String userName, String password) {

        //user name pasun user valid ahe ki nahi hai check karnay sathi
        //user pasun user cha data DB madhun baher kadun => DB madla password ani user ne delela password check karnay sathi
        UserEntity userEntity = userRepo.findByUserName(userName).get();
        if(userEntity.getPassword().equals(password))
        {
            //UserEntity >> UserResponseDTO
            return modelMapper.map(userEntity, UserResponseDTO.class);
        }
        else
            return null;

    }

    //update  DTO >> Entity
    @Override
    public String updateUserData(Integer userId, UserRequestDTO userRequestDTO) {

        //user id ne DB madhun user data kada
        UserEntity userEntity = userRepo.findById(userId).orElse(null);
        if (userEntity == null) {
            log.info("User not found with ID: {}", userId);
            return "User not found";
        }

        //allelya data la DTO chya data ne update kara userEntity set do get
        userEntity.setUserName(userRequestDTO.getUserName());
        userEntity.setFirstName(userRequestDTO.getFirstName());
        userEntity.setLastName(userRequestDTO.getLastName());
        userEntity.setPassword(userRequestDTO.getPassword());
        userEntity.setEmail(userRequestDTO.getEmail());
        userEntity.setContactNo(userRequestDTO.getContactNo());
        userEntity.setUserDob(userRequestDTO .getUserDob());
        userEntity.setAddress(userRequestDTO.getAddress());

        //updated UserEntity cha object Save kara
        userRepo.save(userEntity);
        log.info("User data updated successfully for userId: {}", userId);

        //ek msg return kara
        return "User data updated successfully";

    }

    //get  Entity >> DTO
    @Override
    public UserResponseDTO getUserData(Integer userId) {
        UserEntity userEntity = userRepo.findById(userId).get();
        UserResponseDTO userResponseDTO = modelMapper.map(userEntity, UserResponseDTO.class);
        return userResponseDTO ;
    }
}
