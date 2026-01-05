package com.out_of_the_chat.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String username;
    private String password;
}
