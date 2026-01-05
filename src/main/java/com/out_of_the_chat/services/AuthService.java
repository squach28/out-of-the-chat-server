package com.out_of_the_chat.services;

import com.out_of_the_chat.dto.RegisterRequest;
import com.out_of_the_chat.dto.RegisterResponse;
import com.out_of_the_chat.entities.User;
import com.out_of_the_chat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(RegisterRequest request) {
        User user = new User();

        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = this.userRepository.save(user);

        RegisterResponse response = new RegisterResponse();
        response.setEmail(savedUser.getEmail());
        response.setUsername(savedUser.getUsername());
        return response;
    }
}
