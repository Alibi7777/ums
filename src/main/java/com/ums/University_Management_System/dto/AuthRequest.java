package com.ums.University_Management_System.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
