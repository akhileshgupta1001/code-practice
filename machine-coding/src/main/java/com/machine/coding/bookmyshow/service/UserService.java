package com.machine.coding.bookmyshow.service;

import com.machine.coding.bookmyshow.models.User;
import com.machine.coding.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User signUp(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user=null;
        if (optionalUser.isPresent()) {
            //Call the Login method.
            signIn(email,password);
        }else{
            //Create and register the user.
            BCryptPasswordEncoder
                    bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user = new User();
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user= userRepository.save(user);
        }

        return user;
    }

    public User signIn(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        User user = optionalUser.get();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            System.out.println("Sign in successful");
        } else {
            System.out.println("Sign in unsuccessful");
        }
        return user;
    }
}
