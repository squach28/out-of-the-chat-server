package com.out_of_the_chat.services;

import com.out_of_the_chat.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService

@Service
public class UserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
}
