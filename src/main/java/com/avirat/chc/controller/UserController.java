package com.avirat.chc.controller;

import com.avirat.chc.requestDto.UserRequestDTO;
import com.avirat.chc.responseDto.UserResponseDTO;
import com.avirat.chc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //signup
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserRequestDTO userRequestDTO) {
        String msg = userService.signUp(userRequestDTO);
        return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
    }

    //login
    @GetMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestParam(name = "UserName") String userName, @RequestParam(name = "Password") String password) {

        UserResponseDTO userResponseDTO = userService.login(userName, password);
        if (userResponseDTO != null)
            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    //update
    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUserData(@PathVariable Integer userId, @RequestBody UserRequestDTO userRequestDTO) {
        String response = userService.updateUserData(userId, userRequestDTO);
        if (response.equals("User not found")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    //get
    @GetMapping("/getAllData")
    public ResponseEntity<UserResponseDTO> getUserData(@RequestParam(name = "UserID") Integer userId){
        UserResponseDTO userResponseDTO = userService.getUserData(userId);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.ACCEPTED);
    }

}
