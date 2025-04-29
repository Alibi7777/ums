package com.ums.University_Management_System.dto;

import com.ums.University_Management_System.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private Role role;
}
