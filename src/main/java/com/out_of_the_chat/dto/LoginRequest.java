package com.out_of_the_chat.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
