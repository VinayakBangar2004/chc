package com.avirat.chc.requestDto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {

    //User Name :
    private String userName;

    //First Name :
    private String firstName;

    //Last Name :
    private String  lastName;

    //password :
    private String password;

    //email
    private String email;

    //contact
    private Long contactNo;

    //Role
    private String role;

    //health card id
    private Integer healthCardNo;

    //DOB
    private String userDob;

    //Address
    private String address;

    //Gender
    private String gender;


}
