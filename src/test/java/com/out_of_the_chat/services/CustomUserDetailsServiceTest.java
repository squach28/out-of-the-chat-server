package com.out_of_the_chat.services;

import com.out_of_the_chat.entities.User;
import com.out_of_the_chat.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @Test
    public void shouldReturnUserWhenFound() {
        String username = "user123";
        String email = "user123@gmail.com";
        String password = "password123";

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        user.getUsername();

        when(userRepository.findByUsername(username))
                .thenReturn(Optional.of(user));

        UserDetails foundUserDetails = customUserDetailsService.loadUserByUsername(username);

        assertThat(foundUserDetails).isNotNull();
        assertThat(foundUserDetails.getUsername()).isEqualTo(username);
        assertThat(foundUserDetails.getPassword()).isNotNull();
    }

    @Test
    public void shouldThrowExceptionWhenUserNotFound() {
        String username = "user123";

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.loadUserByUsername(username));
    }
}
