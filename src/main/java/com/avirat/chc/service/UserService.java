package com.avirat.chc.service;

import com.avirat.chc.requestDto.UserRequestDTO;
import com.avirat.chc.responseDto.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    //signup DTO >> Entity
    public String signUp(UserRequestDTO userRequestDto);

    //login   User validation
    public UserResponseDTO login(String userName, String password);

    //update  DTO >> Entity
    public String updateUserData(Integer userId, UserRequestDTO userRequestDTO);

    //get  Entity >> DTO
    public UserResponseDTO  getUserData(Integer userId);
}
