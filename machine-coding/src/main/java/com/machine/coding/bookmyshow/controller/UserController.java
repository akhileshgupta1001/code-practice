package com.machine.coding.bookmyshow.controller;

import com.machine.coding.bookmyshow.dtos.ResponseStatus;
import com.machine.coding.bookmyshow.dtos.SignUpRequestDto;
import com.machine.coding.bookmyshow.dtos.SignUpResponseDto;
import com.machine.coding.bookmyshow.models.User;
import com.machine.coding.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public SignUpResponseDto singUp(SignUpRequestDto requestDto) {
        SignUpResponseDto responseDto = new SignUpResponseDto();

        try {
            User user = userService.signUp(requestDto.getEmail(), requestDto.getPassword());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setUserId(user.getId());
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
