package com.out_of_the_chat.repositories;

import com.out_of_the_chat.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        this.userRepository.deleteAll();
    }

    @Test
    public void createUserTest() {
        String email = "test123@gmail.com";
        String username = "user123";
        String password = "password123";

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        User savedUser = userRepository.save(user);

        long expectedCount = 1;

        assertThat(userRepository.count()).isEqualTo(expectedCount);
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getEmail()).isEqualTo(email);
        assertThat(savedUser.getUsername()).isEqualTo(username);
        assertThat(savedUser.getPassword()).isEqualTo(password);
    }

    @Test
    public void getUserById() {
        String email = "test123@gmail.com";
        String username = "user123";
        String password = "password123";

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        User savedUser = userRepository.save(user);
        UUID userId = savedUser.getId();

        Optional<User> foundUser = userRepository.findById(userId);

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo(email);
        assertThat(foundUser.get().getUsername()).isEqualTo(username);
    }
}
