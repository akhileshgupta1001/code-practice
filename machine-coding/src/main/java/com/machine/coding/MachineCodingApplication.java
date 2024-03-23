package com.machine.coding;

import com.machine.coding.bookmyshow.controller.UserController;
import com.machine.coding.bookmyshow.dtos.SignUpRequestDto;
import com.machine.coding.bookmyshow.dtos.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MachineCodingApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(MachineCodingApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDto requestDto = new SignUpRequestDto();
        requestDto.setEmail("akhilesh@scaler.com");
        requestDto.setPassword("password");

        SignUpResponseDto responseDto = userController.singUp(requestDto);
        System.out.println("DEBUG");
    }
}
