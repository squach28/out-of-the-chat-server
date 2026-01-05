package com.out_of_the_chat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String email;

    private String username;

    private String password;

}
